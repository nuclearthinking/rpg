package com.nuclearthinking.game.app;

import com.nuclearthinking.game.app.utils.ManagerResources;
import com.nuclearthinking.game.utils.ResourceUtil;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

/**
 * Created by kuksin-mv on 02.02.2016.
 */
public class MapEditor extends Application
{
    private static Stage primaryStage;
    private static BorderPane borderPane;
    private static final ResourceUtil ru = new ResourceUtil();

    private GraphicsContext gc;
    private Image image;
    // Ставить больше 32 не рекомендуется так как там не получится покрыть всю картинку
    private static final int PIXEL = 16; //От колличества пикселей зависит точность рисования чем меньше тем больше, но рисовать запарит
    private int[][] config;
    private Canvas canvas;

    @FXML
    private MenuItem open, save;

    @FXML
    private void initialize()
    {
        open.setOnAction(event ->
        {
            FileChooser chooser = new FileChooser();
            //В ExtensionFilter указываем список доступных для открытия файлов
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File", "*.png", "*.jpg", "*.jpeg"));

            File file = chooser.showOpenDialog(primaryStage);
            if (file != null)
                borderPane.setCenter(loadImg(ManagerResources.loadImageFile(file.getAbsolutePath())));
        });

        save.setOnAction(event ->
        {
            FileChooser chooser = new FileChooser();
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Map", "*.map"));
            File file = chooser.showSaveDialog(primaryStage);
            save(file);
        });
    }

    private Node loadImg(Image image)
    {
        this.image = image;

        //Делим картинку на массивы
        int col = (int) image.getWidth() / PIXEL;
        int row = (int) image.getHeight() / PIXEL;
        //Задаем размер массиву
        config = new int[row][col];

        //Задаем размер канваса, что бы не выделять лишнюю область
        this.canvas = new Canvas(image.getWidth(), image.getHeight());

        //Задаем размер окна в зависимости от размера картинки
        primaryStage.setWidth(canvas.getWidth() + 30);
        primaryStage.setHeight(canvas.getHeight() + 80);

        //Действие при клике на канвас (канвас==картинка)
        canvas.setOnMouseClicked(event ->
        {

            //Определяем в какое место на картинке мы ткнули
            int y = (int) event.getY() / PIXEL;
            int x = (int) event.getX() / PIXEL;

            //Если тыкнули в область в которой есть отметка, то вызываем репеинт
            if(config[y][x] > 0)
            {
                config[y][x] = 0;
                repaint();
            }
            //Если тыкнули в область в которой нет отметки, то рисуем прямоугольник
            else
            {
                config[y][x] = 1;
                gc.setStroke(Color.RED);
                gc.strokeRect(x * PIXEL, y * PIXEL, PIXEL, PIXEL);
            }
        });
        //Присваиваем графике канвас с внутренностям
        gc = canvas.getGraphicsContext2D();
        //Рисуем картинку от левого верхнего угла
        gc.drawImage(image, 0, 0);

        return canvas;
    }

    //Метод для перерисовки квадратов
    private void repaint()
    {
        //Чистим чистим очищаем
        gc.clearRect(0, 0, (int) image.getWidth(), (int) image.getHeight());
        //Перерисовываем картинку от угла
        gc.drawImage(image, 0, 0);
        //Проходимся по массиву
        for(int i = 0; i < config.length; i++)
        {
            for(int j = 0; j < config[i].length; j++)
            {
                //Если не отмечено, то пропускаем иначе перерисовываем
                if(config[i][j] < 1)
                    continue;

                //Рисуем красным цвето
                gc.setStroke(Color.RED);
                //Рисуем прямоугольник(у нас получается квадрат)
                gc.strokeRect(j * PIXEL, i * PIXEL, PIXEL, PIXEL);
            }
        }
    }

    public void save(File file)
    {
        try(PrintWriter fileWriter = new PrintWriter(file))
        {
            for(int i = 0; i < config.length; i++)
            {
                for(int j = 0; j < config[i].length - 1; j++)
                {
                    fileWriter.print(config[i][j] + ",");
                }
                fileWriter.println(config[i][config[i].length - 1]);
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.primaryStage = primaryStage;

        initRootLayout();
    }

    private static void initRootLayout()
    {
        try(InputStream is = ru.getResourceAsStream("fxml\\mapeditor.fxml"))
        {
            FXMLLoader loader = new FXMLLoader();
            borderPane = (BorderPane) loader.load(is);

            Scene scene = new Scene(borderPane);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Map Editor");
            primaryStage.show();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

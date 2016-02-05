package com.nuclearthinking.game.app;

import com.nuclearthinking.game.app.alldrow.Atom;
import com.nuclearthinking.game.app.alldrow.ObjectWorld;
import com.nuclearthinking.game.app.alldrow.Sprite;
import com.nuclearthinking.game.app.map.MapContainer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Created by kuksin-mv on 04.02.2016.
 */
public class TestScene extends ObjectWorld
{
    MapContainer mapContainer = new MapContainer("img\\map.png");

    public TestScene(int fps, String title)
    {
        super(fps, title);
    }

    @Override
    public void initialize(Stage primaryStage)
    {
        //Задаем тайтл
        primaryStage.setTitle(getWindowsTitle());
        //Создаем группу нод
        setSceneNode(new Group());
        //Создаем сцену с группой нод и указанием разрешения
        setGameSurface(new Scene(getSceneNodes(), 640, 580));
        //Добавляем сцену на оболочку
        primaryStage.setScene(getGameSurface());

        //Создаем канвас с размерами сцены
        setGameCanvas(new Canvas(getGameSurface().getWidth(), getGameSurface().getHeight()));
        //Создаем объект на сцене TODO: Подумать как объект отрисовать в канвасе
        createAtom();
        //Добавлем в группу нод, канвас
        getSceneNodes().getChildren().add(getGameCanvas());

        //Создаем графический компонент
        setGraphicsContext(getGameCanvas().getGraphicsContext2D());


        //Загружаем карту
        mapContainer.draw(getGraphics());
        //Рисуем все что есть
        primaryStage.show();

        //Слушатели на ресайз
        primaryStage.heightProperty().addListener((observable, oldValue, newValue) ->
        {
            //Присваиваем размер окна, канвасу
            getGameCanvas().setHeight(primaryStage.getHeight());
            //Перерисовываем карту
            mapContainer.draw(getGraphics());
        });
        primaryStage.widthProperty().addListener((observable, oldValue, newValue) ->
        {
            getGameCanvas().setWidth(primaryStage.getWidth());
            mapContainer.draw(getGraphics());
        });


    }

    private void createAtom()
    {
        Random rnd = new Random();
        Atom atom = new Atom(rnd.nextInt(15) + 5);
        Circle circle = atom.getAsCircle();
        Scene gameSurface = getGameSurface();

        atom.vX = 1;
        atom.vY = 2;

        double newX = rnd.nextInt((int) gameSurface.getWidth());

        double newY = rnd.nextInt((int) gameSurface.getHeight());

        circle.setTranslateX(newX);
        circle.setTranslateY(newY);
        circle.setVisible(true);
        circle.setId(atom.toString());

        getSpriteManager().addSprites(atom);

        getSceneNodes().getChildren().add(0, atom.node);
        atom.draw(getGraphics());
    }

    @Override
    protected void handleUpdate(Sprite sprite)
    {
        if (sprite.isAtom())
        {
            updateAtom((Atom)sprite);
        }
    }

    @Override
    protected boolean handleCollision(Sprite spriteA, Sprite spriteB)
    {
        return false;
    }

    @Override
    protected void cleanupSprites()
    {

    }

    private void updateAtom(Atom atom)
    {
        atom.update();

        if (atom.node.getTranslateX() > (getGameSurface().getWidth()  - atom.node.getBoundsInParent().getWidth()) || atom.node.getTranslateX() < 0 )
        {
            atom.vX = atom.vX * -1;
        }
        if (atom.node.getTranslateY() > getGameSurface().getHeight()- atom.node.getBoundsInParent().getHeight() || atom.node.getTranslateY() < 0)
        {
            atom.vY = atom.vY * -1;
        }
    }
}

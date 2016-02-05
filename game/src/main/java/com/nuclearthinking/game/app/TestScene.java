package com.nuclearthinking.game.app;

import com.nuclearthinking.game.app.alldrow.Atom;
import com.nuclearthinking.game.app.alldrow.ObjectWorld;
import com.nuclearthinking.game.app.alldrow.Sprite;
import com.nuclearthinking.game.app.map.MapContainer;
import com.nuclearthinking.game.app.utils.ManagerResources;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Created by kuksin-mv on 04.02.2016.
 */
public class TestScene extends ObjectWorld
{
    MapContainer mapContainer = new MapContainer("img\\map.png");
    private static Image bg = ManagerResources.loadImage("img\\bg.png");

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
        //Добавлем в группу нод, канвас
        getSceneNodes().getChildren().add(getGameCanvas());

        //Создаем графический компонент
        setGraphicsContext(getGameCanvas().getGraphicsContext2D());

        //Загружаем карту
        createAtom();
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
        Atom atom = new Atom("img\\gm.png", 0);

        getSpriteManager().addSprites(atom);

        mapContainer.initHero(atom);
    }

    @Override
    protected void handleUpdate(Sprite sprite)
    {
        if (sprite.isAtom())
        {
            //System.out.println("Он есть");
            //updateAtom((Atom)sprite);
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

        if (atom.getTranslateX() > (getGameSurface().getWidth()  - getGameCanvas().getWidth()) || atom.getTranslateX() < 0 )
        {
            atom.vX = atom.vX * -1;
        }
        if (atom.getTranslateY() > getGameSurface().getHeight()- getGameCanvas().getHeight() || atom.getTranslateY() < 0)
        {

            atom.vY = atom.vY * -1;
        }
    }

}

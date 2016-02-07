package com.nuclearthinking.game.app;

import com.nuclearthinking.game.app.alldrow.Atom;
import com.nuclearthinking.game.app.alldrow.ObjectWorld;
import com.nuclearthinking.game.app.alldrow.SpriteAnimation;
import com.nuclearthinking.game.app.alldrow.SpriteManager;
import com.nuclearthinking.game.app.map.MapContainer;
import com.nuclearthinking.game.app.utils.ManagerAudio;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;

/**
 * Created by kuksin-mv on 04.02.2016.
 */
public class TestScene extends ObjectWorld
{
    public static Pane appRoot = new Pane();
    public static Pane gameRoot = new Pane();
    public Atom player;
    public MapContainer mapContainer;
    public SpriteManager spriteManager = new SpriteManager();

    private HashMap<KeyCode,Boolean> keys = new HashMap<>();

    public TestScene(int fps, String title)
    {
        super(fps, title);
    }

    @Override
    public void initialize(Stage primaryStage)
    {
        createPlayer();
        createWorld();

        gameRoot.getChildren().add(player);
        appRoot.getChildren().addAll(mapContainer, gameRoot);

        //Задаем тайтл
        primaryStage.setTitle(getWindowsTitle());
        //Создаем группу нод
        setSceneNode(new Group(appRoot));
        //Создаем сцену с группой нод и указанием разрешения
        setGameSurface(new Scene(getSceneNodes(), 640, 580));
        getGameSurface().setOnKeyPressed(event-> keys.put(event.getCode(), true));
        getGameSurface().setOnKeyReleased(event ->
        {
            keys.put(event.getCode(), false);
            player.spriteAnimation.stop();
        });
        //Добавляем сцену на оболочку
        primaryStage.setScene(getGameSurface());
        //Рисуем все что есть
        primaryStage.show();
        ManagerAudio.backMusicStart("/audio/bg.mp3");
    }

    private void createPlayer()
    {
        player = new Atom();
        player.setTranslateX(10);
        player.setTranslateY(10);
        spriteManager.addSprites(player);
    }

    private void createWorld()
    {
        mapContainer = new MapContainer();
    }

    private boolean isPressed(KeyCode key)
    {
        return keys.getOrDefault(key,false);
    }

    @Override
    protected void updateSprites()
    {
        if(isPressed(KeyCode.RIGHT))
        {
            player.move(KeyCode.RIGHT);
            player.spriteAnimation.play();
        }
        if(isPressed(KeyCode.LEFT))
        {
            player.move(KeyCode.LEFT);
            player.spriteAnimation.play();
        }
        if(isPressed(KeyCode.UP))
        {
            player.move(KeyCode.UP);
            player.spriteAnimation.play();
        }
        if(isPressed(KeyCode.DOWN))
        {
            player.move(KeyCode.DOWN);
            player.spriteAnimation.play();
        }
    }

    @Override
    protected boolean handleCollision(SpriteAnimation spriteA, SpriteAnimation spriteB)
    {
        return false;
    }

    @Override
    protected void cleanupSprites()
    {
    }

}

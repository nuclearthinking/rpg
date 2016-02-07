package com.nuclearthinking.game.app.alldrow;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by kuksin-mv on 04.02.2016.
 */
public abstract class ObjectWorld
{
    private static Timeline gameLoop;

    private final int fps;
    private final String windowsTitle;

    private Scene gameSurface;
    private Group sceneNode;

    private final SpriteManager spriteManager = new SpriteManager();

    public ObjectWorld(final  int fps, final String title)
    {
        this.fps = fps;
        this.windowsTitle = title;
        buildAndSetGameLoop();
    }

    protected final void buildAndSetGameLoop()
    {
        final Duration oneFrameAmt = Duration.millis(1000/getFps());
        final KeyFrame oneFrame = new KeyFrame(oneFrameAmt, event ->
        {
            updateSprites();
            checkCollision();
            cleanupSprites();
        });

        Timeline timeline = new Timeline(oneFrame);
        timeline.setDelay(oneFrameAmt);
        timeline.setCycleCount(Animation.INDEFINITE);
        setGameLoop(timeline);
    }

    public abstract void initialize(final Stage primaryStage);

    public void beginGameLoop()
    {
        getGameLoop().play();
    }

    protected void updateSprites()
    {

    }

    protected void checkCollision()
    {
        spriteManager.resetCollisionsToCheck();
    }

    protected boolean handleCollision(SpriteAnimation spriteA, SpriteAnimation spriteB)
    {
        return false;
    }

    protected void cleanupSprites()
    {
        spriteManager.cleanupSprites();
    }

    protected int getFps()
    {
        return fps;
    }

    public String getWindowsTitle()
    {
        return windowsTitle;
    }

    protected static Timeline getGameLoop()
    {
        return gameLoop;
    }

    protected static void setGameLoop(Timeline gameLoop)
    {
        ObjectWorld.gameLoop = gameLoop;
    }

    protected SpriteManager getSpriteManager()
    {
        return spriteManager;
    }

    public Scene getGameSurface()
    {
        return gameSurface;
    }

    protected void setGameSurface(Scene gameSurface)
    {
        this.gameSurface = gameSurface;
    }

    public Group getSceneNodes()
    {
        return sceneNode;
    }

    protected void setSceneNode(Group sceneNode)
    {
        this.sceneNode = sceneNode;
    }

    public void shutdown()
    {
        getGameLoop().stop();
    }

}

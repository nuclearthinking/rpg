package com.nuclearthinking.game.app.alldrow;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
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
    private Canvas nodeCanvas;
    private GraphicsContext graphicsContext;

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
            worldUpdate(getGraphics());
            checkCollision();
            cleanupSprites();
            //showFps(); //TODO: Получилось гавно. Надо ещё и чистить как то ведь
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

    private void updateSprites()
    {
        spriteManager.getAllSprites().forEach(Sprite::update);
    }

    protected abstract void worldUpdate(GraphicsContext context);

    protected void checkCollision()
    {
        spriteManager.resetCollisionsToCheck();

        for(Sprite spriteA:spriteManager.getCollisionsToCheck())
        {
            for(Sprite spriteB:spriteManager.getAllSprites())
            {
                if (handleCollision(spriteA, spriteB))
                {
                    break;
                }
            }
        }
    }

    protected boolean handleCollision(Sprite spriteA, Sprite spriteB)
    {
        return false;
    }

    protected void cleanupSprites()
    {
        spriteManager.cleanupSprites();
    }

    protected void showFps()
    {
        getGraphics().setStroke(Color.BLACK);
        getGraphics().strokeText("FPS: " + Integer.toString(fps), 0, 20, 200);
        getGraphics().restore();
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

    public Canvas getGameCanvas()
    {
        return nodeCanvas;
    }

    protected void setGameCanvas(Canvas nodeCanvas)
    {
        this.nodeCanvas = nodeCanvas;
    }

    public GraphicsContext getGraphics()
    {
        return graphicsContext;
    }

    protected void setGraphicsContext(GraphicsContext graphicsContext)
    {
        this.graphicsContext = graphicsContext;
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

package com.nuclearthinking.game.app.alldrow;

import com.nuclearthinking.game.app.utils.ManagerResources;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * Created by kuksin-mv on 04.02.2016.
 */
public class Atom extends Pane
{
    private final Image PLAYER = ManagerResources.loadImage("img\\gm.png");
    private final ImageView imageView = new ImageView(PLAYER);
    private static final int SPRITE_WIDTH = 70;
    private static final int SPRITE_HEIGHT = 124;
    private static final int COLUMNS = 8;
    private static final int COUNT = 4;
    private static final int OFFSET_X = 0;
    private static final int OFFSET_Y = 0;


    public SpriteAnimation spriteAnimation;

    public Atom()
    {
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, SPRITE_WIDTH, SPRITE_HEIGHT));
        spriteAnimation = new SpriteAnimation(this.imageView, Duration.millis(500), COUNT, COLUMNS, OFFSET_X, OFFSET_Y, SPRITE_WIDTH, SPRITE_HEIGHT);
        getChildren().add(imageView);
    }


    public void move(KeyCode keyCode)
    {
        switch (keyCode)
        {
            case RIGHT:
                spriteAnimation.setOffsetY(SPRITE_HEIGHT * 2);
                this.setTranslateX(this.getTranslateX() + 1);
                break;

            case LEFT:
                spriteAnimation.setOffsetY(SPRITE_HEIGHT);
                this.setTranslateX(this.getTranslateX() - 1);
                break;

            case UP:
                spriteAnimation.setOffsetY(SPRITE_HEIGHT * 3);
                this.setTranslateY(this.getTranslateY() - 1);
                break;

            case DOWN:
                spriteAnimation.setOffsetY(0);
                this.setTranslateY(this.getTranslateY() + 1);
                break;
        }
    }

}

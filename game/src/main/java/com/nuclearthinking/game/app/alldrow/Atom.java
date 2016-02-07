package com.nuclearthinking.game.app.alldrow;

import com.nuclearthinking.game.app.controller.Input;
import com.nuclearthinking.game.app.utils.ManagerResources;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * Created by kuksin-mv on 04.02.2016.
 */
public class Atom extends Pane
{
    //Спрайт с игроком
    private final Image PLAYER = ManagerResources.loadImage("img\\gm.png");
    //Создаем представление со спрайтом игрока
    private final ImageView imageView = new ImageView(PLAYER);
    //Размер игрока (именно прямоугольник рисунка, а не всей картинки)
    private static final int SPRITE_WIDTH = 70;
    private static final int SPRITE_HEIGHT = 124;
    //Сколько всего колонок с анимацией игрока
    private static final int COLUMNS = 8;
    //По сути частота кадров для одной анимации
    private static final int COUNT = 4;
    //Смещение по спрайту
    private static final int OFFSET_X = 0;
    private static final int OFFSET_Y = 0;

    public SpriteAnimation spriteAnimation;

    public Atom()
    {
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, SPRITE_WIDTH, SPRITE_HEIGHT));
        spriteAnimation = new SpriteAnimation(this.imageView, Duration.millis(500), COUNT, COLUMNS, OFFSET_X, OFFSET_Y, SPRITE_WIDTH, SPRITE_HEIGHT);
        getChildren().add(imageView);
    }

    public void input(Input input)
    {
        if(input.isMoveRight())
        {
            spriteAnimation.setOffsetY(SPRITE_HEIGHT * 2);
            this.setTranslateX(this.getTranslateX() + (input.isRun()?5:1));
            spriteAnimation.play();
        }
        else if(input.isMoveLeft())
        {
            spriteAnimation.setOffsetY(SPRITE_HEIGHT);
            this.setTranslateX(this.getTranslateX() - (input.isRun()?5:1));
            spriteAnimation.play();
        }
        else if(input.isMoveUp())
        {
            spriteAnimation.setOffsetY(SPRITE_HEIGHT * 3);
            this.setTranslateY(this.getTranslateY() - (input.isRun()?5:1));
            spriteAnimation.play();
        }
        else if(input.isMoveDown())
        {
            spriteAnimation.setOffsetY(0);
            this.setTranslateY(this.getTranslateY() + (input.isRun()?5:1));
            spriteAnimation.play();
        }
        else
        {
            //Топорно но лучше чем spriteAnimation.stop(); при нем персонаж начинает с пробуксовки
            spriteAnimation.pause();
        }
    }

}

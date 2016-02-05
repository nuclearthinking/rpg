package com.nuclearthinking.game.app.alldrow;

import com.nuclearthinking.game.app.utils.ManagerImages;
import com.nuclearthinking.game.app.utils.ManagerResources;
import javafx.scene.image.Image;

/**
 * Created by kuksin-mv on 05.02.2016.
 */
public class SpriteFactory
{
    private static final int SPRITE_WIDTH = 70;
    private static final int SPRITE_HEIGHT = 124;

    private Image[][] images;

    private int imageWidth;
    private int imageHeight;
    private int size = 0;

    public SpriteFactory(String fileName)
    {
        this(fileName, SPRITE_WIDTH, SPRITE_HEIGHT, 4);
    }

    public SpriteFactory(String fileName, int width, int height, int size)
    {
        this.size = size;
        this.imageWidth = width;
        this.imageHeight = height;
        this.images = ManagerImages.split(ManagerResources.loadImage(fileName), width, height);
    }

    public Image[] getMove(int index){
        return images[index];
    }

    public int getSize(){
        return size - 1;
    }

    public int getSpriteHeight(){
        return imageHeight;
    }

    public int getSpriteWidth(){
        return imageWidth;
    }
}

package com.nuclearthinking.game.app;

import com.nuclearthinking.game.app.alldrow.Atom;
import com.nuclearthinking.game.app.alldrow.ObjectWorld;
import com.nuclearthinking.game.app.alldrow.Sprite;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Created by kuksin-mv on 04.02.2016.
 */
public class TestScene extends ObjectWorld
{


    public TestScene(int fps, String title)
    {
        super(fps, title);
    }

    @Override
    public void initialize(Stage primaryStage)
    {
        primaryStage.setTitle(getWindowsTitle());
        setSceneNode(new Group());
        setGameSurface(new Scene(getSceneNodes(), 640, 580));
        primaryStage.setScene(getGameSurface());

        createAtom();
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

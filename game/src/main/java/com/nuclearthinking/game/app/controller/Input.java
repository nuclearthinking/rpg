package com.nuclearthinking.game.app.controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.BitSet;

/**
 * Created by Izonami on 07.02.2016.
 */
public class Input
{
    private BitSet keyboardBitSet = new BitSet();

    private KeyCode upKey = KeyCode.UP;
    private KeyCode downKey = KeyCode.DOWN;
    private KeyCode leftKey = KeyCode.LEFT;
    private KeyCode rightKey = KeyCode.RIGHT;

    Pane scene;

    public Input(Pane scene)
    {
        this.scene = scene;
    }

    public void addListeners()
    {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
        scene.addEventFilter(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);
    }

    public void removeListeners()
    {
        scene.removeEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
        scene.removeEventFilter(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);
    }

    private EventHandler<KeyEvent> keyPressedEventHandler = event -> keyboardBitSet.set(event.getCode().ordinal(), true);

    private EventHandler<KeyEvent> keyReleasedEventHandler = event -> keyboardBitSet.set(event.getCode().ordinal(), false);

    public boolean isMoveUp()
    {
        return keyboardBitSet.get( upKey.ordinal()) && !keyboardBitSet.get( downKey.ordinal());
    }

    public boolean isMoveDown()
    {
        return keyboardBitSet.get( downKey.ordinal()) && !keyboardBitSet.get( upKey.ordinal());
    }

    public boolean isMoveLeft()
    {
        return keyboardBitSet.get( leftKey.ordinal()) && !keyboardBitSet.get( rightKey.ordinal());
    }

    public boolean isMoveRight()
    {
        return keyboardBitSet.get( rightKey.ordinal()) && !keyboardBitSet.get( leftKey.ordinal());
    }

}

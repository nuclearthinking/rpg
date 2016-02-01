package com.nuclearthinking.game.app;

import com.nuclearthinking.game.app.alldrow.IPaint;
import com.nuclearthinking.game.app.utils.ManagerAudio;
import com.nuclearthinking.game.app.utils.ManagerResources;
import com.nuclearthinking.game.app.utils.ManagerView;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;

/**
 * Created by kuksin-mv on 01.02.2016.
 * По сути это менеджер нод
 */
public class ContextContainer extends AnimationTimer
{
    private Canvas canvas;
    private Node controlBar;
    private Group root;
    private ManagerView managerView;

    public ContextContainer(IPaint IPaint, Canvas canvas)
    {
        this.canvas = canvas;
        this.managerView = new ManagerView(IPaint);
        this.controlBar = managerView.getControlBar();
    }

    public Parent getSurface()
    {
        root = new Group();
        root.getChildren().add(canvas);
        root.setCursor(ManagerResources.loadCursor());

        if(controlBar != null)
        {
            root.getChildren().add(controlBar);
        }
        return root;
    }

    public void startUp()
    {
        start(); //Запускает таймер анимации
        managerView.showFps(true); //Показываем FPS
        ManagerAudio.backMusicStart("/audio/bg.mp3");
    }

    //Этот код отвечает за рендер картинки на каждый тик аниматора
    @Override
    public void handle(long now)
    {
        managerView.renderView(canvas.getGraphicsContext2D());
        Node tmp = managerView.getControlBar();

        if (tmp == controlBar)
            return;

        controlBar = tmp;

        if (controlBar == null && root.getChildren().size() > 1)
        {
            root.getChildren().remove(1);
        }
        else if (controlBar != null && root.getChildren().size() > 1)
        {
            root.getChildren().set(1, controlBar);
        }
        else if (controlBar != null && root.getChildren().size() == 1)
        {
            root.getChildren().add(controlBar);
        }
    }
}

package com.nuclearthinking.game.app.utils;

import com.nuclearthinking.game.app.alldrow.IPaint;
import com.sun.javafx.perf.PerformanceTracker;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by kuksin-mv on 01.02.2016.
 */
public class ManagerView implements EventHandler<Event>
{
    private IPaint IPaint;
    private boolean showFps = false;

    public ManagerView(IPaint IPaint)
    {
        this.IPaint = IPaint;
    }

    public void showFps(boolean showFps)
    {
        this.showFps = showFps;
    }

    public void renderView(GraphicsContext context)
    {
        clear(context);
        IPaint.draw(context);
        IPaint = IPaint.invoke();
        if(showFps)
        {
            int fps = getFps(context.getCanvas());
            context.setStroke(Color.RED);
            context.strokeText("FPS: " + Integer.toString(fps), 0, 20, 100);
        }
    }

    public int getFps(Node node)
    {
        return (int) PerformanceTracker.getSceneTracker(node.getScene()).getInstantFPS();
    }

    public Node getControlBar()
    {
        return IPaint.getControllBar();
    }

    @Override
    public void handle(Event event)
    {
        IPaint.handle(event);
    }

    public static void clear(GraphicsContext context){
        context.clearRect(0, 0, context.getCanvas().getWidth(), context.getCanvas().getHeight());
    }
}

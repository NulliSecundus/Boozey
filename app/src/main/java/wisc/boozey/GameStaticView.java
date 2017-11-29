package wisc.boozey;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import wisc.boozey.game.objects.*;

/**
 *
 */

public class GameStaticView extends View {
    public ArrayList<StaticGameObject> staticGameObjects;
    private Canvas canvas;

    public GameStaticView(Context context, ArrayList<StaticGameObject> staticGameObjects) {
        super(context);
        this.staticGameObjects = staticGameObjects;

    }

    public Canvas getCanvas(){
        return canvas;
    }

    public void setStaticGameObjects(ArrayList<StaticGameObject> list){
        staticGameObjects = list;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.canvas = canvas;
        canvas.drawColor(Color.rgb(20,70,20));

        for(StaticGameObject g : staticGameObjects){
            g.draw(canvas);
        }
    }


}

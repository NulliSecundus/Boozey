package wisc.boozey;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import wisc.boozey.game.objects.*;

/**
 *
 */

public class GameView extends View {
    public List<GameObject> gameObjects;
    private Canvas canvas;

    public GameView(Context context, List<GameObject> gameObjects) {
        super(context);
        this.gameObjects = gameObjects;

    }

    public Canvas getCanvas(){
        return canvas;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.canvas = canvas;
        canvas.drawColor(Color.rgb(20,70,20));

        for(GameObject g : gameObjects){
            g.draw(canvas);
        }
    }


}

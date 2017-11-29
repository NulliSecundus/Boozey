package wisc.boozey.game.objects;

import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;

/**
 *
 */

public abstract class GameObject extends ShapeDrawable {
    public int posx, posy;

    public void moveTo(int x, int y){
        posx = x;
        posy = y;
    }

    public abstract void draw(Canvas canvas);

    public abstract void resize();
}

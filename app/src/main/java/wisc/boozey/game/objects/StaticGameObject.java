package wisc.boozey.game.objects;

import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;

/**
 *
 */

public abstract class StaticGameObject extends ShapeDrawable {
    public int posx, posy;

    public abstract void moveTo(int x, int y);

    public abstract void draw(Canvas canvas);

}

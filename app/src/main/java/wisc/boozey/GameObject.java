package wisc.boozey;

import android.graphics.drawable.ShapeDrawable;

/**
 *
 */

public abstract class GameObject extends ShapeDrawable {
    private int x, y;

    public void setPos(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void moveTo(){

    }

    public abstract void draw();

    public abstract void resize();
}

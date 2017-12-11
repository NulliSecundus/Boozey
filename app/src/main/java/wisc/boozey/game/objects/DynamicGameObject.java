package wisc.boozey.game.objects;

import android.content.Context;
import android.view.View;

/**
 *
 */

public abstract class DynamicGameObject extends View {
    public int left;
    public int top;
    public int right;
    public int bottom;

    public DynamicGameObject(Context context) {
        super(context);
    }

    public abstract void layout(int i, int i1, int i2, int i3);

}

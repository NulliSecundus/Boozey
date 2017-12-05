package wisc.boozey.game.objects;

import android.content.Context;
import android.view.View;

/**
 *
 */

public abstract class DynamicGameObject extends View {
    public int posx, posy;

    public DynamicGameObject(Context context) {
        super(context);
    }

}

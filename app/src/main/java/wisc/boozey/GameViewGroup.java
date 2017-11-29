package wisc.boozey;

import android.content.Context;
import android.view.ViewGroup;

/**
 *
 */

public class GameViewGroup extends ViewGroup {
    private GameStaticView gameStaticView;

    public GameViewGroup(Context context, GameStaticView gameStaticView) {
        super(context);
        this.gameStaticView = gameStaticView;
        this.addView(gameStaticView);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        gameStaticView.layout(i, i1, i2, i3);
        getChildAt(1).layout(i, i3 - 150, i2, i3);
    }
}

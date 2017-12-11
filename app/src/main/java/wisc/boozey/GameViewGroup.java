package wisc.boozey;

import android.content.Context;
import android.view.ViewGroup;

import java.util.ArrayList;

import wisc.boozey.game.objects.DynamicGameObject;

/**
 *
 */

public class GameViewGroup extends ViewGroup {
    private GameStaticView gameStaticView;
    private ArrayList<DynamicGameObject> dynamicGameObjects;

    public GameViewGroup(Context context, GameStaticView gameStaticView, ArrayList<DynamicGameObject> dynamicGameObjects) {
        super(context);
        this.gameStaticView = gameStaticView;
        this.dynamicGameObjects = dynamicGameObjects;
        this.addView(gameStaticView);
    }

    public void setDynamicGameObjects(ArrayList<DynamicGameObject> d){
        dynamicGameObjects = d;
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        gameStaticView.layout(i, i1, i2, i3);
        for(DynamicGameObject g : dynamicGameObjects){
            g.layout(i + g.left, i1 + g.top, i2 - g.right, i3 - g.bottom);
        }
    }
}

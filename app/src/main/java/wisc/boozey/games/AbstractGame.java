package wisc.boozey.games;

import android.app.Fragment;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import wisc.boozey.game.objects.*;

/**
 *
 */

public abstract class AbstractGame extends Fragment {
    private String name;
    private String description;
    ArrayList<StaticGameObject> staticGameObjects;
    ArrayList<DynamicGameObject> dynamicGameObjects;

    @Nullable
    @Override
    public abstract View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState);

    public void addToGamesList(){
        //TODO: implement this method to add to global games list
    }

    // Add a new StaticGameObject
    public abstract void addStaticGameObject(StaticGameObject staticGameObject);

    public abstract void removeStaticGameObject(StaticGameObject staticGameObject);

    public abstract void addDynamicGameObject(DynamicGameObject dynamicGameObject);

    public abstract void removeDynamicGameObject(DynamicGameObject dynamicGameObject);

    // Iterate through staticGameObjects list and draw each object
    public void drawAllGameObjects(Canvas canvas){
        for( StaticGameObject g : staticGameObjects){
            g.draw(canvas);
        }
    }

    public abstract void updateProfile();


}

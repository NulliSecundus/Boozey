package wisc.boozey;

import android.app.Fragment;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import wisc.boozey.game.objects.*;

/**
 *
 */

public abstract class AbstractGame extends Fragment {
    private String name;
    private String description;
    List<GameObject> gameObjects;

    @Nullable
    @Override
    public abstract View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState);

    public void addToGamesList(){
        //TODO: implement this method to add to global games list
    }

    // Add a new GameObject
    public abstract void addGameObject(GameObject gameObject);

    // Iterate through gameObjects list and draw each object
    public void drawAllGameObjects(Canvas canvas){
        for( GameObject g : gameObjects){
            g.draw(canvas);
        }
    }

    public abstract void updateProfile();


}

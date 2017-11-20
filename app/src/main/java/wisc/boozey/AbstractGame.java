package wisc.boozey;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */

public abstract class AbstractGame extends Fragment {
    View gameView;
    private String name;
    private String description;
    List<GameObject> gameObjects;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        gameView = new GameView(this.getContext());
        gameObjects = new ArrayList<GameObject>();
        return gameView;
    }

    public void addToGamesList(){
        //TODO: implement this method to add to global games list
    }

    // Add a new GameObject
    public abstract void addGameObject(GameObject gameObject);

    // Iterate through gameObjects list and draw each object
    public void drawAllGameObjects(){

    }

    public abstract void updateProfile();


}

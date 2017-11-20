package wisc.boozey;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wisc.boozey.game.objects.Card;

/**
 *
 */

public class TestGame extends AbstractGame {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //addGameObject(new Card(250, 500));

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void addToGamesList() {
        super.addToGamesList();
    }

    @Override
    public void addGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    @Override
    public void drawAllGameObjects() {
        super.drawAllGameObjects();
    }

    @Override
    public void updateProfile() {

    }
}

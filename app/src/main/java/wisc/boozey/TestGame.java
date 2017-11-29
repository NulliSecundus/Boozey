package wisc.boozey;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import wisc.boozey.game.objects.*;
import wisc.boozey.GameView;

/**
 *
 */

public class TestGame extends AbstractGame {

    private View gameView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        gameObjects = new ArrayList<>();
        Context context = getContext();
        addGameObject(new CardObject(10, 700, 10, "clubs", context));
        addGameObject(new CardObject(350, 700, 10, "clubs", context));
        addGameObject(new CardObject(200, 150, 0, "back", context));
        addGameObject(new CardObject(250, 150, 0, "back", context));
        addGameObject(new CardObject(300, 150, 0, "back", context));
        addGameObject(new CardObject(350, 150, 0, "back", context));
        addGameObject(new CardObject(400, 150, 0, "back", context));
        addGameObject(new CardObject(450, 150, 0, "back", context));

//        LinearLayout testLayout = new LinearLayout(context);
//        Button myButton = new Button(context);
//        myButton.setLayoutParams(new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT));
//        testLayout.addView(myButton);

        gameView = new GameView(context, gameObjects);
        return gameView;
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
    public void drawAllGameObjects(Canvas canvas) {
        super.drawAllGameObjects(canvas);
    }

    @Override
    public void updateProfile() {

    }

}

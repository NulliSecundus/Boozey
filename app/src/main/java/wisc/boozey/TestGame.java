package wisc.boozey;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import wisc.boozey.game.objects.*;

/**
 *
 */

public class TestGame extends AbstractGame {

    private GameStaticView gameStaticView;
    private GameViewGroup gameViewGroup;
    private boolean flip = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        staticGameObjects = new ArrayList<>();
        Context context = getContext();
        addGameObject(new CardObjectStatic(300, 700, 10, "clubs", context));
        addGameObject(new CardObjectStatic(200, 150, 0, "back", context));
        addGameObject(new CardObjectStatic(250, 150, 0, "back", context));
        addGameObject(new CardObjectStatic(300, 150, 0, "back", context));
        addGameObject(new CardObjectStatic(350, 150, 0, "back", context));
        addGameObject(new CardObjectStatic(400, 150, 0, "back", context));
        addGameObject(new CardObjectStatic(450, 150, 0, "back", context));

        gameStaticView = new GameStaticView(context, staticGameObjects);
        gameViewGroup = new GameViewGroup(context, gameStaticView);

        Button flipCardButton = new Button(context);
        flipCardButton.setText("Flip Card");
        flipCardButton.setTextSize(20);
        flipCardButton.setGravity(Gravity.CENTER);
        flipCardButton.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        gameViewGroup.addView(flipCardButton);

        flipCardButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(flip){
                    staticGameObjects.remove(0);
                    staticGameObjects.add(0,
                            new CardObjectStatic(300, 700, 0, "clubs", getContext()));
                    flip = false;
                }else{
                    staticGameObjects.remove(0);
                    staticGameObjects.add(0,
                            new CardObjectStatic(300, 700, 10, "clubs", getContext()));
                    flip = true;
                }
                gameStaticView.setStaticGameObjects(staticGameObjects);
                gameStaticView.invalidate();
            }
        });

        return gameViewGroup;
    }

    @Override
    public void addToGamesList() {
        super.addToGamesList();
    }

    @Override
    public void addGameObject(StaticGameObject staticGameObject) {
        staticGameObjects.add(staticGameObject);
    }

    @Override
    public void removeGameObject(StaticGameObject staticGameObject) {
        gameStaticView.staticGameObjects.remove(staticGameObject);
    }

    @Override
    public void drawAllGameObjects(Canvas canvas) {
        super.drawAllGameObjects(canvas);
    }

    @Override
    public void updateProfile() {

    }

}

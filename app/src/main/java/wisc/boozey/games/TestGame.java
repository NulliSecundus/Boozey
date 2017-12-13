package wisc.boozey.games;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import wisc.boozey.GameStaticView;
import wisc.boozey.GameViewGroup;
import wisc.boozey.game.objects.*;

/**
 *
 */

public class TestGame extends AbstractGame {

    private GameStaticView gameStaticView;
    private GameViewGroup gameViewGroup;
    private boolean flip = true;
    private TextButtonObject flipCardButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        staticGameObjects = new ArrayList<>();
        dynamicGameObjects = new ArrayList<>();

        Context context = getContext();

        gameStaticView = new GameStaticView(context, staticGameObjects);
        gameViewGroup = new GameViewGroup(context, gameStaticView, dynamicGameObjects);

        // Create the static objects, populate the container
        addStaticGameObject(new CardObjectStatic(350, 700, 6, "spades", context));
        addStaticGameObject(new CardObjectStatic(200, 150, 0, "back", context));
        addStaticGameObject(new CardObjectStatic(250, 150, 0, "back", context));
        addStaticGameObject(new CardObjectStatic(300, 150, 0, "back", context));
        addStaticGameObject(new CardObjectStatic(350, 150, 0, "back", context));
        addStaticGameObject(new CardObjectStatic(400, 150, 0, "back", context));
        addStaticGameObject(new CardObjectStatic(450, 150, 0, "back", context));

        //flipCardButton = new TextButtonObject("Flip Card", gameViewGroup, context);

        // Create the dynamic objects, populate the container
        flipCardButton = new TextButtonObject("Flip Card", 300, 1275, 300, 125, context);
        addDynamicGameObject(flipCardButton);
        addDynamicGameObject(new TextButtonObject("Button 1", 0, 1400, 550, 0, context));
        addDynamicGameObject(new TextButtonObject("Button 2", 550, 1400, 0, 0, context));

        flipCardButton.getButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(flip){
                    staticGameObjects.remove(0);
                    staticGameObjects.add(0,
                            new CardObjectStatic(350, 700, 0, "back", getContext()));
                    flip = false;
                }else{
                    staticGameObjects.remove(0);
                    staticGameObjects.add(0,
                            new CardObjectStatic(350, 700, getContext()));
                    flip = true;
                }
                gameStaticView.setStaticGameObjects(staticGameObjects);
                gameStaticView.invalidate();
            }
        });

        // Sync the dynamic object container
        gameViewGroup.setDynamicGameObjects(dynamicGameObjects);
        return gameViewGroup;
    }

    @Override
    public void addToGamesList() {
        super.addToGamesList();
    }

    @Override
    public void addStaticGameObject(StaticGameObject staticGameObject) {
        staticGameObjects.add(staticGameObject);
    }

    @Override
    public void removeStaticGameObject(StaticGameObject staticGameObject) {
        staticGameObjects.remove(staticGameObject);
    }

    @Override
    public void addDynamicGameObject(DynamicGameObject dynamicGameObject) {
        try{
            dynamicGameObjects.add(dynamicGameObject);
            gameViewGroup.addView(dynamicGameObject.getView());
        }catch (Exception e){

        }
    }

    @Override
    public void removeDynamicGameObject(DynamicGameObject dynamicGameObject) {
        try{
            gameViewGroup.removeView(dynamicGameObject.getView());
            dynamicGameObjects.remove(dynamicGameObject);
        }catch (Exception e){

        }
    }

    @Override
    public void drawAllGameObjects(Canvas canvas) {
        super.drawAllGameObjects(canvas);
    }

    @Override
    public void updateProfile() {

    }

}

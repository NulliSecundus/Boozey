package wisc.boozey.games;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import wisc.boozey.GameStaticView;
import wisc.boozey.GameViewGroup;
import wisc.boozey.game.objects.CardObjectStatic;
import wisc.boozey.game.objects.DynamicGameObject;
import wisc.boozey.game.objects.StaticGameObject;
import wisc.boozey.game.objects.TextButtonObject;

/**
 *
 */

public class RideTheBus extends AbstractGame {
    private GameStaticView gameStaticView;
    private GameViewGroup gameViewGroup;
    private TextButtonObject red;
    private TextButtonObject black;
    //private CardObjectStatic mysteryCard;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        staticGameObjects = new ArrayList<>();
        dynamicGameObjects = new ArrayList<>();

        Context context = getContext();

        gameStaticView = new GameStaticView(context, staticGameObjects);
        gameViewGroup = new GameViewGroup(context, gameStaticView, dynamicGameObjects);

        // Create the static objects, populate the container
        addStaticGameObject(new CardObjectStatic(350, 400, 0, "back", context));

        // Create the dynamic objects, populate the container
        red = new TextButtonObject("RED", 50, 1100, 550, 300, gameViewGroup, context);
        addDynamicGameObject(red);
        black = new TextButtonObject("BLACK", 550, 1100, 50, 300, gameViewGroup, context);
        addDynamicGameObject(black);

        red.getButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onRedClick();
            }
        });

        black.getButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBlackClick();
            }
        });

        // Sync the dynamic object container
        gameViewGroup.setDynamicGameObjects(dynamicGameObjects);
        return gameViewGroup;
    }

    private void onRedClick(){
        staticGameObjects.remove(0);
        staticGameObjects.add(0, new CardObjectStatic(350, 400, getContext()));

        String testSuit = ((CardObjectStatic) staticGameObjects.get(0)).getSuit();
        if(testSuit.contentEquals("hearts") || testSuit.contentEquals("diamonds")){
            Toast.makeText(getActivity(), "Correct!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(), "Incorrect!", Toast.LENGTH_SHORT).show();
        }

        gameStaticView.setStaticGameObjects(staticGameObjects);
        gameStaticView.invalidate();
    }

    private void onBlackClick(){
        staticGameObjects.remove(0);
        staticGameObjects.add(0, new CardObjectStatic(350, 400, getContext()));

        String testSuit = ((CardObjectStatic) staticGameObjects.get(0)).getSuit();
        if(testSuit.contentEquals("spades") || testSuit.contentEquals("clubs")){
            Toast.makeText(getActivity(), "Correct!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(), "Incorrect!", Toast.LENGTH_SHORT).show();
        }

        gameStaticView.setStaticGameObjects(staticGameObjects);
        gameStaticView.invalidate();
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
        dynamicGameObjects.add(dynamicGameObject);
    }

    @Override
    public void drawAllGameObjects(Canvas canvas) {
        super.drawAllGameObjects(canvas);
    }

    @Override
    public void updateProfile() {

    }
}

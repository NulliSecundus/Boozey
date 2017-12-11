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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        staticGameObjects = new ArrayList<>();
        dynamicGameObjects = new ArrayList<>();

        Context context = getContext();

        gameStaticView = new GameStaticView(context, staticGameObjects);
        gameViewGroup = new GameViewGroup(context, gameStaticView, dynamicGameObjects);

        // Create the static objects, populate the container
        addStaticGameObject(new CardObjectStatic(350, 500, 0, "back", context));

        // Create the dynamic objects, populate the container
        addDynamicGameObject(new TextButtonObject("Button 1", 50, 1300, 550, 100, gameViewGroup, context));
        addDynamicGameObject(new TextButtonObject("Button 2", 550, 1300, 50, 100, gameViewGroup, context));

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

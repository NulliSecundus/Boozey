package wisc.boozey.games;

import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import wisc.boozey.GameFragment;
import wisc.boozey.GameStaticView;
import wisc.boozey.GameViewGroup;
import wisc.boozey.R;
import wisc.boozey.game.objects.CardObjectStatic;
import wisc.boozey.game.objects.DynamicGameObject;
import wisc.boozey.game.objects.StaticGameObject;
import wisc.boozey.game.objects.TextButtonObject;
import wisc.boozey.game.objects.TextObjectSimple;

/**
 *
 */

public class RideTheBus extends AbstractGame {
    private GameStaticView gameStaticView;
    private GameViewGroup gameViewGroup;
    private TextButtonObject leftButton;
    private TextButtonObject rightButton;
    private TextButtonObject bottomLeftButton;
    private TextButtonObject bottomRightButton;
    private Context context;
    private TextObjectSimple resultText;
    private TextButtonObject cont;
    private CardObjectStatic resultCard;
    private boolean boolCont;
    private int misses;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        staticGameObjects = new ArrayList<>();
        dynamicGameObjects = new ArrayList<>();

        context = getContext();
        boolCont = true;
        misses = 0;

        gameStaticView = new GameStaticView(context, staticGameObjects);
        gameViewGroup = new GameViewGroup(context, gameStaticView, dynamicGameObjects);

        // Create the static objects, populate the container
        addStaticGameObject(new CardObjectStatic(350, 400, 0, "back", context));
        addStaticGameObject(new TextObjectSimple(115, 250, "GUESS THE COLOR", 32, context));

        // Create the dynamic objects, populate the container
        leftButton = new TextButtonObject("RED", 50, 1100, 550, 140, context);
        addDynamicGameObject(leftButton);
        rightButton = new TextButtonObject("BLACK", 550, 1100, 50, 140, context);
        addDynamicGameObject(rightButton);
        resultCard = new CardObjectStatic(350, 400, getContext());

        leftButton.getButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onRedClick();
            }
        });

        rightButton.getButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBlackClick();
            }
        });

        // Sync the dynamic object container
        gameViewGroup.setDynamicGameObjects(dynamicGameObjects);
        return gameViewGroup;
    }

    private void onRedClick(){
        if(boolCont) {
            staticGameObjects.remove(0);
            staticGameObjects.add(0, resultCard);

            removeDynamicGameObject(cont);
            removeStaticGameObject(resultText);
            String testSuit = ((CardObjectStatic) staticGameObjects.get(0)).getSuit();
            if (testSuit.contentEquals("hearts") || testSuit.contentEquals("diamonds")) {
                resultText = new TextObjectSimple(355, 1030, "Correct!", 32, context);
                boolCont = false;
                addStaticGameObject(resultText);
                cont = new TextButtonObject("Continue", 300, 1300, 300, 140, context);
                addDynamicGameObject(cont);
                cont.getButton().setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        higherLower();
                    }
                });
            } else {
                resultText = new TextObjectSimple(330, 1030, "Incorrect!", 32, context);
                boolCont = true;
                misses++;
                addStaticGameObject(resultText);
                resultCard = new CardObjectStatic(350, 400, getContext());
            }

            gameStaticView.invalidate();
        }
    }

    private void onBlackClick(){
        if(boolCont) {
            staticGameObjects.remove(0);
            staticGameObjects.add(0, resultCard);

            removeDynamicGameObject(cont);
            removeStaticGameObject(resultText);
            String testSuit = ((CardObjectStatic) staticGameObjects.get(0)).getSuit();
            if (testSuit.contentEquals("spades") || testSuit.contentEquals("clubs")) {
                resultText = new TextObjectSimple(355, 1030, "Correct!", 32, context);
                boolCont = false;
                addStaticGameObject(resultText);
                cont = new TextButtonObject("Continue", 300, 1300, 300, 140, context);
                addDynamicGameObject(cont);
                cont.getButton().setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        higherLower();
                    }
                });
            } else {
                resultText = new TextObjectSimple(330, 1030, "Incorrect!", 32, context);
                boolCont = true;
                misses++;
                addStaticGameObject(resultText);
                resultCard = new CardObjectStatic(350, 400, getContext());
            }

            gameStaticView.invalidate();
        }
    }

    private void higherLower(){
        boolCont = true;

        // Clear objects from last round
        staticGameObjects.clear();
        dynamicGameObjects.clear();
        gameViewGroup.setDynamicGameObjects(dynamicGameObjects);

        // Reset the static and dynamic layers
        gameStaticView.invalidate();
        gameViewGroup.removeAllViews();
        gameViewGroup.addView(gameStaticView);

        // Populate gameStaticView with this round's objects
        addStaticGameObject(new CardObjectStatic(550, 425, 0, "back", context));
        resultCard.moveTo(100, 475);
        resultCard.resize(300, 400);
        addStaticGameObject(resultCard);
        addStaticGameObject(new TextObjectSimple(100, 250, "HIGHER OR LOWER?", 32, context));
        addStaticGameObject(new TextObjectSimple(125, 425, "Previous", 20, context));
        resultCard = new CardObjectStatic(550, 425, getContext());
        gameStaticView.invalidate();

        // Populate the dynamic game objects
        leftButton = new TextButtonObject("HIGHER", 50, 1100, 550, 140, context);
        addDynamicGameObject(leftButton);
        rightButton = new TextButtonObject("LOWER", 550, 1100, 50, 140, context);
        addDynamicGameObject(rightButton);

        leftButton.getButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(boolCont) {
                    onHigherClick();
                }
            }
        });

        rightButton.getButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(boolCont) {
                    onLowerClick();
                }
            }
        });
    }

    private void onLowerClick() {
        staticGameObjects.remove(0);
        staticGameObjects.add(0, resultCard);

        removeDynamicGameObject(cont);
        removeStaticGameObject(resultText);
        int testValue = resultCard.getValue();
        int cmpValue = ((CardObjectStatic) staticGameObjects.get(1)).getValue();
        if(testValue < cmpValue){
            resultText = new TextObjectSimple(355, 1030, "Correct!", 32, context);
            boolCont = false;
            addStaticGameObject(resultText);
            cont = new TextButtonObject("Continue", 300, 1300, 300, 140, context);
            addDynamicGameObject(cont);
            cont.getButton().setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    insideOutside();
                }
            });
        }else{
            resultText = new TextObjectSimple(330, 1030, "Incorrect!", 32, context);
            boolCont = true;
            misses++;
            addStaticGameObject(resultText);
            resultCard = new CardObjectStatic(550, 425, getContext());
        }

        gameStaticView.invalidate();
    }

    private void onHigherClick() {
        staticGameObjects.remove(0);
        staticGameObjects.add(0, resultCard);

        removeDynamicGameObject(cont);
        removeStaticGameObject(resultText);
        int testValue = resultCard.getValue();
        int cmpValue = ((CardObjectStatic) staticGameObjects.get(1)).getValue();
        if(testValue > cmpValue){
            resultText = new TextObjectSimple(355, 1030, "Correct!", 32, context);
            boolCont = false;
            addStaticGameObject(resultText);
            cont = new TextButtonObject("Continue", 300, 1300, 300, 140, context);
            addDynamicGameObject(cont);
            cont.getButton().setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    insideOutside();
                }
            });
        }else{
            resultText = new TextObjectSimple(330, 1030, "Incorrect!", 32, context);
            boolCont = true;
            misses++;
            addStaticGameObject(resultText);
            resultCard = new CardObjectStatic(550, 425, getContext());
        }

        gameStaticView.invalidate();
    }

    private void insideOutside(){
        boolCont = true;
        StaticGameObject tmp1 = staticGameObjects.get(1);

        // Clear objects from last round
        staticGameObjects.clear();
        dynamicGameObjects.clear();
        gameViewGroup.setDynamicGameObjects(dynamicGameObjects);

        // Reset the static and dynamic layers
        gameStaticView.invalidate();
        gameViewGroup.removeAllViews();
        gameViewGroup.addView(gameStaticView);

        // Populate gameStaticView with this round's objects
        addStaticGameObject(new CardObjectStatic(550, 425, 0, "back", context));
        addStaticGameObject(tmp1);
        resultCard.moveTo(150, 500);
        resultCard.resize(300, 400);
        addStaticGameObject(resultCard);
        addStaticGameObject(new TextObjectSimple(85, 250, "INSIDE OR OUTSIDE?", 32, context));
        addStaticGameObject(new TextObjectSimple(175, 425, "Previous", 20, context));
        resultCard = new CardObjectStatic(550, 425, getContext());
        gameStaticView.invalidate();

        // Populate the dynamic game objects
        leftButton = new TextButtonObject("INSIDE", 50, 1100, 550, 140, context);
        addDynamicGameObject(leftButton);
        rightButton = new TextButtonObject("OUTSIDE", 550, 1100, 50, 140, context);
        addDynamicGameObject(rightButton);

        leftButton.getButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(boolCont) {
                    onInsideClick();
                }
            }
        });

        rightButton.getButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(boolCont) {
                    onOutsideClick();
                }
            }
        });
    }

    private void onOutsideClick() {
        staticGameObjects.remove(0);
        staticGameObjects.add(0, resultCard);

        removeDynamicGameObject(cont);
        removeStaticGameObject(resultText);
        int testValue = resultCard.getValue();
        int cmpValue1 = ((CardObjectStatic) staticGameObjects.get(1)).getValue();
        int cmpValue2 = ((CardObjectStatic) staticGameObjects.get(2)).getValue();
        if(((testValue > cmpValue1)&&(testValue > cmpValue2)) ||
                ((testValue < cmpValue1)&&(testValue < cmpValue2))){
            resultText = new TextObjectSimple(355, 1030, "Correct!", 32, context);
            boolCont = false;
            addStaticGameObject(resultText);
            cont = new TextButtonObject("Continue", 300, 1300, 300, 140, context);
            addDynamicGameObject(cont);
            cont.getButton().setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    guessSuit();
                }
            });
        }else{
            resultText = new TextObjectSimple(330, 1030, "Incorrect!", 32, context);
            boolCont = true;
            misses++;
            addStaticGameObject(resultText);
            resultCard = new CardObjectStatic(550, 425, getContext());
        }

        gameStaticView.invalidate();
    }

    private void onInsideClick() {
        staticGameObjects.remove(0);
        staticGameObjects.add(0, resultCard);

        removeDynamicGameObject(cont);
        removeStaticGameObject(resultText);
        int testValue = resultCard.getValue();
        int cmpValue1 = ((CardObjectStatic) staticGameObjects.get(1)).getValue();
        int cmpValue2 = ((CardObjectStatic) staticGameObjects.get(2)).getValue();
        if(((testValue > cmpValue1)&&(testValue < cmpValue2)) ||
                ((testValue < cmpValue1)&&(testValue > cmpValue2))){
            resultText = new TextObjectSimple(355, 1030, "Correct!", 32, context);
            boolCont = false;
            addStaticGameObject(resultText);
            cont = new TextButtonObject("Continue", 300, 1300, 300, 140, context);
            addDynamicGameObject(cont);
            cont.getButton().setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    guessSuit();
                }
            });
        }else{
            resultText = new TextObjectSimple(330, 1030, "Incorrect!", 32, context);
            boolCont = true;
            misses++;
            addStaticGameObject(resultText);
            resultCard = new CardObjectStatic(550, 425, getContext());
        }

        gameStaticView.invalidate();
    }

    private void guessSuit() {
        boolCont = true;
        StaticGameObject tmp1 = staticGameObjects.get(1);
        StaticGameObject tmp2 = staticGameObjects.get(2);

        // Clear objects from last round
        staticGameObjects.clear();
        dynamicGameObjects.clear();
        gameViewGroup.setDynamicGameObjects(dynamicGameObjects);

        // Reset the static and dynamic layers
        gameStaticView.invalidate();
        gameViewGroup.removeAllViews();
        gameViewGroup.addView(gameStaticView);

        // Populate gameStaticView with this round's objects
        addStaticGameObject(new CardObjectStatic(600, 425, 0, "back", context));
        addStaticGameObject(tmp1);
        addStaticGameObject(tmp2);
        resultCard.moveTo(200, 525);
        resultCard.resize(300, 400);
        addStaticGameObject(resultCard);
        addStaticGameObject(new TextObjectSimple(150, 250, "GUESS THE SUIT", 32, context));
        addStaticGameObject(new TextObjectSimple(175, 425, "Previous", 20, context));
        resultCard = new CardObjectStatic(600, 425, getContext());
        gameStaticView.invalidate();

        // Populate the dynamic game objects
        leftButton = new TextButtonObject("SPADES", 50, 1100, 550, 140, context);
        addDynamicGameObject(leftButton);
        rightButton = new TextButtonObject("HEARTS", 550, 1100, 50, 140, context);
        addDynamicGameObject(rightButton);
        bottomLeftButton = new TextButtonObject("DIAMONDS", 50, 1225, 550, 140, context);
        addDynamicGameObject(bottomLeftButton);
        bottomRightButton = new TextButtonObject("CLUBS", 550, 1225, 50, 140, context);
        addDynamicGameObject(bottomRightButton);

        leftButton.getButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(boolCont) {
                    onSuitClick("spades");
                }
            }
        });

        rightButton.getButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(boolCont) {
                    onSuitClick("hearts");
                }
            }
        });

        bottomLeftButton.getButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(boolCont) {
                    onSuitClick("diamonds");
                }
            }
        });

        bottomRightButton.getButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(boolCont) {
                    onSuitClick("clubs");
                }
            }
        });
    }

    private void onSuitClick(String suit) {
        staticGameObjects.remove(0);
        staticGameObjects.add(0, resultCard);

        removeDynamicGameObject(cont);
        removeStaticGameObject(resultText);
        String testSuit = resultCard.getSuit();
        if(testSuit.contentEquals(suit)){
            resultText = new TextObjectSimple(355, 1030, "Correct!", 32, context);
            boolCont = false;
            addStaticGameObject(resultText);
            cont = new TextButtonObject("Continue", 300, 1400, 300, 140, context);
            addDynamicGameObject(cont);
            cont.getButton().setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    displayStats();
                }
            });
        }else{
            resultText = new TextObjectSimple(330, 1030, "Incorrect!", 32, context);
            boolCont = true;
            misses++;
            addStaticGameObject(resultText);
            resultCard = new CardObjectStatic(600, 425, getContext());
        }

        gameStaticView.invalidate();
    }

    private void displayStats() {
        boolCont = true;

        // Clear objects from last round
        staticGameObjects.clear();
        dynamicGameObjects.clear();
        gameViewGroup.setDynamicGameObjects(dynamicGameObjects);

        // Reset the static and dynamic layers
        gameStaticView.invalidate();
        gameViewGroup.removeAllViews();
        gameViewGroup.addView(gameStaticView);

        // Populate gameStaticView with the final stats
        addStaticGameObject(new TextObjectSimple(125, 400, "FINAL STATISTICS", 32, context));
        String drinksTaken = "Drinks Taken: " + misses;
        addStaticGameObject(new TextObjectSimple(280, 600, drinksTaken, 24, context));
        gameStaticView.invalidate();

        // Populate the dynamic game objects
        cont = new TextButtonObject("Continue", 300, 750, 300, 140, context);
        addDynamicGameObject(cont);
        cont.getButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.main_layout, new GameFragment())
                        .commit();
            }
        });
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

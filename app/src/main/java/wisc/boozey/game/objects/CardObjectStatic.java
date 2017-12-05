package wisc.boozey.game.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import java.util.Random;
import wisc.boozey.R;

/**
 *
 */

public class CardObjectStatic extends StaticGameObject {
    private int width;
    private int height;
    private Rect bounds;
    private Drawable cardPic;
    private String suit;
    private int value;

    public CardObjectStatic(int x, int y, int value, String suit, Context context){
        posx = x;
        posy = y;
        width = 375;
        height = 500;
        this.suit = suit;
        this.value = value;

        cardPic = setPic(value, suit, context);
        bounds = new Rect(posx, posy, posx + width, posy + height);
        cardPic.setBounds(bounds);
    }

    public CardObjectStatic(int x, int y, Context context){
        posx = x;
        posy = y;
        width = 375;
        height = 500;

        Random rng = new Random();
        value = rng.nextInt(13) + 1;
        int suitInt = rng.nextInt(4) + 1;
        switch (suitInt) {
            case 1:
                suit = "clubs";
                break;
            case 2:
                suit = "diamonds";
                break;
            case 3:
                suit = "hearts";
                break;
            case 4:
                suit = "spades";
                break;
            default:
                suit = "back";
                break;
        }

        cardPic = setPic(value, suit, context);
        bounds = new Rect(posx, posy, posx + width, posy + height);
        cardPic.setBounds(bounds);
    }

    private Drawable setPic(int value, String suit, Context context){
        switch (value){
            case 1:
                switch (suit){
                    case "clubs":
                        return  context.getDrawable(R.drawable.card_ace_of_clubs);
                    case "diamonds":
                        return  context.getDrawable(R.drawable.card_ace_of_diamonds);
                    case "hearts":
                        return  context.getDrawable(R.drawable.card_ace_of_hearts);
                    case "spades":
                        return  context.getDrawable(R.drawable.card_ace_of_spades);
                    default:
                        posy -= 7;
                        posx -= 7;
                        height += 17;
                        width += 10;
                        return  context.getDrawable(R.drawable.card_back);
                }
            case 2:
                switch (suit){
                    case "clubs":
                        return  context.getDrawable(R.drawable.card_2_of_clubs);
                    case "diamonds":
                        return  context.getDrawable(R.drawable.card_2_of_diamonds);
                    case "hearts":
                        return  context.getDrawable(R.drawable.card_2_of_hearts);
                    case "spades":
                        return  context.getDrawable(R.drawable.card_2_of_spades);
                    default:
                        posy -= 7;
                        posx -= 7;
                        height += 17;
                        width += 10;
                        return  context.getDrawable(R.drawable.card_back);
                }
            case 3:
                switch (suit){
                    case "clubs":
                        return  context.getDrawable(R.drawable.card_3_of_clubs);
                    case "diamonds":
                        return  context.getDrawable(R.drawable.card_3_of_diamonds);
                    case "hearts":
                        return  context.getDrawable(R.drawable.card_3_of_hearts);
                    case "spades":
                        return  context.getDrawable(R.drawable.card_3_of_spades);
                    default:
                        posy -= 7;
                        posx -= 7;
                        height += 17;
                        width += 10;
                        return  context.getDrawable(R.drawable.card_back);
                }
            case 4:
                switch (suit){
                    case "clubs":
                        return  context.getDrawable(R.drawable.card_4_of_clubs);
                    case "diamonds":
                        return  context.getDrawable(R.drawable.card_4_of_diamonds);
                    case "hearts":
                        return  context.getDrawable(R.drawable.card_4_of_hearts);
                    case "spades":
                        return  context.getDrawable(R.drawable.card_4_of_spades);
                    default:
                        posy -= 7;
                        posx -= 7;
                        height += 17;
                        width += 10;
                        return  context.getDrawable(R.drawable.card_back);
                }
            case 5:
                switch (suit){
                    case "clubs":
                        return  context.getDrawable(R.drawable.card_5_of_clubs);
                    case "diamonds":
                        return  context.getDrawable(R.drawable.card_5_of_diamonds);
                    case "hearts":
                        return  context.getDrawable(R.drawable.card_5_of_hearts);
                    case "spades":
                        return  context.getDrawable(R.drawable.card_5_of_spades);
                    default:
                        posy -= 7;
                        posx -= 7;
                        height += 17;
                        width += 10;
                        return  context.getDrawable(R.drawable.card_back);
                }
            case 6:
                switch (suit){
                    case "clubs":
                        return  context.getDrawable(R.drawable.card_6_of_clubs);
                    case "diamonds":
                        return  context.getDrawable(R.drawable.card_6_of_diamonds);
                    case "hearts":
                        return  context.getDrawable(R.drawable.card_6_of_hearts);
                    case "spades":
                        return  context.getDrawable(R.drawable.card_6_of_spades);
                    default:
                        posy -= 7;
                        posx -= 7;
                        height += 17;
                        width += 10;
                        return  context.getDrawable(R.drawable.card_back);
                }
            case 7:
                switch (suit){
                    case "clubs":
                        return  context.getDrawable(R.drawable.card_7_of_clubs);
                    case "diamonds":
                        return  context.getDrawable(R.drawable.card_7_of_diamonds);
                    case "hearts":
                        return  context.getDrawable(R.drawable.card_7_of_hearts);
                    case "spades":
                        return  context.getDrawable(R.drawable.card_7_of_spades);
                    default:
                        posy -= 7;
                        posx -= 7;
                        height += 17;
                        width += 10;
                        return  context.getDrawable(R.drawable.card_back);
                }
            case 8:
                switch (suit){
                    case "clubs":
                        return  context.getDrawable(R.drawable.card_8_of_clubs);
                    case "diamonds":
                        return  context.getDrawable(R.drawable.card_8_of_diamonds);
                    case "hearts":
                        return  context.getDrawable(R.drawable.card_8_of_hearts);
                    case "spades":
                        return  context.getDrawable(R.drawable.card_8_of_spades);
                    default:
                        posy -= 7;
                        posx -= 7;
                        height += 17;
                        width += 10;
                        return  context.getDrawable(R.drawable.card_back);
                }
            case 9:
                switch (suit){
                    case "clubs":
                        return  context.getDrawable(R.drawable.card_9_of_clubs);
                    case "diamonds":
                        return  context.getDrawable(R.drawable.card_9_of_diamonds);
                    case "hearts":
                        return  context.getDrawable(R.drawable.card_9_of_hearts);
                    case "spades":
                        return  context.getDrawable(R.drawable.card_9_of_spades);
                    default:
                        posy -= 7;
                        posx -= 7;
                        height += 17;
                        width += 10;
                        return  context.getDrawable(R.drawable.card_back);
                }
            case 10:
                switch (suit){
                    case "clubs":
                        return  context.getDrawable(R.drawable.card_10_of_clubs);
                    case "diamonds":
                        return  context.getDrawable(R.drawable.card_10_of_diamonds);
                    case "hearts":
                        return  context.getDrawable(R.drawable.card_10_of_hearts);
                    case "spades":
                        return  context.getDrawable(R.drawable.card_10_of_spades);
                    default:
                        posy -= 7;
                        posx -= 7;
                        height += 17;
                        width += 10;
                        return  context.getDrawable(R.drawable.card_back);
                }
            case 11:
                switch (suit){
                    case "clubs":
                        return  context.getDrawable(R.drawable.card_jack_of_clubs);
                    case "diamonds":
                        return  context.getDrawable(R.drawable.card_jack_of_diamonds);
                    case "hearts":
                        return  context.getDrawable(R.drawable.card_jack_of_hearts);
                    case "spades":
                        return  context.getDrawable(R.drawable.card_jack_of_spades);
                    default:
                        posy -= 7;
                        posx -= 7;
                        height += 17;
                        width += 10;
                        return  context.getDrawable(R.drawable.card_back);
                }
            case 12:
                switch (suit){
                    case "clubs":
                        return  context.getDrawable(R.drawable.card_queen_of_clubs);
                    case "diamonds":
                        return  context.getDrawable(R.drawable.card_queen_of_diamonds);
                    case "hearts":
                        return  context.getDrawable(R.drawable.card_queen_of_hearts);
                    case "spades":
                        return  context.getDrawable(R.drawable.card_queen_of_spades);
                    default:
                        posy -= 7;
                        posx -= 7;
                        height += 17;
                        width += 10;
                        return  context.getDrawable(R.drawable.card_back);
                }
            case 13:
                switch (suit){
                    case "clubs":
                        return  context.getDrawable(R.drawable.card_king_of_clubs);
                    case "diamonds":
                        return  context.getDrawable(R.drawable.card_king_of_diamonds);
                    case "hearts":
                        return  context.getDrawable(R.drawable.card_king_of_hearts);
                    case "spades":
                        return  context.getDrawable(R.drawable.card_king_of_spades);
                    default:
                        posy -= 7;
                        posx -= 7;
                        height += 17;
                        width += 10;
                        return  context.getDrawable(R.drawable.card_back);
                }
            default:
                posy -= 7;
                posx -= 7;
                height += 17;
                width += 10;
                return  context.getDrawable(R.drawable.card_back);
        }
    }

    @Override
    public void moveTo(int x, int y) {
        super.moveTo(x, y);
    }

    @Override
    public void draw(Canvas canvas) {
        cardPic.draw(canvas);
    }

    @Override
    public void resize() {

    }
}

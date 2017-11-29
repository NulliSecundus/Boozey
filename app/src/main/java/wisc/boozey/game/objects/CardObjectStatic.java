package wisc.boozey.game.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
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
        width = 500;
        height = 500;
        this.suit = suit;
        this.value = value;

        cardPic = setPic(value, suit, context);
        bounds = new Rect(posx, posy, posx + width, posy + height);
        cardPic.setBounds(bounds);
    }

    private Drawable setPic(int value, String suit, Context context){
        switch (value){
            case 1:
                switch (suit){
                    case "clubs":

                    case "diamonds":

                    case "hearts":

                    case "spades":

                    default:
                        posy -= 9;
                        height += 17;
                        return context.getResources().getDrawable(R.mipmap.ic_card_back);
                }
            case 2:
                switch (suit){
                    case "clubs":

                    case "diamonds":

                    case "hearts":

                    case "spades":

                    default:
                        posy -= 9;
                        height += 17;
                        return context.getResources().getDrawable(R.mipmap.ic_card_back);
                }
            case 3:
                switch (suit){
                    case "clubs":

                    case "diamonds":

                    case "hearts":

                    case "spades":

                    default:
                        posy -= 9;
                        height += 17;
                        return context.getResources().getDrawable(R.mipmap.ic_card_back);
                }
            case 4:
                switch (suit){
                    case "clubs":

                    case "diamonds":

                    case "hearts":

                    case "spades":

                    default:
                        posy -= 9;
                        height += 17;
                        return context.getResources().getDrawable(R.mipmap.ic_card_back);
                }
            case 5:
                switch (suit){
                    case "clubs":

                    case "diamonds":

                    case "hearts":

                    case "spades":

                    default:
                        posy -= 9;
                        height += 17;
                        return context.getResources().getDrawable(R.mipmap.ic_card_back);
                }
            case 6:
                switch (suit){
                    case "clubs":

                    case "diamonds":

                    case "hearts":

                    case "spades":

                    default:
                        posy -= 9;
                        height += 17;
                        return context.getResources().getDrawable(R.mipmap.ic_card_back);
                }
            case 7:
                switch (suit){
                    case "clubs":

                    case "diamonds":

                    case "hearts":

                    case "spades":

                    default:
                        posy -= 9;
                        height += 17;
                        return context.getResources().getDrawable(R.mipmap.ic_card_back);
                }
            case 8:
                switch (suit){
                    case "clubs":

                    case "diamonds":

                    case "hearts":

                    case "spades":

                    default:
                        posy -= 9;
                        height += 17;
                        return context.getResources().getDrawable(R.mipmap.ic_card_back);
                }
            case 9:
                switch (suit){
                    case "clubs":

                    case "diamonds":

                    case "hearts":

                    case "spades":

                    default:
                        posy -= 9;
                        height += 17;
                        return context.getResources().getDrawable(R.mipmap.ic_card_back);
                }
            case 10:
                switch (suit){
                    case "clubs":
                        return context.getResources().getDrawable(R.mipmap.ic_10_of_clubs);
                    default:
                        posy -= 9;
                        height += 17;
                        return context.getResources().getDrawable(R.mipmap.ic_card_back);
                }
            case 11:
                switch (suit){
                    case "clubs":

                    case "diamonds":

                    case "hearts":

                    case "spades":

                    default:
                        posy -= 9;
                        height += 17;
                        return context.getResources().getDrawable(R.mipmap.ic_card_back);
                }
            case 12:
                switch (suit){
                    case "clubs":

                    case "diamonds":

                    case "hearts":

                    case "spades":

                    default:
                        posy -= 9;
                        height += 17;
                        return context.getResources().getDrawable(R.mipmap.ic_card_back);
                }
            case 13:
                switch (suit){
                    case "clubs":

                    case "diamonds":

                    case "hearts":

                    case "spades":

                    default:
                        posy -= 9;
                        height += 17;
                        return context.getResources().getDrawable(R.mipmap.ic_card_back);
                }
            default:
                posy -= 9;
                height += 17;
                return context.getResources().getDrawable(R.mipmap.ic_card_back);
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

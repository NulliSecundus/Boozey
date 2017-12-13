package wisc.boozey.game.objects;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 *
 */

public class TextButtonObject extends DynamicGameObject {
    private Button button;


    public TextButtonObject(String text, Context context) {
        super(context);
        left = 0;
        top = 0;
        right = 0;
        height = 50;
        button = new Button(context);
        button.setText(text);
        button.setTextSize(20);
        button.setGravity(Gravity.CENTER);
        button.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
    }

    public TextButtonObject(String text, int l, int t, int r, int h, Context context) {
        super(context);
        left = l;
        top = t;
        right = r;
        height = h;
        button = new Button(context);
        button.setText(text);
        button.setTextSize(20);
        button.setGravity(Gravity.CENTER);
        button.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
    }

    public Button getButton(){
        return button;
    }

    public void setPosition(int l, int t, int r, int h){
        left = l;
        top = t;
        right = r;
        height = h;
    }

    @Override
    public void layout(int l, int t, int r, int h) {
        button.layout(l, t, r, h);
    }

    @Override
    public View getView() {
        return button;
    }
}

package wisc.boozey.game.objects;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import wisc.boozey.GameViewGroup;

/**
 *
 */

public class ButtonObject extends DynamicGameObject {
    private Button button;

    public ButtonObject(String text, GameViewGroup gameViewGroup, Context context) {
        super(context);
        button = new Button(context);
        button.setText(text);
        button.setTextSize(20);
        button.setGravity(Gravity.CENTER);
        button.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        gameViewGroup.addView(button);
    }

    public Button getButton(){
        return button;
    }
}

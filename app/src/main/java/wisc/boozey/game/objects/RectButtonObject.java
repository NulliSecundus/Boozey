package wisc.boozey.game.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Brendan on 11/29/2017.
 */

public class RectButtonObject extends GameObject {
    private Button button;
    private Rect bounds;

    public RectButtonObject(Context context){
        button = new Button(context);
        bounds = new Rect(10, 10, 50, 50);
        //button.setClipBounds(bounds);
        LinearLayout linearLayout = new LinearLayout(context);
        button.setText(" Button Programmatically ");
        button.setTextSize(20);
        button.setGravity(Gravity.CENTER);
        linearLayout.addView(button);

    }

    @Override
    public void draw(Canvas canvas) {
        button.draw(canvas);
    }

    @Override
    public void resize() {

    }
}

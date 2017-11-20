package wisc.boozey;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 *
 */

public class GameView extends View {
    public Rect rectangle;
    private Paint paint;
    Drawable tenClubs = getResources().getDrawable(R.mipmap.ic_10_of_clubs);

    public GameView(Context context) {
        super(context);
        int x = 150;
        int y = 250;
        int width = 800;
        int height = 800;

        rectangle = new Rect(x, y, x + width, y + height);
        paint = new Paint();
        paint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.GRAY);
        //canvas.drawRect(rectangle, paint);
        tenClubs.setBounds(rectangle);
        tenClubs.draw(canvas);
    }
}

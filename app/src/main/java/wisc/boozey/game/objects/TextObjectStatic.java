package wisc.boozey.game.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;

/**
 *
 */

public class TextObjectStatic extends StaticGameObject {
    private String text;
    private TextPaint textPaint;
    private int width;
    private StaticLayout textLayout;

    public TextObjectStatic(int x, int y, String text, int size, Context context){
        this.text = text;
        posx = x;
        posy = y;
        textPaint = new TextPaint();
        textPaint.setTextSize(size * context.getResources().getDisplayMetrics().density);
        textPaint.setColor(Color.WHITE);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        width = (int) textPaint.measureText(text);
        textLayout = new StaticLayout(text, textPaint, width,
                Layout.Alignment.ALIGN_CENTER, 1.0f, 0, false);
    }

    public TextObjectStatic(int x, int y, String text, Context context){
        this.text = text;
        posx = x;
        posy = y;
        textPaint = new TextPaint();
        textPaint.setTextSize(24 * context.getResources().getDisplayMetrics().density);
        textPaint.setColor(Color.WHITE);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        width = (int) textPaint.measureText(text);
        textLayout = new StaticLayout(text, textPaint, width,
                Layout.Alignment.ALIGN_CENTER, 1.0f, 0, false);
    }

    @Override
    public void moveTo(int x, int y) {
        posx = x;
        posy = y;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.translate((float) posx, (float) posy);
        textLayout.draw(canvas);
        //canvas.restore();
    }

}

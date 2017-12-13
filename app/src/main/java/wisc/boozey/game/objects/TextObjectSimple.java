package wisc.boozey.game.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextPaint;

/**
 *
 */

public class TextObjectSimple extends StaticGameObject {
    private String text;
    private TextPaint textPaint;

    public TextObjectSimple(int x, int y, String text, int size, Context context){
        this.text = text;
        posx = x;
        posy = y;
        textPaint = new TextPaint();
        textPaint.setTextSize(size * context.getResources().getDisplayMetrics().density);
        textPaint.setColor(Color.WHITE);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
    }

    public TextObjectSimple(int x, int y, String text, Context context){
        this.text = text;
        posx = x;
        posy = y;
        textPaint = new TextPaint();
        textPaint.setTextSize(24 * context.getResources().getDisplayMetrics().density);
        textPaint.setColor(Color.WHITE);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
    }

    @Override
    public void moveTo(int x, int y) {
        posx = x;
        posy = y;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawText(text, (float) posx, (float) posy, textPaint);
    }

}

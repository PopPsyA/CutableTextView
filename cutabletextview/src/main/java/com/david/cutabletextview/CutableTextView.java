package com.david.cutabletextview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;

public class CutableTextView extends AppCompatTextView {

    private boolean clicked = false;
    private boolean linesRendered = false;
    private int totalCountLines;
    private int linesToCut;

    private static final String PROPERTY_MAX_LINES = "maxLines";

    public CutableTextView(Context context) {
        super(context);
        init(context , null);
        linesToCut = 4;
    }

    public CutableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context , attrs);
    }

    public CutableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context , attrs);
    }

    public void setLinesToCut(int linesToCut){
        this.linesToCut = linesToCut;
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        post(() -> {
            if (getLineCount() > linesToCut && !linesRendered){
                totalCountLines = getLineCount();
                linesRendered = true;
            }
            if (totalCountLines > linesToCut){
                setLines(linesToCut);
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP) {
            if (!clicked) {
                expandAnimation();
                clicked = true;
            } else {
                collapseAnimation();
                clicked = false;
            }
        }
        return super.dispatchTouchEvent(event);
    }

    private void expandAnimation(){
        startMaxLineAnimationChanger(totalCountLines , 0);
    }

    private void collapseAnimation(){
        startMaxLineAnimationChanger(totalCountLines , linesToCut);
    }

    private void startMaxLineAnimationChanger(int from , int to) {
        if (totalCountLines > linesToCut){
            ObjectAnimator objectAnimator = ObjectAnimator.ofInt(this, PROPERTY_MAX_LINES, from , to);
            if (to == 0){
                objectAnimator = ObjectAnimator.ofInt(this , PROPERTY_MAX_LINES , from);
            }
            if (totalCountLines <= 8){
                objectAnimator.setDuration(70);
            }
            objectAnimator.start();
        }
    }

    private void init(Context context , @Nullable AttributeSet attrs) {
        if (attrs != null){
            TypedArray a = context.obtainStyledAttributes(attrs , R.styleable.CutableTextView);
            linesToCut = a.getInt(R.styleable.CutableTextView_ctv_lines_to_cut , 4);
            a.recycle();
        }
        setEllipsize(TextUtils.TruncateAt.END);
        setClickable(true);
        setFocusable(true);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground , typedValue , true);
        setBackgroundResource(typedValue.resourceId);
    }
}
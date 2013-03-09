package com.brentpanther.borderedviews;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class BorderedRelativeLayout extends RelativeLayout {

	private Borders borders;
	private boolean paddingCalculated;
	
	public BorderedRelativeLayout(Context context) {
		super(context);
		borders = new Borders();
		this.setWillNotDraw(false);
	}

	public BorderedRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		borders = new Borders(context, attrs);
		this.setWillNotDraw(false);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		if(!paddingCalculated) {
			setPadding(getPaddingLeft() + borders.getLeftBorder(), getPaddingTop() + borders.getTopBorder(),
				getPaddingRight() + borders.getRightBorder(), getPaddingBottom() + borders.getBottomBorder());
			paddingCalculated = true;
		} else {
			borders.onViewDraw(this, canvas);
		}
	}


	public void setBorders(boolean left, boolean top, boolean right, boolean bottom) {
		borders.setBorders(left, top, right, bottom);
		postInvalidate();
	}

	public void setBorderColor(int borderColor) {
		borders.setBorderColor(borderColor);
		postInvalidate();
	}

	public int getBorderColor() {
		return borders.getBorderColor();
	}

	public void setBorderWidth(int borderWidth) {
		borders.setBorderWidth(borderWidth);
		postInvalidate();
	}

	public int getBorderWidth() {
		return borders.getBorderWidth();
	}

	public void setRadii(float topLeft, float topRight, float bottomRight, float bottomLeft) {
		borders.setRadii(topLeft, topRight, bottomRight, bottomLeft);
		postInvalidate();
	}

	public float[] getRadii() {
		return borders.getRadii();
	}

}


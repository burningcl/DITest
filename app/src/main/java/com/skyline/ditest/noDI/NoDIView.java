package com.skyline.ditest.noDI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.skyline.ditest.R;

/**
 * Created by jairus on 16/4/6.
 */
public class NoDIView extends FrameLayout {

	private TextView tv;

	private EditText et;

	private ImageView iv;


	public NoDIView(Context context) {
		super(context);
		init(context);
	}

	public NoDIView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public NoDIView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
	}

	public void init(Context context) {
		View rootView = inflate(context, R.layout.view_test, this);

		tv = (TextView) rootView.findViewById(R.id.tv_view_test);
		et = (EditText) rootView.findViewById(R.id.et_view_test);
		iv = (ImageView) rootView.findViewById(R.id.iv_view_test);

		new NoDIChangeMaker().change(tv, et, iv);
	}

}

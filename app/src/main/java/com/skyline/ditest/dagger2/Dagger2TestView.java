package com.skyline.ditest.dagger2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.skyline.ditest.DITestApplication;
import com.skyline.ditest.R;

import javax.inject.Inject;

import dagger.Lazy;

/**
 * Created by jairus on 16/4/6.
 */
public class Dagger2TestView extends FrameLayout {

	private TextView tv;

	private EditText et;

	private ImageView iv;

	private String tvChanged;

	private String etChanged;

	@Inject
	@Named("forView")
	Lazy<Dagger2TestChangeMaker> changeMaker;

	public Dagger2TestView(Context context) {
		super(context);
		init(context);
	}

	public Dagger2TestView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public Dagger2TestView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
	}

	public void init(Context context) {
		View rootView = inflate(context, R.layout.view_test, this);

		tv = (TextView) rootView.findViewById(R.id.tv_view_test);
		et = (EditText) rootView.findViewById(R.id.et_view_test);
		iv = (ImageView) rootView.findViewById(R.id.iv_view_test);

		tvChanged = getResources().getString(R.string.tv_changed);
		etChanged = getResources().getString(R.string.et_changed);

		DITestApplication.getInstance().getComponent().inject(this);

		changeMaker.get().change(tv, et, iv,tvChanged,etChanged);
	}

}

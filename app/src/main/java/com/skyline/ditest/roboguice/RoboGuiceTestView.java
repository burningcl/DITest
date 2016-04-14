package com.skyline.ditest.roboguice;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.inject.Inject;
import com.skyline.ditest.R;

import roboguice.RoboGuice;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;
import roboguice.inject.RoboInjector;

/**
 * Created by jairus on 16/4/6.
 */
public class RoboGuiceTestView extends FrameLayout {

	@InjectView(R.id.tv_view_test)
	private TextView tv;

	@InjectView(R.id.et_view_test)
	private EditText et;

	@InjectView(R.id.iv_view_test)
	private ImageView iv;

	@Inject
	private RoboGuiceTestChangeMaker changeMaker;

	@InjectResource(R.string.tv_changed)
	private String tvChanged;

	@InjectResource(R.string.et_changed)
	private String etChanged;

	public RoboGuiceTestView(Context context) {
		super(context);
		init(context);
	}

	public RoboGuiceTestView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public RoboGuiceTestView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
	}

	public void init(Context context) {
		inflate(context, R.layout.view_test, this);

		RoboInjector injector=RoboGuice.getInjector(context);
		injector.injectMembers(this);
		// 官方文档上面，少了这一步，会出现view没有被注入进来，出现NullPoint
		injector.injectViewMembers(this);

		changeMaker.change(tv, et, iv, tvChanged, etChanged);
	}

}

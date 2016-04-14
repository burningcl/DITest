package com.skyline.ditest.roboguice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.inject.Inject;
import com.skyline.ditest.R;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;

/**
 * Created by jairus on 16/4/6.
 */
@ContentView(R.layout.activity_test_di_with_roboguice)
public class RoboGuiceTestActivity extends RoboActivity {

	private static final String LOG_TAG = RoboGuiceTestActivity.class.getSimpleName();

	@InjectView(R.id.tv)
	private TextView tv;

	@InjectView(R.id.et)
	private EditText et;

	@InjectView(R.id.iv)
	private ImageView iv;

	@Inject
	private RoboGuiceTestChangeMaker changeMaker;

	@InjectResource(R.string.tv_changed)
	private String tvChanged;

	@InjectResource(R.string.et_changed)
	private String etChanged;

	private static long startTime;

	private static long finishTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		makeChange();
	}

	public void makeChange() {
		changeMaker.change(tv, et, iv, tvChanged, etChanged);
	}

	public void onStart() {
		super.onStart();
		finishTime = System.currentTimeMillis();
		Log.d(LOG_TAG, "cost: " + (finishTime - startTime));
	}

	public static void startActivity(Context context) {
		startTime = System.currentTimeMillis();
		context.startActivity(new Intent(context, RoboGuiceTestActivity.class));
	}

}

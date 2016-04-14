package com.skyline.ditest.dagger2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.skyline.ditest.DITestApplication;
import com.skyline.ditest.R;

import javax.inject.Inject;

/**
 * Created by jairus on 16/4/6.
 */
public class Dagger2TestActivity extends Activity {

	private static final String LOG_TAG = Dagger2TestActivity.class.getSimpleName();

	private TextView tv;

	private EditText et;

	private ImageView iv;

	@Inject
	Dagger2TestChangeMaker changeMaker;

	private String tvChanged;

	private String etChanged;

	private static long startTime;

	private static long finishTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_test_di_with_dagger2);

		tv = (TextView) findViewById(R.id.tv);
		et = (EditText) findViewById(R.id.et);
		iv = (ImageView) findViewById(R.id.iv);

		tvChanged = getResources().getString(R.string.tv_changed);
		etChanged = getResources().getString(R.string.et_changed);

		((DITestApplication) getApplication()).getComponent().inject(this);

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
		context.startActivity(new Intent(context, Dagger2TestActivity.class));
	}

}

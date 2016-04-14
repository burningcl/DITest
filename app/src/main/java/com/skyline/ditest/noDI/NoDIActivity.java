package com.skyline.ditest.noDI;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.skyline.ditest.R;

/**
 * Created by jairus on 16/4/6.
 */
public class NoDIActivity extends Activity {

	private static final String LOG_TAG = NoDIActivity.class.getSimpleName();

	private TextView tv;

	private EditText et;

	private ImageView iv;

	private static long startTime;

	private static long finishTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_no_di);

		tv = (TextView) findViewById(R.id.tv);
		et = (EditText) findViewById(R.id.et);
		iv = (ImageView) findViewById(R.id.iv);

		makeChange();
	}

	public void onStart() {
		super.onStart();
		finishTime = System.currentTimeMillis();
		Log.d(LOG_TAG, "cost: " + (finishTime - startTime));
	}

	public void makeChange() {
		new NoDIChangeMaker().change(tv, et, iv);
	}

	public static void startActivity(Context context) {
		startTime = System.currentTimeMillis();
		context.startActivity(new Intent(context, NoDIActivity.class));
	}

}

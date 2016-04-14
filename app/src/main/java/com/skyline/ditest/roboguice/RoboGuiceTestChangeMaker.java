package com.skyline.ditest.roboguice;

import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.skyline.ditest.R;

import roboguice.inject.ContextSingleton;

/**
 * Created by jairus on 16/4/6.
 */
@ContextSingleton
public class RoboGuiceTestChangeMaker {

	private static final String LOG_ATG = RoboGuiceTestChangeMaker.class.getSimpleName();

	public void change( TextView tv,EditText et, ImageView iv, String tvStr, String etStr){
		tv.setText(tvStr);
		et.setText(etStr);
		iv.setImageResource(R.drawable.github_s);
		Log.d(LOG_ATG, "hash code: " + this.hashCode());
	}
}

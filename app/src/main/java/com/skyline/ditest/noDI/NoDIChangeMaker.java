package com.skyline.ditest.noDI;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.skyline.ditest.R;

/**
 * Created by jairus on 16/4/6.
 */
public class NoDIChangeMaker {

	public void change( TextView tv,EditText et, ImageView iv){
		tv.setText("TextView is changed!");
		et.setText("EditText is changed!");
		iv.setImageResource(R.drawable.github_s);
	}
}

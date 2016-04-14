package com.skyline.ditest.roboguice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.inject.Inject;
import com.skyline.ditest.R;

import roboguice.fragment.provided.RoboFragment;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;

/**
 * Created by jairus on 16/4/6.
 */
public class RoboGuiceTestFragment extends RoboFragment {

	@InjectView(R.id.tv_fragment_test)
	private TextView tv;

	@InjectView(R.id.et_fragment_test)
	private EditText et;

	@InjectView(R.id.iv_fragment_test)
	private ImageView iv;

	@Inject
	private RoboGuiceTestChangeMaker changeMaker;

	@InjectResource(R.string.tv_changed)
	private String tvChanged;

	@InjectResource(R.string.et_changed)
	private String etChanged;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_test, container, false);
		//changeMaker.change();不能在这里调用，因为此时view还没有被注入，会导致NullPoint
		return rootView;
	}

	@Override
	public void onStart(){
		super.onStart();
		changeMaker.change(tv, et, iv, tvChanged, etChanged);
	}

}

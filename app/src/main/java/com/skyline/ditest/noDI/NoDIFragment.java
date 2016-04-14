package com.skyline.ditest.noDI;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.skyline.ditest.R;

/**
 * Created by jairus on 16/4/6.
 */
public class NoDIFragment extends Fragment {

	private TextView tv;

	private EditText et;

	private ImageView iv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_test, container, false);
		init(rootView);
		return rootView;
	}


	public void init(View rootView) {

		tv = (TextView) rootView.findViewById(R.id.tv_fragment_test);
		et = (EditText) rootView.findViewById(R.id.et_fragment_test);
		iv = (ImageView) rootView.findViewById(R.id.iv_fragment_test);

		new NoDIChangeMaker().change(tv, et, iv);
	}

}

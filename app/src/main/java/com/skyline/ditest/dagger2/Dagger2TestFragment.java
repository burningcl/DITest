package com.skyline.ditest.dagger2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.skyline.ditest.DITestApplication;
import com.skyline.ditest.R;

import javax.inject.Inject;

/**
 * Created by jairus on 16/4/6.
 */
public class Dagger2TestFragment extends Fragment {

	private TextView tv;

	private EditText et;

	private ImageView iv;

	private String tvChanged;

	private String etChanged;

	@Inject
	@Named("forFragment")
	Dagger2TestChangeMaker changeMaker;

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

		tvChanged = getResources().getString(R.string.tv_changed);
		etChanged = getResources().getString(R.string.et_changed);

		DITestApplication.getInstance().getComponent().inject(this);

		changeMaker.change(tv, et, iv, tvChanged, etChanged);
	}

}

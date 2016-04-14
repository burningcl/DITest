package com.skyline.ditest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.skyline.ditest.dagger2.Dagger2TestActivity;
import com.skyline.ditest.noDI.NoDIActivity;
import com.skyline.ditest.roboguice.RoboGuiceTestActivity;

public class MainActivity extends AppCompatActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});

		TextView tvNoDi=(TextView)findViewById(R.id.tv_no_di);
		tvNoDi.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				NoDIActivity.startActivity(MainActivity.this);
			}
		});

		TextView tvWithRoboguice=(TextView)findViewById(R.id.tv_with_roboguice);
		tvWithRoboguice.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				RoboGuiceTestActivity.startActivity(MainActivity.this);
			}
		});

		TextView tvWithDagger=(TextView)findViewById(R.id.tv_with_dagger2);
		tvWithDagger.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Dagger2TestActivity.startActivity(MainActivity.this);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}

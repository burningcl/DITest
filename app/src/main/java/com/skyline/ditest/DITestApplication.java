package com.skyline.ditest;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.skyline.ditest.dagger2.Dagger2TestComponent;
import com.skyline.ditest.dagger2.Dagger2TestModule;
import com.skyline.ditest.dagger2.DaggerDagger2TestComponent;

import roboguice.RoboGuice;

/**
 * Created by jairus on 16/4/6.
 */
public class DITestApplication extends Application {

	private static DITestApplication instance;

	public static DITestApplication getInstance() {
		if (instance == null) {
			throw new RuntimeException("DITestApplication not created");
		}
		return instance;
	}

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		// release包不开启MultiDex
		if (BuildConfig.BUILD_TYPE.equals("dev") || BuildConfig.BUILD_TYPE.equals("debug")) {
			MultiDex.install(this);
		}
	}

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		this.component = DaggerDagger2TestComponent.builder().dagger2TestModule(new Dagger2TestModule()).build();
	}

	public Dagger2TestComponent getComponent() {
		return this.component;
	}
	private Dagger2TestComponent component;

	static {
		RoboGuice.setUseAnnotationDatabases(false);
	}
}

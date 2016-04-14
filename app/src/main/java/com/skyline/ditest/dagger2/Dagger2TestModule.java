package com.skyline.ditest.dagger2;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jairus on 16/4/7.
 */
@Module
public class Dagger2TestModule {

	@Provides
	@Singleton
	Dagger2TestChangeMaker provideChangeMaker() {
		return new Dagger2TestChangeMaker();
	}

	@Provides
	@Singleton
	@Named("forFragment")
	Dagger2TestChangeMaker provideChangeMaker4Fragment() {
		return new Dagger2TestChangeMaker();
	}

	@Provides
	@Singleton
	@Named("forView")
	Dagger2TestChangeMaker provideChangeMaker4View() {
		return new Dagger2TestChangeMaker();
	}
}

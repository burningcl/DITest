package com.skyline.ditest.dagger2;

import dagger.Component;

/**
 * Created by jairus on 16/4/7.
 */
@Component(modules = Dagger2TestModule.class)
public interface Dagger2TestComponent {

	Dagger2TestActivity inject(Dagger2TestActivity activity);

	Dagger2TestFragment inject(Dagger2TestFragment fragment);

	Dagger2TestView inject(Dagger2TestView view);

}

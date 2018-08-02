package com.test.molina.rappiapp.rx;

import io.reactivex.Scheduler;

/**
 * Created by Amolina on 02/02/17.
 */

public interface SchedulerProvider {

    Scheduler ui();//observeOn

    Scheduler computation();

    Scheduler io();//subscribeOn

}

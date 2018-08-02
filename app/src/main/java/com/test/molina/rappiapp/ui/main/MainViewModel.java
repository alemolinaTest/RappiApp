package com.test.molina.rappiapp.ui.main;

import com.test.molina.rappiapp.data.DataManager;
import com.test.molina.rappiapp.rx.SchedulerProvider;
import com.test.molina.rappiapp.ui.base.BaseViewModel;

/**
 * Created by Amolina on 02/02/17.
 */

public class MainViewModel extends BaseViewModel {

    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }


}

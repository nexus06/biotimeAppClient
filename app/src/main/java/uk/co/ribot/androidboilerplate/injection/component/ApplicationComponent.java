package uk.co.ribot.androidboilerplate.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import uk.co.ribot.androidboilerplate.data.DataManager;
import uk.co.ribot.androidboilerplate.data.local.PreferencesHelper;
import uk.co.ribot.androidboilerplate.data.remote.HeroesService;
import uk.co.ribot.androidboilerplate.data.remote.RemoteData;
import uk.co.ribot.androidboilerplate.injection.ApplicationContext;
import uk.co.ribot.androidboilerplate.injection.module.ApplicationModule;
import uk.co.ribot.androidboilerplate.util.RxEventBus;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

//    void inject(SyncService syncService);

    @ApplicationContext Context context();
    Application application();
    HeroesService ribotsService();
    RemoteData remoteData();
    PreferencesHelper preferencesHelper();
    DataManager dataManager();
    RxEventBus eventBus();

}

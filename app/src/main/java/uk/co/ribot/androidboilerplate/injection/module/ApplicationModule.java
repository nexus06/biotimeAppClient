package uk.co.ribot.androidboilerplate.injection.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.ribot.androidboilerplate.data.remote.HeroesService;
import uk.co.ribot.androidboilerplate.data.remote.RemoteData;
import uk.co.ribot.androidboilerplate.injection.ApplicationContext;

/**
 * Provide application-level dependencies.
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    HeroesService provideRibotsService() {
        return HeroesService.Creator.newRibotsService();
    }

    @Provides
    @Singleton
    RemoteData provideRemoteData() {
        return RemoteData.Creator.newRemoteData();
    }

}

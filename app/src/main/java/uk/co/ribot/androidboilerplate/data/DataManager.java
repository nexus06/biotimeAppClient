package uk.co.ribot.androidboilerplate.data;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import uk.co.ribot.androidboilerplate.data.model.Superheros;
import uk.co.ribot.androidboilerplate.data.remote.HeroesService;

@Singleton
public class DataManager {

    private final HeroesService mRibotsService;

    @Inject
    public DataManager(HeroesService ribotsService) {
        mRibotsService = ribotsService;
    }

    public Observable<Superheros> getSuperHeros() {
        return mRibotsService.getSuperHeros();
    }

}

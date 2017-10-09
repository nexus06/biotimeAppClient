package uk.co.ribot.androidboilerplate;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import rx.Observable;
import uk.co.ribot.androidboilerplate.data.DataManager;
import uk.co.ribot.androidboilerplate.data.model.Profiles;
import uk.co.ribot.androidboilerplate.test.common.TestDataFactory;
import uk.co.ribot.androidboilerplate.ui.main.MainPresenter;
import uk.co.ribot.androidboilerplate.ui.main.ProvidedPresenterOperations;
import uk.co.ribot.androidboilerplate.util.RxSchedulersOverrideRule;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    ProvidedPresenterOperations.MainMvpView mMockMainMvpView;
    @Mock DataManager mMockDataManager;
    private MainPresenter mMainPresenter;

    @Rule
    public final RxSchedulersOverrideRule mOverrideSchedulersRule = new RxSchedulersOverrideRule();

    @Before
    public void setUp() {
        mMainPresenter = new MainPresenter(mMockDataManager);
        mMainPresenter.attachView(mMockMainMvpView);
    }

    @After
    public void tearDown() {
        mMainPresenter.detachView();
    }

    @Test
    public void loadSuperHerossReturnsSuperHeros() {
        List<Profiles> superhero_avs = TestDataFactory.makeListSuperHero(10);
        when(mMockDataManager.getSuperHeros())
                .thenReturn(Observable.just(superhero_avs));

        mMainPresenter.loadSuperHeros();
        verify(mMockMainMvpView).showSuperHeros(superhero_avs);
        verify(mMockMainMvpView, never()).showSuperHeroEmpty();
        verify(mMockMainMvpView, never()).showError();
    }

    @Test
    public void loadSuperHerosReturnsEmptyList() {
        when(mMockDataManager.getSuperHeros())
                .thenReturn(Observable.just(Collections.<Profiles>emptyList()));

        mMainPresenter.loadSuperHeros();
        verify(mMockMainMvpView).showSuperHeroEmpty();
        verify(mMockMainMvpView, never()).showSuperHeros(ArgumentMatchers.<Profiles>anyList());
        verify(mMockMainMvpView, never()).showError();
    }

    @Test
    public void loadSuperHeroFails() {
        when(mMockDataManager.getSuperHeros())
                .thenReturn(Observable.<List<Profiles>>error(new RuntimeException()));

        mMainPresenter.loadSuperHeros();
        verify(mMockMainMvpView).showError();
        verify(mMockMainMvpView, never()).showSuperHeroEmpty();
        verify(mMockMainMvpView, never()).showSuperHeros(ArgumentMatchers.<Profiles>anyList());
    }

}

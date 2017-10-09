package uk.co.ribot.androidboilerplate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import rx.Observable;
import uk.co.ribot.androidboilerplate.data.DataManager;
import uk.co.ribot.androidboilerplate.data.local.PreferencesHelper;
import uk.co.ribot.androidboilerplate.data.model.Profiles;
import uk.co.ribot.androidboilerplate.data.model.Superheros;
import uk.co.ribot.androidboilerplate.data.remote.HeroesService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * This test class performs local unit tests without dependencies on the Android framework
 * For testing methods in the DataManager follow this approach:
 * 1. Stub mock helper classes that your method relies on. e.g. RetrofitServices or DatabaseHelper
 * 2. Test the Observable using TestSubscriber
 * 3. Optionally write a SEPARATE test that verifies that your method is calling the right helper
 * using Mockito.verify()
 */
@RunWith(MockitoJUnitRunner.class)
public class DataManagerTest {

    @Mock PreferencesHelper mMockPreferencesHelper;
    @Mock
    HeroesService mMockRibotsService;
    private DataManager mDataManager;

    @Before
    public void setUp() {
        mDataManager = new DataManager(mMockRibotsService);
    }

    @Test
    public void callsApi() {
        mDataManager.getSuperHeros().subscribe();
        // Verify right calls to helper methods
        verify(mMockRibotsService).getSuperHeros();
    }

    private void stubSyncRibotsHelperCalls(Superheros superhero_avs) {
        // Stub calls to the ribot service and database helper.
        when(mMockRibotsService.getSuperHeros())
                .thenReturn(Observable.just(superhero_avs));

    }

}

package uk.co.ribot.androidboilerplate.ui.main;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;
import uk.co.ribot.androidboilerplate.data.DataManager;
import uk.co.ribot.androidboilerplate.data.model.Ribot;
import uk.co.ribot.androidboilerplate.data.model.UserLoggedInfo;
import uk.co.ribot.androidboilerplate.data.remote.RemoteData;
import uk.co.ribot.androidboilerplate.injection.ConfigPersistent;
import uk.co.ribot.androidboilerplate.ui.base.BasePresenter;
import uk.co.ribot.androidboilerplate.util.RxUtil;

import javax.inject.Inject;
import java.util.List;

@ConfigPersistent
public class LoginPresenter extends BasePresenter<ProvidedPresenterOperations.LoginMvpView> {

    private Subscription mSubscription;
    private RemoteData remoteData;

    @Inject
    public LoginPresenter(RemoteData dataManager) {
        remoteData = dataManager;
    }

    @Override
    public void attachView(ProvidedPresenterOperations.LoginMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void login(String user, String pass) {
        checkViewAttached();
        RxUtil.unsubscribe(mSubscription);

        mSubscription = remoteData.login("username=111111111&password=21232f297a57a5a743894a0e4a801fc3")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<UserLoggedInfo>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, "There was an error loading the ribots.");
                        getMvpView().showError();
                    }

                    @Override
                    public void onNext(UserLoggedInfo ribots) {
                        /*if (ribots.isEmpty()) {
                            getMvpView().showError();
                        } else {
                            getMvpView().showLoginResult();
                        }*/
                    }
                });
    }

}

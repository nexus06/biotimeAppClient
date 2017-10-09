package uk.co.ribot.androidboilerplate.ui.main;

import java.util.List;

import uk.co.ribot.androidboilerplate.data.model.Profile;
import uk.co.ribot.androidboilerplate.ui.base.MvpView;

public class ProvidedPresenterOperations{
    public interface MainMvpView extends MvpView {

        void showSuperHeros(List<Profile> superhero_avs);

        void showSuperHeroEmpty();

        void showError();

    }

    public interface LoginMvpView extends MvpView {

        void showLoginResult();

        void showError();

    }


}

package uk.co.ribot.androidboilerplate.test.common;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import uk.co.ribot.androidboilerplate.data.model.Profile;
import uk.co.ribot.androidboilerplate.data.model.Profiles;

/**
 * Factory class that makes instances of data models with random field values.
 * The aim of this class is to help setting up test fixtures.
 */
public class TestDataFactory {

    public static String randomUuid() {
        return UUID.randomUUID().toString();
    }

    public static Profiles makeSuperHero(String uniqueSuffix) {
        return Profiles.create(makeProfile(uniqueSuffix));
    }

    public static List<Profiles> makeListSuperHero(int number) {
        List<Profiles> ribots = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            ribots.add(makeSuperHero(String.valueOf(i)));
        }
        return ribots;
    }

    public static Profile makeProfile(String uniqueSuffix) {
        return Profile.builder()
                .setName(uniqueSuffix)
                .setGroups("invisibility, fly")
                .setHeight("1233")
                .setPower("5000")
                .setPhoto("http://api.ribot.io/images/" + uniqueSuffix)
                .setRealName("TheHardMenPath")
                .build();
    }

}
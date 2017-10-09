package uk.co.ribot.androidboilerplate.data.model;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class Profiles implements Comparable<Profiles>, Parcelable {

    public abstract Profile profile();

    public static Profiles create(Profile profile) {
        return new AutoValue_Profiles(profile);
    }

    public static TypeAdapter<Profiles> typeAdapter(Gson gson) {
        return new AutoValue_Profiles.GsonTypeAdapter(gson);
    }

    @Override
    public int compareTo(@NonNull Profiles another) {
        return profile().name().compareToIgnoreCase(another.profile().name());
    }
}

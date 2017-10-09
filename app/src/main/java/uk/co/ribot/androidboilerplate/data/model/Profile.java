package uk.co.ribot.androidboilerplate.data.model;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

@AutoValue
public abstract class Profile implements Parcelable {

    public abstract String name();
    @Nullable public abstract String photo();
    public abstract String realName();
    public abstract String height();
    @Nullable public abstract String power();
    public abstract String abilities();
    @Nullable public abstract String groups();

    public static Builder builder() {
        return new AutoValue_Profile.Builder();
    }

    public static TypeAdapter<Profile> typeAdapter(Gson gson) {
        return new AutoValue_Profile.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setName(String name);
        public abstract Builder setPhoto(String photo);
        public abstract Builder setRealName(String realName);
        public abstract Builder setHeight(String height);
        public abstract Builder setPower(String power);
        public abstract Builder setAbilities(String abilities);
        public abstract Builder setGroups(String groups);
        public abstract Profile build();
    }
}

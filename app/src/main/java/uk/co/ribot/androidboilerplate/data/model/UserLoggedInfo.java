
package uk.co.ribot.androidboilerplate.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLoggedInfo implements Parcelable
{

    @SerializedName("value")
    @Expose
    private Value value;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("success")
    @Expose
    private Boolean success;
    public final static Parcelable.Creator<UserLoggedInfo> CREATOR = new Creator<UserLoggedInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UserLoggedInfo createFromParcel(Parcel in) {
            UserLoggedInfo instance = new UserLoggedInfo();
            instance.value = ((Value) in.readValue((Value.class.getClassLoader())));
            instance.token = ((String) in.readValue((String.class.getClassLoader())));
            instance.success = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            return instance;
        }

        public UserLoggedInfo[] newArray(int size) {
            return (new UserLoggedInfo[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public UserLoggedInfo() {
    }

    /**
     * 
     * @param token
     * @param value
     * @param success
     */
    public UserLoggedInfo(Value value, String token, Boolean success) {
        super();
        this.value = value;
        this.token = token;
        this.success = success;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(value);
        dest.writeValue(token);
        dest.writeValue(success);
    }

    public int describeContents() {
        return  0;
    }

}

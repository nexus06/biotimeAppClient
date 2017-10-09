
package uk.co.ribot.androidboilerplate.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Value implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private Integer id;
    @SerializedName("pin")
    @Expose
    private String pin;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("isAdmin")
    @Expose
    private Integer isAdmin;
    public final static Parcelable.Creator<Value> CREATOR = new Creator<Value>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Value createFromParcel(Parcel in) {
            Value instance = new Value();
            instance.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.pin = ((String) in.readValue((String.class.getClassLoader())));
            instance.firstName = ((String) in.readValue((String.class.getClassLoader())));
            instance.isAdmin = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Value[] newArray(int size) {
            return (new Value[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Value() {
    }

    /**
     * 
     * @param id
     * @param pin
     * @param isAdmin
     * @param firstName
     */
    public Value(Integer id, String pin, String firstName, Integer isAdmin) {
        super();
        this.id = id;
        this.pin = pin;
        this.firstName = firstName;
        this.isAdmin = isAdmin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(pin);
        dest.writeValue(firstName);
        dest.writeValue(isAdmin);
    }

    public int describeContents() {
        return  0;
    }

}

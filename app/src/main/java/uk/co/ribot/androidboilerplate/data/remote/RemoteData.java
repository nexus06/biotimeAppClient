package uk.co.ribot.androidboilerplate.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;
import uk.co.ribot.androidboilerplate.data.model.Ribot;
import uk.co.ribot.androidboilerplate.data.model.UserLoggedInfo;
import uk.co.ribot.androidboilerplate.util.MyGsonTypeAdapterFactory;

import java.util.List;

public interface RemoteData {

    /* attendancesURL: "model/attendances.json",
    attendancesCorrectURL: "model/attendanceDemoCorrect.json",
    employeeURL: "model/employee.json",
    attendancesEventsURL: "model/attendanceEvents.json",
    //Employees
    GETEmployeeURL: "http://192.168.1.4:8080/api_v1/employees",
    POSTEmployeePhotoURL: "http://192.168.1.4:8080/api_v1/employee/photo",
    DELETEEmployeeURL: "http://192.168.1.4:8080/api_v1/employees/delete",
    UPDATEEmployeeURL: "http://192.168.1.4:8080/api_v1/employees/update",
    // Departments
    GETDepartmentsURL: "http://192.168.1.4:8080/api_v1/departments",
    DELETEDepartmentURL: "http://192.168.1.4:8080/api_v1/departments/delete",
    UPDATEDepartmentURL: "http://192.168.1.4:8080/api_v1/departments/update",
    GETDepartmentsHierarchyURL: "http://192.168.1.4:8080/api_v1/departments/hierarchy",
    // Attendances
    POSTAttendancesURL: "http://192.168.1.4:8080/api_v1/attendances",
    POSTAttendanceURL: "http://192.168.1.4:8080/api_v1/attendance",
    // AttendanceEvents
    GETAttendanceEventsURL: "http://192.168.1.4:8080/api_v1/attendanceEvents",
    POSTAuthenticationURL: "http://192.168.1.4:8080/api_v1/authentication",
    POSTDeleteEventURL: "http://192.168.1.4:8080/api_v1/attendance/delete",
    POSTUpdateEventURL: "http://192.168.1.4:8080/api_v1/attendance/update",
    POSTDataURL: "http://192.168.1.4:8080/api_v1/executeShell",
    GETTerminalInfoURL: "http://192.168.1.4:8080/api_v1/terminalInfo",
    GETFileURL: "http://192.168.1.4:8080/api_v1/file",
    GETMessageURL: "http://192.168.1.4:8080/api_v1/message"*/


    String GETEmployeeURL = "api_v1/employees";
    String POSTEmployeePhotoURL=  "api_v1/employee/photo";
    String DELETEEmployeeURL=  "api_v1/employees/delete";
    String UPDATEEmployeeURL=  "api_v1/employees/update";
    String GETDepartmentsURL=  "api_v1/departments";
    String DELETEDepartmentURL=  "api_v1/departments/delete";
    String GETDepartmentsHierarchyURL=  "api_v1/departments/hierarchy";
    String UPDATEDepartmentURL=  "api_v1/departments/update";
    String POSTAttendancesURL=  "api_v1/attendances";
    String POSTAttendanceURL=  "api_v1/attendance";
    String GETAttendanceEventsURL=  "api_v1/attendanceEvents";
    String POSTAuthenticationURL=  "api_v1/authentication";
    String POSTDeleteEventURL=  "api_v1/attendance/delete";
    String POSTUpdateEventURL=  "api_v1/attendance/update";
    String POSTDataURL=  "api_v1/executeShell";
    String GETTerminalInfoURL=  "api_v1/terminalInfo";
    String GETFileURL=  "api_v1/file";
    String  GETMessageURL= "api_v1/message";



    String ENDPOINT = "192.168.1.5/";

    //var query = "username=" + username + "&password="+ md5Password;
    @POST(ENDPOINT+POSTAuthenticationURL)
    Observable<UserLoggedInfo> login(@Body String credentials);

    /******** Helper class that sets up a new services *******/
    class Creator {

        public static RemoteData newRemoteData() {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapterFactory(MyGsonTypeAdapterFactory.create())
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(RemoteData.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(RemoteData.class);
        }
    }
}

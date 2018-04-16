package com.example.seema.seema; /**
 * Created by sihle on 4/16/18.
 */
import com.parse.Parse;
import android.app.Application;

public class SEEMA extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("myAppId")
                .server("https://seema-web.herokuapp.com/parse")
                .build()
        );


        //Parse.enableLocalDatastore(this);
    }
}
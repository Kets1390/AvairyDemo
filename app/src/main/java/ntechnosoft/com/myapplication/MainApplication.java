package ntechnosoft.com.myapplication;

import android.app.Application;

import com.adobe.creativesdk.foundation.AdobeCSDKFoundation;
import com.adobe.creativesdk.foundation.auth.IAdobeAuthClientCredentials;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSEnvironment;
import com.aviary.android.feather.sdk.IAviaryClientCredentials;

/**
 * Created by Ketan on 2/8/2016.
 */
public class MainApplication extends Application implements IAviaryClientCredentials {

    /* Be sure to fill in the two strings below. */
    private static final String CREATIVE_SDK_CLIENT_ID = "your client id";
    private static final String CREATIVE_SDK_CLIENT_SECRET = "secret id";

    @Override
    public void onCreate() {
        super.onCreate();
        AdobeCSDKFoundation.initializeCSDKFoundation(
                getApplicationContext(),
                AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentProductionUS
        );
    }

    @Override
    public String getClientID() {
        return CREATIVE_SDK_CLIENT_ID;
    }

    @Override
    public String getClientSecret() {
        return CREATIVE_SDK_CLIENT_SECRET;
    }

    @Override
    public String getBillingKey() {
        return "";
    }
}
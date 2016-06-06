package com.example.dheeraj.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {

    public static final String TAG = MyIntentService.class.getSimpleName();
    private static int count = 0;

    public MyIntentService() {
        super(MyIntentService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        count++;
        for (int k = 0; k < 10; k++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
           /* Intent localIntent =
                    new Intent(Constants.BROADCAST_ACTION)
                            .putExtra(Constants.EXTENDED_DATA_STATUS, "running " + count + "@" + k);
            LocalBroadcastManager.getInstance(MyIntentService.this).sendBroadcast(localIntent);*/
/*
            Intent localIntent =
                    new Intent(Constants.BROADCAST_ACTION)
                            .putExtra(Constants.EXTENDED_DATA_STATUS, "running ");
            sendBroadcast(localIntent);
*/
            sendMessage();
            Log.e(TAG, "running " + count + "@" + k);
        }

    }

    private void sendMessage() {
        Log.d("sender", "Broadcasting message");
        Intent intent = new Intent("custom-event-name");
        // You can also include some extra data.
        intent.putExtra("message", "This is my message!");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

}

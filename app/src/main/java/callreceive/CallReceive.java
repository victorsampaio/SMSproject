package callreceive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by VictorSampaio on 29/10/2014.
 */
public class CallReceive extends BroadcastReceiver {

    private static final String CATEGORY = "call";

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i(CATEGORY, "RECEIVER > " + intent.getAction());

        if (intent.getExtras() != null ){

            String state = intent.getStringExtra("state");
            String number = intent.getStringExtra("incoming_number");

            Log.i(CATEGORY, "Receiver State > " + state);
            if ("RINGING".equalsIgnoreCase(state) ){
                Log.i(CATEGORY, "Receiver Calling Number " + number);
            }
        }
    }
}

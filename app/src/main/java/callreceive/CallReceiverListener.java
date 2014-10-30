package callreceive;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by VictorSampaio on 29/10/2014.
 */
public class CallReceiverListener extends PhoneStateListener {

    private static final String CATEGORY = "callReceiverListener";

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        Log.v(CATEGORY, "Listener >> incoming number: " + incomingNumber);
        super.onCallStateChanged(state, incomingNumber);

        switch (state){
            case TelephonyManager.CALL_STATE_IDLE:
                Log.i(CATEGORY, "CALL_STATE_IDLE");
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                Log.i(CATEGORY, "CALL_STATE_OFFHOOK");
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                // It's Ringing
                Log.i(CATEGORY, "CALL_STATE_RINGING");
                Log.i(CATEGORY, "Received Call: " + incomingNumber);
                break;
            default:
                Log.w(CATEGORY, "Unknown State: " + state);
        }
    }
}

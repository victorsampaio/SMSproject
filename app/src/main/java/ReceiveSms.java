import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.telephony.SmsMessage;
import android.widget.Toast;



/**
 * Created by VictorSampaio on 28/10/2014.
 */
public class ReceiveSms extends BroadcastReceiver {

    private static final String CATEGORY = "receiveSms";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(CATEGORY, ">" + intent.getAction() );
        android.com.smsproject.Sms sms = new android.com.smsproject.Sms();

        // Read Message
        SmsMessage msg = sms.receiveMessage(intent);
        String cell = msg.getDisplayOriginatingAddress();
        String message = msg.getDisplayMessageBody();
        String text = "ReceiveSms: receive sms [" +cell+ "] -> " + message;
        Log.i(CATEGORY, text);
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}


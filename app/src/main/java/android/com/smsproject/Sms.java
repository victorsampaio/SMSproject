package android.com.smsproject;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;


/**
 * Created by VictorSampaio on 28/10/2014.
 */
public class Sms {

    private static final String CATEGORY = "Sms";

    // Send SMS for indicated Number
    public void sendSms(Context context, String destination, String message) {
        try {

            SmsManager smsManager = SmsManager.getDefault();
            PendingIntent pIntent = PendingIntent.getBroadcast(context, 0, new Intent(), 0);
            smsManager.sendTextMessage(destination, null, message, pIntent, null);
        } catch (Exception e) {
            Log.e(CATEGORY, "ERROR to send the Message: " + e.getMessage(), e);
        }
    }


    // Read the message from the Intent. The Intent is received for a IntentFilter
    // configured for the action "android.provider.Telephony.SMS_RECEIVED"
    public SmsMessage receiveMessage(Intent intent) {
        SmsMessage[] messages = getMessageFromIntent(intent);
        if (messages != null) {
            return messages[0];
        }
        return null;
    }

    private SmsMessage[] getMessageFromIntent(Intent intent) {
        Log.d(CATEGORY, "Sms.getMessagesFromIntent: " + intent.getAction());

        Object messages[] = (Object[]) (Object[]) intent.getSerializableExtra("pdus");
        byte pduObjs[][] = new byte[messages.length][];
        for (int i = 0; i < messages.length; i++)
                pduObjs[i] = (byte[]) (byte[]) messages[i];
            byte pdus[][] = new byte[pduObjs.length][];
            if (pdus == null) {
                return null;
            }

            int pduCount = pdus.length;
            if (pduCount == 0) {
                return null;
            }

            SmsMessage msgs[] = new SmsMessage[pduCount];
            for (int i = 0; i < pduCount; i++) {
                pdus[i] = pduObjs[i];
                msgs[i] = SmsMessage.createFromPdu(pdus[i]);

                String cell = msgs[0].getDisplayOriginatingAddress();
                String message = msgs[0].getDisplayMessageBody();
                Log.d(CATEGORY, "Sms.Message: " + cell + " -> " + message);

            }
            return msgs;
        }
    }
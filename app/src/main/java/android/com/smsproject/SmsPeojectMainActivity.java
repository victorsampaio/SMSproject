package android.com.smsproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SmsPeojectMainActivity extends Activity {

    private static final String CATEGORY = "sendSms";

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_sms_peoject_main);

        Button btSendSms = (Button)findViewById(R.id.btnSendSms);
        btSendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberText = (EditText)findViewById(R.id.edtxNumber);
                EditText messageText = (EditText)findViewById(R.id.edtxMessage);

                String number = numberText.getText().toString();
                String message = messageText.getText().toString();

                Log.i(CATEGORY, "Sending SMS for ["+number+"]: " + message );
                android.com.smsproject.Sms sms = new android.com.smsproject.Sms();
                sms.sendSms(SmsPeojectMainActivity.this, number, message);
                     }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sms_peoject_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

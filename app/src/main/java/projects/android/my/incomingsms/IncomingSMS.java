package projects.android.my.incomingsms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by User on 20-11-2017.
 */

public class IncomingSMS extends BroadcastReceiver
{
    final SmsManager sms = SmsManager.getDefault();
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Incoming Msg",Toast.LENGTH_LONG).show(); // Get the object of SmsManager
        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();
        try
        {
            if(bundle!=null)
            {
                final Object[] pdusObj = (Object[]) bundle.get("pdus");
                for (int i = 0; i < pdusObj.length; i++)
                {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();
                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();
                   // Show Alert
                    Toast.makeText(context,
                    "senderNum: "+ senderNum + ", message: " + message, Toast.LENGTH_LONG).show();


                }
            }
        }
        catch(Exception ex)
        {

        }

    }
}

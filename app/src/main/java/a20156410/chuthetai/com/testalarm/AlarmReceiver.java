package a20156410.chuthetai.com.testalarm;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Admin on 10/18/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //String chuoi=intent.getExtras().getString("TatBT");
        Intent myintent = new Intent(context, Music.class);
        //myintent.putExtra("TatBT",chuoi);
        context.startService(myintent);
        //Toast.makeText(context, "Reciever", Toast.LENGTH_SHORT).show();
    }

}

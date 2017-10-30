package a20156410.chuthetai.com.testalarm;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Admin on 10/22/2017.
 */

public class Music  extends Service {
    MediaPlayer mp;
    int id;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
        String NhanKQ=intent.getExtras().getString("TatBT");
        mp=MediaPlayer.create( this,R.raw.chuong );
        mp.start();
        /*if (NhanKQ.equals("on"))
        {
            id=1;
        }
        else if (NhanKQ.equals("off"))
        {
            id=0;
        }
        if (id== 1)
        {
            mp=MediaPlayer.create( this,R.raw.chuong );
            mp.start();
            id = 0;
        }
        else if(id==0)
        {
            mp.stop();
            mp.reset();
        }*/
        Toast.makeText(this, "Alarm....", Toast.LENGTH_LONG).show();
        return START_NOT_STICKY;
    }
}

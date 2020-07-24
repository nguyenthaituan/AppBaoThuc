package vn.edu.ntu.appbaothuc;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class Music extends Service {
    MediaPlayer mediaPlayer;
    int id;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String nhankey = intent.getExtras().getString("extra");
        if (nhankey.equals("on")){
            id =1;
        }
        else
            if (nhankey.equals("off"))
            {
             id = 0;
            }

        if (id == 1)
        {
            mediaPlayer = MediaPlayer.create(this,R.raw.baothuc);
            mediaPlayer.start();

        }else if (id==0){
            mediaPlayer.stop();
            mediaPlayer.reset();
        }

        return START_NOT_STICKY;

    }
}

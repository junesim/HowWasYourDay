package kr.ac.yonsei.howasyourday;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LockBroadcastReceiver extends BroadcastReceiver  {
    private SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private long current;
    private Date date;
    private TextView text;

    public void setText(TextView text) {
        this.text = text;
    }
    @Override
    public void onReceive(Context context, Intent intent){
        if(intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
            current = System.currentTimeMillis();
            date = new Date(current);
            Toast.makeText(context,now.format(date),Toast.LENGTH_SHORT).show();
        }
        else if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF)){
            current = System.currentTimeMillis();
            date = new Date(current);
            text.setText(now.format(date));
        }
    }

}

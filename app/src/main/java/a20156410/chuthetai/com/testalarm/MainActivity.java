package a20156410.chuthetai.com.testalarm;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {
    Button btnHengio,btnHuyBT;
    TimePicker timePicker;
    TextView txtLoiNhac,txtThongBao;
    Calendar calendar;
    AlarmManager alarmManager;
    Intent intent;
    Intent intent1;
    PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControll();
        addEvents();
        timePicker.setIs24HourView(true);
    }
    private void addControll() {
        btnHengio = (Button) findViewById(R.id.btnAddAlarm);
        btnHuyBT = (Button) findViewById(R.id.btnHuyBT);
        txtLoiNhac = (TextView) findViewById(R.id.txtLoiNhac);
        txtThongBao = (TextView) findViewById(R.id.txtThongBao);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
    }
    private void addEvents() {
        btnHengio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChuyenManHinh();
            }
        });
        btnHuyBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mgs=txtLoiNhac.getText().toString();
                int DoDaiChuoi= mgs.length();
                if (DoDaiChuoi==0)
                {
                    Toast.makeText(MainActivity.this, "Đã tắt báo thức", Toast.LENGTH_LONG).show();;
                }
                else Toast.makeText(MainActivity.this, mgs, Toast.LENGTH_LONG).show();
                intent.putExtra("TatBT","off");
                alarmManager.cancel(pendingIntent);
                sendBroadcast(intent);
            }
        });
    }

    private void ChuyenManHinh() {
        intent1=new Intent(MainActivity.this,Main2Activity.class);
        PendingIntent Pen=PendingIntent.getActivity(MainActivity.this,2323202,intent1,0);
        alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);

        calendar=calendar.getInstance();
        intent  = new Intent(MainActivity.this,AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(
                MainActivity.this, 234324243, intent, 0);

        long gio = timePicker.getCurrentHour();
        long phut = timePicker.getCurrentMinute();

        String string_gio=String.valueOf(gio);
        String string_phut=String.valueOf(phut);
        intent.putExtra("TatBT","on");
        if (phut < 10 )
        {
            string_phut= "0" + String.valueOf(phut);
        }
        long ThoiGianHenGio;
        long GioHen,PhutHen;

        //Toast.makeText(MainActivity.this,"Báo thức được đặt đổ chuông sau " +" giờ "+" phút " +" nữa tính từ bây giờ",Toast.LENGTH_LONG).show();
        if (gio==calendar.get(Calendar.HOUR_OF_DAY)) {
            GioHen = (gio - calendar.get(Calendar.HOUR_OF_DAY));
            PhutHen = (phut - 1 - calendar.get(Calendar.MINUTE));   long PhutHenMili= TimeUnit.MINUTES.toMillis(PhutHen);
            int GiayHen = (60 - calendar.get(Calendar.SECOND)); long GiayHenMili=TimeUnit.SECONDS.toMillis(GiayHen);
            ThoiGianHenGio = PhutHenMili+GiayHenMili;
            alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+  ThoiGianHenGio, pendingIntent);
            alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+ ThoiGianHenGio,Pen);
        }
        else
        {
            GioHen = (gio-1 - calendar.get(Calendar.HOUR_OF_DAY)); long GioHenMili=TimeUnit.HOURS.toMillis(GioHen);
            PhutHen = (60 + phut - calendar.get(Calendar.MINUTE)); long PhutHenMili=TimeUnit.MINUTES.toMillis(PhutHen);
            int GiayHen = (60 - calendar.get(Calendar.SECOND)); long GiayHenMili=TimeUnit.SECONDS.toMillis(GiayHen);
            ThoiGianHenGio = GioHenMili+PhutHenMili+GiayHenMili;
            alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+ ThoiGianHenGio, pendingIntent);
            alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+ ThoiGianHenGio,Pen);
        }
        txtThongBao.setText("Báo thức được đặt đổ chuông sau "+ GioHen +" Giờ "+(PhutHen+1)+" Phút "+" nữa tính từ bây giờ"+" ("+string_gio+":"+string_phut+")");
        //Toast.makeText(MainActivity.this, gio+":"+phut+"-"+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+"\n" +System.currentTimeMillis(), Toast.LENGTH_LONG).show();
    }
    }






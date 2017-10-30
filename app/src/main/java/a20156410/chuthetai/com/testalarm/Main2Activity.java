package a20156410.chuthetai.com.testalarm;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button btnSleep,btnTurnOff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnSleep = (Button) findViewById(R.id.btnSleep);
        btnTurnOff= (Button) findViewById(R.id.btnTurnOff);
    }
}

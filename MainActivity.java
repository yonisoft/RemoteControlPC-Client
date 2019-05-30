package com.example.yoni.videocontroller;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private CClient mClient;
    EditText eText, eText2;
    public static String ipadd = "127.0.0.1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        mClient = new CClient();
        Thread myThready = new Thread(mClient);
        myThready.start();

        eText = findViewById(R.id.editText);
        eText2 = findViewById(R.id.editText2);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                playpause(arg0);
            }
        });

        final Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                back(arg0);
            }
        });

        final Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                forward(arg0);
            }
        });

        final Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                String str = eText.getText().toString();
                setvol(str);
            }
        });

        final Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                ipadd = eText2.getText().toString();
            }
        });
    }

    public void playpause(View v)
    {
            mClient.Send("01");
            Thread myThready = new Thread(mClient);
            myThready.start();
            return;
    }

    public void back(View v)
    {
        mClient.Send("03");
        Thread myThready = new Thread(mClient);
        myThready.start();
        return;
    }

    public void forward(View v)
    {
        mClient.Send("04");
        Thread myThready = new Thread(mClient);
        myThready.start();
        return;
    }

    public void setvol(String... params)
    {
        mClient.Send("02 " + params[0]);
        Thread myThready = new Thread(mClient);
        myThready.start();
        return;
    }
}

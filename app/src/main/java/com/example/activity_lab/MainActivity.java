package com.example.activity_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView mTvCreate , mTvRestart , mTvStart , mTvResume ;
    Button btnactivity;
    String tag = "key";
    private static final String RESTART_KEY = "restart";
    private static final String RESUME_KEY = "resume";
    private static final String START_KEY = "start";
    private static final String CREATE_KEY = "create";
    int mCreate = 0 , mRestart=0 , mStart = 0 , mResume = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTvCreate = (TextView) findViewById(R.id.create);
        mTvRestart = (TextView) findViewById(R.id.Restart);
        mTvStart = (TextView) findViewById(R.id.start);
        mTvResume = (TextView) findViewById(R.id.resume);
        btnactivity =(Button)findViewById(R.id.btnsctivity);

        btnactivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO:
                // Launch Activity Two
                // Hint: use Context's startActivity() method

                // Create an intent stating which Activity you would like to
                // start
                startActivity(new Intent(MainActivity.this, ActivityTwo.class));

                // Launch the Activity using the intent

            }
        });

        if(savedInstanceState != null ){

            mCreate = savedInstanceState.getInt(CREATE_KEY);
            mStart = savedInstanceState.getInt(START_KEY);
            mRestart = savedInstanceState.getInt(RESTART_KEY);
            mResume = savedInstanceState.getInt(RESUME_KEY);

        }
        Log.d(tag, "Entered the onCreate() method");

        mCreate ++;
        displayCounts();

    }

    public void onStart() {
        super.onStart();

        // Emit LogCat message
        Log.d(tag, "Entered the onStart() method");

        // TODO:
        // Update the appropriate count variable
        // Update the user interface
        mStart++;
        displayCounts();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "Entered the onResume() method");

        // TODO:
        // Update the appropriate count variable
        // Update the user interface
        mResume ++;
        displayCounts();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "Entered the onStop() method");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "Entered the onRestart() method");

        // TODO:
        // Update the appropriate count variable
        // Update the user interface
        mRestart ++;
        displayCounts();
    }
    public void onDestroy() {
        super.onDestroy();

        // Emit LogCat message
        Log.d(tag, "Entered the onDestroy() method");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putInt(CREATE_KEY, mCreate);
        outState.putInt(START_KEY, mStart);
        outState.putInt(RESTART_KEY, mRestart);
        outState.putInt(RESUME_KEY, mResume);
    }

    public void displayCounts() {

        // TODO - uncomment these lines

        mTvCreate.setText("onCreate() calls: " + mCreate);
        mTvStart.setText("onStart() calls: " + mStart);
        mTvResume.setText("onResume() calls: " + mResume);
        mTvRestart.setText("onRestart() calls: " + mRestart);

    }
}
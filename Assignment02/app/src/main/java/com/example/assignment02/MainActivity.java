// ---------Assignment 02--------------//
// ---------Madhan Mannem--------------//
//----------Sai Snehitha Ravuru--------//
//----------Group 14-------------------//

package com.example.assignment02;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private View colorView ;
    private TextView rgbValue;
    private TextView HEXValue ;
    private SeekBar redSeekbar;
    private SeekBar greenSeekbar ;
    private SeekBar blueSeekbar ;
    private TextView redProgressValue;
    private TextView greenProgressValue;
    private TextView blueProgressValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        colorView=findViewById(R.id.colorView);
        rgbValue=findViewById(R.id.rgb_value);
        HEXValue=findViewById(R.id.HEX_value);
        redSeekbar=findViewById(R.id.redSeekbar);
        blueSeekbar=findViewById(R.id.blueSeekbar);
        greenSeekbar=findViewById(R.id.greenSeekbar);
        redProgressValue=findViewById(R.id.redValueTV);
        blueProgressValue=findViewById(R.id.blueValueTV);
        greenProgressValue=findViewById(R.id.greenValueTV);

        redSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                updateColor();
                redProgressValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        blueSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                updateColor();
                blueProgressValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        greenSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                updateColor();
                greenProgressValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        findViewById(R.id.reset_button).setOnClickListener(view -> reset());
        findViewById(R.id.black_button).setOnClickListener(view -> changeColor(0,0,0));
        findViewById(R.id.white_button).setOnClickListener(view -> changeColor(255,255,255));
        findViewById(R.id.blue_button).setOnClickListener(view -> changeColor(0,0,255));
        updateColor();
    }

    private void updateColor()
    {
        int red=redSeekbar.getProgress();
        int blue=blueSeekbar.getProgress();
        int green=greenSeekbar.getProgress();
        int color = Color.rgb(red,green,blue);
        colorView.setBackgroundColor(color);
        rgbValue.setText("("+red+","+green+","+blue+")");
        HEXValue.setText(String.format("#%02X%02X%02X",red,green,blue));
    }
    private void reset(){
        redSeekbar.setProgress(64);
        greenSeekbar.setProgress(128);
        blueSeekbar.setProgress(0);
        updateColor();
    }
    private void changeColor(int red,int green, int blue)
    {
        redSeekbar.setProgress(red);
        blueSeekbar.setProgress(blue);
        greenSeekbar.setProgress(green);
        updateColor();
    }
}
package com.example.sukrins.temperatureconverter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView fah, cel, tempView;
    SeekBar seekBar;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fah = (TextView) findViewById(R.id.fahView);
        cel = (TextView) findViewById(R.id.celView);
        tempView = (TextView) findViewById(R.id.tempDetail);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        image = (ImageView) findViewById(R.id.tempImage);

        SeekBar temp = (SeekBar) findViewById(R.id.seekBar);

        temp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                DecimalFormat decimal = new DecimalFormat("##.##");

                float value = (float) ((float)progress/100);
                fah.setText(String.valueOf(decimal.format(value)));

                double f = Double.valueOf(fah.getText().toString());
                double c = ((5.0/9.0)*(f - 32.0));

                cel.setText(String.valueOf(decimal.format(c)));


            if(f <= 50.0){

                tempView.setText("Too Cold!!!");
                tempView.setBackgroundColor(Color.parseColor("#FF76C0FF"));
                image.setImageResource(R.drawable.winter);


            }
                else if(f>50.0 && f<90.0){
                tempView.setText("Just Right.");
                tempView.setBackgroundColor(Color.parseColor("#FF6DFF32"));
                image.setImageResource(R.drawable.spring);
            }
                else{
                tempView.setText("Too Hot!!!");
                tempView.setBackgroundColor(Color.parseColor("#FFFF7540"));
                image.setImageResource(R.drawable.summer);

            }


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

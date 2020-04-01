 package com.example.onlineshop;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

 public class SensorsActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager smm;
    List<Sensor> sensor;
    ListView lv;
     List<String> SensorName = new ArrayList<String>();
     private String[] valueSens = new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

// make list
            smm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
            lv = findViewById (R.id.lvSensor);
            sensor = smm.getSensorList(Sensor.TYPE_ALL);
        for (Sensor currentSensor : sensor ) {
           SensorName.add(currentSensor.getName());
            smm.registerListener(this, currentSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }


        lv.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,SensorName){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){

                View view = super.getView(position, convertView, parent);

                return view;
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv2 = findViewById(R.id.textView2);
                tv2.setText(sensor.get(position).getName().toString()  + "\nValoare:\n" + valueSens);
            }
        });



// get coord
        ////
        // flag for GPS status
        boolean isGPSEnabled = false;
        boolean isNetworkEnabled = false;
        boolean canGetLocation = false;

        Location location; // location
        double latitude; // latitude
        double longitude; // longitude
        //  statusCheck();

        }



     @Override
     public final void onSensorChanged(SensorEvent event) {

        switch(event.sensor.getType())
         {
             case Sensor.TYPE_GYROSCOPE :
                 valueSens[1] += String.valueOf(event.values[0]);
                 break;
             case Sensor.TYPE_MAGNETIC_FIELD :
                 valueSens[2] += String.valueOf(event.values[0]);
                 break;
             case Sensor.TYPE_PROXIMITY :
                 valueSens[3] += String.valueOf(event.values[0]);
                 break;
             case Sensor.TYPE_LIGHT :
                 valueSens[4] += String.valueOf(event.values[0]);
                 break;
             case Sensor.TYPE_PRESSURE :
                 valueSens[5] += String.valueOf(event.values[0]);
                 break;
             case Sensor.TYPE_RELATIVE_HUMIDITY :
                 valueSens[6] += String.valueOf(event.values[0]);
                 break;
             case Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED :
                 valueSens[7] += String.valueOf(event.values[0]);
                 break;
             case Sensor.TYPE_GYROSCOPE_UNCALIBRATED :
                 valueSens[8] += String.valueOf(event.values[0]);
                 break;
             case Sensor.TYPE_GAME_ROTATION_VECTOR :
                 valueSens[9] += String.valueOf(event.values[0]);
                 break;
             case Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR :
                 valueSens[10] += String.valueOf(event.values[0]);
                 break;
             case Sensor.TYPE_GRAVITY :
                 valueSens[11] += String.valueOf(event.values[0]);
                 break;
             case Sensor.TYPE_LINEAR_ACCELERATION :
                 valueSens[12] += String.valueOf(event.values[0]);
                 break;
             case Sensor.TYPE_ROTATION_VECTOR :
                 valueSens[13] += String.valueOf(event.values[0]);
                 break;
             default:
                 break;
         }

//
         }

     @Override
     public void onAccuracyChanged(Sensor sensor, int i) {

     }


      /*  public void statusCheck() {
            final LocationManager manager = (LocationManager) this.getSystemService(LOCATION_SERVICE);

            if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER) || !manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
            {
              //  buildAlertMessageNoGps();
                Toast.makeText(this, "Eneable gps", Toast.LENGTH_SHORT).show();

            }
            else
                Toast.makeText(this, "else gps", Toast.LENGTH_SHORT).show();

        }

            private void buildAlertMessageNoGps()
            {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(final DialogInterface dialog, final int id) {
                            dialog.cancel();
                           // Toast.makeText(this, "Eneable gps", Toast.LENGTH_SHORT).show();

                           // startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(final DialogInterface dialog, final int id) {
                            dialog.cancel();
                        }
                    });
            final AlertDialog alert = builder.create();
            alert.show();
        }*/
   }



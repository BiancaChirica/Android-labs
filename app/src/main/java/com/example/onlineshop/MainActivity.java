package com.example.onlineshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private TextView textView;
    private String[] listItem;
    private String[] listDescription;
    private Integer positionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listView);
        textView=(TextView)findViewById(R.id.textView);
        listItem = getResources().getStringArray(R.array.products);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);

        if (savedInstanceState != null) {
            positionNumber = savedInstanceState.getInt("position");
            listDescription = getResources().getStringArray(R.array.description);

            textView.setText(listDescription[positionNumber]);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                positionNumber = position;

                listDescription = getResources().getStringArray(R.array.description);

                textView.setText(listDescription[position]);
            }
        });

        PreferenceManager.setDefaultValues(this,R.xml.preference, false);
    }


    // save position -> on reconstruct stays the same
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("position", positionNumber);

    }

//life cycle

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i("life Cycle", "Start");

    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i("life Cycle", "Resume");

    }
    @Override
    protected void onPause()
    {
        super.onPause();
        Log.i("life Cycle", "Pause");
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        Log.i("life Cycle", "Stop");
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.i("life Cycle", "Destroy");

    }

    // for menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1 :
                Toast.makeText(this, "Fire + new activity", Toast.LENGTH_SHORT).show();
                openActivity2();
                return true;
            case R.id.item2 :
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                openSettings();
                return true;
            case R.id.item3 :
                Toast.makeText(this, "More Tools", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem1 :
                Toast.makeText(this, "Save Activity.", Toast.LENGTH_SHORT).show();
                openActivitySAVE();
                return true;
            case R.id.subitem2 :
                Toast.makeText(this, "Item 2.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem3 :
                Toast.makeText(this, "Item 3.", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    //open new activity
    public void openActivity2(){
        String selectedDescription;
       if( positionNumber == null )
           selectedDescription = "";
       else {
           listDescription = getResources().getStringArray(R.array.description);
           selectedDescription =  listDescription[positionNumber];
       }
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,selectedDescription);
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent,"Send message"));

    }

    // open settings , preferenceActivity
    public void openSettings()
    {
        Intent intent2 = new Intent(this, SettingsActivity.class);
        startActivity(intent2);
    }

    public void openActivitySAVE()
    {
        Intent intent3 = new Intent(this, ActivitySave.class);
        startActivity(intent3);
    }

}

package com.example.onlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity  implements MyDialog.MyDialogListener {

    private TextView tv1;
    private TextView tv2;
    private TextView tvUser ;
    private  TextView tvPass;
    Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tv1 = findViewById( R.id.textViewA2);
        tv1.setText(R.string.activity2);
        tv2 = findViewById( R.id.textView2A2);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        assert bundle != null;
        String msg = bundle.getString(Intent.EXTRA_TEXT);
        tv2.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        // alert dialog
        tvUser = findViewById(R.id.tbUsername);
        tvPass = findViewById(R.id.tbPass);
        bt = findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAlertDialog();
            }
        });

        }

    public void openAlertDialog(){
        MyDialog mydialog = new MyDialog();
        mydialog.show(getSupportFragmentManager(),"dialog");
    }

    @Override
    public void applyTexts(String username, String password) {
        tvUser.setText(username);
        tvPass.setText(password);
    }
}

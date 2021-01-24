package com.example.textview_01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DialogActivity extends AppCompatActivity {

    Button btn_dial;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        btn_dial = (Button)findViewById(R.id.btn_dial);
        tv_result = (TextView)findViewById(R.id.tv_result);
        btn_dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ad = new AlertDialog.Builder(DialogActivity.this);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("Title");
                ad.setMessage("Is this dialog msg?");

                final EditText et = new EditText(DialogActivity.this);
                ad.setView(et);
                ad.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String result = et.getText().toString();
                        tv_result.setText(result);
                        dialogInterface.dismiss();
                    }
                });

                ad.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                ad.show();  // 마지막에 넣어줘야함
            }
        });
    }
}
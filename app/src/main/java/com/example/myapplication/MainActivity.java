package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText m = null;
    TextFileManager mTextFileManager = new TextFileManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextButton = (Button) findViewById(R.id.button9);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(i);
            }

        });


        m = (EditText) findViewById(R.id.memo_edit);

        ImageButton exitButton = (ImageButton) findViewById(R.id.exitbutton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("종료하시겠습니까?");
                builder.setTitle("종료")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("종료");
                alert.show();
            }
        });
    }





    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.load_btn: {
                String memoData = mTextFileManager.load();
                m.setText(memoData);
                Toast.makeText(this,"불러오기", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.save_btn: {
                String memoData = m.getText().toString();
                mTextFileManager.save(memoData);
                m.setText("");
                Toast.makeText(this,"저장하기", Toast.LENGTH_LONG).show();
                break;
            }

            case R.id.delete_btn: {
                mTextFileManager.delete();
                m.setText("");
                Toast.makeText(this,"삭제하기", Toast.LENGTH_LONG).show();


            }
        }
    }


}
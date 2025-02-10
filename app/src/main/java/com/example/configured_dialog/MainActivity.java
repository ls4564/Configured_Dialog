package com.example.configured_dialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    LinearLayout back;
    AlertDialog.Builder adb;
    final String[] colors = {"Red" , "Green" , "Blue"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        back = (LinearLayout) findViewById(R.id.back);
    }

    
    public void btn1(View view)
    {
        int[] color = new int[]{0, 0, 0};
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Choose color");


        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                color[i] = 255;
                back.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });
        adb.show();
    }

    public void btn2(View view) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Choose color");

        String[] colors = {"Red", "Green", "Blue"};
        final int[] color = {0, 0, 0};
        final int[] selectedColorIndex = {-1};

        adb.setSingleChoiceItems(colors, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                selectedColorIndex[0] = i;
            }
        });

        adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (selectedColorIndex[0] != -1) {
                    color[selectedColorIndex[0]] = 255;
                    findViewById(R.id.back).setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
                }
            }
        });

        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        adb.show();
    }

    public void btn3(View view) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Reset BackgroundColor");

        String[] options = {"Reset"};

        adb.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                back.setBackgroundColor(Color.WHITE);
            }
        });

        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });


        adb.show();
    }

    public void btn4(View view) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Enter text");

        final EditText input = new EditText(this);
        adb.setView(input);

        adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String text = input.getText().toString();
                Toast.makeText(getApplicationContext(), "Entered: " + text, Toast.LENGTH_SHORT).show();
            }
        });

        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        adb.show();
    }



    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId();


        if(id == R.id.it2)
        {
            si = new Intent(this, MainActivity2.class);
            startActivity(si);
        }
        return true;

    }

}
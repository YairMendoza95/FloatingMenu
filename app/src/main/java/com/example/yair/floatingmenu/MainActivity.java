package com.example.yair.floatingmenu;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Toast;

import com.github.fafaldo.fabtoolbar.widget.FABToolbarLayout;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private CircleMenu circleMenu;
    private FABToolbarLayout fabToolbarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleMenu = (CircleMenu)findViewById(R.id.circleMenu);
        findViewById(R.id.snapchat).setOnClickListener(this);
        findViewById(R.id.gmail).setOnClickListener(this);
        findViewById(R.id.whatsApp).setOnClickListener(this);
        findViewById(R.id.twitter).setOnClickListener(this);
        findViewById(R.id.facebook).setOnClickListener(this);
        findViewById(R.id.floating).setOnClickListener(this);
        fabToolbarLayout=(FABToolbarLayout)findViewById(R.id.fabToolbarLayout);
        menuCircle();
    }

    private void menuCircle(){
        circleMenu.setMainMenu(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent), android.R.drawable.ic_menu_share, android.R.drawable.ic_menu_share);
        circleMenu.addSubMenu(ContextCompat.getColor(getApplicationContext(), R.color.message), R.drawable.snapchat);
        circleMenu.addSubMenu(ContextCompat.getColor(getApplicationContext(), R.color.email), R.drawable.gmail);
        circleMenu.addSubMenu(ContextCompat.getColor(getApplicationContext(), R.color.whatsApp), R.drawable.whatsapp);
        circleMenu.addSubMenu(ContextCompat.getColor(getApplicationContext(), R.color.twitter), R.drawable.gorjeo);
        circleMenu.addSubMenu(ContextCompat.getColor(getApplicationContext(), R.color.facebook), R.drawable.facebook);

        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {
            @Override
            public void onMenuSelected(int i) {
                indexCircle(i);
            }
        });
    }

    private void indexCircle(int index){
        switch (index){
            case 0:
                Toast.makeText(getApplicationContext(), "Snapchat", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(getApplicationContext(), "Gmail", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getApplicationContext(), "WhatsApp", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(getApplicationContext(), "Twitter", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(getApplicationContext(), "Facebook", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.floating:
                fabToolbarLayout.show();
                break;
            case R.id.facebook:
                Toast.makeText(getApplicationContext(), "Facebook", Toast.LENGTH_LONG).show();
                fabToolbarLayout.hide();
                break;
            case R.id.twitter:
                Toast.makeText(getApplicationContext(), "Twitter", Toast.LENGTH_LONG).show();
                fabToolbarLayout.hide();
                break;
            case R.id.gmail:
                Toast.makeText(getApplicationContext(), "Gmail", Toast.LENGTH_LONG).show();
                fabToolbarLayout.hide();
                break;
            case R.id.whatsApp:
                Toast.makeText(getApplicationContext(), "WhatsApp", Toast.LENGTH_LONG).show();
                fabToolbarLayout.hide();
                break;
            case R.id.snapchat:
                Toast.makeText(getApplicationContext(), "Snapchat", Toast.LENGTH_LONG).show();
                fabToolbarLayout.hide();
        }
    }
}

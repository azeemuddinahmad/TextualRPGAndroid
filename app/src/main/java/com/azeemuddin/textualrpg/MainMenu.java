package com.azeemuddin.textualrpg;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void quit_game(View view) {
        finish();
    }

    public void new_game(View view) {
        Intent new_game = new Intent(this,StartGame.class);
        startActivity(new_game);
        finish();
        Inventory inventory = new Inventory();
        inventory._gameStart();
    }

    public void continue_game(View view) {
        Intent new_game = new Intent(this,StartGame.class);
        startActivity(new_game);
        finish();
    }
}

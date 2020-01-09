package com.example.univerzijada2020.Views;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.univerzijada2020.Data.Game;
import com.example.univerzijada2020.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Games extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        Game.initializeGames();
        final TableLayout g = (TableLayout)findViewById(R.id.gameTable);
        ArrayList<Game> games = Game.getGamesUser();
        fillTable(games, g);

        final Button gamesButton = findViewById(R.id.filter);
        gamesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText datefromField = (EditText)findViewById(R.id.datefrom);
                String datefrom = datefromField.getText().toString();

                EditText datetoField = (EditText)findViewById(R.id.dateto);
                String dateto = datetoField.getText().toString();

                EditText timefromField = (EditText)findViewById(R.id.timefrom);
                String timefrom = timefromField.getText().toString();

                EditText timeField = (EditText)findViewById(R.id.timeto);
                String timeto = timeField.getText().toString();

                EditText stadiumField = (EditText)findViewById(R.id.stadiumFil);
                String stadium = stadiumField.getText().toString();

                ArrayList<Game> list = Game.games;
                if(!datefrom.isEmpty() && !dateto.isEmpty()){
                    try {
                        Date d1 = new SimpleDateFormat("dd/MM/yyyy").parse(datefrom);
                        Date d2 = new SimpleDateFormat("dd/MM/yyyy").parse(dateto);
                        list = Game.searchGamesDate(list, d1, d2);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }
                if(!timefrom.isEmpty() && !timeto.isEmpty()){
                    list = Game.searchGamesTime(list, timefrom, timeto);
                }
                if(!stadium.isEmpty()){
                    list = Game.searchGamesStadium(list, stadium);
                }

                fillTable(list, g);
            }
        });
    }

    public void fillTable(ArrayList<Game> games, TableLayout g){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        ViewGroup.LayoutParams lp = new TableLayout.LayoutParams(200, 50);
        g.removeAllViews();

        TableRow tr1 = new TableRow(this);

        TextView date1 = new TextView(this);
        date1.setTextColor(Color.BLACK);
        date1.setTextSize(16);
        date1.setTypeface(null, Typeface.BOLD);

        TextView time1 = new TextView(this);
        time1.setTextColor(Color.BLACK);
        time1.setTextSize(16);
        time1.setTypeface(null, Typeface.BOLD);

        TextView stadium1 = new TextView(this);
        stadium1.setTextColor(Color.BLACK);
        stadium1.setTextSize(16);
        stadium1.setTypeface(null, Typeface.BOLD);

        date1.setText("Datum");
        time1.setText("Vreme");
        stadium1.setText("Hala");
        tr1.addView(date1);
        tr1.addView(time1);
        tr1.addView(stadium1);

        g.addView(tr1);

        for(Game game: games){
            TableRow tr = new TableRow(this);

            TextView date = new TextView(this);
            date.setTextColor(Color.BLACK);
            date.setTextSize(16);

            TextView time = new TextView(this);
            time.setTextColor(Color.BLACK);
            time.setTextSize(16);

            TextView stadium = new TextView(this);
            stadium.setTextColor(Color.BLACK);
            stadium.setTextSize(16);

            date.setText(dateFormat.format(game.getDate()));
            time.setText(game.getTime());
            stadium.setText(game.getStadium());
            tr.addView(date);
            tr.addView(time);
            tr.addView(stadium);

            g.addView(tr);
        }
    }
}

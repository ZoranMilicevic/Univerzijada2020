package com.example.univerzijada2020.Data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Game {
    private String username;
    private Date date;
    private String time;
    private String stadium;

    public static ArrayList<Game> games;

    public static void initializeGames(){
        games = new ArrayList<>();

        Date date = new GregorianCalendar(2020, Calendar.JUNE, 11).getTime();
        games.add(new Game("zoki", date, "16:30", "Pionir"));

        date = new GregorianCalendar(2020, Calendar.JUNE, 21).getTime();
        games.add(new Game("zoki", date, "17:30", "Marakana"));

        date = new GregorianCalendar(2020, Calendar.JUNE, 24).getTime();
        games.add(new Game("zoki", date, "18:00", "Rajko Mitic"));


        date = new GregorianCalendar(2020, Calendar.JUNE, 18).getTime();
        games.add(new Game("zika", date, "13:30", "Arena"));

        date = new GregorianCalendar(2020, Calendar.JULY, 27).getTime();
        games.add(new Game("zika", date, "14:30", "Omladinski"));

        date = new GregorianCalendar(2020, Calendar.JUNE, 8).getTime();
        games.add(new Game("zika", date, "15:00", "JNA"));

    }

    public static ArrayList<Game> getGamesUser(){
        ArrayList<Game> ret = new ArrayList<>();
        for (Game game:games) {
            if(game.getUsername().equals(User.currentUser.getUsername())){
                ret.add(game);
            }
        }
        return ret;
    }

    public static ArrayList<Game> searchGamesDate(ArrayList<Game> games, Date begin, Date end){
        ArrayList<Game> ret = new ArrayList<>();
        for (Game game:games) {
            if(game.getUsername().equals(User.currentUser.getUsername())){
                if(game.getDate().before(end) && game.getDate().after(begin)){
                    ret.add(game);
                }
            }
        }
        return ret;
    }

    public static ArrayList<Game> searchGamesTime(ArrayList<Game> games, String startTime, String endTime){
        String[] arr = startTime.split(":");
        int startHours = Integer.parseInt(arr[0]);
        int startMinutes = Integer.parseInt(arr[1]);

        String[] arr2 = endTime.split(":");
        int endHours = Integer.parseInt(arr2[0]);
        int endMinutes = Integer.parseInt(arr2[1]);

        ArrayList<Game> ret = new ArrayList<>();
        for (Game game:games) {
            if(game.getUsername().equals(User.currentUser.getUsername())){
                String[] arr3 = game.getTime().split(":");
                int gameHours = Integer.parseInt(arr3[0]);
                int gameMinutes = Integer.parseInt(arr3[1]);

                if(gameHours < endHours && gameHours>startHours){
                    ret.add(game);
                }
                else if(gameHours == startHours && gameMinutes > startMinutes){
                    ret.add(game);
                }
                else if(gameHours == endHours && gameMinutes < endMinutes){
                    ret.add(game);
                }
            }
        }

        return ret;
    }

    public static ArrayList<Game> searchGamesStadium(ArrayList<Game> games, String stadium){
        ArrayList<Game> ret = new ArrayList<>();
        for (Game game:games) {
            if(game.getUsername().equals(User.currentUser.getUsername()) && game.getStadium().equals(stadium)){
                ret.add(game);
            }
        }
        return ret;
    }

    ///////////////////////////////////////////////////////////////////////////

    public Game(String username, Date date, String time, String stadium) {
        this.username = username;
        this.date = date;
        this.time = time;
        this.stadium = stadium;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }
}

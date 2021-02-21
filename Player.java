package com.company;

import java.util.ArrayList;

public class Player
{   private String playername;



    private String Answer = "placeholder";
    private int score = 0;



    public Player() {}

    public Player (String playername)
    {this.playername=playername;}


    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }



    public String getCard()
    { return getPlayername()+ " : " +getScore();}

}

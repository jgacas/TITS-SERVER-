package com.company;

import java.sql.SQLException;
import java.util.ArrayList;

public class Session {


    public RNGjesus rnGjesus1 = new RNGjesus();
    private String gameid = "placeholder";
    private String Question = "placeholder";
    public ArrayList<Player> players = new ArrayList<Player>();
    private String doomsdayclock = "no" ;
    SqlMinion sqlminionSession1 = new SqlMinion();
    public String electorcount = "placeholder";


    private String password;

    public Session(){}
    public Session (String gameid) {this.gameid = gameid;}
    public String getQuestion() {return Question;}
    public void setQuestion(String question)
    {Question = question;}
    public String getGameid() {
        return gameid;
    }
    public void setGameid(String gameid) {
        this.gameid = gameid;
    }
    public void addplayer (String playername) {this.players.add(new Player(playername));}


    public String getDoomsdayclock() {
        return doomsdayclock;
    }

    public void setDoomsdayclock(String doomsdayclock) {
        this.doomsdayclock = doomsdayclock;
    }
    public String getElectorcount() {return electorcount;}
    public void setElectorcount(String electorcount) {this.electorcount = electorcount;}

    public void createQuestion() throws SQLException {this.setQuestion(rnGjesus1.CreateCard());}

    public String getAnswers() {
        StringBuilder endgamepaloki = new StringBuilder(" ");
        if (this.players.size()>0)
        { for (int i = 0; i<this.players.size(); i++ )
        { endgamepaloki.append( " " + this.players.get(i).getPlayername() + "gave this answer" + " " + this.players.get(i).getAnswer() + " "   );} }

        return String.valueOf(endgamepaloki) ;
    }
    public ArrayList<String> adhoccheck ()
    { ArrayList <String> playernames = new ArrayList<String>() ;
        for (int i = 0; i<this.players.size(); i++)
     { playernames.add(players.get(i).getPlayername()); }
       return playernames;
    }
    public String getScores() {
        StringBuilder endgamepaloki = new StringBuilder(" ");
        if (this.players.size()>0)
        { for (int i = 0; i<this.players.size(); i++ )
         { endgamepaloki.append( " "+ "Judge Status" + "  " + this.getElectorcount() + " " + this.players.get(i).getPlayername()+ " "
                 + "has this number of points"  + " " + this.players.get(i).getCard());} }

        return String.valueOf(endgamepaloki) ;
    }

    public void incrementScore(String Player , String Judge)
    {   for (int i = 0; i<this.players.size(); i++ )
        { if  ((this.players.get(i).getPlayername().equals(Player) && ( this.getElectorcount().equals(Judge)  )   ))
        { this.players.get(i).setScore(this.players.get(i).getScore()+1);
          this.setElectorcount(Player);
        }}
    }
    public void d20roll ()
    { for (int i = 0; i<this.players.size();i++ )
    { if (this.players.get(i).getPlayername().equals(this.electorcount))
    { System.out.println("derp");    }
    else this.setElectorcount(this.players.get(i).getPlayername());}   }
    public void insAnswer( String player , String answer )
    { for (int i = 0; i<this.players.size(); i++ )
    { if (this.players.get(i).getPlayername().equals(player))
    { this.players.get(i).setAnswer(answer);}}  }
}

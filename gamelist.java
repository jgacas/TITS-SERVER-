package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class gamelist {

    public ConcurrentHashMap<String, Session> sessionConcurrentHashMap = new ConcurrentHashMap<>();


    public String electorcount = "placeholder";

    public gamelist() {
    }

    public void addsession(String gameid) throws SQLException {
        sessionConcurrentHashMap.put(gameid, new Session(gameid));
        sessionConcurrentHashMap.get(gameid).rnGjesus1.preparedecks();
        sessionConcurrentHashMap.get(gameid).rnGjesus1.CreateCard();

    }

    //  sessionConcurrentHashMap.get(gameid).addplayer(master);
    public void listensocket() {

        try (ServerSocket ss = new ServerSocket(3333)) {
            while (1 > 0) {

                Socket s = ss.accept();
                DataInputStream din = new DataInputStream(s.getInputStream());
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                String Paloki = din.readUTF();
                String[] Palokiz = Paloki.split("spergzilion");

                dout.writeUTF(String.valueOf(filtertheneedful(Palokiz)));
                dout.flush();
            }
        } catch (IOException | SQLException exc) {
            System.out.println(exc.getMessage());
        }
    }

    public String filtertheneedful(String[] Palokiz) throws SQLException {
        if (Palokiz[0].equals("getscore")) {
            sessionConcurrentHashMap.get(Palokiz[1]).setDoomsdayclock("no");
            return sessionConcurrentHashMap.get(Palokiz[1]).getScores();
        } else if (Palokiz[0].equals("getanswers")) {
            sessionConcurrentHashMap.get(Palokiz[1]).setDoomsdayclock("no");
            return sessionConcurrentHashMap.get(Palokiz[1]).getAnswers();
        } else if (Palokiz[0].equals("getquestion")) {
            sessionConcurrentHashMap.get(Palokiz[1]).setDoomsdayclock("no");
            return sessionConcurrentHashMap.get(Palokiz[1]).getQuestion();
        } else if (Palokiz[0].equals("addplayer")) {

            if (sessionConcurrentHashMap.get(1).adhoccheck().contains(Palokiz[2])) {
                return " they are alredy here jim ";
            } else {
                sessionConcurrentHashMap.get(Palokiz[1]).addplayer(Palokiz[2]);
                if ((sessionConcurrentHashMap.get(Palokiz[1]).players.size() > 0)
                        && (sessionConcurrentHashMap.get(Palokiz[1]).players.size() < 2)) {
                    sessionConcurrentHashMap.get(Palokiz[1]).setElectorcount(Palokiz[2]);
                }
                sessionConcurrentHashMap.get(Palokiz[1]).setDoomsdayclock("no");
                return "Player inserted";
            }
        } else if (Palokiz[0].equals("vote")) {
            if (Palokiz[2].equals(Palokiz[3])) {
                sessionConcurrentHashMap.get(Palokiz[1]).d20roll();
            } else {
                sessionConcurrentHashMap.get(Palokiz[1]).incrementScore(Palokiz[2], Palokiz[3]);
                sessionConcurrentHashMap.get(Palokiz[1]).rnGjesus1.CreateCard();
            }
        } else if (Palokiz[0].equals("answer")) {
            sessionConcurrentHashMap.get(Palokiz[1]).insAnswer(Palokiz[2], Palokiz[3]);
        } else if (Palokiz[0].equals("addsession")) {

            if (sessionConcurrentHashMap.contains(Palokiz[1])) {
                return " game already exists ";
            } else {

                this.addsession(Palokiz[1]);
                sessionConcurrentHashMap.get(Palokiz[1]).addplayer(Palokiz[2]);
            }
        } else {
            return "yinz fucked up";
        }

        return " Did a thing ";
    }


    public void cleandoom() {
        {
            this.sessionConcurrentHashMap.forEach((k, v) ->
            {
                if (this.sessionConcurrentHashMap.get(k).getDoomsdayclock().equals("no")) {
                    this.sessionConcurrentHashMap.get(k).setDoomsdayclock("yes");
                } else if (this.sessionConcurrentHashMap.get(k).getDoomsdayclock().equals("yes")) {
                    sessionConcurrentHashMap.remove(k);
                }
                try {
                    TimeUnit.MINUTES.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
    }

    public void inserttheneedful(String gameid, String element) {
    }

    public String slctscore(String gameid) {
        return this.sessionConcurrentHashMap.get(gameid).getScores();
    }

    public String slctanswer(String gameid) {
        return this.sessionConcurrentHashMap.get(gameid).getAnswers();
    }

    public String slctquestion(String gameid) {
        return this.sessionConcurrentHashMap.get(gameid).getQuestion();
    }
}



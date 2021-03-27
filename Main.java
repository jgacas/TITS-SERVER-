package com.company; // // struktura foldera mora da prati hijerarhiju paketa, zato da ova klasa mora da bude u com/company folderu

import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) throws SQLException {
        // klasagamelist (treba da bude GameList) nije importovana
        // zasto gamelist1, sto nije gameList ili gameList1000, zasto bas 1?
        gamelist gamelist1 = new gamelist();

        ThreadPoolExecutor ThreadPoolExecutor1 = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        ThreadPoolExecutor1.submit(() -> { gamelist1.listensocket();});
        ThreadPoolExecutor1.submit(() -> { gamelist1.cleandoom();});}}

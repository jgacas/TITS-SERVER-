package com.company;

import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) throws SQLException {
        gamelist gamelist1 = new gamelist();

        ThreadPoolExecutor ThreadPoolExecutor1 = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        ThreadPoolExecutor1.submit(() -> { gamelist1.listensocket();});
        ThreadPoolExecutor1.submit(() -> { gamelist1.cleandoom();});}}

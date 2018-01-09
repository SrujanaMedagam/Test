package com.valuelabs.timer;

import java.util.TimerTask;

class Checker extends TimerTask {
        public static final int DELAY = 60 * 1000;
     
        public void run() {

            doCheck();

        }


        private void doCheck() {
            System.out.println("Current time is: " + System.currentTimeMillis());
        }
    }
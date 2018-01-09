package com.valuelabs.timer;

import java.util.Timer;

public class SimpleTimer {

    public static void main (String[] argv) {
    	Checker checker = new Checker();
        Timer timer = new Timer(); // start the timer thread
        timer.schedule
        (checker, Checker.DELAY); // calls the Checker's run() method after one minute and repeat every one minute.
    }
}

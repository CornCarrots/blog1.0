package com.lh.util;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {
    Timer timer;

    public MyTimer(int sec,TimerTask task)
    {
        timer = new Timer();
        timer.schedule(task,10000,sec*1000*60);
    }
}

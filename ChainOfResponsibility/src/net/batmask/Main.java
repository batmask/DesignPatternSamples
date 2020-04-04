package net.batmask;

import net.batmask.MyLogger.LOGLEVEL;
import net.batmask.MyLogger.MyLog;

public class Main {
    public static void main(String[] args){
        MyLog.log(LOGLEVEL.D, "It's debug message");
        MyLog.log(LOGLEVEL.V, "It's verbose message");
        MyLog.log(LOGLEVEL.E, "It's error message");

        System.out.println("--- Set output level DEBUG ---");
        MyLog.setLevel(LOGLEVEL.D);
        MyLog.log(LOGLEVEL.D, "It's debug message");
        MyLog.log(LOGLEVEL.V, "It's verbose message");
        MyLog.log(LOGLEVEL.E, "It's error message");
    }
}



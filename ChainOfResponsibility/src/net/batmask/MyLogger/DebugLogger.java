package net.batmask.MyLogger;

public class DebugLogger extends MyLogger {
    DebugLogger(){
        level = LOGLEVEL.D;
    }

    @Override
    public void handleMessage(LOGLEVEL level, String msg) {
        if(this.level == level){
            System.out.println("DebugLogger: " + level.type + msg);
        }

        sendToNext(level, msg);
    }
}

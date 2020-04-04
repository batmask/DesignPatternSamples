package net.batmask.MyLogger;

public class ErrorLogger extends MyLogger {
    ErrorLogger(){
        level = LOGLEVEL.E;
    }

    @Override
    public void handleMessage(LOGLEVEL level, String msg) {
        if(this.level == level){
            System.out.println("ErrorLogger: " + level.type + msg);
        }

        sendToNext(level, msg);
    }
}

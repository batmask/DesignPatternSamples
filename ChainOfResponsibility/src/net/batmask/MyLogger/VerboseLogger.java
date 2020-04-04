package net.batmask.MyLogger;

public class VerboseLogger extends MyLogger {
    VerboseLogger(){
        level = LOGLEVEL.V;
    }

    @Override
    public void handleMessage(LOGLEVEL level, String msg) {
        if(this.level == level){
            System.out.println("VerboseLogger: " + level.type + msg);
        }

        sendToNext(level, msg);
    }
}

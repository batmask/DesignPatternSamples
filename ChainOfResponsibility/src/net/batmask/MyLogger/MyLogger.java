package net.batmask.MyLogger;

public abstract class MyLogger {
    protected MyLogger nextLogger = null;
    protected LOGLEVEL level = null;

    private static LOGLEVEL outputLevel = LOGLEVEL.V;

    public abstract void handleMessage(LOGLEVEL level, String msg);
    public void setNextLogger(MyLogger logger){
        nextLogger = logger;
    }

    public void sendToNext(LOGLEVEL level, String msg){
        if(this.level.ordinal() < MyLogger.outputLevel.ordinal() && nextLogger != null){
            nextLogger.handleMessage(level, msg);
        }
    }

    public static void setLevel(LOGLEVEL level){
        outputLevel = level;
    }

    public static LOGLEVEL getLevel(){
        return outputLevel;
    }
}

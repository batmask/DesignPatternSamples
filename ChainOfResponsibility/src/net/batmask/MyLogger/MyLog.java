package net.batmask.MyLogger;

public class MyLog {
    private static MyLogger vLogger = new VerboseLogger();
    private static MyLogger dLogger = new DebugLogger();
    private static MyLogger eLogger = new ErrorLogger();

    static {
        eLogger.setNextLogger(dLogger);
        dLogger.setNextLogger(vLogger);
    }

    public static void log(LOGLEVEL level, String msg){
        eLogger.handleMessage(level, msg);
    }

    public static void setLevel(LOGLEVEL level){
        MyLogger.setLevel(level);
    }

    public static LOGLEVEL getLevel(){
        return MyLogger.getLevel();
    }
}

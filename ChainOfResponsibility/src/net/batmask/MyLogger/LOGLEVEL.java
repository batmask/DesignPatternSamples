package net.batmask.MyLogger;

public enum LOGLEVEL{E("[ERROR]"), D("[DEBUG]"), V("[VERBOSE]");
    protected final String type;

    LOGLEVEL(String s) {
        this.type = s;
    }
}

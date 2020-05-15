package net.batmask;

public class Kotlin extends MyEditorCompiler {
    private String JVM = "OpenJDK";

    public String getJVM() {
        return JVM;
    }

    public void setJVM(String JVM) {
        this.JVM = JVM;
    }

    @Override
    protected void compile() {
        System.out.println("Kotlin compiler compile...");
    }

    @Override
    protected void runOnJVM() {
        System.out.println("Run on " + getJVM() + " JVM");
    }
}

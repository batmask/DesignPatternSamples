package net.batmask;

public class OpenJDK extends MyEditorCompiler {
    @Override
    protected void compile() {
        System.out.println("OpenJDK compiler compile...");
    }

    @Override
    protected void runOnJVM() {
        System.out.println("Run on OpenJDK JVM");
    }
}

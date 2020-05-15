package net.batmask;

public class Oracle extends MyEditorCompiler {
    @Override
    protected void compile() {
        System.out.println("Oracle compiler compile...");
    }

    @Override
    protected void runOnJVM() {
        System.out.println("Run on Oracle JVM");
    }
}

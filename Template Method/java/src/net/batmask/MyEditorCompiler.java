package net.batmask;

public abstract class MyEditorCompiler {
    public void run(){
        preProcess();
        compile();
        runOnJVM();
    }

    private void preProcess(){
        System.out.println("Common preprocessing in editor");
    }
    protected abstract void compile();
    protected abstract void runOnJVM();
}

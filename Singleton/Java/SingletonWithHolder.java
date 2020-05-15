public class SingletonWithHolder {
    private SingletonWithHolder(){}

    private static class LazyHolder {
        private static final SingletonWithHolder instance = new SingletonWithHolder();
    }

    public static SingletonWithHolder getInstance(){
        return LazyHolder.instance;
    }
}
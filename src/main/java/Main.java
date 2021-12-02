public class Main {
    private static final int CALLS = 60;
    private static final int SPECIALISTS = 10;

    public static void main(String[] args) {
        CallCenter center = new CallCenter();
        for (int i = 0; i < CALLS; i++) {
            new Thread(null, center::call, "№ " + (i + 1)).start();
        }
        for (int i = 0; i < SPECIALISTS; i++) {
            new Thread(null, center::takeTheCall, "№ " + (i + 1)).start();
        }
    }
}

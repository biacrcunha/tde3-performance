public class DeadlockResolvido {

    static final Object LOCK_A = new Object();
    static final Object LOCK_B = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> executar(1));
        Thread t2 = new Thread(() -> executar(2));

        t1.start();
        t2.start();
    }

    private static void executar(int id) {
        Object primeiro = LOCK_A;
        Object segundo  = LOCK_B;

        // Ordem global: sempre adquirir A antes de B
        synchronized (primeiro) {
            System.out.println("T" + id + ": adquiriu LOCK_A");
            dormir(50);

            synchronized (segundo) {
                System.out.println("T" + id + ": adquiriu LOCK_B");
                System.out.println("T" + id + ": execução concluída");
            }
        }
    }

    private static void dormir(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

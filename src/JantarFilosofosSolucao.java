import java.util.concurrent.locks.ReentrantLock;

public class JantarFilosofosSolucao {

    private static final int N = 5;
    private static final ReentrantLock[] garfos = new ReentrantLock[N];

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            garfos[i] = new ReentrantLock(true); // modo justo (FIFO)
        }

        for (int i = 0; i < N; i++) {
            int id = i;
            new Thread(() -> filosofoOrdenado(id)).start();
        }
    }

    private static void filosofoOrdenado(int id) {
        int esquerda = id;
        int direita = (id + 1) % N;

        // Impõe ordem global
        int first = Math.min(esquerda, direita);
        int second = Math.max(esquerda, direita);

        while (true) {
            pensar(id);

            System.out.println("Filósofo " + id + " está com fome.");

            // Adquire sempre na ordem menor → maior
            garfos[first].lock();
            System.out.println("Filósofo " + id + " pegou garfo " + first);

            garfos[second].lock();
            System.out.println("Filósofo " + id + " pegou garfo " + second);

            comer(id);

            garfos[second].unlock();
            garfos[first].unlock();
        }
    }

    private static void pensar(int id) {
        System.out.println("Filósofo " + id + " pensando...");
        dormir(200);
    }

    private static void comer(int id) {
        System.out.println("Filósofo " + id + " COMENDO!");
        dormir(200);
    }

    private static void dormir(long ms) {
        try { Thread.sleep(ms); } catch (Exception ignored) {}
    }
}


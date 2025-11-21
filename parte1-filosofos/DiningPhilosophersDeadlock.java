import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophersDeadlock {

    private static final int N = 5;
    private static final ReentrantLock[] garfos = new ReentrantLock[N];

    public static void main(String[] args) {
        // Inicializa os garfos
        for (int i = 0; i < N; i++) {
            garfos[i] = new ReentrantLock();
        }

        // Cria e inicia os filósofos
        for (int i = 0; i < N; i++) {
            int id = i;
            new Thread(() -> filosofoIngenuo(id)).start();
        }
    }

    private static void filosofoIngenuo(int id) {
        int esquerda = id;
        int direita = (id + 1) % N;

        while (true) {
            pensar(id);

            System.out.println("Filósofo " + id + " está com fome.");

            // PROTOCOLO ERRADO: pega primeiro esquerda, depois direita
            garfos[esquerda].lock();
            System.out.println("Filósofo " + id + " pegou garfo ESQUERDA " + esquerda);

            dormir(50);

            garfos[direita].lock(); // <- aqui trava se o vizinho estiver segurando
            System.out.println("Filósofo " + id + " pegou garfo DIREITA " + direita);

            comer(id);

            garfos[direita].unlock();
            garfos[esquerda].unlock();
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



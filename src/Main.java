import java.util.concurrent.CyclicBarrier;

public class Main {

    private static final int NUMERO_AMIGOS = 10;

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(NUMERO_AMIGOS,new Ciclo1());
        CyclicBarrier cyclicBarrier2 = new CyclicBarrier(NUMERO_AMIGOS,new Ciclo2());
        CyclicBarrier cyclicBarrier3 = new CyclicBarrier(NUMERO_AMIGOS,new Ciclo3());

        for(int i = 0;i < NUMERO_AMIGOS; i++){

            new Thread(new Ciclista("Ciclista " + (i+1),cyclicBarrier1,cyclicBarrier2,cyclicBarrier3)).start();


        }

    }
}

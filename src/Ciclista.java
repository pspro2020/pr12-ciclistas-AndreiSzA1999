import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Ciclista implements Runnable{

      private final String nombre;
      private final CyclicBarrier cyclicBarrier1;
      private final CyclicBarrier cyclicBarrier2;
      private final CyclicBarrier cyclicBarrier3;
      private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.getDefault());

    public Ciclista(String nombre, CyclicBarrier cyclicBarrier1, CyclicBarrier cyclicBarrier2, CyclicBarrier cyclicBarrier3) {
        this.nombre = nombre;
        this.cyclicBarrier1 = cyclicBarrier1;
        this.cyclicBarrier2 = cyclicBarrier2;
        this.cyclicBarrier3 = cyclicBarrier3;
    }

    @Override
    public void run() {
        try {
            irAGasolinera();
        } catch (InterruptedException e) {
            System.out.println("He sido interrumpiod");
            return;
        }
        try {
            cyclicBarrier1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        try{
            irAVenta();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            cyclicBarrier2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        try {
            volverAGasolinera();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            cyclicBarrier3.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        try {
            volverACasa();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void irAGasolinera() throws InterruptedException {

        System.out.printf("%s -> %s ha salido de su casa \n", LocalTime.now().format(dateTimeFormatter),nombre);
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(3)+1);
        System.out.printf("%s -> %s ha llegado a la gasolinera \n", LocalTime.now().format(dateTimeFormatter),nombre);

    }

    private void irAVenta() throws InterruptedException {
        System.out.printf("%s -> %s ha salido de la gasolinera \n", LocalTime.now().format(dateTimeFormatter),nombre);
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5,11));
        System.out.printf("%s -> %s ha llegado a la venta \n", LocalTime.now().format(dateTimeFormatter),nombre);
    }

    private void volverAGasolinera() throws InterruptedException {
        System.out.printf("%s -> %s ha salido de la venta \n", LocalTime.now().format(dateTimeFormatter),nombre);
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(5,11));
        System.out.printf("%s -> %s ha llegado a la gasolinera \n", LocalTime.now().format(dateTimeFormatter),nombre);
    }


    private void volverACasa() throws InterruptedException {

        System.out.printf("%s -> %s ha salido de su gasolinera \n", LocalTime.now().format(dateTimeFormatter),nombre);
        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(3)+1);
        System.out.printf("%s -> %s YA EN CASA \n", LocalTime.now().format(dateTimeFormatter),nombre);

    }


}

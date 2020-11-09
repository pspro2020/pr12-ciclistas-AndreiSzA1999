import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Ciclo2 implements Runnable {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.getDefault());


    @Override
    public void run() {
        System.out.printf("%s -> DE VUELTA A CASA \n", LocalTime.now().format(dateTimeFormatter));
    }
}

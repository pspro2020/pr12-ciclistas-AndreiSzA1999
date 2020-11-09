import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Ciclo3 implements Runnable {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.getDefault());


    @Override
    public void run() {
        System.out.printf("%s -> ETAPA FINALIZADA \n", LocalTime.now().format(dateTimeFormatter));
    }
}

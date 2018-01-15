import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Calka {

    private static volatile double wynik = 0;

    public static void main(String[] args) throws Exception{
        for (int i =0; i*0.1< Math.PI;i++){
            Calka_callable calka = new Calka_callable(i*0.1, i*0.1+0.1, 0.00000001);
            wynik += calka.call();
        }

        System.out.println("Wynik calkowania: "+ wynik);

        ExecutorService executor = Executors.newFixedThreadPool(8);
        for(int i =0; i*0.1 < Math.PI; i++){
            Runnable worker = new Calka_callable(i*0.1, i *0.1 + 0.1, 0.00000001);
            executor.execute(worker);
        }

        executor.shutdown();

        while (!executor.isTerminated()){}

        System.out.print("Wszystkie watki zakonczone");
        System.out.print("Wynik " + Calka_callable.getWynik());
    }
}

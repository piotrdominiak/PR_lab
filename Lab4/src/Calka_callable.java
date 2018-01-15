import java.util.concurrent.Callable;

public class Calka_callable implements Callable<Double>, Runnable {
   private double dx;
   private double xp;
   private double xk;
   private int N;

   private static volatile double wynik;

   public static double getWynik() {
       return wynik;
   }

   public Calka_callable(double dx, double xk, double xp){
       this.dx = dx;
       this.xk = xk;
       this.N = (int)Math.ceil((xk-xp)/dx);
       this.dx = (xk-xp)/N;

       System.out.println("Tworze instancje Calka_callable");
       System.out.println("xp = " + xp +", xk = " + xk + ", N = " + N);
       System.out.println("dx oczekiwane = " + dx + ", dx koncowe " + this.dx);
   }


   private double getFunction(double x){
       return Math.sin(x);
   }

   public double compute(){
       double calka = 0;
       for(int i = 0; i < N; i++){
           double x1 = xp +i*dx;
           double x2 = x1 + dx;
           calka +=((getFunction(x1) + getFunction(x2))/2.)*dx;
       }
       return  calka;
   }

   @Override
    public Double call() throws Exception{
       double calka = compute();
       System.out.println("Calka czastkowa: " + calka);
       return calka;
   }

   @Override
    public void run() {
        double calka = compute();
        System.out.println("Calka czastkowa: " + calka);
        wynik += calka;
    }
}

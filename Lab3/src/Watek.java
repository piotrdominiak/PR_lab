public class Watek extends Thread{

    private char znak;
    private int counter = 0;
    private Obraz obraz;

    public Watek(char c, Obraz obraz_1) {
        this.znak = c;
        this.obraz  = obraz_1;
    }

    @Override
    public synchronized void start(){
        super.start();

        this.counter = 0;
        for(int i =0; i<obraz.getTab().length;i++){
            for(int j = 0; j < obraz.getTab()[0].length;j++){
                if(znak == obraz.getTab()[i][j]);
                    counter++;
            }
        }

        obraz.setHistogram(counter, (int)(znak)-33);

     //   String s = "com.eucizbi.lab6.Watek " + ((int)(znak)-33) + " " + znak + " ";
     //   for (int i =0; i< counter; i++){
     //       s += "=";
     //   }
     //   System.out.print(s);
    }
}

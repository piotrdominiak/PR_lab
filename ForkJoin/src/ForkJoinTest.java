import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.RecursiveAction;

public class ForkJoinTest {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set array size: ");
        int totalNumbers = scanner.nextInt();
        double []numbers = new double[totalNumbers];

        int i_p=0;
        int i_k = totalNumbers-1;

        MaxTask task = new MaxTask(numbers, i_p, i_k);
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        forkJoinPool.invoke(task);

        System.out.println("Max el in array: "+task.join());
    }
}

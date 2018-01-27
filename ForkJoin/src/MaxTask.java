import java.util.concurrent.RecursiveTask;


public class MaxTask extends RecursiveTask<Double>{
    private double[] arrayForMax;
    private int index_start;
    private int index_end;

    final private int THRESHOLD =100;

    public MaxTask(double[] arrayForMax, int index_start, int index_end){
        this.index_start = index_start;
        this.index_end = index_end;
        this.arrayForMax = arrayForMax;
    }

    public double maxSeq(){
        double MaxLoc = arrayForMax[index_start];
        for(int i = 0; i <= index_end; i++){
            if(arrayForMax[i]>MaxLoc)
                MaxLoc = arrayForMax[i];
        }
        return MaxLoc;
    }

    protected Double compute(){
        System.out.println("Task: (" + index_start + ", " + index_end + ")");

        if((index_end - index_start) <= THRESHOLD){
            return maxSeq();
        }
        int index_mid = (index_start + index_end)/2;
        MaxTask left = new MaxTask(arrayForMax,index_start,index_mid-1);
        MaxTask right = new MaxTask(arrayForMax, index_mid,index_end);

        left.fork();
        right.fork();

        double leftMax = left.join();
        double rightMax = right.join();

        return Math.max(leftMax,rightMax);

    }

}

package walmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergedIntervals {


    public static int[][] merge(int [][]intervals){

        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));

        int []currentInterval=intervals[0];
        for(int i : currentInterval){
            System.out.println("array item : "+i);
        }
        List<int[]> merged = new ArrayList<>();
        merged.add(currentInterval);
        for(int [] interval: intervals){

            int nextStart=interval[0];
            int nextEnd=interval[1];
            int currentEnd= currentInterval[1];

            if(nextStart<=currentEnd){
               currentInterval[1]= Math.max(nextEnd,currentEnd);
            }else{
                currentInterval=interval;
                merged.add(currentInterval);
            }

        }

        return merged.toArray(new int[merged.size()][]);
    }
    public static void main(String args[]){

        int[][] intervals = {
                {1,3}, {2,6}, {8,10}, {15,18}
        };

        int[][] merged = merge(intervals);

        System.out.println("Merged intervals:");
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

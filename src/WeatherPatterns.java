import java.util.ArrayList;

/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author Caden Chock
 */

public class WeatherPatterns {


    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures) {
        ArrayList<Integer>[] list = new ArrayList[temperatures.length];
        for(int i = 0; i < list.length; i++){
           list[i] = new ArrayList<Integer>();
        }
        //Array of Saved Runs
        int[] saved = new int[temperatures.length];
        list = adjacencyList(list, temperatures);
        int biggest = 0;
        for(int i = 0; i < temperatures.length; i++){
            int num = LongestPathTo(i, list, saved);
            if(num > biggest){
                biggest = num;
            }
        }
    }

    //Create Adjacency List
    public static ArrayList<Integer>[] adjacencyList(ArrayList<Integer>[] list, int[] temperatures){
      for(int j = 0; j < list.length; j++) {
          for (int i = j; i >= 0; i--) {
              if(temperatures[i] < temperatures[j]){
                  list[j].add(i);
              }
          }
      }
      return list;
    }

    public static int LongestPathTo(int day, ArrayList<Integer>[] list, int[] saved){
        int len = 1;
        // If Nothing points to Day
        if(list[day].isEmpty()){
            return len;
        }
        // Already Visited
        if(saved[day] != 0){
            return saved[day];
        }
        // Get Biggest Run
        int biggest = 1;
        for(int i = 0; i < list[day].size(); i++){
            int num = LongestPathTo(list[day].get(i), list, saved);
            if(num > biggest){
                biggest = num;
            }
        }
        saved[day] = biggest+len;
        return biggest+len;
    }
}

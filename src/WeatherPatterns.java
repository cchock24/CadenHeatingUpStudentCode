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
        // TODO: Write your code here!
        int[] runs = new int[temperatures.length];
        int biggest = 0;
        for(int i = 0; i < temperatures.length; i++){
            runs[i] = checkPrevious(temperatures,runs,temperatures[i],i) + 1;
            if(runs[i] > biggest){
                biggest = runs[i];
            }
        }
        return biggest;
    }

    // Take Temperature and Day return day with smaller temperature and biggest run
    public static int checkPrevious(int[] temperatures, int[] runs, int currentTemp, int day){
        int biggest = 0;
        for(int i = 0; i < day; i++){
            if(temperatures[i] < currentTemp && runs[i] > biggest){
                biggest = runs[i];
            }
        }
        return biggest;
    }
}

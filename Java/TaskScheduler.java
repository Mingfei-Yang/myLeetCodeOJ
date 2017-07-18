// 621. Task Scheduler

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskNum = new int [26];    // Number of each task
        
        for(char c : tasks) {
            int index = (int)(c - 'A');
            taskNum[index]++;
        }
        
        Arrays.sort(taskNum);   // Ascending order
        
        int intervals = 0;
        
        // When task list is not empty
        while (taskNum[25] > 0) {
            int i = 0;
            
            while (i <= n) {
                // Task list is empty then break
                if (taskNum[25] == 0) {
                    break;
                }
                
                if (i < 26 && taskNum[25 - i] > 0) {
                    taskNum[25 - i]--;
                }
                
                intervals++;
                i++;
            }
            Arrays.sort(taskNum);   // Re-sort
        }
        
        return intervals;
    }
}

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            courses.get(pair[0]).add(pair[1]);
         }

         int[] visited = new int[numCourses];
         for(int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && hasCycle(i, courses, visited)) {
                return false;
            }
         }

         return true;
    }

    private boolean hasCycle(int index, List<List<Integer>> courses, int[] visited) {
        if (visited[index] == 1) {
            return true;    // visiting. cycle detected
        }
        if (visited[index] == 2) {
            return false;   // visited. no need to check second time
        }

        visited[index] = 1;
        for(int child : courses.get(index)) {
            if (hasCycle(child, courses, visited)) {
                return true;    // return if found cycle 
            }
        }
        visited[index] = 2;     // No need to check children second time from another starting point

        return false;
    }
}
// @lc code=end


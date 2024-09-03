class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> table = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            table.add(new ArrayList<>());
        }

        for (int[] courses: prerequisites) {
            table.get(courses[1]).add(courses[0]);
        }

        int[] visitMarker = new int[numCourses];
        for (int course = 0; course < numCourses; course++) {
            if (visitMarker[course] == 0 && dfs(course, table, visitMarker) == false) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(int course, List<List<Integer>> table, int[] visitMarker) {
        //0 = notvisited, 1 = visiting, 2 = visited
        if (visitMarker[course] == 2) return true;
        if (visitMarker[course] == 1) return false;
        
        visitMarker[course] = 1;
        for (int childCourse : table.get(course)) {
            if (dfs(childCourse, table, visitMarker) == false) return false;
        }

        visitMarker[course] = 2;
        return true;
    }
}
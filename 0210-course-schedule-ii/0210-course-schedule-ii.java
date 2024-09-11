class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjList = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] prereq : prerequisites) {
            int u = prereq[1];
            int v = prereq[0];
            adjList[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }            
        }

        int[] res = new int[numCourses];
        int count = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            res[count] = node;
            count++;
            for (int neighbor : adjList[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        return numCourses == count ? res : new int[0];
    }
}
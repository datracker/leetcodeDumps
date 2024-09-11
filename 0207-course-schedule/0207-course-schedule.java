class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        int nodeVisited = 0; 
        while (!q.isEmpty()) {
            int node = q.poll();
            nodeVisited++;
            for (int neighbor : adjList[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        return nodeVisited == numCourses;
    }
}
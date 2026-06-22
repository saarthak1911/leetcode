import java.util.*;

class Solution {

    // DFS to calculate product from start to target
    private double dfs(int current, int target, List<List<Integer>> graph,
                       double currentProduct, Set<Integer> visited,
                       Map<String, Double> weightMap) {

        // base case: reached target
        if (current == target) return currentProduct;

        double result = 0.0;

        // traverse neighbors
        for (int neighbor : graph.get(current)) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);

                String edgeKey = current + "," + neighbor;
                double edgeWeight = weightMap.get(edgeKey);

                result += dfs(neighbor, target, graph,
                              currentProduct * edgeWeight,
                              visited, weightMap);

                // backtrack is implicit because visited is only added before recursion
            }
        }

        return result;
    }

    public double[] calcEquation(List<List<String>> equations,
                                 double[] values,
                                 List<List<String>> queries) {

        // map variables to integer indices
        Map<String, Integer> variableIndex = new HashMap<>();
        int index = 0;

        for (List<String> eq : equations) {
            String u = eq.get(0);
            String v = eq.get(1);
            if (!variableIndex.containsKey(u)) variableIndex.put(u, index++);
            if (!variableIndex.containsKey(v)) variableIndex.put(v, index++);
        }

        int n = variableIndex.size();

        // adjacency list for graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // build graph connectivity
        for (List<String> eq : equations) {
            int u = variableIndex.get(eq.get(0));
            int v = variableIndex.get(eq.get(1));
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // store edge weights
        Map<String, Double> weightMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            int u = variableIndex.get(equations.get(i).get(0));
            int v = variableIndex.get(equations.get(i).get(1));
            weightMap.put(u + "," + v, values[i]);
            weightMap.put(v + "," + u, 1.0 / values[i]);
        }

        // process queries
        double[] answers = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String startVar = queries.get(i).get(0);
            String endVar = queries.get(i).get(1);

            if (!variableIndex.containsKey(startVar) || !variableIndex.containsKey(endVar)) {
                answers[i] = -1.0;
                continue;
            }

            int start = variableIndex.get(startVar);
            int end = variableIndex.get(endVar);

            Set<Integer> visited = new HashSet<>();
            visited.add(start);

            double value = dfs(start, end, graph, 1.0, visited, weightMap);

            answers[i] = (value == 0.0) ? -1.0 : value;
        }

        return answers;
    }
}
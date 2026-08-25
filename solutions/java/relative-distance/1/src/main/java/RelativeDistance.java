import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class RelativeDistance {

   
    private final Map<String, Set<String>> graph = new HashMap<>();

    public RelativeDistance(Map<String, List<String>> familyTree) {
    for (Map.Entry<String, List<String>> entry : familyTree.entrySet()) {
        String parent = entry.getKey();
        List<String> children = entry.getValue();

        
        for (String child : children) {
            graph.computeIfAbsent(parent, k -> new HashSet<>()).add(child);
            graph.computeIfAbsent(child, k -> new HashSet<>()).add(parent);
        }

        
        for (int i = 0; i < children.size(); i++) {
            for (int j = i + 1; j < children.size(); j++) {
                String sibling1 = children.get(i);
                String sibling2 = children.get(j);
                
                graph.computeIfAbsent(sibling1, k -> new HashSet<>()).add(sibling2);
                graph.computeIfAbsent(sibling2, k -> new HashSet<>()).add(sibling1);
            }
        }
    }
}

    int degreeOfSeparation(String personA, String personB) {
            if (personA.equals(personB)) {
            return 0;
        }

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.add(personA);
        visited.add(personA);

        int distance = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); 
            distance++; 

            for (int i = 0; i < levelSize; i++) {
                String current = queue.poll();
                Set<String> neighbors = graph.getOrDefault(current, new HashSet<>());

                for (String neighbor : neighbors) {                
                    if (neighbor.equals(personB)) {
                        return distance;
                    }
                    
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
       
        return -1;
    }
}
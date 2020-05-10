import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("dat.txt"));
        int cases = sc.nextInt();
        for (int i=0; i< cases;i++){
            int v = sc.nextInt();
            int edges = sc.nextInt();
            int traversals = sc.nextInt();
            Graph g = new Graph(v);
            for (int j=0; j< edges;j++){
                g.addEdge(sc.nextInt(),sc.nextInt());
            }
            boolean[] res = new boolean[v];
            for (int j=0; j< traversals;j++){
                res = g.dfs(sc.nextInt(),res);
            }
            int booleanCounter = 0;
            for (int j=0; j< res.length;j++){
                if (res[j]) booleanCounter++;
            }
            System.out.println(booleanCounter);
        }

    }
}
class Graph {

    Map<Integer, ArrayList<Integer>> edges = new HashMap<>();
    public Graph(int v){
        for (int i =1; i<=v;i++){
            edges.put(i,new ArrayList<Integer>());
        }
    }
    public void addEdge(int a, int b){
        edges.putIfAbsent(a, new ArrayList<Integer>());
        ArrayList<Integer> temp = edges.get(a);
        temp.add(b);
        edges.put(a,temp);
    }
    public boolean[] dfs(int start ,boolean[] visited){
            visited[start-1] = true;
            Iterator<Integer> i = edges.get(start).listIterator();
            while (i.hasNext()){
                int n = i.next();
                if (!visited[n-1]) dfs(n,visited);
            }
            return visited;
    }

}
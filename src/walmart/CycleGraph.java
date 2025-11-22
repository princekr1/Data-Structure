package walmart;

import codeforce.Visits;

import java.util.ArrayList;
import java.util.List;

public class CycleGraph {

    static class Graph{
        int V;
        List<List<Integer>> adj;

        Graph(int v){
            this.V=v;
            adj=new ArrayList<>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u,int v){
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean hasCycle(){
            boolean []visited=new boolean[V];

            for(int i=0;i<V;i++){
                if(!visited[i]){
                    if(dfs(i,visited,-1)){
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(int node, boolean[] visited, int parent) {

            visited[node]=true;
            for(int neighbour : adj.get(node)){
                if(!visited[neighbour]){
                    if(dfs(neighbour,visited,node)){
                        return true;
                    }
                }else if(neighbour!=parent){
                    return true;
                }
            }
            return false;
        }

        public static void main(String[] args) {
            Graph g = new Graph(4);
            g.addEdge(0, 1);
            g.addEdge(1, 2);
            g.addEdge(2, 3);
            g.addEdge(3, 1); // Cycle

            System.out.println("Cycle Detected: " + g.hasCycle());
        }

    }

}

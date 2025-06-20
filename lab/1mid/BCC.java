import java.util.*;
public class BCC {
    int v;
    int time=0;
    List<ArrayList<Integer>> adj;
    Stack<int []> edgestack;
    BCC(int v){
        this.v=v;
        adj= new ArrayList<>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<Integer>());
        edgestack=new Stack<>();
    }
    void addEdge(int u,int v){
        adj.get(v).add(u);
        adj.get(u).add(v);
    }
    void bccFinder(){
        int tm[]= new int[v];
        int low[]= new int[v];
        int parent[]= new int[v];
        boolean ap[]= new boolean[v];
        Arrays.fill(tm,-1);
        Arrays.fill(low,-1);
        Arrays.fill(parent,-1);
        for(int i=0;i<v;i++){
            if(tm[i]==-1){
                bccUtil(i,tm,low,parent,ap);
                if(!edgestack.isEmpty()){
                    System.out.print("Bcc: ");
                    while(!edgestack.isEmpty()){
                        int []edge=edgestack.pop();
                        System.out.print("("+edge[0]+","+edge[1]+") ");
                    }
                    System.out.println();
                }
            }
        }
        System.out.print("AP:");
        for(int i=0;i<v;i++)
            if(ap[i]) 
                System.out.print(i+" ");
    }
    void bccUtil(int u,int[] tm,int[] low,int[] parent,boolean[] ap){
        int children=0;
        low[u]=tm[u]=++time;
        for(int v:adj.get(u)){
            if(tm[v]==-1){
                children++;
                parent[v]=u;
                edgestack.push(new int[]{u,v});
                bccUtil(v, tm, low, parent, ap);
                low[u]=Math.min(low[u],low[v]);
                if((parent[u]==-1 && children>1) || (parent[u]!=-1 && low[v]>=tm[u])){
                    ap[u] = true;
                    if(!edgestack.isEmpty()){
                        System.out.print("Bcc: ");
                        while(!edgestack.isEmpty()){
                            int []edge=edgestack.pop();
                            System.out.print("("+edge[0]+","+edge[1]+") ");
                            if(edge[0]==u && edge[1]==v) break;
                        }
                        System.out.println();
                    }
                }
            }else if(v!=parent[u] && tm[v]<tm[u]){
                    low[u]=Math.min(low[u], tm[v]);
                    edgestack.push(new int[]{u,v});
            }
        }
    }
    public static void main(String[] args) {
        BCC graph = new BCC(7);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);
        graph.addEdge(5, 6);

        graph.bccFinder();
    }
}
import java.io.*;
import java.util.*;
class DisjointSet{
    ArrayList<Integer> rank=new ArrayList<>();
    ArrayList<Integer> parent=new ArrayList<>();
    ArrayList<Integer> size=new ArrayList<>();
    
    DisjointSet(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int findUPar(int node){
        if(parent.get(node)==node){
            return node;
        }
        int upr=findUPar(parent.get(node));
        parent.set(node,upr);
        return parent.get(node);
    }
    public void unionByRank(int u,int v){
        int uu=findUPar(u);
        int uv=findUPar(v);
        
        if(uu==uv) return;
        
        if(rank.get(uu)<rank.get(uv)){
            parent.set(uu,uv);
        }
        else if(rank.get(uu)>rank.get(uv)){
            parent.set(uv,uu);
        }
        else{
            parent.set(uv,uu);
            rank.set(uu,rank.get(uu)+1);
        }
    }
    
    public void unionBySize(int u,int v){
        int uu=findUPar(u);
        int uv=findUPar(v);
        
        if(uu==uv) return;
        
        if(size.get(uu) < size.get(uv)){
            parent.set(uu,uv);
            size.set(uv,size.get(uv)+size.get(uu));
        }
        else{
            parent.set(uv,uu);
            size.set(uu,size.get(uu)+size.get(uv));
        }
        
    }
    
}
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello Mr.Basak Jarvis from this side");
		DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);
        
        
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
            
            
            

        System.out.println("Another one");
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);
        // if 3 and 7 same or not
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionBySize(3, 7);
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
	}
}

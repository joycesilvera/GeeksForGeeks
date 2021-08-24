import java.util.*;

// Node that possess row i, col j and distance from (0,0) position
class Node {
int i,j;
int distance;

Node(int i,int j,int distance) {
this.i=i;
this.j=j;
this.distance=distance;
}
}

public class BFS_Algo
{
static int row[]={-1,0,1,0};
static int col[]={0,1,0,-1};

// testing main method
public static void main(String[] args) {
List<List<Integer>> list=new ArrayList<List<Integer>>();

List<Integer> l1=new ArrayList<Integer>();
l1.add(1);
l1.add(0);
l1.add(0);
List<Integer> l2=new ArrayList<Integer>();
l2.add(1);
l2.add(0);
l2.add(0);
List<Integer> l3=new ArrayList<Integer>();
l3.add(1);
l3.add(9);
l3.add(1);

list.add(l1);
list.add(l2);
list.add(l3);

System.out.println(minimumDistance(list));
}

// method need to be implemented
public static int minimumDistance(List<List<Integer>> area) {
// calculate no.of rows and columns
int R=area.size();
int C=area.get(0).size();

// if value st (0,0) is 0, then return -1
if(area.get(0).get(0)==0)
return -1;

// initialise visited 2D array
boolean [][] visited=new boolean[R][C];

// initialise a queue and add (0,0) into queue
Queue<Node> queue=new LinkedList<Node>();
queue.add(new Node(0,0,0));

// do till queue is empty
while(!queue.isEmpty()) {
// get a value from queue
Node node=queue.poll();

// if value at (i,j) is 9, then return node.distance
if(area.get(node.i).get(node.j)==9)
return node.distance;

// mark (node.i,node,j) as true
visited[node.i][node.j]=true;

// add all valid nodes around (node.i,node.j) into queue
for(int x=0;x<4;x++) {
int new_i=node.i+row[x];
int new_j=node.j+col[x];

if(new_i>=0 && new_i<R && new_j>=0 && new_j<C && !visited[new_i][new_j] && area.get(new_i).get(new_j)!=0) {
queue.add(new Node(new_i,new_j,node.distance+1));
}
}

}
return -1;
}

}

/**
 * a super simple implementatino of union find which works with integers.
 */

 import java.util.*;

 class UnionFind{

    class Node{
        int value;
        Node parent;
        public Node(int value, Node parent){
            this.value = value;
            this.parent = parent;
        }
    }

    HashMap<Integer, Node> sets = new HashMap<Integer, Node>();

    /**
     * makes new set with just one node with the value i
     * @param i
     */
    public void make(int i){
        Node n = new Node(i, null);
        n.parent = n;
        sets.put(i,n);
    }

    /**
     * returns the representative of the set in which i lives
     * @param i
     * @return
     */
    public int find(int i){
        Node n = sets.get(i);
        if(n != null){
            Node curr = n;
            while(curr.parent != curr){
                curr = curr.parent;
            }
            return curr.value;
        }
        return -1;
    }

    /**
     * merges the sets containing i and j. 
     * @param i
     * @param j
     */
    public void union(int i, int j){
        int repI = find(i); // representative of i
        int repJ = find(j); // representative of j
        // get the representative Nodes from the hashmap
        Node nRepI = sets.get(repI);    
        Node nRepJ = sets.get(repJ);
        // make one representative node the representative(parent) of the other representative
        // this has the effect of merging the two sets together
        nRepJ.parent = nRepI;
    }

    public static void main(String [] args){
        UnionFind uf = new UnionFind();
        // let's say we have 10 people : a, b, c, d, e, f, g, h, i, j
        // each of these 10 start in their own set
        for(int i = 'a'; i <= 'j'; i++){
            uf.make(i);
        }
        /**
         * Following are relationships to be added.
            a <-> b  (read : 'a' becomes friends with 'b')
            b <-> d
            c <-> f
            c <-> i
            j <-> e
            g <-> j
         */
        uf.union('a','b');
        uf.union('b', 'd');
        uf.union('c', 'f');
        uf.union('c', 'i');
        uf.union('j', 'e');
        uf.union('g', 'j');

        // is 'a' a friend of 'd'
        System.out.println(uf.find('a') == uf.find('d'));
        // if 'c' a friend of 'j'
        System.out.println(uf.find('c') == uf.find('j'));
    }

 }
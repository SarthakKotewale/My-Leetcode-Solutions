/*class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/

class Solution {
    
    static class Pair {
        Node node;
        int horiz;
    }
    
    static ArrayList<Integer> topView(Node root){
        
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Node> hm = new HashMap<>();
        Queue<Pair> qu = new LinkedList<>();
        
        Pair p = new Pair();
        p.node = root;
        p.horiz = 0;
        
        qu.add(p);
        
        int lv = 0, rv = 0; //lv/rv -> left/right vertical for sorting in HM
        
        while(qu.size() > 0){
            Pair temp = qu.remove();
            
            if(temp.horiz < lv){
                lv = temp.horiz;
            }
            
            if(temp.horiz > rv){
                rv = temp.horiz;
            }
            
            if(hm.containsKey(temp.horiz) == false){
                hm.put(temp.horiz, temp.node);
            }
            
            if(temp.node.left != null){
                Pair lp = new Pair();
                lp.node = temp.node.left;
                lp.horiz = temp.horiz - 1;
                qu.add(lp);
            }
            if(temp.node.right != null){
                Pair rp = new Pair();
                rp.node = temp.node.right;
                rp.horiz = temp.horiz + 1;
                qu.add(rp);
            }
        }
        
        for(int i = lv ; i <= rv; i++){
            list.add(hm.get(i).data);
        }
        
        return list;
        
    }
}
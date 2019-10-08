/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {
    List<Integer> chilCount;
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root==null) return null;
        StringBuilder sb = new StringBuilder();
        Queue<Node> que = new LinkedList<>();
        chilCount = new ArrayList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;++i){
                Node temp = que.poll();
                if(temp==null){
                    sb.append("#,");
                    continue;
                }else{
                    sb.append(temp.val+",");
                   chilCount.add(temp.children.size());
                }
                for(Node x: temp.children) que.add(x);
            }
        }
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        
        if(data==null) return null;
        String[] dese = data.split(",");
        Queue<Node> que = new LinkedList<>();
        
        int i=0;
        int j=0;
        Node root = new Node(Integer.valueOf(dese[i++]));
        que.add(root);
        while(!que.isEmpty()){
            Node temp = que.remove();
            List<Node> ch = new ArrayList<>();
            for(int k=0;k<chilCount.get(j);++k){
                if(!dese[i].equals("#")){
                    Node child = new Node(Integer.valueOf(dese[i++]));
                    ch.add(child);
                    que.add(child);
                }
            }
            temp.children = ch;
            j++;
           
        }
        return root;
        
    }
}
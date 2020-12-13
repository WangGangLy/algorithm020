1.递归练习：括号生成
class Solution {

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        
        recur(0,0,n,"");
        return res;
    }

    private void recur(int leftLevel,int rightLevel,int max,String s){
        if (max == leftLevel && max == rightLevel) {
            res.add(s);
            return;
        }

        if (leftLevel < max){
           String s1 = s + "(";
           recur(leftLevel + 1,rightLevel,max,s1);
        }

        if (rightLevel < leftLevel){
          String s2 = s + ")";
          recur(leftLevel,rightLevel+1,max,s2);
        }

    }
}

2.二叉树的层序遍历：
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i = 0;i < size;++i ) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null){
                    queue.offer(node.left);
                }

                 if (node.right != null){
                    queue.offer(node.right);
                }
            }

            res.add(list);
        }

        
        return res;


        
    }
}
3.数中每行的最大值：
class Solution {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = 0;
            for(int i = 0;i < size ;++i){
                TreeNode node = queue.poll();
                max =  i == 0 ? node.val : Math.max(max,node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            res.add(max);
        } 

        return res;
    }
}
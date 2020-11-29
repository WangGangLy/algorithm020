二叉树的中序遍历
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
         inOrder(root,result);
        
        return result;
    }

    private void inOrder(TreeNode root,List result){
        if (root == null) {
            return;
        }
        inOrder(root.left,result);
        result.add(root.val);
        inOrder(root.right,result);
    }
}

二叉树的前序遍历
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        preorder(root,res);
        return res;
    }

    private void preorder(TreeNode node,List res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        preorder(node.left,res);
        preorder(node.right,res);
        
    }
}
N叉树的后序遍历
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList();
        postorderTree(root,result);
        return result;

    }
    private void postorderTree(Node root,List result){
        if (root == null) {
            return;
        }

        for (int i = 0;i< root.children.size();++i) {
            postorderTree (root.children.get(i),result);
        }
        result.add(root.val);
    }
}
N叉树的层序遍历
class Solution {

    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> levelOrder(Node root) {
        
        int level = 0;

        levelOrderTree(root,level);
        return res;

    }

    private void levelOrderTree (Node root,int level) {
        if (root == null) {
            return;
        }

        if (res.size() <= level) {
            res.add(new ArrayList());
        }

        res.get(level).add(root.val);

        for (int i = 0; i < root.children.size(); ++i) {
            levelOrderTree (root.children.get(i),level + 1);
        }


    }
}

有效的字母异位词

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] si = new int[26];
        int[] ti = new int[26];
        for (int i = 0; i< s.length();++i){
            int st = s.charAt(i) - 'a';
            si[st]++;
        }

        for (int j = 0; j < t.length();++j){
            int tt = t.charAt(j) - 'a';
            ti[tt]++;
        }

       return Arrays.equals(si,ti);
    }
}
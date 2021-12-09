/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int depth(TreeNode* root) {
        if (root == NULL) {
            return 0;
        }
        return 1 + max(depth(root->left), depth(root->right));
    }
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        int d = depth(root);
        vector<vector<int>> ans(d);
        if (!root) {
            return ans;
        }
        queue<TreeNode*> q;
        q.push(root);
        int i, size;
        TreeNode* node;
        while (!q.empty()) {
            size = q.size();
            vector<int> tempAns;

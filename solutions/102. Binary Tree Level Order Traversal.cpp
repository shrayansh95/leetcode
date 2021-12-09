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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        if (!root) {
            return ans;
        }
        queue<TreeNode*> q;
        q.push(root);
        int size, i;
        TreeNode* node;
        while (!q.empty()) {
            size = q.size();
            vector<int> tempAns;
            for (i = 0; i < size; i++) {
                node = q.front();
                q.pop();
                tempAns.push_back(node->val);
                if (node->left) {
                    q.push(node->left);
                }

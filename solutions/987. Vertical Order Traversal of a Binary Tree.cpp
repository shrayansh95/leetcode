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
    void preorder(TreeNode* root, map<int, map<int, multiset<int>>>& mp, int x, int y) {
        if (!root) {
            return;
        }
        mp[x][y].insert(root->val);
        preorder(root->left, mp, x - 1, y + 1);
        preorder(root->right, mp, x + 1, y + 1);
    }
    
    vector<vector<int>> verticalTraversal(TreeNode* root) {
        vector<vector<int>> ans;
        if (!root) {
            return ans;
        }
        map<int, map<int, multiset<int>>> mp;
        preorder(root, mp, 0, 0);
        for (auto it : mp) {
            vector<int> temp;

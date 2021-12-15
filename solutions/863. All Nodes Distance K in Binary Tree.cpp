/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        unordered_map<TreeNode*, TreeNode*> mp;
        queue<TreeNode*> q;
        q.push(root);
        set<TreeNode*> visited;
        TreeNode* temp;
        while (!q.empty()) {
            temp = q.front();
            q.pop();
            if (temp->left) {
                mp[temp->left] = temp;
                q.push(temp->left);
            }
            if (temp->right) {
                mp[temp->right] = temp;
                q.push(temp->right);
            }
        }
        q.push(target);
        int dis = 0;
        vector<int> ans;
        int size = 0;
        while (!q.empty()) {
            size = q.size();
            if (dis++ == k) {
                break;
            }

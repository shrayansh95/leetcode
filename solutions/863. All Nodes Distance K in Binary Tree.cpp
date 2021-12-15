class Solution {
public:
    // for nodes below target 
    void subtreeNodes(TreeNode* root, int k, vector<int>& ans) {
        if (!root or k < 0) {
            return;
        } else if (k == 0) {
            ans.push_back(root->val);
            return;
        }
        subtreeNodes(root->left, k - 1, ans);
        subtreeNodes(root->right, k - 1, ans);
    }
    
    int nodesAbove(TreeNode* root, TreeNode* target, int k, vector<int>& ans) {
        if (!root) {
            return -1;
        }
        if (root == target) {
            subtreeNodes(root, k, ans);
            return 0;
        }
        int dl = nodesAbove(root->left, target, k, ans);
        if (dl != -1) {
            if (dl + 1 == k) {
                ans.push_back(root->val);
            } else {
                subtreeNodes(root->right, k - dl - 2, ans);
            }
            return 1 + dl;
        }
        int dr = nodesAbove(root->right, target, k, ans);
        if (dr != -1) {
            if (dr + 1 == k) {
                ans.push_back(root->val);
            } else {
                subtreeNodes(root->left, k - dr - 2, ans);
            }
            return 1 + dr;
        }
        return -1;
    }
    
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        vector<int> ans;
        nodesAbove(root, target, k, ans);
        return ans;
    }
};

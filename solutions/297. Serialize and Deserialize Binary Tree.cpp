 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:
​
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if (!root) {
            return "";
        }
        queue<TreeNode*> q;
        string ans = "";
        q.push(root);
        TreeNode* temp;
        while (!q.empty()) {
            temp = q.front();
            q.pop();
            if (temp == NULL) {
                ans.append("#,");
            } else {
                ans.append(to_string(temp->val) + ",");
            }
            if (temp != NULL) {
                q.push(temp->left);
                q.push(temp->right);
            }
        }
        return ans;
    }
​
    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        if (data.length() == 0) {
            return NULL;
        }
        stringstream s(data);
        string str;
        getline(s, str, ',');
        TreeNode* root = new TreeNode(stoi(str));
        queue<TreeNode*> q;
        q.push(root);
        TreeNode* temp, *leftNode, *RightNode;
        while (!q.empty()) {
            temp = q.front();
            q.pop();
            getline(s, str, ',');
            if (str == "#") {
                temp->left = NULL;
            } else {
                leftNode = new TreeNode(stoi(str));
                temp->left = leftNode;
                q.push(leftNode);
            }
            getline(s, str, ',');
            if (str == "#") {
                temp->right = NULL;
            } else {
                RightNode = new TreeNode(stoi(str));
                temp->right = RightNode;
                q.push(RightNode);
            }
        }
        return root;
    }
};
​
// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));

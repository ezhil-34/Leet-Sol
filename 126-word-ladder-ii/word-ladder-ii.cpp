class Solution {
public:
   vector<vector<string>> res;
    vector<string> te;
    unordered_map<string, int> mp;
    string b;

    void dfs(string s) {  
        te.push_back(s);
        if (s == b) {
            vector<string> x = te;
            reverse(x.begin(), x.end());
            res.push_back(x);
            te.pop_back();
            return;
        }
        int cur = mp[s];
        for (int i = 0; i < s.size(); i++) {
            char c = s[i];
            for (char cc = 'a'; cc <= 'z'; cc++) {
                s[i] = cc;
                if (mp.count(s) && mp[s] == cur - 1)
                    dfs(s);
            }
            s[i] = c;
        }
        te.pop_back();
        return;
    }

    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string> &wordList) {
        unordered_set<string> dict(wordList.begin(), wordList.end());
        if (dict.find(endWord) == dict.end()) return {}; // If endWord is not in wordList, return empty result

        b = beginWord;
        queue<string> q;
        int k = beginWord.size();
        q.push(beginWord);
        mp[beginWord] = 0;
        bool found = false;

        while (!q.empty() && !found) {  // Step 1: BFS to find the shortest path
            int n = q.size();
            unordered_set<string> toErase;
            while (n--) {
                string t = q.front();
                q.pop();
                int x = mp[t] + 1;
                for (int i = 0; i < k; i++) {
                    string temp = t;
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        temp[i] = ch;
                        if (dict.count(temp) && !mp.count(temp)) {
                            mp[temp] = x;
                            q.push(temp);
                            toErase.insert(temp);
                            if (temp == endWord) found = true;
                        }
                    }
                }
            }
            for (const string &word : toErase) {
                dict.erase(word);
            }
        }

        if (mp.count(endWord)) {
            dfs(endWord);  // Step 2: Backtrack to construct paths
        }
        
        return res;
    }
};
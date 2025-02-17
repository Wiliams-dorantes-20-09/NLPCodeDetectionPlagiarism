#include <bits/stdc++.h>

using namespace std;

pair< vector<int>, string > an[2][256];

int getval(const vector<int> &a){
    int sum = 0;
    int cur = 1;
    for(auto u: a){
        sum += u * cur;
        cur *= 2;
    }
    return sum;
}

bool cmp(const string &lhs, const string &rhs){
    if(lhs.size() != rhs.size()) return lhs.size() < rhs.size();
    return lhs < rhs;
}

main()
{
    ios_base::sync_with_stdio(0);
    //freopen("output.txt", "w", stdout);
    vector<vector<int>> tmp;
    tmp.push_back({0, 0, 0, 0, 1, 1, 1, 1});
    tmp.push_back({0, 0, 1, 1, 0, 0, 1, 1});
    tmp.push_back({0, 1, 0, 1, 0, 1, 0, 1});
    for(int i = 0; i < 3; i++){
        string s = (i == 0) ? "x" : (i == 1) ? "y" : "z";
        for(int j = 0; j < 2; j++) an[j][getval(tmp[i])] = make_pair(tmp[i], s);
    }
    while(true){
        bool ok = false;
        for(int i = 0; i < 256; i++){
            for(int j = 0; j < 2; j++){
                if(an[j][i].first.empty()) continue;
                vector<int> b;
                for(auto u: an[j][i].first) b.push_back(!u);
                int x = getval(b);
                string str = an[j][i].second;
                if(str.size() > 1) str = "!(" + str + ")";
                else str = "!" + str;
                for(int k = 0; k < 2; k++){
                    if(an[k][x].first.empty() || cmp(str, an[k][x].second)){
                        an[k][x] = make_pair(b, str);
                        ok = true;
                    }
                }
            }
        }
        for(int i = 0; i < 256; i++){
            for(int j = 0; j < 2; j++){
                if(an[j][i].first.empty()) continue;
                for(int k = 0; k < 256; k++){
                    for(int t = 0; t < 2; t++){
                        if(an[t][k].first.empty()) continue;
                        vector<int> b = an[j][i].first;
                        for(int TO = 0; TO < 8; TO++) b[TO] &= an[t][k].first[TO];
                        int x = getval(b);
                        string t1 = an[j][i].second, t2 = an[t][k].second;
                        bool ok = false;
                        for(auto u: t1) if(u == '|') ok = true;
                        if(ok) t1 = "(" + t1 + ")";
                        ok = false;
                        for(auto u: t2) if(u == '|') ok = true;
                        if(ok) t2 = "(" + t2 + ")";
                        string r = min(t1, t2) + "&" + max(t1, t2);
                        if(an[1][x].first.empty() || cmp(r, an[1][x].second)){
                            an[1][x] = make_pair(b, r);
                            ok = true;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < 256; i++){
            for(int j = 0; j < 2; j++){
                if(an[j][i].first.empty()) continue;
                for(int k = 0; k < 256; k++){
                    for(int t = 0; t < 2; t++){
                        if(an[t][k].first.empty()) continue;
                        vector<int> b = an[j][i].first;
                        for(int TO = 0; TO < 8; TO++) b[TO] |= an[t][k].first[TO];
                        int x = getval(b);
                        string t1 = an[j][i].second, t2 = an[t][k].second;
                        string r = min(t1, t2) + "|" + max(t1, t2);
                        if(an[0][x].first.empty() || cmp(r, an[0][x].second)){
                            an[0][x] = make_pair(b, r);
                            ok = true;
                        }
                    }
                }
            }
        }
        if(!ok) break;
    }
    int n;
    cin >> n;
    for(int i = 0; i < n; i++){
        string s;
        cin >> s;
        vector<int> b;
        for(auto u: s) b.push_back(u - '0');
        int x = getval(b);
        if(cmp(an[0][x].second, an[1][x].second)) cout << an[0][x].second;
        else cout << an[1][x].second;
        cout << "\n";
    }
}

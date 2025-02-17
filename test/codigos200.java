#include <bits/stdc++.h>

#define F first
#define S second
#define pb push_back
#define ll long long
#define FILE ""

using namespace std;

const int mod = 1e9 + 7;
const ll inf = 1e18;

vector <set <int> > friends;
vector <int> online,cnt;

void add(int x,int y) {
    if (friends[x].size() > friends[y].size()) swap(x,y);
    friends[x].insert(y);
    cnt[y] += online[x];
}

int main() {
    ios_base::sync_with_stdio(0);
   // freopen("input.txt","r",stdin);
   // freopen("output.txt","w",stdout);
    cin.tie(0);
    cout.tie(0);
    int n,m,q;
    cin >> n >> m >> q;
    online.resize(n+1);
    friends.resize(n+1);
    cnt.resize(n+1);
    int o;
    cin >> o;
    for (int i=0; i<o; i++) {
        int x;
        cin >> x;
        online[x] = 1;
    }
    for (int i=0; i<m; i++) {
        int x,y;
        cin >> x >> y;
        add(x,y);
    }
    while (q--) {
        char c;
        cin >> c;
        if (c == 'O') {
            int x;
            cin >> x;
            online[x] = 1;
            for (auto tmp : friends[x]){
                cnt[tmp]++;
            }
        }
        if (c == 'F') {
            int x;
            cin >> x;
            online[x] = 0;
            for (auto tmp : friends[x]){
                cnt[tmp]--;
            }
        }
        if (c == 'A') {
            int x,y;
            cin >> x >> y;
            add(x,y);
        }
        if (c == 'D') {
            int x,y;
            cin >> x >> y;
            if (friends[x].find(y) == friends[x].end()) swap(x,y);
            friends[x].erase(y);
            cnt[y] -= online[x];
        }
        if (c == 'C') {
            int x;
            cin >> x;
            int ans = cnt[x];
            for (auto tmp : friends[x]){
                ans += online[tmp];
            }
            cout << ans << endl;
        }
    }
}
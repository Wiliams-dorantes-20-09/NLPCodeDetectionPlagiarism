#include <bits/stdc++.h>
//#include <ext/rope>

#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx")

#define endl "\n"
#define fi first
#define se second
#define pb push_back
#define last(s) (s)[(int)((s).size())-1]
#define prelast(s) (s)[(int)((s).size())-2]
#define all(a) (a).begin(),(a).end()
#define rall(a) (a).rbegin(),(a).rend()
#define elif else if
#define left asdasd
#define next zaza
//#define prev azaz
#define cclear cout<<flush;
#define x0 kerker
//#define time chas
#define y0 lolik
#define x1 ashkjl
#define y1 fakakaka
#define y2 ololol
#define x2 jejejejej
#define kchay ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
#define files freopen("input.txt", "r", stdin);freopen("output.txt", "w", stdout);
#define ref svyazi
#define int long long
#define ii pair<int, int>
#define llong long long
#define ld long double
#define list spisok
#define tm kozerog
const ld eps = 1e-7;
const ld Pi = acos(-1);
const int md = 1e9+7;
const int fakmd = 998244353;

using namespace std;
//using namespace __gnu_cxx;


/*
2 3 5


*/

bool notPrime[1000100];
int num[1000100], n, a[1000100];
vector<int> primes, g[1000100], vert[100100];
int used[1000100], ans;

int dfs(int x, int& us, int& prm, int p = -1) {
    used[x] = us;
    // cout << "in " << x << " " << prm << endl; 
    int mx1 = 0, mx2 = 0;
    for(auto& i : g[x]) {
        if(i == p || a[i] % prm) continue;
        int f = dfs(i, us, prm, x);
        if(mx1 <= f)mx2 = mx1, mx1 = f;
            elif(mx2 <= f)mx2 = f;
    }
    // cout << "out ";
    // cout << x << " == " << a[x] << " " << prm << " " << mx1 << " " << mx2 << endl; 
    ans = max(ans, mx1 + mx2 + 1);
    return mx1 + 1;
}

int32_t main() {
    kchay;
    
    for(int i = 2; i <= 2e5; i++) {
        if(!notPrime[i]) {
            primes.pb(i);
            num[i] = primes.size() - 1;
            for(int j = 2 * i; j <= 2e5; j += i) {
                notPrime[j] = true;
            }
        }
    }
    
    
    cin >> n;
    
    for(int i = 1; i <= n; i++) {
        cin >> a[i];
        int x = a[i];
        for(int j = 2; j * j <= x; j++) {
            if(x % j == 0) {
                while(x % j == 0) {
                    x /= j;
                }
                vert[num[j]].pb(i);
            }
        }
        if(x > 1) {
            vert[num[x]].pb(i);
        }
    }
    
    for(int i = 1; i < n; i++) {
        int x, y;
        cin >> x >> y;
        g[x].pb(y);
        g[y].pb(x);
    }
    
    for(int i = 1; i <= primes.size(); i++) {
        for(auto& v : vert[i - 1]) {
            if(used[v] == i)continue;
            dfs(v, i, primes[i - 1]);
        }
    }
    
    cout << ans;
    
    
    return 0;
}
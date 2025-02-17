#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,sse3,sse4,popcnt,abm,mmx")
#include <bits/stdc++.h>
#define pb push_back
#define F first
#define S second
#define ins insert
#define mp make_pair
#define mt make_tuple
#define fo(i, n1, n, x) for(int i = n1; i <= n; i += x)
#define foo(i, n, n1, x) for(int i = n; i >= n1; i -= x)
#define bit __builtin_popcount
#define md (l + ((r - l) / 2))
#define all(x) x.begin(),x.end()
#define ll long long
#define ld long double
#define eb emplace_back
#define ub upper_bound
#define lb lower_bound
#define ios ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0)
#define file(s) if (fopen(s".in", "r")) freopen(s".in", "r", stdin), freopen(s".out", "w", stdout)

using namespace std;

const int N = 1e4 + 11, mod = 1e9 + 7, mod2 = 998244353;
const int MAX = 6e5 + 11;
const int INF1 = 2e9 + 11;
const ll INF2 = 2e18 + 11;
const int base = 500;
const int P = 31;
const int dx[] = {1, -1, 0, 0, 1, 1, -1, -1};
const int dy[] = {0, 0, 1, -1, 1, -1, 1, -1};
const double EPS = 1e-4;
const double PI = acos(-1.0);

template<typename T1, typename T2> inline void chmin(T1 &a, T2 b) { if (a > b) a = b; }
template<typename T1, typename T2> inline void chmax(T1 &a, T2 b) { if (a < b) a = b; }

mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());

int te, n;
string s;
main() {
    file("console");
    ios;
    cin >> te;
    while (te--) {
        cin >> n >> s;
        int l = 0, r = 0;
        s = '#' + s;
        fo(i, 1, n, 1) if (s[i] == '<') ++l; else break;
        foo(i, n, 1, 1) if (s[i] == '>') ++r; else break;
        cout << min(l, r) << "\n";
    }
    return 0;
}
/**

*/

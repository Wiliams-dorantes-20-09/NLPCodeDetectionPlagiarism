#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>

#define x first
#define y second
#define ndl '\n'
#define mp make_pair
#define mt make_tuple
#define pb push_back
#define up_b upper_bound
#define low_b lower_bound
#define sz(x) (int)x.size()
#define bit __builtin_popcount
#define all(x) x.begin(), x.end()
#define rall(x) x.rbegin(), x.rend()

using namespace std;
using namespace __gnu_pbds;

template<typename T> using indexed_set = tree <T, null_type, less<T>, rb_tree_tag, tree_order_statistics_node_update>;
mt19937_64 rng(chrono::steady_clock::now().time_since_epoch().count());

typedef long long ll;
typedef long double ld;
typedef unsigned int uint;
typedef unsigned long long ull;
typedef pair<ll, ll> pll;
typedef pair<int, int> pii;
typedef pair<int, ll> pil;
typedef pair<ll, int> pli;
typedef pair<int, ull> piu;
typedef vector<vector<int>> matrix;

const ll INF = 1e18 + 123;
const ld EPS = 1e-9;
const int inf = 1e9 + 123;
const int MOD = 1e9 + 7;
const int N = 4e5 + 123;
const int M = 1e6 + 123;
const double pi = acos(-1.0);
const int dx[] = {0, 0, 1, -1};
const int dy[] = {1, -1, 0, 0};

int a[N];

vector<int> ind[N];

void solve(){
    int n, k;
    cin >> n >> k;
    for (int i = 1; i <= n; i++){
        cin >> a[i];
    }
    indexed_set<pii> s, q;
    for (int i = 1; i <= n/2; i++){
        ind[a[i]+a[n-i+1]].pb(i);
        s.insert({min(a[i], a[n-i+1]), i});
        q.insert({max(a[i], a[n-i+1]), i});
    }
    int mn = inf;
    for (int x = 2; x <= k+k; x++){
        for (int i : ind[x]){
            s.erase({min(a[i], a[n-i+1]), i});
            q.erase({max(a[i], a[n-i+1]), i});
        }
        int j = s.order_of_key(mp(x, 0));
        int cur = j + (sz(s)-j)*2 + q.order_of_key(mp(x-k, 0));
       // cout <<x<< " "<< cur << endl;
        mn = min(mn, cur);
        for (int i : ind[x]){
            s.insert({min(a[i], a[n-i+1]), i});
            q.insert({max(a[i], a[n-i+1]), i});
        }
        ind[x].clear();
    }
    cout << mn << ndl;
}

int main(){
    #ifdef KAZAKH
        freopen("input.txt", "r", stdin);
    #endif
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int t = 1;
    cin >> t;
    for (int i = 1; i <= t; i++){
        //cout << "case #" << i << ": ";
        solve();
    }
    return 0;
}

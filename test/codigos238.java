#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
#include <ext/pb_ds/priority_queue.hpp>
//#pragma GCC optimize("O3")
//#pragma GCC target("sse4")
//#pragma GCC target("avx2")

#define deb(x) cout << #x << " = " << x << "\n"
#define all(x) (x).begin(), (x).end()
#define len(x) (ll) x.size()
#define lsb(x) (x) & -(x)
#define l(x) (x << 1) + 1
#define r(x) (x << 1) + 2

#define xx first
#define yy second
#define mp make_pair
#define pb push_back
#define lb lower_bound
#define ub upper_bound

using namespace std;
using namespace __gnu_pbds;
typedef long long ll;
typedef long double ld;
typedef pair <ll, ll> pii;
typedef pair <ld, ld> pld;
typedef pair <ll, ll> pll;

template <class T1, class T2 = less <T1>> using pb_heap = __gnu_pbds::priority_queue <T1, T2, binary_heap_tag>;
template <class T1, class T2 = null_type, class T3 = less <T1>> using pb_map = tree <T1, T2, T3, rb_tree_tag, tree_order_statistics_node_update>;
template <class T1, class T2 = null_type, class T3 = hash <T1>> using pb_umap = gp_hash_table <T1, T2, T3>;
template <class T1, class T2, class T3 = hash <T1>> using umap = unordered_map <T1, T2, T3>;
template <class T> using uset = unordered_set <T>;
template <class T> using vec = vector <T>;

const ll infll = numeric_limits <ll>::max() >> 1;
const ll inf = numeric_limits <ll>::max() >> 1;
const ll N = 2e5 + 1;
ll n, q;

ll arr[N];
ll pre[N];

void input() {
    cin >> n >> q;
    for(ll i = 1; i <= n; ++i) {
        cin >> arr[i];
        pre[i] = pre[i - 1] + arr[i];
    }
}

ll ind(ll x) {
    return lb(pre, pre + n + 1, x) - pre;
}

void solve() {
    for(ll i = 0; i < q; ++i) {
        ll x; cin >> x;
        cout << ind(x) << " " << x - pre[ind(x) - 1] << "\n";
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);
    input();
    solve();
}

#include <iostream>
#include <cmath>
#include <cstdio>
#include <cstring>
#include <cstdlib>
#include <cassert>
#include <ctime>
#include <sstream>
#include <algorithm>
#include <functional>
#include <numeric>
#include <string>
#include <vector>
#include <queue>
#include <stack>
#include <map>
#include <set>

using namespace std;

#define f first
#define s second
#define pb push_back
#define mp make_pair
#define ll long long
#define pii pair < int, int >
#define pll pair < long long, long long>
#define ull unsigned long long
#define y1 stupid_cmath
#define left stupid_left
#define right stupid_right
#define vi vector <int>
#define sz(a) (int)a.size()
#define forit(it, s) for(__typeof(s.begin()) it = s.begin(); it != s.end(); it++)
#define all(a) a.begin(), a.end()
#define sqr(x) ((x) * (x))

const int inf = (int)1e9;
const int mod = inf + 7;
const double eps = 1e-9;
const double pi = acos(-1.0);

int t;

int f(ll a, ll b) {
    ll d = abs(a - b);
    for (int i = 0;; i++) {
        ll s = i * 1ll * (i + 1) / 2;
        if (d % 2 == s % 2 and s >= d) return i;
    }
    return -1;
}

void solve() {
    int a, b;
    scanf("%d%d\n", &a, &b);
    printf("%d\n", f(a, b));
}

int main(){

    scanf("%d", &t);
    while (t--) solve();

    return 0;
}

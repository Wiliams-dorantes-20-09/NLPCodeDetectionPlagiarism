//In The Name of Allah
#include <bits/stdc++.h>

using namespace std;

typedef long long            ll;
typedef long double          ld;
typedef string               str;
typedef pair < ll , ll >     pll;

#define X               first
#define Y               second
#define pb              push_back
#define sep             ' '
#define endl            '\n'
#define fast_io         ios::sync_with_stdio(false);cin.tie(0);cout.tie(0);
#define dbl_io(x)       cout << fixed << setprecision(x);

const int N = 1e5 + 10;
const ll mod = 1e9 + 7;
const ll inf = 1e18 + 10;

ll A[N], B[N], L[N], a, b;

double f(ll i, ll j){
    double res = L[i];
    res += sqrt(1.0 * (a * a + A[j] * A[j]));
    res += sqrt(1.0 * ((a - b) * (a - b) + (A[j] - B[i]) * (A[j] - B[i])));
    return res;
}

int main(){
    fast_io
    //dbl_io(10);
    ll n, m;
    cin >> n >> m >> a >> b;
    for (ll i = 0; i < n; i ++)
        cin >> A[i];
    for (ll i = 0; i < m; i ++)
        cin >> B[i];
    for (ll i = 0; i < m; i ++)
        cin >> L[i];
    sort(A, A + n);
    double Min = inf;
    ll x = -1, y = -1;
    for (ll i = 0; i < m; i ++){
        ll l = 0, r = n;
        while (r - l > 6){
            ll m1 = (l + l + r) / 3, m2 = (l + r + r) / 3;
            if (f(i, m1) < f(i, m2))
                r = m2;
            else
                l = m1;
        }
        double w = inf, ind = -1;
        for (ll j = max(0LL, l - 20); j < min(n, l + 20); j ++)
            if (f(i, j) < w)
                w = f(i, j), ind = j;
        if (w < Min){
            x = i;
            y = ind;
            Min = w;
        }
    }
    cout << y + 1 << ' ' << x + 1;
    return 0;
}

#include <stdio.h>
#include <bits/stdc++.h>

#define uint unsigned int
#define ll long long
#define ull unsigned long long
#define ld long double
#define rep(i, l, r) for (int i = l; i < r; i++)
#define repb(i, r, l) for (int i = r; i > l; i--)
#define sz(a) (int)a.size()
#define fi first
#define se second
#define mp(a, b) make_pair(a, b)

using namespace std;

const int N = 100000;
const int inf = (int)1e9 + 1;
const ll big = (ll)1e18 + 1;
const int P = 31;
const int MOD = (int)1e9 + 7;
const int MOD1 = (int)1e9 + 9;
const int MAX_INT = (1LL << 31) - 1;
const ld eps = 1e-6;
const ld pi = atan2(0, -1);

int main()
{
    //freopen("a.in", "r", stdin);
    //freopen("a.out", "w", stdout);
    //ios_base::sync_with_stdio(0);
    //cin.tie(0);
    //cout.precision(20);
    ll n, k;
    cin >> n >> k;
    k = (k + 1) / 2;
    for (ll i = 0; i < k; i++)
    {
        if (n == 1)
            break;
        ll cnt = n;
        for (ll i = 2; i * i <= n; i++)
        if (n % i == 0)
        {
            cnt -= cnt / i;
            while (n % i == 0)
                n /= i;
        }
        if (n > 1)
            cnt -= cnt / n;
        n = cnt;
    }
    cout << n % MOD << endl;
    return 0;
}

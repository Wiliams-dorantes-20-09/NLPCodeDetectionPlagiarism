#include <bits/stdc++.h>
using namespace std;

#define all(x) begin(x), end(x)
#define sz(x) (ll)(x).size()

using ll = long long;
using ld = long double;

ll gcd(ll a, ll b) { return b == 0 ? a : gcd(b, a % b);}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    ll t;
    cin >> t;
    for (ll i = 0; i < t; i++) {
        ll a, m;
        cin >> a >> m;
        ll g = gcd(a, m);
        ll l = a;
        ll r = a + m;
        ll remain = m / g;
        vector<ll> ps;
        for (ll d = 2; d*d <= remain; d++) {
            if (remain % d == 0) {
                ps.push_back(d);
                while (remain % d == 0) remain /= d;
            }
        }
        if (remain > 1) ps.push_back(remain);
        auto count = [&](ll x){
            ll res = 0;
            for (ll i = 0; i < (1ll << sz(ps)); i++) {
                ll mul = g;
                ll sign = 1;
                for (ll j = 0; j < sz(ps); j++) {
                    if ((i & (1ll << j)) != 0) {
                        sign *= -1;
                        mul *= ps[j];
                    }
                }
                res += sign * (x / mul);
            }
            return res;
        };
        cout << count(r - 1) - count(l - 1) << endl;
    }
}

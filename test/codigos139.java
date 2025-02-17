#include <bits/stdc++.h>
#define base 1000000007LL
#define ll long long
#define ld double
#define X first
#define Y second
#define pb push_back
#define EPS 1e-9
#define all(a) (a).begin(), (a).end()
#define sz(a) int((a).size())
#define ms(s, n) memset(s, n, sizeof(s))
#define FOR(i,a,b) for (int i = (a); i <= (b); i++)
#define FORE(i,a,b) for (int i = (a); i >= (b); i--)
#define FORALL(it, a) for (__typeof((a).begin()) it = (a).begin(); it != (a).end(); it++)
using namespace std;
typedef pair<int, int> II;
typedef pair<II, int> III;

ll D, a[100010], b[100010];
int n;
multiset<ll> s;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(NULL);
    //freopen("inp.txt", "r", stdin);
    //freopen("out.txt", "w", stdout);
    cin >> n >> D;
    FOR(i,1,n) cin >> a[i];
    FOR(i,1,n) {
        b[i] = b[i-1] + a[i];
        if (b[i] > D) {
            cout << -1;
            return 0;
        }
    }
    FOR(i,1,n) s.insert(b[i]);
    ll now = 0, res = 0;
    FOR(i,1,n) {
        if (a[i] == 0) {
            if (now < 0) {
                res++;
                ll Max = *s.rbegin() - b[i-1];
                ll top = D - Max;
                if (top < 0 || top > D) {
                    cout << -1;
                    return 0;
                }
                now = top;
            }
        }
        else {
            now += a[i];
            if (now > D) {
                cout << -1;
                return 0;
            }
        }
        s.erase(s.lower_bound(b[i]));
    }
    cout << res;
    return 0;
}

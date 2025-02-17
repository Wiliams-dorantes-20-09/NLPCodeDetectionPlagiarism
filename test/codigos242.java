#include <bits/stdc++.h>
#define ll long long
#define ull unsigned ll
#define ld long double
#define F first
#define S second
#define mp make_pair
#define pb push_back

using namespace std;

const int MIN = 1e3 + 2;
const int MXN = 1e6 + 3;
const int INF = 1e9 + 7;
const double EPS = 1e-9;
const ll LINF = 1e18 + 15;

int n;
ll p[MXN];
int a[MXN], b[MXN];
int m;
int c[MXN];
set <pair <ll, ll> > v[4];
map <ll, bool> z;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    cin >> n;
    for (int i = 1; i <= n; ++i){
        cin >> p[i];
    }
    for (int i = 1; i <= n; ++i){
        cin >> a[i];
        v[a[i]].insert(mp (p[i], i));
    }
    for (int i = 1; i <= n; ++i){
        cin >> b[i];
        v[b[i]].insert(mp (p[i], i));
    }
    cin >> m;
    for (int i = 1; i <= m; ++i){
        cin >> c[i];
        bool ok = 0;
        for (auto it : v[c[i]]){
            cout << it.F << " ";
            v[1].erase(it);
            v[2].erase(it);
            v[3].erase(it);
            ok = 1;
            break;
        }
        if (!ok){
            cout << "-1 ";
        }
    }
    return 0;
}

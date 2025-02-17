//#pragma comment(linker,"/STACK:100000000000,100000000000")

#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <string>
#include <cstring>
#include <vector>
#include <cmath>
#include <map>
#include <stack>
#include <set>
#include <iomanip>
#include <queue>
#include <map>
#include <functional>
#include <list>
#include <sstream>
#include <ctime>
#include <climits>
#include <bitset>
#include <list>
#include <cassert>
#include <complex>

using namespace std;

/* Constants begin */
const long long inf = 2e18 + 7;
const long long mod = 1e9 + 7;
const double eps = 1e-9;
const double PI = 2*acos(0.0);
const double E = 2.71828;
/* Constants end */

/* Defines begin */
#define pb push_back
#define mp make_pair
#define ll long long
#define double long double
#define F first
#define S second
#define all(a) (a).begin(),(a).end()
#define forn(i, n) for (int (i)=0; (i)<(n); ++(i))
#define random (rand()<<16|rand())
#define sqr(x) (x)*(x)
#define base complex<double>
/* Defines end */

int n;
string s[55];
ll mask[1 << 20];
double f[1 << 20];

int main(void) {
    #ifdef nobik
        freopen("input.txt", "rt", stdin);
        freopen("output.txt", "wt", stdout);
    #endif
    int n;
    cin >> n;
    for(int i = 1; i <= n; ++i) {
        cin >> s[i];
    }
    int m = s[1].size();
    for(int i = 1; i <= n; ++i) {
        for(int j = i + 1; j <= n; ++j) {
            int same = 0;
            for(int it = 0; it < m; ++it) {
                if(s[i][it] == s[j][it]) {
                    same |= (1 << it);
                }
            }
            mask[same] |= (1LL << i) | (1LL << j);
        }
    }
    for(int i = (1 << m) - 1; i >= 0; --i) {
        for(int j = 0; j < m; ++j) {
            if(i & (1 << j)) {
                mask[i ^ (1 << j)] |= mask[i];
            }
        }
    }
    for(int i = (1 << m) - 1; i >= 0; --i) {
        int bcnt = m - __builtin_popcountll(i);
        for(int j = 0; j < m; ++j) {
            if(~i & (1 << j)) {
                f[i] += 1.0 / bcnt *  f[i | (1 << j)];
            }
        }
        int cnt = __builtin_popcountll(mask[i]);
        f[i] += (cnt + .0) / n;
    }
    cout << setprecision(12) << fixed << f[0] << "\n";
    return 0;
}

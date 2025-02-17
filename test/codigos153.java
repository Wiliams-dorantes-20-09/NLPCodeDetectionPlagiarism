/*
ID: hamed_51
PROG: ?
LANG: C++
*/

#include <iostream>
#include <iomanip>
#include <fstream>
#include <sstream>
#include <cmath>
#include <cstdio>
#include <string>
#include <vector>
#include <algorithm>
#include <cstdlib>
#include <cstring>
#include <map>
#include <queue>
#include <set>
#include <queue>
#include <stack>
#include <list>
#include <deque>
#include <assert.h>
#include <ctime>
#include <bitset>
#include <numeric>
#include <complex>
using namespace std;

#if (_win32 || __win32__)
#define LLD "%i64d"
#else
#define LLD "%lld"
#endif

#define FOREACH(i, c) for(__typeof((c).begin()) i = (c).begin(); i != (c).end(); ++i)
#define FOR(i, a, n) for (register int i = (a); i < (int)(n); ++i)
#define Size(n) ((int)(n).size())
#define all(n) (n).begin(), (n).end()
#define ll long long
#define pb push_back
#define error(x) cerr << #x << " = " << x << endl;
#define ull unsigned long long
#define pii pair<int, int>
#define pll pair<ll, ll>
#define point complex<double>
//#define X real()
//#define Y imag()
#define X first
#define Y second
#define EPS 1e-8

#define MAXN 101*1000

vector<int> adj[MAXN];
ll n, sz;
bool mark[MAXN];

void dfs(int pos) {
	if (mark[pos]) return;
	mark[pos] = true;
	sz++;
	FOREACH(next, adj[pos]) dfs(*next);
}

int main() {
	ios::sync_with_stdio(false);
	cin >> n;
	FOR(i, 1, n) {
		int u, v, w;
		cin >> u >> v >> w;
		u--; v--;
		bool lucky = true;
		while (w) { if (w%10 != 4 && w%10 != 7) lucky = false; w /= 10; }
		if (!lucky) {
			adj[u].pb(v);
			adj[v].pb(u);
		}
	}
	ll tot = 0;
	FOR(i, 0, n) if (!mark[i]) {
		sz = 0;
		dfs(i);
		tot += sz*(n-sz)*(n-sz-1);
	}
	cout << tot << endl;
	return 0;
}


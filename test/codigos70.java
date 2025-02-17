#include<bits/stdc++.h>

#define _USE_MATH_DEFINES
#define ll long long
#define ins Not Needed Thing
#define ull unsigned long long
#define ld long double
#define Accepted 0
#define pb push_back
#define pii pair<int,int>
#define pll pair<ll,ll>
#define mp make_pair
#define sz(x) (int)(x.size())
#define all(x) x.begin(),x.end()
#define F first
#define S second
#define emp What is it
#define SORRY FUL Accepted 
#define dimash the top one
#define I wish 
#define you be a little more calm
#define SpeedForce ios_base::sync_with_stdio(0), cin.tie(0)

using namespace std;

const double eps = 0.000001;
const ld pi = acos(-1);
const int maxn = 1e7 + 9;
const int mod = 1e9 + 7;
const ll MOD = 1e18 + 9;
const ll INF = 1e18 + 123;
const int minn = 1e5 + 9;
const int N = 5e3 + 123;                                          
const int NN = 5e5 + 123;
const int PRI = 555557;
const int pri = 997;
const int inf = 1e9 + 9;

int n, m, x, y;
vector<int> ans[5];
vector<int> g[NN];
int u[NN];

void dfs(int v, int lvl = 1) {
	u[v] = 1;
	if(lvl % 2 == 0) {
		u[v] = 2;
	}
	for (int i = 0; i < sz(g[v]); i ++) {
		int to = g[v][i];
		if(!u[to]) {
			dfs(to, lvl + 1);
		}
	}
}

int main () {
	cin >> n >> m;
	for (int i = 1; i <= m; i ++) {
		cin >> x >> y;
		g[x].pb(y);
		g[y].pb(x);
	}
	
	for (int i = 1; i <= n; i ++) {
		if(!u[i] && sz(g[i])) {
			dfs(i);
		}
	}
	
	bool ok = 0;
	for(int i = 1;i <= n; i++) {
    	if(u[i] == 1) ans[2].pb(i);
    	else if(u[i] == 2) ans[1].pb(i);
    	for(int j = 0; j < sz(g[i]); j++) {
    		int to = g[i][j];
        	if(u[to] == u[i]) ok = 1;
    	}
	}
	if(ok) {
		cout << -1;
		exit(0);
	}
//	dfs1(1);
	cout << sz(ans[1]) << '\n';
	for (int i = 0; i < sz(ans[1]); i ++) {
		cout << ans[1][i] << ' '; 
	}
	cout << '\n' << sz(ans[2]) << '\n';
	for (int i = 0; i < sz(ans[2]); i ++) {
		cout << ans[2][i] << ' '; 
	}
}
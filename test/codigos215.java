// In the name of Allah.
// We're nothing and you're everything.
// Ya Ali!
 
#include <bits/stdc++.h>
#define X first
#define Y second
using namespace std;
typedef long long ll;
template <class T, class L> inline bool smax(T &x, L y){  return x < y ? ( x = y, 1) : 0;  }
template <class T, class L> inline bool smin(T &x, L y){  return y < x ? ( x = y, 1) : 0;  }
typedef pair <int, int> pii;
 
const int maxn = 2e5 + 17, lg = 17, mod = 1e9 + 7;
int n, m, q, edge[maxn], comp[maxn], h[maxn], gp, cnt[maxn], po[maxn], par[maxn][lg], a[maxn], alam, nxtcmp[maxn];
ll s[maxn];
bool bl[maxn], seen[maxn], is[maxn];
vector<int> g[maxn];
pii e[maxn];
int hi(int v = 0, int p = -1){
	int ret = h[v];
	seen[v] = 1;
	for(auto i : g[v]){
		int u = edge[i] ^ v;
		if(!seen[u]){
			h[u] = h[v] + 1;
			int t = hi(u, v);
			if(t == h[u])  bl[i] = 1;
			smin(ret, t);
		}
		else if(u != p)  smin(ret, h[u]);
	}
	return ret;
}
void hello(int v){
	cnt[ comp[v] = gp ]++;
	for(auto i : g[v]){
		int u = edge[i] ^ v;
		if(!bl[i] && comp[u] == -1)
			hello(u);
	}
}
void dfs(int v = 0){
	for(int i = 1; i < lg; i++)  par[v][i] = par[ par[v][i - 1] ][i - 1];
	for(auto u : g[v])
		if(u != par[v][0]){
			h[u] = h[v] + 1, par[u][0] = v;
			cnt[u] += cnt[v];
			dfs(u);
		}
}
int lca(int v, int u){
	if(h[v] > h[u])  swap(v, u);
	for(int i = 0; i < lg; i++)
		if(h[u] - h[v] >> i & 1)
			u = par[u][i];
	for(int i = lg - 1; i >= 0; i--)
		if(par[v][i] != par[u][i])
			v = par[v][i], u = par[u][i];
	return v == u ? v : par[v][0];
}
bool cmpr(int v, int p = -1){
	bool cmprs = cnt[v] > 1;
	for(auto u : g[v])
		if(u != p)
			cmprs |= cmpr(u, v);
	if(cmprs){
		nxtcmp[v] = alam;
		//cerr << v << " -> " << alam << '\n';
	}
	return cmprs;
}
void build_tree(){
	fill(g, g + n, vector<int>());
	for(int i = 0; i < m; i++)
		if(bl[i])
			g[ comp[ e[i].X ] ].push_back(comp[ e[i].Y ]),
				g[ comp[ e[i].Y ] ].push_back(comp[ e[i].X ]);
	iota(nxtcmp, nxtcmp + gp, 0);
alam=n;
	for(int i = 0; i < gp; i++)
		if(cnt[i] > 1){
			alam = i;
			cmpr(i);
			break;
		}
	//for(int i = 0; i < n; i++)
	//	cerr << comp[i] << ' ';
	//cerr << '\n';
	for(int i = 0; i < n; i++)
		comp[i] = nxtcmp[ comp[i] ];
	fill(g, g + n, vector<int>());
	for(int i = 0; i < m; i++)
		if(bl[i])
			g[ comp[ e[i].X ] ].push_back(comp[ e[i].Y ]),
				g[ comp[ e[i].Y ] ].push_back(comp[ e[i].X ]);	
}
 
ll get(int v, int p = -1){
	ll mx = 0;
	for(auto u : g[v])
		if(u != p && u != v)
			mx = max(mx, get(u, v));
	return mx + s[v];
}
int main(){
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> n >> m;
	for(int i = 0; i < n; i++)
		cin >> a[i];
	for(int i = 0, v, u; i < m; i++){
		cin >> v >> u, v--, u--;
		edge[i] = v ^ u, e[i] = {v, u};
		g[v].push_back(i), g[u].push_back(i);
	}
	hi();
	memset(comp, -1, sizeof comp);
	for(int i = 0; i < n; i++)
		if(comp[i] == -1){
			hello(i);
			gp++;
		}
	build_tree();
	for(int i = 0; i < n; i++)
		s[ comp[i] ] += a[i];
	int s;
	cin >> s;
	s--;
	cout << max(get(alam), get(comp[s])) << '\n';
}
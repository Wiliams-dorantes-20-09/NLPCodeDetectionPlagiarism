#include <iostream>
#include <vector>
#include <set>

using namespace std;

const int INF = 1 << 30;
const int MAXN = 101010;

int n, m, st, x[MAXN], y[MAXN], w[MAXN], d[MAXN], ans, l;
vector < pair < int, int > > g[MAXN];
set < pair < int, int > > q;

int main()
{
//	freopen("in", "r", stdin);
		cin >> n >> m >> st;
		for (int i = 1; i <= m; i++)
		{
			cin >> x[i] >> y[i] >> w[i];
			g[x[i]].push_back( make_pair(y[i], w[i]) );
			g[y[i]].push_back( make_pair(x[i], w[i]) );
			
		}
		cin >> l;
		for (int i = 1; i <= n; i++)
			d[i] = INF;
		d[st] = 0;
		q.insert( make_pair(d[st], st) );
		while ( !q.empty() )
		{
			int v = q.begin()->second;
			q.erase(q.begin());
			for (int i = 0; i < g[v].size(); i++)
			{
				int to = g[v][i].first;
				int w = g[v][i].second;
				if (d[to] > d[v] + w)
				{
					q.erase( make_pair(d[to], to) );
					d[to] = d[v] + w;
					q.insert( make_pair(d[to], to) );
				}
			}
		}
		for (int i = 1; i <= m; i++)
		{
			if (l > d[x[i]] && l < d[x[i]] + w[i] && l > d[y[i]] && l < d[y[i]] + w[i]) 
			{
				if (d[x[i]] + d[y[i]] + w[i] == l + l)
					ans++;
				else if (d[x[i]] + d[y[i]] + w[i] > l + l) 
					ans += 2;
			}
			else if (l > d[x[i]] && l < d[x[i]] + w[i])
			{
				if (l <= d[y[i]]) ans++;
			}
			else if (l > d[y[i]] && l < d[y[i]] + w[i])
			{
				if (l <= d[x[i]]) ans++;
			}
		}
		for (int i = 1; i <= n; i++)
			if (d[i] == l) ans++;
		cout << ans;

	return 0;
}

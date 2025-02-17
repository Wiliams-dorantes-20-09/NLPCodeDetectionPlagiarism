#include <bits/stdc++.h>

#define pii pair<int, int>

#define pb push_back
#define mp make_pair

#define f first
#define s second

using namespace std;

typedef long long ll;
typedef vector<int> big;

const double EPS = 1e-9;
const double PI = acos(-1);

const int MAXN = (int) 1e6 + 7;
const int INF = (int) 1e9 + 7;

struct edge {
  int to, cost, id;
};

int n, m, st;
int de[MAXN];

int lastUsed[MAXN];

vector<edge> g[MAXN];

long long d[MAXN];
long long ans;

int main() {
  #ifdef LOCAL
  freopen("in", "r", stdin);
  #endif
  
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= m; i++) {
    int u, v, w;
    scanf("%d%d%d", &u, &v, &w);
    g[u].pb({v, w, i});
    g[v].pb({u, w, i});   
    de[i] = w;
  }
  scanf("%d", &st);
  set<int> all;

  for (int i = 1; i <= n; i++)
    d[i] = (long long) 1e18;

  set<pii> s;
  s.insert(mp(0, st));
  d[st] = 0;
  while (!s.empty()) {
    int cur = s.begin() -> second;
    s.erase(s.begin());
    for (auto it : g[cur]) {
      int to = it.to;
      int wt = it.cost;
      int id = it.id;
      if (d[to] > d[cur] + wt || (d[cur] + wt == d[to] && de[lastUsed[to]] > wt)) {
        s.erase(mp(d[to], to));
        
        if (d[to] == (long long) 1e18) {
          ans += wt;
          lastUsed[to] = id;
          all.insert(id);
        }
        else {
          ans += wt;
          ans -= de[lastUsed[to]];
          all.erase(lastUsed[to]);
          lastUsed[to] = id;
          all.insert(id);
        }
        d[to] = d[cur] + wt;
        s.insert(mp(d[to], to));
      } 
    }
  }
  cout << ans << endl;
  for (auto it : all)
    printf("%d ", it);

  return 0;
}
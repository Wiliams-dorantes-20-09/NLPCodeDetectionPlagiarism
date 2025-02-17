#include <bits/stdc++.h>

using namespace std;

#define debug(s) cout<< #s <<" = "<< s <<endl
#define all(v) (v).begin(), (v).end()
#define mem(a,val) memset(a,val,sizeof a)

#define ll long long
#define ff first
#define ss second
#define pb push_back
#define endl '\n'
#define mod 1000000007

bool vis[100011];
int n,m,nSCC,counter,c[100011],low[100011],num[100011];
vector<int> adj[100011],SCC[100011];
vector<int> S;

void tarjanSCC(int u)
{
  low[u] = num[u] = counter++;
  S.pb(u);
  vis[u] = 1;
  for(int v: adj[u]){
    if(num[v] == -1) tarjanSCC(v);
    if(vis[v]) low[u] = min(low[u],low[v]);
  }
  if(low[u] == num[u]){
    ++nSCC;
    while(1){
      int x = S.back();
      S.pop_back();
      vis[x] = 0;
      SCC[nSCC].pb(x);
      if(u == x) break;
    }
  }
}

int main()
{
  ios_base::sync_with_stdio(false);cin.tie(NULL);
  cin >> n;
  for(int i = 1; i <= n; ++i) cin >> c[i];
  cin >> m;
  for(int i = 0; i < m; ++i){
    int u,v;
    cin >> u >> v;
    adj[u].pb(v);
  }
  mem(num,-1);
  for(int i = 1; i <= n; ++i){
    if(num[i] == -1) tarjanSCC(i);
  }
  ll int p = 1, sum = 0;
  for(int i = 1; i <= nSCC; ++i){
    int sz = SCC[i].size();
    int mini = INT_MAX;
    ll int cnt = 0;
    for(int num: SCC[i]){
      mini = min(mini,c[num]);
    }
    for(int num: SCC[i]){
      if(c[num] == mini) ++cnt;
    }
    p = p*cnt;
    p %= mod;
    sum += mini;
  }
  cout << sum << " " << p%mod << endl;
}

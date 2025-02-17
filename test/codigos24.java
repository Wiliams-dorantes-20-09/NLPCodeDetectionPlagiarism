#include <algorithm>
#include <bitset>
#include <cassert>
#include <climits>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <deque>
#include <iomanip>
#include <iostream>
#include <map>
#include <numeric>
#include <queue>
#include <set>
#include <stack>
#include <string>
#define ll          long long
#define pb          push_back
#define mp          make_pair
#define pii         pair<int,int>
#define vi          vector<int>
#define all(a)      (a).begin(),(a).end()
#define F           first
#define S           second
#define sz(x)       (int)x.size()
#define hell        1000000007
#define endl        '\n'
#define rep(i,a,b)	for(int i=a;i<b;i++)
using namespace std;
vi val[1001];
vi adj[1001];
int weight[1001];
int beauty[1001];
int idx=1;
int visited[1001];
int dp[1001][1001];
//dp[n][w]
void dfs(int u){
	val[idx].pb(u);
	visited[u]=1;
	for(auto v:adj[u]){
		if(!visited[v])dfs(v);
	}
}
void solve(){
	int n,m,w;
	cin>>n>>m>>w;
	rep(i,1,n+1)cin>>weight[i];
	rep(i,1,n+1)cin>>beauty[i];
	rep(i,0,m){
		int a,b;
		cin>>a>>b;
		adj[a].pb(b);
		adj[b].pb(a);
	}
	rep(i,1,n+1){
		if(!visited[i]){
			dfs(i);
			idx++;
		}
	}
	rep(i,0,idx){
		rep(j,0,w+1){
			if(i==0 || j==0)dp[i][j]=0;
			else{
				dp[i][j]=dp[i-1][j];
				int curb=0;
				int curw=0;
				for(auto k:val[i]){
					curb+=beauty[k];
					curw+=weight[k];
					if(j-weight[k]>=0)dp[i][j]=max(dp[i][j],dp[i-1][j-weight[k]]+beauty[k]);
				}
				if(j-curw>=0)dp[i][j]=max(dp[i][j],dp[i-1][j-curw]+curb);
			}
		}
	}
	cout<<dp[idx-1][w];
}	

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int t=1;
//	cin>>t;
	while(t--){
		solve();
	}
	return 0;
}
#include <iostream>
#include <fstream>
#include <stack>
#include <cstdlib>
#include <cmath>
#include <string>
#include <set>
#include <map>
#include <vector>
#include <algorithm>
#include <ctime>
#include <cassert>
#include <stdio.h>
#include <queue>

#define mp make_pair
#define pb push_back
#define foru(i,n) for(int i = 0; i < n; i++)
#define ford(i,n) for(int i = n - 1; i >= 0; i++)
#define forab(i,l,r) for(int i = l; i <= r; i++)
#define forabd(i,r,l) for(inr i = r; i >= l; i--)
#define sqr(x) ((x) * (x))

const long long base = 1000000000 + 7;

using namespace std;

vector < int > a[11111];
int sum[111][1111];
int f[111][55555];

void solve(){

	int n = 0;
	int m = 0;
	cin >> n >> m;

	for (int i = 0; i < n; i++)
	{
		int x,y;
		cin >> x >> y;
		x = m - x;
		if (x >= 0)
			a[x].push_back(y);
	}
	for (int i = 0; i <= m; i++) if (a[i].size() > 0)
	{
		sort(a[i].begin(), a[i].end());
		reverse(a[i].begin(), a[i].end());
		sum[i][0] = 0;
		sum[i][1] = a[i][0];
		for (int j = 2; j <= (int)a[i].size(); j++)
			sum[i][j] = sum[i][j - 1] + a[i][j - 1];
	}
	f[0][0] = sum[0][1];
	for (int i = 0; i <= m; i++)
	{
		int lev = 1;
		for (int k = 0; k < i; k++)
		{
			lev += lev;
			if (lev > n)
			{
				lev = n;
				break;
			}
		}
		for (int j = 0; j <= min(lev, n); j++)
		{
			for (int k = 0; k <= min(j, int(a[i].size())); k++)
			{
				f[i + 1][min(lev+lev,min(n, 2 * j - 2 * k))] = max(f[i + 1][min(n,min(lev+lev, 2 * j - k - k))], f[i][j] + sum[i][k]);
			}
		}
	//	for (int j = 0; j <= min(lev, n); j++)
	//		cout << "f [ " << i << " ][ " <<  j <<" ] = " << f[i][j] << endl;
	}
	int ans = 0;
	for (int i = 0; i < m + 5; i++)
		for (int j = 0; j < n + 5; j++)
			ans = max(ans, f[i][j]);
	cout << ans << endl;
}

int main(){
	ios_base :: sync_with_stdio(false);
	int test = 1;
	while (test--){
		solve();
	}
	return 0;
}
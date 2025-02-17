#include<bits/stdc++.h>
#include<ext/numeric>
using namespace std;
using namespace __gnu_cxx;

#define all(v) v.begin(),v.end()
#define rall(v) v.rbegin(),v.rend()
#define sz(v)  (int)v.size()
#define UNVISITED -1
#define CLR(a,v) memset(a,v,sizeof a)
#define PC(x) __builtin_popcnt(x)

typedef long long ll;
typedef pair<int, int> ii;
typedef pair<ll, ll> pll;
typedef vector<int> vi;
typedef vector<ii> vii;
typedef unsigned int ui;

const double PI = acos(-1.0);

int dx[] = { 0, 0, 1, -1, -1, -1, 1, 1 };
int dy[] = { 1, -1, 0, 0, 1, -1, 1, -1 };

const int MAX = 1 << 22, MOD = 1e9 + 7, oo = 1 << 30, MAXN = 1e6 + 5;
int n, memo[MAX], a[MAXN];
void solve(int msk, int val) {
	int &ret = memo[msk];
	if (~ret)
		return;
	ret = val;
	for (int i = 0; i < 22; ++i)
		if (msk & (1 << i))
			solve(msk & (~(1 << i)), val);
}

int main() {
#ifndef ONLINE_JUDGE
	freopen("in.txt", "r", stdin);
#endif
	scanf("%d", &n);
	CLR(memo, -1);
	for (int i = 0; i < n; ++i) {
		scanf("%d", &a[i]);
		solve(a[i] ^ ((1 << 22) - 1), a[i]);
	}
	for (int i = 0; i < n; ++i)
		printf("%d ", memo[a[i]]);
}


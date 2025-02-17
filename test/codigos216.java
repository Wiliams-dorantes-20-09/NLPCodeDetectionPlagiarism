//~In The Name Of Allah~//
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <iomanip>
#include <math.h>
#include <stdio.h>
#include <algorithm>
#include <cmath>
#include <string.h>
#include <sstream>
#include <fstream>
#include <functional>
#include <stack>
#include <utility> 
#include <set>
#include <list>
#include <queue>
#include <bitset>
#include <time.h>

using namespace std;

#define read freopen("in.txt", "r", stdin)
#define write freopen("out.txt", "w", stdout)
#define all(_) _.begin(), _.end()
#define rall(_) _.rbegin(), _.rend()
#define rep(i, j) for (int i = 0; i < j; i++)
#define Rep(i, j, k) for (int i = j; i < k; i++)
#define siz(_) (int)_.size()
#define ll long long
#define endl '\n'
#define ff fflush(stdout)

const double PI = 2.0 * acos(0.0);
const int MOD = 1e9 + 7;
const int oo = MOD;

typedef pair<int, int> pii;

ll gcd(ll x, ll y) { return !y ? x : gcd(y, x%y); }

int main() {
	int n, l, r;
	cin >> n;
	vector<int> in(n), vis(n);
	rep(i, n) 
		cin >> in[i];
	vector<pii> ans;
	int len = 0;
	rep(i, n) {
		int idx;
		if (in[i]) {
			idx = i - 1;
			int l, r;
			while (idx >= 0 && !in[idx] && !vis[idx])
				vis[idx--] = 1;
			l = ++idx;
			idx = i + 1;
			while (idx < n && !in[idx] && !vis[idx])
				vis[idx++] = 1;
			r = --idx;
			ans.push_back({ l, r });
			len += r - l + 1;
		}
	}
	if (len != n) 
		puts("NO");
	else {
		puts("YES");
		cout << siz(ans) << endl;
		rep(i, siz(ans))
			cout << ++ans[i].first << " " << ++ans[i].second << endl;
	}
	return 0;
}
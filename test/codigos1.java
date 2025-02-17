#include <bits/stdc++.h>
using namespace std;
typedef long double ld;

const int N = 20 + 2, M = (1LL << 20) + 10;
int n, k, zero;
ld p[N], dp[M], sum[M];

int main() {
	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		cin >> p[i];
		if (!p[i])
			zero++;
	}
	k = min(k, n - zero);
	
	for (int msk = 0; msk < (1LL << n); msk++)
		for (int i = 0; i < n; i++)
			if (!(msk & (1LL << i)))
				sum[msk] += p[i];
	
	dp[0] = 1;
	for (int cnt = 1; cnt <= n; cnt++) {
		for (int msk = 0; msk < (1LL << n); msk++) {
			if (__builtin_popcount(msk) != cnt)
				continue;
			for (int i = 0; i < n; i++)
				if (msk & (1LL << i)) {
					dp[msk] += (dp[msk ^ (1LL << i)] * p[i]) / (sum[msk] + p[i]);
				}
		}
	}
	
	for (int i = 0; i < n; i++) {
		if (!p[i]) {
			cout << 0 << " ";
			continue;
		}
		
		ld res = 0;
		for (int msk = 0; msk < (1LL << n); msk++) {
			if (__builtin_popcount(msk) == k && (msk & (1LL << i)))
				res += dp[msk];
		}
		cout << fixed << setprecision(6) << res << " ";
	}
}

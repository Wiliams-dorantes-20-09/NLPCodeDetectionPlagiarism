#include <bits/stdc++.h>
using namespace std;
long long a[105];
int main() {
	long long n, d, i, ans;
	scanf("%lld%lld", &n, &d);
	for(i = 0; i < n; i++)
		scanf("%lld", &a[i]);
	ans = 2;
	for(i = 0; i < n - 1; i++) {
		if(a[i + 1] - a[i] > 2 * d) ans += 2;
		else if(a[i + 1] - a[i] == 2 * d) ans++;
	}
	printf("%lld\n", ans);
	return 0;
}
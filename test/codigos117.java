/*
 */
#include <bits/stdc++.h>
using namespace std;

int main() {
	//freopen("in.txt", "rt", stdin);
	int n, k;
	scanf("%d %d", &n, &k);
	deque<int> dq(n);
	for (int i = 0; i < n; ++i) {
		scanf("%d", &dq[i]);
	}
	while (dq.size() && dq[0] <= k)
		dq.pop_front();
	while (dq.size() && dq.back() <= k)
		dq.pop_back();
	printf("%d",n-dq.size());
}

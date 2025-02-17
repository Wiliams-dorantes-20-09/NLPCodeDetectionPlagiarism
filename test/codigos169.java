#include <iostream>
#include <stdio.h>
#include <vector>
#include <algorithm>
#include <string>
#include <assert.h>
#include <ctype.h>
#include <limits.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <bitset>
#include <deque>
#include <map>
#include <queue>
#include <set>
#include <sstream>
using namespace std;

typedef long long ll;

const int N = 2e5 + 1;
int n, a[N], m, b[N], c[N];

int main(int argc, char **argv) {
//	freopen("in.txt", "r", stdin);
	scanf("%d", &n);
	for (int i = 0; i < n; ++i)
		scanf("%d", &a[i]);
	sort(a, a + n);
	scanf("%d", &m);
	for (int i = 0; i < m; ++i)
		scanf("%d", &b[i]);
	for (int i = 0; i < m; ++i)
		scanf("%d", &c[i]);
	int A = -1, S = -1, l, r, res = -1;
	for (int i = 0; i < m; ++i) {
		l = lower_bound(a, a + n, b[i]) - a;
		r = upper_bound(a, a + n, b[i]) - a;
		int canA = r - l;
		l = lower_bound(a, a + n, c[i]) - a;
		r = upper_bound(a, a + n, c[i]) - a;
		int canS = r - l;
		if (canA > A || (canA == A && canS > S)) {
			res = i + 1;
			A = canA;
			S = canS;
		}
	}
	assert(res != -1);
	printf("%d\n", res);
	return 0;
}
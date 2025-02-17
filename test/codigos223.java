/* 63B */
#include <iostream>
#include <string>
#include <map>
#include <queue>
#include <set>
#include <stack>
#include <vector>
#include <deque>
#include <algorithm>
#include <cstdio>
#include <cmath>
#include <ctime>
#include <cstring>
#include <climits>
#include <cctype>
#include <cassert>
#include <functional>
using namespace std;
//#pragma comment(linker,"/STACK:102400000,1024000")

#define sti				set<int>
#define stpii			set<pair<int, int> >
#define mpii			map<int,int>
#define vi				vector<int>
#define pii				pair<int,int>
#define vpii			vector<pair<int,int> >
#define rep(i, a, n) 	for (int i=a;i<n;++i)
#define per(i, a, n) 	for (int i=n-1;i>=a;--i)
#define clr				clear
#define pb 				push_back
#define mp 				make_pair
#define fir				first
#define sec				second
#define all(x) 			(x).begin(),(x).end()
#define SZ(x) 			((int)(x).size())
#define lson			l, mid, rt<<1
#define rson			mid+1, r, rt<<1|1

const int maxn = 105;
int c[maxn];

int main() {
	ios::sync_with_stdio(false);
	#ifndef ONLINE_JUDGE
		freopen("data.in", "r", stdin);
		freopen("data.out", "w", stdout);
	#endif
	
	int n, k;
	int x;
	
	memset(c, 0, sizeof(c));
	scanf("%d %d", &n, &k);
	rep(i, 0, n) {
		scanf("%d", &x);
		++c[x];
	}
	
	int ans = 0;
	
	while (c[k] != n) {
		++ans;
		per(i, 1, k) {
			if (c[i]) {
				--c[i];
				++c[i+1];
			}
		}
	}
	
	printf("%d\n", ans);
	
	#ifndef ONLINE_JUDGE
		printf("time = %d.\n", (int)clock());
	#endif
	
	return 0;
}

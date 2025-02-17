//#pragma GCC optimize("Ofast")
//#pragma GCC target("sse,sse2,sse3,ssse3,sse4,avx,avx2")
#include <bits/stdc++.h>

using namespace std;

#define PB push_back
#define MP make_pair
#define EB emplace_back
#define f first
#define s second
#define FOR(i,a,b) for (int i = a; i < (b); ++i)
#define RFOR(i, b, a) for (int i = b-1; i>=a; --i)
#define FILL(a, b) memset(a, b, sizeof a)
#define ALL(a) a.begin(), a.end()
#define SZ(a) ((int)a.size())
#define bitc(n) __builtin_popcount(n)
#define bitcll(n) __builtin_popcount(n)
#define MAGIC0 mt19937 rnd(time(0)); //rnd()

typedef long long LL;
typedef unsigned long long ULL;
typedef vector<int> VI;
typedef pair<int, int> PII;
typedef pair<LL, LL> PLL;

const int INF = 1000 * 1000 * 1000 + 7;
const LL LINF = 1LL * INF*INF;
const int MAX = 1e5 + 7;
const double PI = acos(-1.);
const double EPS = 1e-7;
const int MOD = 998244353;


int main()
{
	ios_base::sync_with_stdio(0);
//	freopen("input.txt", "r", stdin);
//	freopen("output.txt", "w", stdout);
	int q;
	cin >> q;
	while(q--)
	{
		int n, k;
		cin >> n >> k;
		VI ans, a(n);
		int ost = 0;
		FOR(i, 0, n)
		{
			cin >> a[i];
			ost += a[i] % 2;
		}
		if (ost < k || (ost - k) % 2)
		{
			cout << "NO\n";
			continue;
		}
		ost = 0;
		FOR(i, 0, n)
		{
			ost += a[i] % 2;
			if (ost && SZ(ans) < k - 1)
			{
				ost = 0;
				ans.PB(i + 1);
			}
		}
		ans.PB(n);
		cout << "YES\n";
		for(auto el : ans)
		{
			cout << el << ' ';
		}
		cout << '\n';
	}

	return 0;
}


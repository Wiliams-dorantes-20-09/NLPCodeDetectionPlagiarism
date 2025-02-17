#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <cstdio>
#include <cmath>
#include <vector>
#include <queue>
#include <utility>
#include <algorithm>
#include <map>
#include <set>

using namespace std;

// for debug
//#define cin myCin
//ifstream cin("test.txt");
//#define cout myCout
//ofstream cout("res.txt");
#define STOP system("pause");

#define FORU(i, a, b) for (int i = a; i < b; i++)
#define FORD(i, a, b) for (int i = a - 1; i >= b; i--)
#define ALL(v) v.begin(), v.end()
#define MAXEL(x, n) *max_element(x, x + n)
#define MAXELS(v) *max_element(ALL(v))
#define MINEL(x, n) *min_element(x, x + n)
#define MINELS(v) *min_element(ALL(v))
#define LB(x, n, a) int (lower_bound(x, x + n, a) - x)
#define LBS(v, a) int (lower_bound(ALL(v), a) - v.begin())
#define UB(x, n, a) int (upper_bound(x, x + n, a) - x)
#define UBS(v, a) int (upper_bound(ALL(v), a) - v.begin())
#define SORT(x, n) sort(x, x + n)
#define SORTS(v) sort(ALL(v))
#define PB push_back
#define MP make_pair
#define CINVI(v) { int cur; cin >> cur; v.PB(cur); }
#define BSS(v, a) (LBS(v, a) == v.size() || v[LBS(v, a)] != a ? -1 : LBS(v, a))
#define REV(v) reverse(ALL(v))
#define SQR(a) (a) * (a)

typedef long long li;
typedef long double ld;
typedef pair <int, int> pii;
typedef pair <double, double> pdd;
typedef map <int, int> mii;
typedef map <string, int> msi;
typedef vector <int> vi;
typedef set <int> si;

const int SHINF = 1 << 15;
const int INF = 1 << 30;
const li LINF = 1LL << 62;

// types, constants and variables
int n;
string s;

// solving
char diff(char c) {
	if (c == 'R') {
		return 'G';
	} 
	if (c == 'G') {
		return 'R';
	}
	if (c == 'B') {
		return 'R';
	}
}

char diff(string s) {
	if (s == "RG") {
		return 'B';
	}
	if (s == "GR") {
		return 'B';
	}
	if (s == "RB") {
		return 'G';
	}
	if (s == "BR") {
		return 'G';
	}
	if (s == "BG") {
		return 'R';
	}
	if (s == "GB") {
		return 'R';
	}
}

void solve() {
	int k = 0;
	for (int i = 0; i < n - 1; i++) {
		if (s[i] != s[i + 1]) {
			continue;
		}
		k++;
		if (i == n - 2) {
			s[n - 1] = diff(s[n - 1]);
		} else {
			if (s[i + 2] == s[i]) {
				s[i + 1] = diff(s[i]);
			} else {
				string t = "";
				t += s[i + 1];
				t += s[i + 2];
				s[i + 1] = diff(t);
			}
		}
	}
	cout << k << endl;
	cout << s << endl;
}

// reading
int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cin >> n >> s;
	
	//-----------------------------------------------

	solve();
}

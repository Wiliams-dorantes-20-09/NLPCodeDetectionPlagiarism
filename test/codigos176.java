#include <algorithm>
#include <iostream>
#include <cstdlib>
#include <iomanip>
#include <sstream>
#include <cstdio>
#include <vector>
#include <cmath>
#include <stack>
#include <set>
#include <map>
#include <bitset>
#include <cstring>
#include <cctype>
#include <queue>
#include <deque>

using namespace std;

#define fi first
#define se second
#define pf push_front
#define pb push_back
#define mk make_pair
#define all(c) (c).begin(), (c).end()
#define sz(x) (int)x.size()
#define SWS ios_base::sync_with_stdio(false)
#define rfile freopen("input.txt", "r", stdin)
#define wfile freopen("output.txt", "w", stdout)
#define files rfile; wfile

typedef long long ll;
typedef long double ld;

const int Z = (int)1e5 + 111;
const int inf = (int)1e9 + 111;
const ll llinf = (ll)1e18 + 5;
const int MOD = (int)1e9 + 7;

int main() {
	//files;
	SWS;
	string s;
	set <char> good;
	cin >> s;
	for (int i = 0; i < sz(s); ++i) {
        good.insert(s[i]);
	}
	string t;
	cin >> t;
	int n;
	cin >> n;
	while (n--) {
        string r;
        cin >> r;
        if (sz(r)<sz(t)-1) {
            cout << "NO\n";
            continue;
        }
        int cur = 0;
        bool br = false;
        for (int i = 0; i < sz(t); ++i) {
            if (cur == sz(r) && t[i] != '*') {
                cout << "NO\n";
                br = 1;
                break;
            }
            if (t[i] == r[cur]) {
                cur++;
                continue;
            }
            if (t[i] == '*' && sz(r) == sz(t)-1) continue;
            bool f = false;
            if (t[i] == '*') {
                for (int j = 0; j <= sz(r)-sz(t); ++j) {
                    if (good.count(r[cur])) {
                        cout << "NO\n";
                        f = br = 1;
                        break;
                    }
                    cur++;
                }
            }
            if (f) break;
            if (t[i] == '?' && !good.count(r[cur])) {
                cout << "NO\n";
                br = 1;
                break;
            } else if (t[i] == '?') {
                cur++;
            }
        }
        if (br) continue;
        if (cur == sz(r)) {
            cout << "YES\n";
        }  else {
            cout << "NO\n";
        }
	}
	return 0;
}
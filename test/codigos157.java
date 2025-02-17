#include <bits/stdc++.h>
using namespace std;

#define pb push_back
#define mp make_pair

typedef long long ll;
typedef pair<int, int> pii;

int main() {
#ifdef LOCAL
  freopen("input", "r", stdin);
#endif
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  string s = "aeiou";
  string t;
  cin >> t;
  int res = 0;
  for (int i = 0; i < (int)s.size(); ++i) {
    res += count(t.begin(), t.end(), s[i]);
  }
  for (int i = 1; i < 10; i += 2) {
    res += count(t.begin(), t.end(), '0' + i);
  }
  cout << res << endl;
  return 0;
}
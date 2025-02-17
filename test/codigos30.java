//Daniel Grzegorzewski
#include <bits/stdc++.h>
#pragma GCC optimize("O3")

#define MP make_pair
#define PB push_back
#define ST first
#define ND second

using namespace std;

typedef pair<int, int> PII;
typedef vector<int> VI;
typedef vector<PII> VII;
typedef long long LL;

void init_ios() {
     ios_base::sync_with_stdio(0);
     cin.tie(0);
}

const int N = (int)1e5 + 3;

int n;
string s;
bool vis[N];

int main() {
  init_ios();
  cin >> n >> s;
  int ile = n-11;
  int meh = ile/2;
  for (int i = 0; i < n; ++i)
    if (s[i] == '8' && meh) {
      --meh;
      vis[i] = true;
    }
  meh = ile/2;
  for (int i = 0; i < n; ++i)
    if (s[i] != '8' && meh) {
      vis[i] = true;
      --meh;
    }
  for (int i = 0; i < n; ++i)
    if (!vis[i]) {
      if (s[i] == '8')
        cout<<"YES\n";
      else
        cout<<"NO\n";
      return 0;
    }
}
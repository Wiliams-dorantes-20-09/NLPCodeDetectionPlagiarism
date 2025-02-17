#include <cstdio>
#include <algorithm>

using namespace std;

const int N = 100'009;

int a[N];
int b[N];

int main() {
  int tt;
  scanf("%d", &tt);
  while (tt--) {
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
      scanf("%d", a + i);
    }
    for (int i = 0; i < n; ++i) {
      scanf("%d", b + i);
    }
    const int inf = 1'000'000'000;
    int mn = inf, mx = -inf;
    int d = inf;
    bool ans = true;
    for (int i = 0; i < n; ++i) {
      if (a[i] == b[i]) {
        continue;
      }
      mn = min(mn, i);
      mx = max(mx, i);
      if (d != inf && d != b[i] - a[i]) {
        ans = false;
      }
      d = b[i] - a[i];
    }
    if (d < 0) {
      ans = false;
    }
    for (int i = mn; i <= mx; ++i) {
      if (b[i] - a[i] != d) {
        ans = false;
      }
    }
    puts(ans ? "YES" : "NO");
  }
}

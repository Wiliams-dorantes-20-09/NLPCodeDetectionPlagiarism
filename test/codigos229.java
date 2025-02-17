#define TASK "1"
#include <bits/stdc++.h>

using namespace std;

int const N = 1234;

int a[N];
int dp[N];

int main() {
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        scanf("%d", a + i);
    }
    for (int i = 0; i < n; ++i) {
        dp[i] = a[i];
        if (i - 1 >= 0) {
            if (i - 2 >= 0) {
                dp[i] = min(dp[i], max(dp[i - 1], dp[i - 2]));
            } else {
                dp[i] = min(dp[i], dp[i - 1]);
            }
        }
    }
    printf("%d\n", dp[n - 1]);
    return 0;
}
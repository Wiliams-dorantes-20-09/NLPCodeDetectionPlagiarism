#include <bits/stdc++.h>
#define f(i, a, n) for(int i = a; i <= n; ++i)
#define rf(i, a, n) for (int i = n; i >= a; --i)

using namespace std;

const int N = 100001;

long long n, m, a[N];
main(){
  cin >> n;

  long long x, cnt[N];
  f(i, 1, n){
    cin >> x;
    ++cnt[x];
 }

 long long dp[N];

 dp[0] = 0;
 dp[1] = cnt[1];

 f(i, 2, 100000){
    dp[i] = max (dp[i - 1], dp[i - 2] + cnt[i] * i);
 }

 cout << dp[100000];
}

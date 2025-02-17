#include <bits/stdc++.h>
#define err(args...) {}
#ifdef DEBUG
#include "_debug.cpp"
#endif
using namespace std;
using ll = long long;
template <typename T> using lim = numeric_limits<T>;
const int N = 2000;
const ll C = 1'000'000'000, INF = N * C;
int t[N+1], c[N+1];
ll mem[N+1][2*N+1];
ll opt(int n, int free) {
    ll& ans = mem[n][N + free];
    if(ans == -1) {
        if(n == 0) {
            ans = free >= 0 ? 0 : INF;
        } else {
            ans = min(c[n] + opt(n - 1, min(free + t[n], N)), opt(n - 1, free - 1));
        }
    }
    return ans;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    for(int i = 1; i <= n; i++) {
        cin >> t[i] >> c[i];
    }
    memset(mem, -1, sizeof mem);
    cout << opt(n, 0) << endl;
    return 0;
}

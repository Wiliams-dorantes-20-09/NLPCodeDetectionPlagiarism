#include <bits/stdc++.h>

using namespace std;

#define all(x) x.begin(), x.end()

const int Z = 1e5 + 1;

int main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    cin >> n;
    double ans = 0;
    for (int i = n; i >= 1; --i) {
        ans += (double)1 / i;
    }
    cout << fixed << setprecision(10) << ans;


    return 0;
}
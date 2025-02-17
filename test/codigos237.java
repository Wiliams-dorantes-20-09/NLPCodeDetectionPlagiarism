#include <bits/stdc++.h>
using namespace std;
using ll = long long;

const int maxn = 2e5+5;
int n, a[maxn];

int k;
int total[maxn];
int cnt[maxn][20];

int walk(int i) {
    int curr = k;
    int res = 0;
    for (int j = 0; j < 20; j++) {
        int sub = min(curr,cnt[i][j]);
        res += sub*j;
        curr -= sub;
        //cout << "walk " << i << ": " << res << '\n';
    }
    assert(curr == 0);
    return res;
}

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    cin >> n;
    cin >> k;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    for (int i = 0; i < n; i++) {
        int dist = 0;
        while (true) {
            total[a[i]]++;
            cnt[a[i]][dist]++;

            if (a[i] == 0) break;

            a[i] /= 2;
            dist++;
        }
    }
    int ans = 2e9+9;
    for (int i = 0; i <= 200000; i++) {
        if (total[i] >= k) {
            /*
            cout << i << ": " << total[i] << '\n';
            cout << walk(i) << '\n';
            */
            ans = min(ans,walk(i));
        }
    }
    cout << ans << '\n';
}


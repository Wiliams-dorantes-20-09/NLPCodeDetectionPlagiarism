#include <bits/stdc++.h>

#define ll long long

using namespace std;

const int MXN = 1e3 + 10;
const int INF = 1e9;

int n, k;
int cnt[MXN];

string ans, s;

int main()
{
    cin >> k >> s;

    n = s.length();
    for (int i = 0; i < n; i++)
        cnt[s[i]]++;

    if (n % k != 0)
    {
        printf("-1");
        return 0;
    }

    for (int i = 'a'; i <= 'z'; i++)
    {
        if (cnt[i] % k != 0)
        {
            printf("-1");
            return 0;
        }
        for (int j = 0; j < cnt[i] / k; j++)
            ans += char(i);
    }

    for (int i = 0; i < k; i++)
        cout << ans;

    return 0;
}

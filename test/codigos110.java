#include<bits/stdc++.h>
#define int long long

using namespace std;
signed main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int n, arr[1000];
    cin >> n;
    for (int i = 1; i <= n; i++)
        arr[i - 1] = i;
    for (int i = n - 1; i > 0; i--)
        swap(arr[i - 1], arr[i]);
    for (int i = 0; i < n; i++)
        cout << arr[i] << " \n"[i == n - 1];

    return 0;
}

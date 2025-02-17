#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")

using namespace std;

#define ff first
#define ss second
#define add push_back
#define all(x) x.begin(), x.end()
typedef long long ll;

int main(){
    //freopen("input.txt", "r", stdin);
    //freopen("output.txt", "w", stdout);
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int n, ans = 0;
    cin >> n;
    vector<int> candies(n);
    for (int &candy : candies)
    {
        cin >> candy;
    }
    map<int,int> sizes;
    for (int i = 0; i < n; ++i)
    {
        for (int j = i + 1; j < n; ++j)
        {
            ++sizes[candies[i] + candies[j]];
        }
    }
    for (auto it : sizes)
    {
        ans = max(ans, it.ss);
    }
    cout << ans;

    return 0;
}

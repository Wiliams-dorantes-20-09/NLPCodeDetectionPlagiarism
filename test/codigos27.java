#include <bits/stdc++.h>

#define F first
#define S second
#define pb push_back
#define ll long long

using namespace std;

const ll mod=1e9+7;

vector <ll> a,dp;

int main() {
    ios_base::sync_with_stdio(0);
    //freopen("input.txt", "r", stdin);
    //freopen("output.txt", "w", stdout);
    int n;
    cin >> n;
    ll ans=0;
    a.resize(n);
    dp.resize(n);
    for (int i(0); i<n; i++) {
        cin >> a[i];
    }
    sort(a.begin(),a.end());
    dp[0]=1;
    for (int i=1; i<n; i++) {
        dp[i]=(dp[i-1]*2);
        dp[i]%=mod;
        ans+=(a[i]*dp[i-1]);
        dp[i]++;
        ans%=mod;
        ans=(ans+mod)%mod;
    }
    for (int i=0; i<n; i++) {
        dp[i] = 0;
    }
    sort(a.rbegin(),a.rend());
    dp[0]=1;
    for (int i=1; i<n; i++) {
        dp[i]=(dp[i-1]*2);
        dp[i]%=mod;
        ans-=(a[i]*dp[i-1]);
        dp[i]++;
        ans%=mod;
        ans=(ans+mod)%mod;
    }
    ans%=mod;
    cout << ans << endl;

}
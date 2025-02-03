#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define rep(i,a,n) for (int i=a;i<n;i++)
#define per(i,a,n) for (int i=n-1;i>=a;i--)
#define setDP(arr) memset(arr,-1,sizeof arr)
#define Clear(arr) memset(arr,0,sizeof arr)
#define pb push_back
#define mp make_pair
#define all(x) (x).begin(),(x).end()
#define fi first
#define se second
#define sz(x) ((int)(x).size())
#define TurnOn(s,j) s|=(1<<j)
#define TurnOff(s,j) s&=~(1<<j)
#define Flip(s,j) s^=(1<<j)
#define LSB(s) s&(-s)
#define Setall(n) ((1<<n)-1)
const ll mod = 1000000007;
const double eps = 1e-9;
#define In_the_name_of_allah_the_merciful ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
#define Alhamdulillah return 0 ;
const int N = 2e5+5;
ll n,m,k,x,mx;
pair<ll,ll> f[N],s[N];
ll bs(ll crPoints){
    int lo = 0 , hi = k;
    while(lo < hi){
        int mid = (lo+hi+1)/2;
        if (crPoints >= s[mid].se){
            lo = mid;
        }
        else
            hi = mid-1;
    }
    return s[lo].fi;
}
int main()
{
    In_the_name_of_allah_the_merciful
    cin >> n >> m >> k >> x >> mx;
    f[0] = {x,0};
    s[0] = {0,0};
    m++;
    rep(i,1,m)
        cin >> f[i].fi;
    rep(i,1,m)
        cin >> f[i].se;
    rep(i,1,k+1)
        cin >> s[i].fi;
    rep(i,1,k+1){
        cin >> s[i].se;
    }
    ll ans = n*x;
    rep(i,0,m){
        ll taken = mx - f[i].se;
        if (taken < 0) continue;
        ans = min(ans,(n-bs(taken))*f[i].fi);

    }
    cout << ans << endl;
    Alhamdulillah
}

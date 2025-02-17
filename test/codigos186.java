/* ****GT_18**** */

#include<bits/stdc++.h>
#define ll          long long
#define pb          push_back
#define	endl		'\n'
#define pii         pair<ll int,ll int>
#define vi          vector<ll int>
#define all(a)      (a).begin(),(a).end()
#define F           first
#define S           second
#define sz(x)       (ll int)x.size()
#define hell        1000000007
#define rep(i,a,b)	for(ll int i=a;i<b;i++)
#define lbnd        lower_bound
#define ubnd        upper_bound
#define bs          binary_search
#define mp          make_pair
using namespace std;

#define N  100005

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int TESTS=1;
//	cin>>TESTS;
	while(TESTS--)
	{
		ll n;
	    cin>>n;
	    vi a(n);
	    rep(i,1,n+1) 
	    cin>>a[i],a[i]=min(a[i]+1,i);
	    ll ans=0,cur_alive=n;
	    for(ll i=n;i>=1;--i) 
	    {
	        if(cur_alive>=i) ans++;
	        cur_alive=min(cur_alive,i-a[i]);
	    }
	    cout<<ans<<endl;		
	}
	return 0;
}
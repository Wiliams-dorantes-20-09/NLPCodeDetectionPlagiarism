/* winners never quit and quitters never win.
      #swap                                 */
#include <bits/stdc++.h>
using namespace std;
typedef long long int ll;
typedef long double ld;
#pragma GCC optimize ("-O3")
#define mod 1000000007
#define inf 1000000000000000000
#define rk 256
#define pb push_back
#define mp make_pair
#define vc vector
#define fs first
#define sec second
#define pq priority_queue
#define endl '\n'
#define lb lower_bound
#define ub upper_bound
#define pll pair<ll,ll> 
#define pls pair<ll,string>
#define psl pair<string,ll>
#define plc pair<ll,char>
#define pcl pair<char,ll>
#define pss pair<string,string>
#define all(v) v.begin(),v.end()
#define tol(s) transform(s.begin(),s.end(),s.begin(),::tolower);
#define tou(s) transform(s.begin(),s.end(),s.begin(),::toupper);
#define T ll t=0;cin>>t;for(ll test=0;test<t;test++)
/*ll ncr[5001][5001];
void coeff()
{
    for(ll a=0;a<5001;a++)
    {
        for(ll b=0;b<5001;b++)
        {
            ncr[a][b]=0;
        }
        ncr[a][0]=1;
    }
    for(ll a=1;a<5001;a++)
    {
        for(ll b=1;b<=a;b++)
        {
            ncr[a][b]=(ncr[a-1][b]+ncr[a-1][b-1])%mod;
        }
    }
}*/
ll fast_exp(ll base, ll exp1) {
    ll res=1;
    while(exp1>0) {
       if(exp1&1) res=(res*base)%mod;
       base=(base*base)%mod;
       exp1/=2;
    }
    return res%mod;
} 
ll pr[1000001]={0};
void isprime()
{
    pr[0]=1;
    pr[1]=1;
    for(ll a=2;a*a<=1000001;a++)
    {
        if(!pr[a])
        {
            for(ll b=a*a;b<1000001;b+=a)
            {
                pr[b]=1;
            }
        }
    }
}
ll comp=1,tim=0;
struct vertex
{
    vc<ll> adj;
    ll vis=0;
    ll parent=-1;
    ll dist=0;
    ll component=0;
    ll in=0;
    ll out=0;
    ll low=0;
    ll child=0;
    ll indeg=0;
    ll outdeg=0;
    bool AP=false;
};
 
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);cout.tie(0);
	//isprime();
	//coeff();
	/*freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);*/
    ll n;
    cin>>n;
    vc<ll> v(n);
    ll freq[200005]={0};
    for(ll a=0;a<n;a++)
    {
        cin>>v[a];
        freq[v[a]]++;
    }
    ll ele=0,po=0;
    for(ll a=0;a<200005;a++)
    {
        if(freq[a]>po)
        {
            po=freq[a];
            ele=a;
        }
    }
    vc<pair<ll,pll>> ans;
    queue<ll> q;
    for(ll a=0;a<n;a++)
    {
        if(v[a]==ele)
            q.push(a);
    }
    while(!q.empty())
    {
        ll sor=q.front();
        q.pop();
        if(sor<n-1 and v[sor+1]!=ele)
        {
            if(v[sor+1]<ele)
                ans.pb(mp(1,mp(sor+1,sor)));
            else
                ans.pb(mp(2,mp(sor+1,sor)));
            v[sor+1]=ele;
            q.push(sor+1);
        }
        if(sor and v[sor-1]!=ele)
        {
            if(v[sor-1]<ele)
                ans.pb(mp(1,mp(sor-1,sor)));
            else
                ans.pb(mp(2,mp(sor-1,sor)));
            v[sor-1]=ele;
            q.push(sor-1);
        }
    }
    cout<<ans.size()<<endl;
    for(auto y:ans)
        cout<<y.fs<<" "<<y.sec.fs+1<<" "<<y.sec.sec+1<<endl;
	return 0;
}
#include<bits/stdc++.h>
#define In_the_name_of_allah_the_merciful ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
#define Alhamdulillah return 0;
#define pb push_back
#define ins(x) insert(x)
#define fi first
#define se second
#define lb lower_bound
#define ub upper_bound
#define all(v) (v.begin(),v.end())
#define sz(v) ((ll)((v).size()))
#define reset(v,val) memset(v,val,sizeof(v))
#define erep(i, x, n) for ( i = x; i<=(ll)(n); i++)
#define rep(i, x, n) for( i = x; i<(ll)(n); i++)
using namespace std;
typedef  long long int   ll;
const long long int mod=1e9+7;
ll dx[]={0,0,1,-1};
ll dy[]={1,-1,0,-1};
ll m,k,n,a[500005],dp[200005],dpr[500005],ans,sm=0,res=0;
multiset<  ll >st1,st2;
string s1="one",s2="zero",s,ch="";
vector<ll>v0,v1;
vector< pair<ll,ll> >vv;
vector< pair< ll,pair <ll,ll> > > vvv;
priority_queue <ll> pq;
map< ll , ll >cost;
ll xa,xb,xc,ya,yb,yc,xres;



int main(){
In_the_name_of_allah_the_merciful

	ll i=0,x,y,j=0,z=0,q,nb0=0,nb1=0,nbmax=0,nbinf=0,nb=0,mm=5e8,idx=0,ok=0,l,mx=0,r,negatif=0,positif=0,l1,r1;
	multiset<  ll > ::iterator it,it1,it2;
	char c;
  // freopen("a.txt.txt","r",stdin);
   q=1;
   //cin>>q;
   while(q--){
       cin>>n;
          for(i=1;i<=n;i++){
            cin>>a[i];
          }
          res=0;
          dp[1]=1;
          for(i=2;i<=n;i++){
            if(a[i]>a[i-1]){
                dp[i]=dp[i-1]+1;
            }
            else{
                dp[i]=1;
            }
            res=max(res,dp[i]);
          }
          dpr[n]=1;
          res=max(res,(ll)1);
          for(i=n-1;i>=1;i--){
             if(a[i]<a[i+1])dpr[i]=dpr[i+1]+1;
             else dpr[i]=1;
             res=max(res,dpr[i]);
          }

          for(i=2;i<n;i++){
             if(a[i-1]<a[i+1]){
                res=max(res,dp[i-1]+dpr[i+1]);
             }
          }
          cout<<res<<endl;
       }
   // cout<<res<<endl;


Alhamdulillah
 }

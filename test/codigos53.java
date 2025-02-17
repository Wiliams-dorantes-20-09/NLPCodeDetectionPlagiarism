// Charan Sriramula

#include<bits/stdc++.h>
using namespace std;
typedef long double ld;
typedef long long int ll;

const ll logx=30;
const ll N=2e5+5;
const ll INF=1e18;
const ll mod=1e9+7;
const double PI = 3.14159265358979323846;

#define ints(n) scanf("%d",&n)
#define intp(n) printf("%d\n",n)
#define longs(n) scanf("%intd",&n)
#define longp(n) printf("%intd\n",n)

#define f first
#define s second
#define pb(x) push_back(x)
#define pf(x) push_front(x)
#define mp(x,y) make_pair(x,y)
#define GCD(a,b) __gcd((a),(b))
#define all(v) v.begin(),v.end()
#define bits(x) __builtin_popcount(x)
#define LCM(a,b) ((a)*(b))/GCD((a),(b))
#define ms(dp,val) memset(dp,val,sizeof(dp))
#define fast ios_base::sync_with_stdio(false);cin.tie(NULL);
template<typename T> T power(T x,T y,ll m){T ans=1;while(y>0){if(y&1LL) ans=(ans*x)%m;y>>=1ll;x=(x*x)%m;}return ans%m;}

int main()
{
  fast;
  ll q;
  cin>>q;
  while(q--)
  {
    ll n;
    cin>>n;
    string s;
    cin>>s;
    if(s.length()==2)
    {
      if(s[0]>=s[1]){cout<<"NO"<<endl;}
      else
      {
        cout<<"YES"<<endl;
        cout<<2<<endl;
        cout<<s[0]<<" "<<s[1]<<endl;
      }
    }
    else
    {
      cout<<"YES"<<endl;
      cout<<2<<endl;
      cout<<s[0]<<" ";
      for(ll i=1;i<n;i++){cout<<s[i];}
      cout<<endl;
    }
  }
}

#include <bits/stdc++.h>
#include<ext/pb_ds/assoc_container.hpp>
#include<ext/pb_ds/tree_policy.hpp>
// #include <boost/multiprecision/cpp_int.hpp> 

#define gc getchar//_unlocked
#define pc putchar//_unlocked
#define ll long long
#define ld long double
#define pb push_back
#define mp make_pair
#define pp pair<int,int>
#define ppl pair<ll,ll>
#define bigint boost::multiprecision::cpp_int
#define finp ios_base::sync_with_stdio(0);cin.tie(0);
#define bc __builtin_popcountll
#define afor(i,a,b) for(int i=a;i<=b;++i)
#define bfor(i,a,b) for(int i=a;i>=b;--i)
#define vi vector<int>
#define vpp vector<pp>
#define vll vector<ll>
#define fr first
#define se second

using namespace std;
using namespace __gnu_pbds;

char putnb[20];
void putn(ll n) {if(!n)pc('0');if(n<0)pc('-'),n=0-n;int pi=0;while(n)putnb[pi++]=(n%10)+'0',n/=10;while(pi)pc(putnb[--pi]);}
void sci(int *x) {register char c = gc();*x = 0;for(; (c<48)||(c>57);c = gc());for(; (c>47)&&(c<58);c = gc())*x = (int)((((*x)<<1) + ((*x)<<3)) + c - 48);}
void scll(ll *x)  {register char c = gc();*x = 0;for(; (c<48)||(c>57);c = gc());for(; (c>47)&&(c<58);c = gc())*x =  (ll)((((*x)<<1) + ((*x)<<3)) + c - 48);}
ll fp(ll a,ll b,ll c) {if(b==0)return 1%c; if(b==1)return a%c; ll ret=fp(a,b/2,c); ret=(ret*ret)%c; if(b&1)ret=(ret*a)%c; return ret;}

const ll mod=1e9 +7;
const ll mod2=1999999973;
const ll inf=1e18;
const int infs=1e9 + 1000;
const int N=100000;
const long double PI = acos(-1);

template <typename T>
using ordered_set = tree<T, null_type, less<T>, rb_tree_tag, tree_order_statistics_node_update>;



int main()
{
  finp;
  int n;
  cin>>n;
  int dp[n + 1];
  dp[0] = 0;
 
  int ans = -infs;
  int ans2 = 0;
  afor(i,1,n)
  {
    char s;
    cin>>s;
    if(s == '1')++ans2;

    dp[i] = dp[i - 1] + ((s == '0')?1:-1);

    if(s == '0')dp[i] = max(dp[i] ,1);
    else dp[i] = max(dp[i],-1);
    ans = max(ans,dp[i]);
  }

 

  cout<<ans+ans2;
  
return 0;
}
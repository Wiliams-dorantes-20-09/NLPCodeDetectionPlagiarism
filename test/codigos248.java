#include <bits/stdc++.h>
 
using namespace std;
 
#define SPEED ios::sync_with_stdio(false); cin.tie(0); cout.tie(0)
#define fileio freopen("in.in", "r", stdin),freopen("out.out", "w", stdout);
#define ll long long int
#define FF first
#define SS second
#define mp make_pair
#define pb push_back
#define pii pair<int,int>
#define pll pair<long long int,long long int>
#define sd(x) scanf("%d",&x)
#define slld(x) scanf("%lld",&x)
#define pd(x) printf("%d\n",x)
#define plld(x) printf("%lld\n",x)
#define pss printf
#define MOD 1000000007
#define INF 1e18
#define eps 0.00001
#define endl '\n'
#define debug(n1) cout<<n1<<endl
ll n;
string s;
 
int main() {
cin>>n;
cin>>s;
ll x=0,y=0;
ll ans=0;
for(int i=0;i<n;i++)
{
	if(s[i]=='U')y++;
	else x++;
	if(x==y&&i!=0&&i!=n-1&&s[i]==s[i+1])ans++;
}
cout<<ans<<endl;
	return 0;
           } 
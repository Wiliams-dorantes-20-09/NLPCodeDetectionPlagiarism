#include <bits/stdc++.h>
using namespace std;
#define pf push_front
#define pb push_back
#define FOR(i,begin,end) for (LL i=begin;i<=end;i++)
#define rep(i,t) for (LL i=0;i<t;i++)
#define ROF(i,begin,end) for (LL i=begin;i>=endp;i--)
#define pii pair<LL,LL>
#define X first
#define Y second  
typedef long long LL;
typedef unsigned long long int ulli;
const LL maxN=3e3+7,MOD=1e9+7,inf=1e9,N=3e5+7;
LL n,m,k,ans,c[maxN],x,y;
pii a[maxN];
int main()
{
	cin>>n>>m;
	FOR(i,1,n)
		cin>>a[i].X>>a[i].Y;
	sort(a+1,a+n+1);
	for(LL i=n;i>=1;i--)
	{
		x=a[i].X;
		y=a[i].Y;
		if(c[x+1]+y<=m)
			ans+=y,c[x+1]+=y;
		else
		{
			ans+=m-c[x+1];
			y-=m-c[x+1];
			c[x+1]=m;
			if(c[x]+y<=m)
				ans+=y,c[x]+=y;
			else
				ans+=m-c[x],c[x]=m;
		}
	}
	return cout<<ans<<"\n",0;
}	
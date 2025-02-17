//It’s never too late to become what you might have been....
 #include <iostream>
#include<bits/stdc++.h>
using namespace std;
#define ll long long int
#define inf 1000000000000
#define mod 1000000007
#define pb push_back
#define mp make_pair
#define all(v) v.begin(),v.end()
#define S second
#define F first
#define boost1 ios::sync_with_stdio(false);
#define boost2 cin.tie(0);
#define mem(a,val) memset(a,val,sizeof a)
#define endl "\n"
#define maxn 300001

ll tree[4*maxn],rght[maxn],p[maxn],l[maxn],store[maxn][21],nxt[maxn][21];

void update(ll node,ll a,ll b,ll ind,ll val)
{
	if(a>b || a>ind || b<ind)
	return;
	if(a==b)
	{
		tree[node]=val;
		return;
	}
	ll mid=(a+b)/2;
	if(ind<=mid)
	update(2*node,a,mid,ind,val);
	else
	update(2*node+1,mid+1,b,ind,val);
	tree[node]=max(tree[2*node],tree[2*node+1]);
}
ll query(ll node,ll a,ll b,ll l,ll r)
{
	if(a>b || a>r || b<l)
	return -inf;
	if(a>=l && b<=r)
	return tree[node];
	ll mid=(a+b)/2;
	return max(query(2*node,a,mid,l,r),query(2*node+1,mid+1,b,l,r));
}
int main()
{
	boost1;boost2;	
	ll i,j,n,q,x,y,lo,mid,hi,ans=0;
	cin>>n;
	for(i=1;i<=n;i++)
	cin>>p[i]>>l[i];
	for(i=n;i>=1;i--)
	{
		rght[i]=p[i]+l[i];
		if(p[n]<=p[i]+l[i])
		rght[i]=max(rght[i],query(1,1,n,i+1,n));
		else
		{
			lo=i;
			hi=n+1;
			while(hi-lo>1)
			{
				mid=(lo+hi)/2;
				if(p[mid]<=p[i]+l[i])
				lo=mid;
				else
				hi=mid;
			}
			if(p[lo+1]>p[i]+l[i] && p[lo]<=p[i]+l[i])
			rght[i]=max(rght[i],query(1,1,n,i+1,lo));
		}
		update(1,1,n,i,rght[i]);

		if(p[n]<=rght[i])
		nxt[i][0]=n+1;
		else
		{

			lo=i;
			hi=n;
			while(hi-lo>1)
			{
				mid=(lo+hi)/2;
				if(p[mid]>rght[i])
				hi=mid;
				else
				lo=mid;
			}
			nxt[i][0]=hi;
		}	
		store[i][0]=max(0LL,p[nxt[i][0]]-rght[i]);
	}
	nxt[n+1][0]=n+1;
	for(i=1;i<20;i++)
	{
		nxt[n+1][i]=n+1;
		for(j=1;j<=n;j++)
		{
			nxt[j][i]=nxt[nxt[j][i-1]][i-1];
			store[j][i]=store[j][i-1]+store[nxt[j][i-1]][i-1];
		}
	}
	cin>>q;
	while(q--)
	{
		cin>>x>>y;
		ans=0;
		for(i=19;i>=0;i--)
		{
			if(nxt[x][i]<=y)
			{
				ans+=store[x][i];
				//cout<<"HERE"<<" "<<ans<<endl;
				x=nxt[x][i];
			}
		}
		cout<<ans<<endl;
	}
	return 0;
}

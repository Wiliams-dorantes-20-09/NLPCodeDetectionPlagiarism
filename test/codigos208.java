#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define fl(i,a,b) for(int i=a;i<b;i++)
#define mx 100005
#define endl '\n'
#define ff first
#define ss second
#define pb push_back
#define inf 1000000000
#define mod 1000000007
#define fast ios_base::sync_with_stdio(0);cin.tie(NULL);cout.tie(NULL);
#define mx 200005
int arr[mx];
bool vis[mx];
int cont[mx];
int cnt = 0;
void dfs(int x)
{
	vis[x] = 1;
	cnt++;
	int nx = arr[x];
	//cout<<x<<" " <<nx<<endl;
	if(!vis[nx])
	{
		dfs(nx);
	}
	cont[x] = cnt;
}
main()
{
	fast;
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		fl(i,1,n+1)
		{
			cin>>arr[i];
			vis[i] = 0;
			cont[i] = 0;
		}
		fl(i,1,n+1)
		{
			if(!vis[i])
			{
				cnt = 0;
				dfs(i);
				//cout<<cnt<<" ";
			}
		}
		fl(i,1,n+1)
		{
			cout<<cont[i]<<" ";
		}
		cout<<endl;
	}
}
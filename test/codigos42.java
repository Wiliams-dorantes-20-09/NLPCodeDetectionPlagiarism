// Sandy and Nuts! XD
#include <bits/stdc++.h> 
using namespace std;
#define fl(i,a,b) for(int i=a;i<b;i++)
#define rfl(i,a,b) for(int i=b-1;i>=a;i--)
#define ll long long
#define endl '\n'
#define pb push_back
#define ff first
#define ss second
#define mod 1000000007
#define mx 300005
#define mx2 20
#define inf 1e18
#define fast ios_base::sync_with_stdio(0);cin.tie(NULL);cout.tie(NULL);
main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		string s1,s2;
		cin>>s1>>s2;
		vector<pair<int,int> > v;
		bool flag = 1;
		fl(i,0,n)
		{
			if(s1[i] == s2[i])continue;
			bool f = 0;
			fl(j,i+1,n)
			{
				if(s1[i] == s2[j])
				{
					swap(s2[j],s1[j]);
					v.pb(make_pair(j,j));
					f = 1;
					break;
				}
			}
			fl(j,i+1,n)
			{
				if(s1[i] == s1[j])
				{
					swap(s2[i],s1[j]);
					v.pb(make_pair(j,i));
					f = 1;
					break;
				}
			}
			if(f == 0)
			{
				flag = 0;
				break;
			}
		}
		if(flag == 0)
		{
			cout<<"No"<<endl;
		}
		else
		{
			cout<<"Yes"<<endl;
			cout<<v.size()<<endl;
			fl(i,0,v.size())
			{
				cout<<v[i].ff + 1<<" "<<v[i].ss+1<<endl;
			}
		}
	}
}
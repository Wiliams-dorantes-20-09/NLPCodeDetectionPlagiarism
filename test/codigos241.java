#include <iostream>
#include <cmath>
#include <algorithm>
#include <string.h>
#include <cstdio>
#include <string>
#include <map>
#include <set>
#include <vector>
using namespace std;
 
#define FOR(i,a,b) for(int i=a;i<=b;++i)
#define sz(s) (int)s.size()
#define pb push_back
#define mp make_pair
#define sqr(x) (x)*(x)
typedef long long Int;
const int inf=1000000000;
const int MOD=1000000007;


string s,cur;
vector<string>res;
int main()
{
	//freopen("input.txt","r",stdin);
	getline(cin,s);
	res.clear();

	cur="";
	for(int i=0;i<=sz(s);++i)
	{
		if(i==sz(s) || (i && s[i-1]=='@'))
		{
			if(i==sz(s))res.pb(cur);else
			{
				cur+=s[i];
				res.pb(cur);
				cur="";
			}
		}else
		{
			cur+=s[i];
		}
	}

	cur=res[sz(res)-1];
	res.pop_back();
	if(res.empty()){cout<<"No solution"<<endl;return 0;}
		res[sz(res)-1]+=cur;

	//FOR(i,0,sz(res)-1)cout<<res[i]<<" ";cout<<endl;

	FOR(i,0,sz(res)-1)
		if(sz(res[i])==0 || res[i][0]=='@' || res[i][sz(res[i])-1]=='@'){cout<<"No solution"<<endl;return 0;}

	FOR(i,0,sz(res)-1)
	{
		cout<<res[i];
		if(i!=sz(res)-1)cout<<",";
	}
	cout<<endl;
} 

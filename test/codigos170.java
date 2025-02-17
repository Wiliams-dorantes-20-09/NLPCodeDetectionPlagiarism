#include "bits/stdc++.h"
#pragma GCC optimize ("O3")
#pragma GCC target ("sse4")

#ifdef PRINTERS
#include "printers.hpp"
using namespace printers;
#define tr(a)		cerr<<#a<<" : "<<a<<endl
#else
#define tr(a)    
#endif

#define ll          long long
#define pb          push_back
#define mp          make_pair
#define pii         pair<int,int>
#define vi          vector<int>
#define all(a)      (a).begin(),(a).end()
#define F           first
#define S           second
#define sz(x)       (int)x.size()
#define hell        1000000007
#define endl        '\n'
#define rep(i,a,b)	for(int i=a;i<b;i++)
using namespace std;

void solve(){
	{
		string s;
		cin>>s;
		int k=sz(s);
		k--;
		while(k%2){
			k--;
		}
		string curans=string(k,'9');
		k=sz(s);
		if(k%2){
			cout<<curans<<endl;
			return;
		}
		bitset<10>b;
		b.reset();
		for(auto i:s){
			b.flip(i-'0');
		}
		for(int i=k-1;i>=0;i--){
			b.flip(s[i]-'0');
			for(int j=s[i]-'0'-1;j>=0;j--){
				b.flip(j);
				int positions_left=k-1-i;
				int oddcnt=b.count();
				if(oddcnt<=positions_left){
					s[i]=j+'0';
					for(int v=i+1;v<sz(s);v++){
						s[v]='9';
					}
					int cur=sz(s)-1;
					for(int g=0;g<10;g++){
						if(b[g]==0)continue;
						s[cur]=g+'0';
						b.flip(g);
						cur--;
					}
					if(s[0]=='0'){
						cout<<string(k-2,'9')<<endl;
						return;
					}
					cout<<s<<endl;
					return;
				}
				b.flip(j);
			}
		}
		cout<<string(k-2,'9')<<endl;
	}
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int t=1;
	cin>>t;
	while(t--){
		solve();
	}
	return 0;
}
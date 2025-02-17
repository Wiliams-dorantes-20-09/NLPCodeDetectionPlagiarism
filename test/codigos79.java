#include <algorithm>
#include <bitset>
#include <cassert>
#include <climits>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <deque>
#include <iomanip>
#include <iostream>
#include <map>
#include <numeric>
#include <queue>
#include <set>
#include <stack>
#include <string>

#ifdef PRINTERS
#include "printers.hpp"
using namespace printers;
#define tr(a)		cerr<<#a<<": "<<a<<endl;
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
vi dp;
vi x;
vi minseg;
vi maxseg;
vi ans;
void build(int pos,int l,int r){
	if(l==r){
		maxseg[pos]=x[l];
		minseg[pos]=x[l];
	}
	else{
		int mid=l+(r-l)/2;
		build(pos*2+1,l,mid);
		build(pos*2+2,mid+1,r);
		maxseg[pos]=max(maxseg[pos*2+1],maxseg[pos*2+2]);
		minseg[pos]=min(minseg[pos*2+1],minseg[pos*2+2]);
	}
}

int querymin(int pos,int l,int r,int a,int b){
	if(l>b or r<a)return INT_MAX;
	if(l>=a and r<=b)return minseg[pos];
	int mid=l+(r-l)/2;
	return min(querymin(pos*2+1,l,mid,a,b),querymin(pos*2+2,mid+1,r,a,b));
}
int querymax(int pos,int l,int r,int a,int b){
	if(l>b or r<a)return INT_MIN;
	if(l>=a and r<=b)return maxseg[pos];
	int mid=l+(r-l)/2;
	return max(querymax(pos*2+1,l,mid,a,b),querymax(pos*2+2,mid+1,r,a,b));
}
void update(int pos,int l,int r,int idx,int val){
	if(idx>r or idx<l)return;
	if(l==r){
		minseg[pos]=val;
	}
	else{
		int mid=l+(r-l)/2;
		update(pos*2+1,l,mid,idx,val);
		update(pos*2+2,mid+1,r,idx,val);
		minseg[pos]=min(minseg[pos*2+1],minseg[pos*2+2]);
	}
}
void solve(){
	int n,s,l;
	cin>>n>>s>>l;
	x.resize(n);
	dp.resize(n);
	minseg.resize(4*n);
	maxseg.resize(4*n);
	ans.resize(n);
	rep(i,0,n)cin>>x[i];
	build(0,0,n-1);
	rep(i,0,n){
		int lo=i;
		int hi=n;
		while(hi-lo>1){
			int mid=lo+(hi-lo)/2;
			if(querymax(0,0,n-1,i,mid)-querymin(0,0,n-1,i,mid)<=s){
				lo=mid;
			}
			else{
				hi=mid;
			}
		}
		dp[i]=lo;
	}
	minseg.clear();
	minseg.resize(4*n);
	for(int i=n-1;i>=0;i--){
		if(i+l-1>dp[i]){
			ans[i]=1e9+5;
		}
		else if(n>=i+l and n<=dp[i]+1){
			ans[i]=1;
		}
		else{
			ans[i]=querymin(0,0,n-1,i+l,dp[i]+1)+1;
		}
		update(0,0,n-1,i,ans[i]);
	}
	if(ans[0]>1e9)cout<<-1;
	else cout<<ans[0];
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int t=1;
//	cin>>t;
	while(t--){
		solve();
	}
	return 0;
}
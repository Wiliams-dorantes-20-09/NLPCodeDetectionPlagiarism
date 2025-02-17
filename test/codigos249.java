#include<iostream>
//#include <bits/stdc++.h>
using namespace std;
#include<algorithm>
#include<map>
#include<vector>
#include <iomanip>
#include <set>
#include<cmath>
#define F first
#define S second
#define pii pair<int,int>
#define pb push_back
#define int long long
#define mp make_pair
#define error(x) cout<<#x<<"="<<(x)<<endl;
void sp(double y,int x){cout<<fixed<<setprecision(x)<<y;}
int inf=1e9+10;
int const M=2e5+10;
int const M2=1e6+10;
int const M3=1e3+10;
int mod=1e9+7;
int ans=0;
int cnt[M];
int l[M],r[M],a[M],hlp[M];
pair<pii,int>cur[M];
int sq=400;
bool cmp(pair<pii,int> a,pair<pii,int> b)
{
    if(a.F.F/sq!=b.F.F/sq)
        return a.F.F<b.F.F;
    return a.F.S<b.F.S;
}
void del(int x)
{
    if(x>1e5)
        return;
    cnt[x]--;
    if(cnt[x]==x-1)
        ans--;
    if(cnt[x]==x)
        ans++;
}
void inc(int x)
{
    if(x>1e5)
        return;
    cnt[x]++;
    if(cnt[x]==x+1)
        ans--;
    if(cnt[x]==x)
        ans++;
}
void update(int l,int r,int l2,int r2)
{
    if(l>l2)
        for(int i=l2;i<l;i++)
            del(a[i]);
    if(l2>l)
        for(int i=l;i<l2;i++)
            inc(a[i]);
    if(r>r2)
        for(int i=r2+1;i<=r;i++)
            inc(a[i]);
    if(r<r2)
        for(int i=r+1;i<=r2;i++)
            del(a[i]);
}
int sa(int x,int y){if(x%y==0)return x/y;return x/y+1;}
int binp(int x,int y){int ans=1;int t=x;while(y!=0){if(y%2==1){ans*=t;ans;}y/=2;t*=t;t;}return ans;}
main(){
	ios::sync_with_stdio(0) , cin.tie(0) , cout.tie(0);
	int n,q;
	cin>>n>>q;
	for(int i=1;i<=n;i++)
    {
        cin>>a[i];
    }
    for(int i=1;i<=q;i++)
        cin>>cur[i].F.F>>cur[i].F.S,cur[i].S=i;
    sort(cur+1,cur+q+1,cmp);
    for(int i=1;i<=q;i++)
    {
        l[i]=cur[i].F.F,r[i]=cur[i].F.S;
    }
    for(int i=1;i<=q;i++)
    {
        if(i==1)
        {
            for(int j=l[i];j<=r[i];j++)
            {
                if(a[j]>1e5)
                    continue;
                cnt[a[j]]++;
                if(cnt[a[j]]==a[j])
                    ans++;
                else if(cnt[a[j]]==a[j]+1)
                    ans--;
            }
        }
        else
        {
            update(l[i],r[i],l[i-1],r[i-1]);
        }
        hlp[cur[i].S]=ans;
    }
    for(int i=1;i<=q;i++)
        cout<<hlp[i]<<"\n";
}
//submitted by HimJ
#include<bits/stdc++.h>
#define ll long long
#define mod 1000000007
#define pb push_back
#define fi first
#define se second
#define fr(i,s,e) for(i=s;i<e;i++)
#define ms(arr,val) memset(arr,val,sizeof(arr))
using namespace std;
const int mxn=1e5+1;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
  ll t=1;
  //cin>>t;
    while(t--){
            int n,i,a=-1,b=-1;
            int ca=0,cb=0;
    cin>>n;
    int x;
    fr(i,0,n)
    {
        cin>>x;
        if(a==-1||a==x)
            a=x;
        else if(b==-1)
            b=x;
        if(a==x)
            ca++;
        else if(b==x)
            cb++;
    }
    if(ca==cb&&(ca+cb==n))
    {
        cout<<"YES\n";
        cout<<a<<" "<<b;
    }
    else cout<<"NO";

    }
  return 0;
  }


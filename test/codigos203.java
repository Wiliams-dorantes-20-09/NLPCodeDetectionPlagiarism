/*
   Salim Shebli
   Russian,Syrian
   Faculty Of Information Technology
   University of Damascus
   Game Developer
 */
#include <bits/stdc++.h>
#define ll long long
#define mp make_pair
#define pb push_back

using namespace std;
ll k1,k2,k3;
ll nm[200100];
vector<ll>ww[4];
ll dp1[200100];
ll dp2[200100];
int main()
{
 ios::sync_with_stdio(false);
    cin>>k1>>k2>>k3;
    for(int i=0;i<k1;i++)
    {
        ll a;
        cin>>a;
        nm[a]=1;
        ww[1].pb(a);
    }
     for(int i=0;i<k2;i++)
    {
        ll a;
        cin>>a;
        nm[a]=2;
        ww[2].pb(a);
    }
     for(int i=0;i<k3;i++)
    {
        ll a;
        cin>>a;
        nm[a]=3;
        ww[3].pb(a);
    }
    ll rr=k1+k2;
    ll vv=0;
    ll mm=0;
    ll sol=9999999999;
    ll n=k1+k2+k3;
    for(int i=0;i<=n;i++)
    {
        if(nm[i]==3)
        {
            vv++;
        }
        else if(i!=0)
        {
            rr--;
        }
       // cout<<i<<endl;
       // cout<<rr<<" "<<vv<<endl;
        if(i!=0)
        {
            dp2[i]=dp2[i-1];
            dp1[i]=dp1[i-1];
            if(nm[i]==2)
            {
                dp2[i]++;
            }
            else if(nm[i]==1)
            {
                dp1[i]++;
            }
         //   cout<<dp1[i]<<" "<<dp2[i]<<" ";
            mm=min(dp2[i]-dp1[i],mm);
          //  cout<<mm<<endl;
            sol=min(sol,dp1[i]+mm+(rr+vv));
        }
        else
        {
            sol=min(sol,rr+vv);
         //   cout<<sol<<endl;
        }
    }
    cout<<sol<<endl;
    return 0;
}

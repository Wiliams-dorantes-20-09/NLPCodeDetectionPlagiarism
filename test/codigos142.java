#include<bits/stdc++.h>
using namespace std;
 
typedef long long int ll;
typedef long double ld;
typedef vector<ll> vec;
 
#define LM LLONG_MAX
#define int long long int
 
#define ff first
#define ss second
 
#define FAST ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define endl "\n"
 
#define M 1
#define MOD 1000000007

signed main()
{
        FAST;
        
        ll n;
        cin>>n;
        
        vec a(n);
        
        for(int i=0;i<n;i++)   cin>>a[i];
        
        sort(a.begin(),a.end());
        
        if(a[n-1]<a[n-2]+a[0])
        {
                cout<<"YES"<<endl;
                for(int i=0;i<n;i++)   cout<<a[i]<<" ";
        }
        else if(a[n-1]<a[n-2]+a[n-3])
        {
                cout<<"YES"<<endl;
                for(int i=0;i<n-2;i++)    cout<<a[i]<<" ";
                cout<<a[n-1]<<" "<<a[n-2];
        }
        else
        {
                cout<<"NO";
        }
        
}
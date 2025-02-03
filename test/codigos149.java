#include <bits/stdc++.h>
#include<string>
using namespace std;
        
    #define ll long long
    #define do double
    #define ff first
    #define ss second
    #define FOR(a,n) for(ll ii=0;ii<n;ii++){    cin>>a[ii];}
    #define pb push_back
    #define mp make_pair
    #define inf LONG_LONG_MAX
    #define mod  998244353
    #define FAST ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
        
ll d,x,y;

void extendedEuclid(ll A, ll B) 
{
    if(B == 0) 
    {
         d = A;
         x = 1;
         y = 0;
    }
    else 
    {
        extendedEuclid(B, A%B);
        int temp = x;
        x = y;
        y = temp - (A/B)*y;
    }
}

ll power(ll x,ll y, ll p) 
{ 
    ll res = 1; 
    x = x % p;
    while (y > 0) 
    {  // If y is odd, multiply x with result 
        if (y & 1) 
            res = (res*x) % p;
                    
        y = y>>1; 
        x = (x*x) % p;   
    } 
    return res; 
} 

ll IsPrime(ll n)
{
    if(n==0||n==1)
        return n;
    if(n%2==0)
        return (ll)2;
    if(n%3==0)
        return (ll)3;
    else
    {
        for(ll i=5;i*i<=n;i+=6)
        {
            if(n%i==0)
                return i;
            if(n%(i+2)==0)
                return (i+2);
        }
        return n;
    }
}
ll min(ll a,ll b)
{
	if(a<b)
		return a;
	return b;
}

ll max(ll a,ll b)
{
	if(a<b)
		return b;
	return a;
}

bool comp(pair<ll,ll> a,pair<ll,ll> b)
{
	if(a.ff!=b.ff)
		return a.ff>b.ff;

	return a.ss<b.ss;
}

int main()
{
   FAST
   ll n,m,q,k,i,j;
   cin>>q;
   while(q--)
   {
   		string s;
   		cin>>s;
   		n=s.size();
   		i=0;
   		ll c=0;
   		ll ans=0;
   		while(i<n)
   		{
   			if(s[i]=='0')
   			{
   				i++;
   				c++;
   				continue;
   			}
   			ll num=0;
   			j=i;
   			//cout<<c<<"  ";
   		
   			while(c+j-i+1>=num && j<n)
   			{	//cout<<num<<" ";
   					ans++;
   				num=0;
   				j++;
   				if(j==n)
   				break;
   				 for(k=j;k>=i;k--)
   				 if(s[k]=='1')
   				 	num+=pow(2,j-k);
   				
   			}
   			//cout<<"\n";
   			//cout<<j<<" "<<ans<<endl;
   			c=0;
   			i++;
   			
   		}
   		cout<<ans<<endl;
   }



}

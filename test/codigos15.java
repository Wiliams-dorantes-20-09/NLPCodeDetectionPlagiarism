/**
*
* Author: MARS
* Lang: GNU C++14
*
**/

#include<bits/stdc++.h>
using namespace std;

#define F first
#define S second
#define ii pair < int , int >
#define LS pair < ll , string >

typedef unsigned long long ull;
typedef long double ldbl;
typedef long long ll;
typedef double dbl;

const ldbl E = 2.71828182845904523536;
const ldbl pi = acos(-1);
const dbl eps = 1e-9;
const ll mod = 1e9+7;
const ll inf = 1LL<<30;

/** /////////// ** Code ** /////////// **/

const int N=100100;
ll mx=4*(1e18);
map<ll,ll>mp;
vector<ll>v;
ll a[N];
int n;

bool ok(ll x){
    mp.clear();
    for(int i=0 ; i<n ; i++)
        mp[a[i]]++;

    v.push_back(x);
    mp[x]--;

    while(1){
        if(x < mx && mp[2*x]){
            v.push_back(2*x);
            mp[2*x]--;
            x*=2;
        }

        else if(x%3 == 0 && mp[x/3]){
            v.push_back(x/3);
            mp[x/3]++;
            x/=3;
        }

        else break;
    }

    return v.size() == n;

}

int main()
{
    scanf("%d",&n);

    for(int i=0 ; i<n ; i++)
        scanf("%lld",&a[i]);

    for(int i=0 ; i<n ; i++){
        v.clear();
        if(ok(a[i])){
            for(auto x:v)
                printf("%lld ",x);

            return 0;
        }
    }

    return 0;
}

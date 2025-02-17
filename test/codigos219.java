#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const ll mod = 1e9 + 7;
const ll N = 2e5 + 5;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    ll n,z;
    cin>>n>>z;

    ll arr[n];
    for(ll i=0;i<n;i++)
        cin>>arr[i];

    sort(arr,arr+n);
    ll l = 0;
    ll r = n/2 + 1;

    while(r-l>1){
        ll mid = (l+r)>>1;
        bool flg=true;
        for(ll i=0;i<mid;i++)
            if(arr[n-mid+i]-arr[i]<z)
                flg=false;
        if(flg)
            l=mid;
        else
            r=mid;
    }
    cout<<l;
}

#include<bits/stdc++.h>
using namespace std;


using ll = long long;
const int N = 1e5 + 5;
const ll mod = 1e9 + 7;

int p[N] , sz[N];

set < ll > st;

int get(int x){
    if(x == p[x])return x;
    return  p[x] = get(p[x]);
}

void join(int x , int y){
    x = get(x);
    y = get(y);

    if(x == y)return;

    if(sz[x] < sz[y])swap(x , y);
    sz[x] += sz[y];
     p[y]  = x;
}

ll power(ll x , ll y){
    if(x == 0)return 0;
    ll res = 1ll;

    x %= mod;
    while(y > 0){
        if(y&1)
            res = (res * x) % mod;
        y >>= 1;
        x = (x*x)%mod;
    }
    return res;
}

main(){

    for(int i = 0 ; i < N ; i ++){p[i] = i;sz[i] = 1;}

    int n , k;
    scanf("%d %d" , &n , &k);

    int u , v , c;
    for(int i = 1 ; i < n ; i ++){
        scanf("%d %d %d" , &u , &v , &c);
        if(c == 0){
            join(u , v);
        }
    }

    for(int i = 1 ; i <= n ; i ++){
        st.insert(get(i));
    }

    ll sum = 0;
    for(auto S : st){
        sum = (sum + power(sz[S], k)) % mod;
    }

    printf("%lld\n" , (power(n , k) - sum + mod) % mod);

    return 0;
}

#include <bits/stdc++.h>
#define ll long long int
#define pb push_back
#define endl '\n'
#define Endl '\n'
#define fi first
#define ii pair<ll,ll>
#define iii pair<ll, pair<ll, ll> >
#define se second
#define ld long double
#define mod 1000000007
#define popcount __builtin_popcountll
#define PI acos(-1.0)
using namespace std;
bool has[222];
int main(){
    int t;
    cin>>t;
    while(t--){
        int n, x;
        cin>>n>>x;
        memset(has,0,sizeof has);
        for(int i=0;i<n;i++){
            int xx;
            scanf("%d", &xx);
            has[xx] = 1;
        }
        int amid = 0;
        for(int i=1;;i++){
            if(has[i])continue;
            if(x){
                x--;
                continue;
            }
            amid = i-1;
            break;
        }
        printf("%d\n", amid);
    }
}

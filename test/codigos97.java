#include <bits/stdc++.h>
#define F first
#define S second
#define all(a) a.begin(),a.end()
#define setDP(arr) memset(arr,-1,sizeof arr)
#define oo 2000000000
#define inf 1400000000000000000LL
#define M1 1000000007
#define M2 1000000009
#define P1 29
#define P2 31
typedef long long ll;
using namespace std;
const int N = 355001;
const double PI = acos(-1);

ll n , k , ctr ;

signed main(){
    #ifndef ONLINE_JUDGE
        freopen("in.txt","r",stdin);
    #endif
    cin >> n >> k ;
    for(int i = 0 ; i < n ; i++){
        ctr++;
        if((ctr*(ctr+1)/2)-k==n-ctr){
            cout << n-ctr << endl;
            break;
        }
    }




}

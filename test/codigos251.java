#include <bits/stdc++.h>
//#pragma GCC optimize("Ofast")

#define fi first
#define se second
#define LL long long

using namespace std;

const int N = 1e5 + 7;
const int mod = 1e9 + 7;
const int B = 317;

int n,k;
int p[N];
int a[5][N];

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    //freopen( "input.txt" , "r" , stdin );
    //freopen( "output.txt" , "w" , stdout );

    cin >> n >> k;
    for( int i = 1; i <= n; i++ ){
        int x = 0;
        for( int j = 1; j <= k; j++ ){
            cin >> a[j][i];
            x = x * 2 + a[j][i];
        }
        p[x]++;
    }
    for( int i = 0; i < (1 << k); i++ ){
        for( int j = 0; j < (1 << k); j++ ){
            if( p[i] && p[j] && ((i & j) == 0) ){
                cout << "YES";
                return 0;
            }
        }
    }
    cout << "NO";
}

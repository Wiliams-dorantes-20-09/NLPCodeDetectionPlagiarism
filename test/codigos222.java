#include<bits/stdc++.h>
using namespace std;
#define mxs ( int )(1e6)
int n , ans , mi , mx , x , t , c , a , i , j ;
vector < int > v [ mxs ];
map < int , int  > mp;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cin>>n;
    for ( i = 1; i <= n; i++ )
    {
        cin>>a;
        mp [ a ]++;
        mx = max( mp [ a ] , mx );
    }
    cout<<n-mx;
    return 0;
}


#include <bits/stdc++.h>
using namespace std;

#define F first
#define S second
#define ll long long
#define ld long double
#define vi   vector<int>
#define pii pair<int, int>
#define ull unsigned long long
#define sz(v)  ((int)((v).size()))
#define all(v) ((v).begin()),((v).end())
#define MEM(dp,i) memset(dp ,i, sizeof (dp))
#define repit( cont , i  ) for( auto i : cont)
#define forr(c,x,n)   for(ll c=x;c<=(ll)n; ++c )
#define forrr(c,x,n)  for(ll c=x;c>=( ll )n ;--c )
#define db(x) cout << " LOOK " <<(#x) <<" = " <<  x << '\n'
#define ICPC ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
#define printarr(a , l , r ) forr ( i , l , r )cout << a[i] << " ";cout<<endl;
#define printarr2(a, n , m) forr ( i , 1 , n){forr ( j , 1, m )cout << a[i][j] << " ";cout<<endl;}

//freopen("input.txt", "r", stdin);
//freopen("output.txt", "w", stdout);

int main()
{
ICPC;
pair<int ,int > a[5007];
int n ;
cin >> n ;
for (int i = 0 ; i < n ; i++ )
{
    cin >> a[i].F >> a[i].S;
}
sort( a , a+n);

int l = 0 ;
for ( int i = 0 ; i < n ; i++ )
{
    if ( a[i].S < a[i].F)
        swap( a[i].S , a[i].F );
    if ( a[i].F >= l )
        l = a[i].F ;
    else
        l = a[i].S;
}
cout << l ;
}

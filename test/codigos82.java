#include <bits/stdc++.h>
#define pb push_back
#define se second
#define fr first
#define sc scanf
#define sz size
#define pr printf
#define ll long long
#define sq(n) n * n
#define cube(n) n * n * n
#define fin(s) freopen( s, "r", stdin )
#define fout(s) freopen( s, "w", stdout )
#define TIME ios_base::sync_with_stdio(0)
using namespace std;

const ll N = 1e2 + 6;

int n, m;
char a[N][N], d[N][N];
int k, l;
bool f, f1;
char rev( char a ){
    if( a == 'L' )return 'R';
    return 'L';
}
char rev1( char a ){
    if( a == 'D' )return 'U';
    return 'D';
}
bool can( char x ){
    if( x == '0' )return 1;
    else return 0;
}
void dfs( int x, int y ){
    if( a[x][y] == 'F' ){ f = 1; return; }
    if( f == 1 )return;
    if( x + 1 <= n && a[x + 1][y] != '*' && can( d[x + 1][y] ) )d[x + 1][y] = 'D', dfs( x + 1, y );
    if( x - 1 > 0 && a[x - 1][y] != '*' && can( d[x - 1][y] ) )d[x - 1][y] = 'U', dfs( x - 1, y );
    if( y + 1 <= m && a[x][y + 1] != '*' && can( d[x][y + 1] ) )d[x][y + 1] = 'R', dfs( x, y + 1 );
    if( y - 1 > 0 && a[x][y - 1] != '*' && can( d[x][y - 1] ) )d[x][y - 1] = 'L', dfs( x, y - 1 );
}
main() {
    cin >> n >> m;
    for( int i = 1; i <= n; i ++ ){
        for( int j = 1; j <= m; j ++ ){
            cin >> a[i][j];
            d[i][j] = '0';
            if( a[i][j] == 'F' )k = i, l = j;
        }
    }
    dfs( 1, 1 );
    vector < char > s;
    while( k > 1 || l > 1 ){
        s.pb( d[k][l] );
        if( d[k][l] == 'U' )k++;
        else if( d[k][l] == 'D' )k--;
        else if( d[k][l] == 'R' )l--;
        else if( d[k][l] == 'L' )l++;
    }
    reverse( s.begin(), s.end() );
    int x, y, x1 = 1, y1 = 1;
    f = 0;
    for( int i = 0; i < s.size(); i ++ ){
        auto k = s[i];
        if( k == 'R' || k == 'L' ){
            //cout << 1 << ' ';
            if( f1 )cout << rev( k ) << endl;
            else cout << k << endl;
        }
        else {
            //cout << 2 << ' ';
            if( f )cout << rev1(k) << endl;
            else cout << k << endl;
        }
        cin >> x >> y;
        if( x == x1 && y == y1 ){
            if( k == 'L' || k == 'R' )f1 = 1;
            else f = 1;
            i--;
        }
        y1 = y;
        x1 = x;
        //cout <<
    }
}

#include <bits/stdc++.h>
#define ll long long
#define ull unsigned long long
#define pb push_back
#define popb pop_back
#define fo(i , a , b) for (int i = (a); i < (b); ++i)
#define forr(i , b) fo( i , 0 , b )
#define carr( n , array ) forr(i , n) cin >> array[i]
#define cmap( n , map ) forr (i , n) {ll x ; cin >> x ; map [x] ++ ; }
#define cpmap( n , map ) forr (i , n) {ll x , y ; cin >> x >> y ; map [x] = y ; }
#define F first
#define S second
#define IF ->first
#define IS ->second

const ll max9 = 10 + 1e9 ,  max6 = 10 + 1e6 , max12 = 10 + 1e12 , max15 = 10 + 1e15 ;
const ll min6 = -1 * max6 , min9 = -1 * max9 , min12 = -1 *max12 , min15 = -1 * max15 ;
const ll R = 7 + 1e9 , NN = 10 + 1e5 ;
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    string s ; cin >> s ; cout << s ; forr (i , s.size()) cout << s[s.size() - 1 - i] ;
    return 0;
}

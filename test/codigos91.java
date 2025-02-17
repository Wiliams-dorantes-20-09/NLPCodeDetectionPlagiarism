#include <bits/stdc++.h>

using namespace std;

#define pb push_back
#define mp make_pair
#define ff first
#define ss second

typedef long long int ll;
typedef vector< pair<int, int> > vii;
typedef vector<int> vi;
typedef vector<vi> vvi;
typedef vector<long long int> vll;
typedef pair<int, int> pii;

const ll INF = 1e18;
const int inf = 1e9;
const int MOD = 1e9 + 7;
const int nax = 1000000 + 10;

int a00, a01, a10, a11, o = -1, z = -1, ones, zeroes;

int main()
{
    ios::sync_with_stdio(0);
    cin >> a00 >> a01 >> a10 >> a11;
    if(a00 == 0 && a01 == 0 && a10 == 0 && a11 == 0)
    {
        cout << 1;
        return 0;
    }
    for(int i = 0; i <= 1e5; i++)
    {
        int num = (i * (i - 1)) / 2;
        if(num == a00)
            {
                z = i;
                break;
            }
    }
     for(int i = 0; i <= 1e5; i++)
    {
        int num = (i * (i - 1)) / 2;
        if(num == a11)
            {
                o = i;
                break;
            }
    }
    if(z == -1 || o == -1)
    {
        cout << "Impossible";
        return 0;
    }
    if(a01 != 0 || a10 != 0)
    {
        if(z == 0) z++;
        if(o == 0) o++;
    }
    if(z * o != a01 + a10)
    {
        cout << "Impossible";
        return 0;
    }
    string ans = "";
    while(z || o)
    {
        // try to put a zero;
        if(z && a01 >= o)
        {
            ans += '0';
            z--, a01 -= o;
        }
        else
        {
            ans += '1';
            o--, a10 -= z;
        }
    }
    cout << ans;
    return 0;
}

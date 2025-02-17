/**
*     ________   ________   ___        ________          ________   ___        ________       ___    ___  _______    ________
*    |\   ____\ |\   __  \ |\  \      |\   __  \        |\   __  \ |\  \      |\   __  \     |\  \  /  /||\  ___ \  |\   __  \
*    \ \  \___|_\ \  \|\  \\ \  \     \ \  \|\  \       \ \  \|\  \\ \  \     \ \  \|\  \    \ \  \/  / /\ \   __/| \ \  \|\  \
*     \ \_____  \\ \  \\\  \\ \  \     \ \  \\\  \       \ \   ____\\ \  \     \ \   __  \    \ \    / /  \ \  \_|/__\ \   _  _\
*      \|____|\  \\ \  \\\  \\ \  \____ \ \  \\\  \       \ \  \___| \ \  \____ \ \  \ \  \    \/  /  /    \ \  \_|\ \\ \  \\  \|
*        ____\_\  \\ \_______\\ \_______\\ \_______\       \ \__\     \ \_______\\ \__\ \__\ __/  / /       \ \_______\\ \__\\ _\
*       |\_________\\|_______| \|_______| \|_______|        \|__|      \|_______| \|__|\|__||\___/ /         \|_______| \|__|\|__|
*       \|_________|                                                                        \|___|/
*/

#include <ext/rope>
#include <bits/stdc++.h>
#include <ext/pb_ds/tree_policy.hpp>
#include <ext/pb_ds/assoc_container.hpp>
using namespace std;
using namespace __gnu_cxx;
using namespace __gnu_pbds;

template<class T> using ordered_set = tree<T, null_type, less<T>, rb_tree_tag,tree_order_statistics_node_update>;

#define ll long long
#define ull unsigned long long
typedef vector<vector<ll>> mat;

const int N = 1e5 + 5;
ll n , a[N] , b[N];

ll solve(ll a[N] , ll b[N])
{
    priority_queue<ll> f , s;
    for(int i = n - 1 ; i >= 0 ; i--)
    {
        ll gf = f.size() ? f.top() : 0;
        ll gs = s.size() ? s.top() : 0;

        f.push(gs + a[i]);
        s.push(gf + b[i]);
    }

    return max(f.top() , s.top());
}

int main()
{
    ios::sync_with_stdio(0) , cin.tie(0) , cout.tie(0);

    cin >> n;
    for(int i = 0 ; i < n ; i++) cin >> a[i];
    for(int i = 0 ; i < n ; i++) cin >> b[i];
    cout << solve(a , b);

    return 0;
}

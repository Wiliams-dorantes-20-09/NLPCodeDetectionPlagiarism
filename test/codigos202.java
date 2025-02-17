#include <bits/stdc++.h>
#define ll long long
#define ld long double
#define pi pair<int, int>
#define F first
#define S second
#define pb push_back
#define mp make_pair
#define PI acos(-1.0)
using namespace std;
ll t, a, b;
int power[5000500];
bool seive[5000500];
set<ll> st;
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    for (ll i=2; i*i <= 5000000; i++)
        if (!seive[i]){
            //st.insert(i);
            for (ll j = 2*i; j <= 5000000; j += i)
                seive[j] = true;
        }
        
    for (ll i=2; i<=5000000; i++)
        if (!seive[i]) st.insert(i);

    for(auto i : st)
        for (ll j = i; j<=5000000; j *= i)
            for (ll k = j; k <= 5000000; k += j)
                power[k]++;

    for (int i=1; i<=5000000; i++)  power[i] += power[i-1];

    int T; cin >> T;
    while(T--){
        cin >> a >> b;
        cout << power[a] - power[b] << '\n';
    }

    return 0;
}

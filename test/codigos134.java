using namespace std;

#include<bits/stdc++.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

#define _USE_MATH_DEFINES
#define ll long long
#define ins Not Needed Thing
#define ull unsigned long long
#define ld long double
#define Accepted 0
#define pb push_back
#define pii pair<int,int>
#define pll pair<ll,ll>
#define mp make_pair
#define sz(x) (int)(x.size())
#define all(x) x.begin(),x.end()
#define F first
#define S second
#define emp What is it
#define SORRY FUL Accepted 
#define dimash the top one
#define I wish 
#define you be a little more calm
#define SpeedForce ios_base::sync_with_stdio(0), cin.tie(0)

const double eps = 0.000001;
const ld pi = acos(-1);
const int maxn = 1e7 + 9;
const int mod = 1e9 + 7;
const ll MOD = 1e18 + 9;
const ll INF = 1e18 + 123;
const int inf = 2e9 + 11;
const int minn = 1e5 + 9;
const int N = 5e3 + 123;                                          
const int NN = 5e5 + 123;
const int PRI = 555557;
const int pri = 997;

int phi(int n){
    int res = n;
    for(ll i = 2; i * i <= n; i ++){
        if(n % i == 0){
            while(n % i == 0)
                n /= i;
            res -= res / i;
        }
    }
    if(n > 1)
        res -= res / n;
    return res;
}
 
int mult(int a, int b){
    return (1ll * a * b) % mod;
}
 
int binpow(int a, int b){
    if(b == 0) return 1;
    if(b % 2) return mult(a, binpow(a, b - 1) );
    else {
        int h = binpow(a, b / 2);
        return mult(h, h);
    }
}
 
int divide(int a, int b){
    return mult(a, binpow(b, phi(mod) - 1));
}
 
void add(int &a, int b){
    a += b;
    if(a >= mod) a-= mod;
}
 
void subs(int &a, int b){
    a -= b;
    if(a < 0) a += mod;
}

int tests = 1;
int n, m, k, cnt, ans;
int dp[76][(1 << 20)];
string s;

inline void Solve () {
	cin >> n;
	cin >> s;
	for (int i = 0;i < n; i ++) {
		dp[i][1] = 1;
		for (int mask = 0; mask < (1 << 20); mask ++) {
			if(!dp[i][mask]) continue;

			for(int cur = 0, j = i;j < n && cur < 20; j ++) {
				cur = cur * 2 + (s[j] - '0');
				if(cur && cur < 20)
					add(dp[j + 1][mask | (1 << cur)], dp[i][mask]);
			}
		}
	}
	for (int i = 0; i <= n; i ++)
		for(int m = 2; m <= 20; m ++)
			add(ans, dp[i][(1 << m) - 1]); 
    cout << ans;	
}

int main () {
	SpeedForce;
//	freopen(".in", "r", stdin);
//	freopen(".out", "w", stdout);	
	// cin >> tests;
	while(tests --) {
		Solve ();
		// Ee Zadrot
	}	
}
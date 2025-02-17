#include <bits/stdc++.h>
#define ll long long

using namespace std;

ll mod = 1000000007, a, b;

void gcd(ll c, ll d, ll & x, ll & y)
{
	if (!c)
	{
		x = 0;
		y = 1;
		return;
	}
	
	ll x1, y1;
	gcd(d % c, c, x1, y1);
	x = y1 - d / c * x1;
	y = x1;
}

ll rev(ll x)
{
	ll y, z;
	gcd(x, mod, y, z);
	y = (y % mod + mod) % mod;
	return y;
}

ll gd(ll x)
{
	while (x)
	{
		if (x % 10 != a && x % 10 != b)
			return 0;
			
		x /= 10;
	}
	
	return 1;
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	ll n, ans = 0, cs = 1;
	cin >> a >> b >> n;
	
	for (ll i = 0; i <= n; i++)
	{
		if (gd(i * a + (n - i) * b))
			ans = (ans + cs) % mod;
			
		cs = cs * (n - i) % mod * rev(i + 1) % mod;
	}
	
	cout << ans;
}
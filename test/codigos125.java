#define _CRT_SECURE_NO_WARNINGS
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
#define N 3003000

ll gcd(ll a, ll b)
{
	for (;;)
	{
		if (a == 0) return b;
		b %= a;
		if (b == 0) return a;
		a %= b;
	}
}

ll lcm(ll a, ll b)
{
	int temp = gcd(a, b);
	return temp ? (a / temp * b) : 0;
}

pair<ll, ll> reduce(ll up, ll down){
	ll g = gcd(up, down);
	up /= g;
	down /= g;
	return make_pair(up, down);
}

ll x[N];
ll y[N];
int hsCnt = 0;
map<pair<ll, ll>, ll> hs;
set<pair<ll, ll> > C[N];

int getHs(pair<ll, ll> val){
	if (hs.count(val)) return hs[val];
	hs[val] = hsCnt++;
	return hs[val];
}

pair<ll, ll> getM(int i, int j){
	if (x[i] == x[j]) return make_pair(0, 0);
	ll up = y[j] - y[i];
	ll down = x[j] - x[i];
	pair<ll, ll> res = reduce(abs(up), abs(down));
	if (up * down < 0) res.first *= -1;
	return res;
}

pair<ll, ll> getC(int i, int j){
	ll up = y[i] * (x[j] - x[i]) - x[i] * (y[j] - y[i]);
	ll down = x[j] - x[i];
	pair<ll, ll> res = reduce(abs(up), abs(down));
	if (up * down < 0) res.first *= -1;
	return res;
}

void solve(int i, int j){
	pair<ll, ll> m = getM(i, j);
	int idx = getHs(m);
	if (x[i] == x[j]){
		C[idx].insert(make_pair(x[i], x[i]));
	}
	else{
		pair<ll, ll> c = getC(i, j);
		C[idx].insert(c);
	}
}

int main() {
//	freopen("in.in", "r", stdin);
//	freopen("out.out", "w", stdout);
	ios::sync_with_stdio(0); cin.tie(); cout.tie();

	ll n; cin >> n;
	for (int i = 0; i < n; i++) cin >> x[i] >> y[i];
	for (int i = 0; i < n; i++){
		for (int j = i + 1; j < n; j++){
			solve(i, j);
		}
	}
	ll lines = 0;
	for (int i = 0; i <= hsCnt; i++) lines += C[i].size();
	ll ans = lines * (lines - 1) / 2;
	for (int i = 0; i < hsCnt; i++){
		ll m = C[i].size();
		ans -= m * (m - 1) / 2;
	}
	cout << ans << endl;

	return 0;
}
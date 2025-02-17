#include <bits/stdc++.h>
/*#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
using namespace __gnu_pbds;
template <typename T>
using ordered_set = tree<T, null_type, less<T>, rb_tree_tag, tree_order_statistics_node_update>;*/
#define itn int
#define all(c) c.begin(),c.end()
#define make_unique(x) sort(all((x))); (x).resize(unique(all((x))) - (x).begin())
#define ll long long
#define ull unsigned long long
#define pll pair<ll, ll>
#define pii pair<int, int>
#define mp(x, y) make_pair(x, y)
using namespace std;
 
const ll inf = numeric_limits<ll>::max();
const double PI = 3.1415926536;
int days[13] = {0, 31, 28, 31, 30, 31,30, 31, 31, 30, 31, 30, 31};
 
template<typename T>
ostream& operator <<(ostream& out, const vector<T>& mas) {
    for (const auto& x : mas) {
        out << x << ' ';
    }
    return out;
}
 
void ok() {
    cout << "YES" << '\n';
}
 
void no() {
    cout << "NO" << '\n';
}
 
inline ll nxt() {
    ll x;
    cin >> x;
    return x;
}
 
template <int mod>
struct Modular {
	int val;
 
    Modular(long long _val = 0) {
        if (_val < 0 || _val >= mod) {
            val = _val % mod;
            if (val < 0) {
                val += mod;
            }
        } else {
            val = _val;
        }
    }
 
    Modular operator +(const Modular& ot) const {
        int res = val + ot.val;
        if (res >= mod) {
            res -= mod;
        }
        return {res};
    }
 
    Modular operator -(const Modular& ot) const {
        int res = val - ot.val;
        if (res < 0) {
            res += mod;
        }
        return {res};
    }
 
    Modular operator *(const Modular& ot) const {
        return {1ll * val * ot.val};
    }
 
    Modular& operator ++() {
        val += 1;
        if (val == mod) {
            val = 0;
        }
        return *this;
    }
 
    Modular operator ++(int) {
        Modular tmp(*this);
        operator ++();
        return tmp;
    }
 
    void operator +=(const Modular& ot) {
        val += ot.val;
        if (val >= mod) {
            val -= mod;
        }
    }
 
	void operator -=(const Modular& ot) {
		val -= ot.val;
		if (val < 0) {
			val += mod;
		}
	}
 
	void operator *=(const Modular& ot) {
		val = 1ll * val * ot.val % mod;
	}
 
	bool operator ==(const Modular& ot) const {
		return val == ot.val;
	}
 
	bool operator !=(const Modular& ot) const {
		return val != ot.val;
	}
};
 
template <int mod>
ostream& operator <<(ostream& ostr, const Modular<mod>& x) {
	return ostr << x.val;
}
 
const int mod = 998244353, N = 3e3 + 1;
using Mint = Modular<mod>;
 
Mint getPow(Mint d, ll n) {
    Mint cur = 1;
    while (n) {
        if (n % 2 == 1) {
            cur *= d;
        }
        d *= d;
        n /= 2;
    }
    return cur;
}
 
template<class T>
T inv(T d) {
    return getPow(d, mod - 2);
}
 
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);
    ll n = nxt(), m = nxt();
    int L = nxt(), R = nxt();
    int len = R - L + 1;
    if (n * m % 2) { 
        cout << getPow(len, n * m);
    } else {
        int even = 0, odd = 0;
        if (L % 2 == R % 2) {
            even += len / 2 + (1 - L % 2);
            odd += len / 2 + L % 2;
        } else {
            even += len / 2;
            odd += len / 2;
        }
        Mint t1 = getPow(even + odd, n * m);
        Mint t2 = getPow(even - odd, n * m);
        cout << (t1 + t2) * inv(Mint(2));
    }
    return 0;
}
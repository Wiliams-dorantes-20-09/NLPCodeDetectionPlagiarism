#include <bits/stdc++.h>
using namespace std;
 
const int maxx = 1e5 + 7;
 
#define F first
#define S second
#define int long long
#define pb push_back
 
typedef long long ll;
 
int32_t main() {
	ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
	int a, b;
    cin >> a >> b;
	int x = 0, y = 0, z = 0;
    for (int i = 1; i <= 6; i++) {
        if (abs(a - i) < abs(b - i))
            x++;
        else if (abs(a - i) > abs(b - i))
            y++;
        else if (abs(a - i) == abs(b - i))
            z++;
    }
    cout << x << ' ' << z << ' ' << y << endl;
	return 0;
}
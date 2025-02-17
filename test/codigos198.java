#include <algorithm>
#include <iostream>
#include <cmath>
#include <fstream>
#include <vector>
#include <iomanip>
#include <string>
#include <queue>
#include <map>
#include <stack>
#include <set>

using namespace std;

typedef long long ll;
typedef long double ld;

template <typename T>
T gcd(T a, T b) {
	while (a > 0 && b > 0) {
		if (a > b) a %= b; else b %= a;
	}
	return (a + b);
}

int main() {
	int k, r;
	cin >> k >> r;
	for (int cnt = 1; true; ++cnt) {
		int sum = (cnt * k) % 10;
		if (sum == r || sum == 0) {
			cout << cnt << endl;
			return 0;
		}
	}
	return 0;
}
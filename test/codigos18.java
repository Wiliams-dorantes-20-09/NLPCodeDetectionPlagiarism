/** 
 *                                                                   
 *   |    |                        ,   .              ,--.,--.,--.,--.
 *   |    |    ,---..    ,,---.    |   |,---..   .      -||  ||  ||  |
 *   |    |    |   | \  / |---'    `---'|   ||   |       ||  ||  ||  |
 *   `    `---'`---'  `'  `---'      |  `---'`---'    `--'`--'`--'`--'
 *                                   `                                
**/
#include <bits/stdc++.h>
using namespace std;

int n, a[100005], b[100005];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	// freopen("out.txt", "w", stdout);
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}

	int lo = n - 1;
	int times = 0;
	while (lo >= 0 && a[lo] <= a[(lo + 1) % n]) {
		--lo;
		++times;
	}

	// cout << lo << '\n';

	int id = 0;
	lo = ++lo % n;
	for (int i = lo; id == 0 || i != lo; i = ++i % n) {
		b[id++] = a[i];
	}

	// for (int i = 0; i < n; i++) {
	// 	cout << b[i] << ' ';
	// } cout << '\n';

	bool ok = 1;
	for (int i = 1; ok && i < n; i++) {
		if (b[i] < b[i - 1]) ok = 0;
	}

	if (ok) cout << times % n << '\n';
	else cout << -1 << '\n';

	return 0;
}
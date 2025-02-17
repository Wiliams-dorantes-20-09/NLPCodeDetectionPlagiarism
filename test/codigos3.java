#define _USE_MATH_DEFINES
#include <iostream>
#include <complex>
#include <vector>
#include <sstream>
#include <string>
#include <math.h>
#include <iomanip>
#include <algorithm>
#include <map>
#include <set>

using namespace std;

int n;
int k = 0;
vector<int> a;
vector<int> b;
vector<int> m;
vector<int> x;

void swap_elem(int i, int j) {
	++k;
	a.push_back(i);
	b.push_back(j);
	swap(x[i], x[j]);
	m[x[i]] = i;
	m[x[j]] = j;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);	
	cin >> n;
	for (int i = 0; i < n; ++i)
		m.push_back(0);
	for (int i = 0; i < n; ++i) {
		int e;
		cin >> e;
		e--;
		m[e] = i;
		x.push_back(e);
	}
	for (int i = 1; i < n - 1; ++i) {
		if (m[i] != i) {
			if (i < n / 2) {
				if (m[i] < n / 2)
					swap_elem(m[i], n - 1);
				else {
					swap_elem(0, m[i]);
					swap_elem(0, n - 1);
				}
				swap_elem(i, n - 1);
			}
			else {
				if (m[i] >= n / 2)
					swap_elem(0, m[i]);
				else {
					swap_elem(m[i], n - 1);
					swap_elem(0, n - 1);
				}
				swap_elem(0, i);
			}
		}
	}
	if (x[0] != 0)
		swap_elem(0, n - 1);
	cout << k << '\n';
	for (int i = 0; i < k; ++i)
		cout << a[i] + 1 << ' ' << b[i] + 1 << '\n';
	return 0;
}
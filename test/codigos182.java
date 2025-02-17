#include<bits/stdc++.h>

using namespace std;

const int MAXN = 1000 + 5;
int n, arr[MAXN];
long long s;

int main() {
	int _min = INT_MAX;
	cin >> n >> s;
	for(int i = 0; i < n; i ++) {
		cin >> arr[i];
		_min = min(_min, arr[i]);
	}
	long long sum = 0; 
	for(int i = 0; i < n; i ++) {
		sum += arr[i] - _min;
	}
	if(sum >= s) {
		cout << _min << endl;
		return 0;
	}
	s -= sum;
	long long a = (s + n - 1) / n;
	if(a > _min) {
		cout << -1 << endl;
		return 0;
	}
	cout << _min - a << endl;
	return 0;
}
#include <bits/stdc++.h>
using namespace std;
int n, x, a[100005];
int main () {
	scanf("%d", &n);
	for (int i=0; i<n; i++) {
		scanf("%d", &x);
		a[x]++;
	}
	for (int i=100000; i>0; i--) {
		if (a[i]%2) {
			printf("Conan\n");
			return 0;
		}
	}
	printf("Agasa\n");
	return 0;
}
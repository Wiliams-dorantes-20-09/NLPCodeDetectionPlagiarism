//I_F_A
#include "bits/stdc++.h"
using namespace std;

int main(){

	long long n,a,b,c;
	cin >> n >> a >> b >> c;

	long long ans = 0;
	for(long long i = 0 ; i * a <= n  ;i++){

		for(long long j = 0 ; j*b + i * a <=  n ;j++){

			long long C = n - a*i - b*j;
			if(C%c == 0){
				ans = max(ans,i+j+C/c);
			}
		}
	}
	cout << ans;
}
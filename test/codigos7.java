#include<bits/stdc++.h>
#define md 100000000
using namespace std;
int N[2], K[2], H, i, j, k, A[200][101][2][11]; //pos ban akh tur
int main () {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin>>N[0]>>N[1]>>K[0]>>K[1];
	A[0][1][0][1]=1;
	A[0][0][1][1]=1;
	for (i=1;i<N[0]+N[1];i++) {
		for (j=1;j<=N[0];j++) {
			for (k=1;k<=K[1];k++) {
				A[i][j][0][1]=(A[i][j][0][1]+A[i-1][j-1][1][k])%md;
			}
			for (k=2;k<=K[0];k++) {
				A[i][j][0][k]=A[i-1][j-1][0][k-1];
			}
		}
		for (j=0;j<=N[0];j++) {
			for (k=1;k<=K[0];k++) {
				A[i][j][1][1]=(A[i][j][1][1]+A[i-1][j][0][k])%md;
			}
			for (k=2;k<=K[1];k++) {
				A[i][j][1][k]=A[i-1][j][1][k-1];
			}
		}
	}
	for (k=1;k<=K[0];k++) {
		H=(H+A[N[0]+N[1]-1][N[0]][0][k])%md;
	}
	for (k=1;k<=K[1];k++) {
		H=(H+A[N[0]+N[1]-1][N[0]][1][k])%md;
	}
	cout<<H<<'\n';
}

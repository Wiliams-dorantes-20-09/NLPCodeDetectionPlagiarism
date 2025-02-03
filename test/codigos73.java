//#include <vector>
//#include <string>
#include <iostream>
//#include <algorithm>
//#include <cmath>
//#include <cstdio>
//#include <map>
//#include <set>
//#include <string.h>
using namespace std;
//#pragma comment(linker, "/STACK:167772160")

#define sz(x) int((x).size())
#define inf 1000000000
#define pb push_back
#define FOR(i,a,b) for(i=a;i<=b;i++)
#define REP(i,a,b) for(i=a;i<b;i++)
#define pi 2*acos(0.0)
#define sqr(a) (a)*(a)
#define mp make_pair
typedef long long ll;
#define y1 kjdh
#define y0 sf

int n,i,j,a[2001][2001],b[2001][2001],ans,J,C,A[2001][2001],B[2001][2001];
char c[2001][2001];


int main()
{
    //freopen("input.txt","r",stdin);
	
	cin>>n;

	FOR(i,1,n)
	FOR(j,1,n)cin>>c[i][j];

	memset(a,0,sizeof(a));
	memset(b,0,sizeof(b));
	memset(A,0,sizeof(A));
	memset(B,0,sizeof(B));

	ans=0;
	
	for(J=n;J>=2;J--)
	{
		i=1;j=J;
		FOR(C,1,n+1-J)
		{
			if(c[i][j]=='0' && (a[i][j]+b[i][j])%2==1 || c[i][j]=='1' && (a[i][j]+b[i][j])%2==0)
			{
				//cout<<i<<" "<<j<<" "<<endl;
				ans++;
				a[i][j-1]=a[i][j]+1;
				b[i+1][j]=b[i][j]+1;
			}else
			{
			a[i][j-1]=a[i][j];
			b[i+1][j]=b[i][j];
			}
			i++;j++;
		}


		i=n;j=n+1-J;
		FOR(C,1,n+1-J)
		{
			if(c[i][j]=='0' && (A[i][j]+B[i][j])%2==1 || c[i][j]=='1' && (A[i][j]+B[i][j])%2==0)
			{
				//cout<<i<<" "<<j<<" "<<endl;
				ans++;
				A[i][j+1]=A[i][j]+1;
				B[i-1][j]=B[i][j]+1;
			}else
			{
			A[i][j+1]=A[i][j];
			B[i-1][j]=B[i][j];
			}
			i--;j--;
		}
	}

	FOR(i,1,n)
	{
		if(c[i][i]=='0' && (a[i][i]+b[i][i]+A[i][i]+B[i][i])%2==1 || c[i][i]=='1' && (a[i][i]+b[i][i]+A[i][i]+B[i][i])%2==0)ans++;
	}

	cout<<ans<<endl;
}
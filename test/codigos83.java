//Link : https://codeforces.com/contest/1253

#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define N 400005
#define mod 998244353
/*
#include <limits.h>
INT_MAX
LLONG_MAX
*/

int m[N],c[N];

int add(int x,int y) {
  return ((x+y)%mod+mod)%mod;
}

int mul(int x,int y) {
  return (ll)x*y%mod;
}

int mypow(int x,int c) {
  int ret = 1;
  while(c>0) {
    if(c&1) {
      ret = mul(ret,x);
    }
    c/=2;
    x = mul(x,x);
  }
  return ret;
}
int fac[N],invFac[N];
int combi(int n,int r) {
  if(n<r) {
    return 0;
  }
  return mul(fac[n],mul(invFac[r],invFac[n-r]));
}

int findMatching(int row,int n) {
  int ret = mypow(row,n);
  for(int i=1;i<row;++i) {
    int ad = mul(combi(row,i),mypow(row-i,n));
    if(i&1) {
      ret = add(ret, -ad);
    } else {
      ret = add(ret,ad);
    }
  }
  return ret;
}

void solve() {
  int n;
  ll k;
  fac[0] = 1;
  invFac[0] = 1;
  for(int i=1;i<N;++i) {
    fac[i] = mul(fac[i-1],i);
    invFac[i] = mypow(fac[i],mod-2);
  }
  scanf("%d %lld ", &n,&k);
  int ret = 0;
  ll row = n - k;
  if(1<=row && row<=n) {
    ret = mul(combi(n,row),findMatching(row,n));
    //combi(n,row);
    if(row!=n) {
      ret = mul(ret,2);
    }
  }
  printf("%d\n", ret);
}

int main() {
    //freopen("input.txt","r",stdin);
    solve();
    return 0;
}

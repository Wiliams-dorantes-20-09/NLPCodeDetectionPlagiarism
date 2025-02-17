#include <iostream>

using namespace std;

int n, a, b;
int h[111];

int dp[11][20][20];
int php[11][20][20];
int ps[11][20][20];
int shoot[11][20][20];
// last, hp, shots

void restore(int i, int hp, int s) {
  if(!i)return;
  for (int j=0;j<shoot[i][hp][s];j++)cout<<i<<' ';
  restore(i-1,php[i][hp][s],ps[i][hp][s]);
}

int main() {
  #ifdef LOCAL
  freopen("in.txt","r",stdin);
  #endif
  cin>>n>>a>>b;
  for(int i=1;i<=n;i++){
    cin>>h[i];
    h[i]++;
  }

  for(int i=0;i<=n;i++)
    for(int j=0;j<=16;j++)
      for(int k=0;k<=16;k++)
        dp[i][j][k]=(int)1e8;

  dp[1][h[1]][0] = 0;
  for (int i = 2; i <= n; i++) {
    for (int hp = 0; hp <= h[i-1]; hp++) {
      for (int s = 0; s <= 16; s++) {
        for (int cur = 0; cur <= 16; cur++) {
          if (hp - cur * b > 0) continue;
          if (i==n&&cur>0)continue;

          if (dp[i-1][hp][s]+cur < dp[i][max(0, h[i] - s * b - cur * a)][cur]){
            dp[i][max(0, h[i] - s * b - cur * a)][cur] = min(dp[i][max(0, h[i] - s * b - cur * a)][cur], dp[i-1][hp][s]+cur);
            php[i][max(0, h[i] - s * b - cur * a)][cur] = hp;
            ps[i][max(0, h[i] - s * b - cur * a)][cur] = s;
            shoot[i][max(0, h[i] - s * b - cur * a)][cur] = cur;
          }
        }
      }
    }
  }
  int ans=(int)1e8;
  for (int s = 0; s <= 16; s++)
    ans =min(ans, dp[n][0][s]);
  cout<<ans<<endl;
  for (int s = 0; s <= 16; s++)
    if(ans==dp[n][0][s]){
      restore(n,0,s);
      return 0;
    }
  return 0;
}
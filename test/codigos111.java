#include <bits/stdc++.h>
#define ll long long
#define fr first
#define sc second
#define mp make_pair
#define All(v) v.begin(),v.end()
#define ii pair<int,int>
using namespace std;
int main()
{
  ll n;
  cin>>n;
  vector < ll > v;
  int minx = 1e9;
  for(ll i=1;i*i<=n;i++)
  {
      v.push_back(i*i);
  }
  for(int i=0;i<v.size();i++)
  {
      vector < int > d;
      ll temp = v[i];
      while(temp > 0)
      {
          d.push_back(temp%10);
          temp/=10;
      }
      int cnt = d.size()-1;
      int j = 0;
      ll temp2 = n;
      int cnt2 = 0;
      while(temp2 > 0)
      {
          if(j <= cnt  && (temp2%10) == d[j])
          {
              j++;
          }
          temp2/=10;
          cnt2++;
      }
      if(j == cnt+1)
      {
          cnt = d.size();
          minx = min(minx , cnt2 - cnt);
      }
  }
  if(minx == 1e9)
    minx = -1;
  cout<<minx;
}

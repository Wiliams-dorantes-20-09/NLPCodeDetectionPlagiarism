#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <stdio.h>
using namespace std;
int main(){
  #ifdef Vlad_kv
   freopen("input.txt","r",stdin);
   freopen("output.txt","w",stdout);
  #endif // Vlad_kv
  int q,w,e,r,t;
  long long a[10];
  scanf("%d%d",&q,&t);
  for(w=0;w<t;w++)
   a[w]=0;
  for(w=0;w<q;w++){
   scanf("%d",&e);
   a[e-1]++;
  }
  long long ans=0;
  for(w=0;w<t;w++)
   for(e=w+1;e<t;e++)
    ans+=a[w]*a[e];
  cout<<ans;
  return 0;
}

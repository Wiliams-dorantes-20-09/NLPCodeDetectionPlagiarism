#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <stdio.h>
using namespace std;
class sp{
  public:
  int q;
  sp *w;
  sp(int q1,sp *w1){
   q=q1;w=w1;}
};
sp *a[500000];
int y,c,v,i=0,s[500000],s1[500000],d[1048576],d1[1048576];
void l(int q,int w){
  s[q]=i;
  i++;
  for(sp *c=a[q];c;c=c->w)
   if(c->q!=w)
    l(c->q,q);
  s1[q]=i-1;
}
void k(int w,int e,int t){
  if((c<=e)&&(e+t-1<=v))
   d[w<<1]=y;
  else
   if(min(v,e+t-1)-max(c,e)>=0)
    k(w<<1,e,t>>1);
  if((c<=e+t)&&(e+(t<<1)-1<=v))
   d[(w<<1)+1]=y;
  else
   if(min(v,e+(t<<1)-1)-max(c,e+t)>=0)
    k((w<<1)+1,e+t,t>>1);
}
int k1(int w,int e,int t){
  int r=-2;
  if((c<=e)&&(e+t-1<=v))
   r=max(r,d1[w<<1]);
  else
   if(min(v,e+t-1)-max(c,e)>=0)
    r=max(r,k1(w<<1,e,t>>1));
  if((c<=e+t)&&(e+(t<<1)-1<=v))
   r=max(r,d1[(w<<1)+1]);
  else
   if(min(v,e+(t<<1)-1)-max(c,e+t)>=0)
    r=max(r,k1((w<<1)+1,e+t,t>>1));
  return r;
}
int main(){
  //freopen("input.txt","r",stdin);
  //freopen("output.txt","w",stdout);
  int q,w,e,r,t,u;
  scanf("%d",&q);
  for(w=0;w<q;w++)
   a[w]=0;
  for(w=1;w<1048576;w++){
   d[w]=-2;
   d1[w]=-1;}
  for(w=1;w<q;w++){
   scanf("%d%d",&e,&r);
   e--;r--;
   a[e]=new sp(r,a[e]);
   a[r]=new sp(e,a[r]);}
  l(0,-1);
  scanf("%d",&u);
  for(w=0;w<u;w++){
   scanf("%d%d",&e,&r);
   r--;
   if(e==1){
    c=s[r];
    v=s1[r];
    y=w;
    k(1,0,262144);}
   if(e==2)
    for(r=s[r]+524288;r;r>>=1)
     d1[r]=w;
   if(e==3){
    t=-2;
    for(c=s[r]+524288;c;c>>=1)
     t=max(t,d[c]);
    c=s[r];
    v=s1[r];
    if(t<k1(1,0,262144))
     printf("0\n");
    else
     printf("1\n");}}
  return 0;}

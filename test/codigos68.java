/*
 ############### sabka katega ###############
 ********************************
 */
//#include "stdc++.h"
#include<bits/stdc++.h>
#include<iostream>
#pragma warning(disable:4996)
#pragma comment(linker, "/STACK:336777216")
using namespace std;
//mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
//typedef tuple<int, int, int> t3;
typedef long long ll;
typedef unsigned long long ull;
typedef double db;
typedef long double ldb;
typedef pair <int, int> pii;
typedef pair <ll, ll> pll;
typedef pair <ll, int> pli;
typedef pair <db, db> pdd;
typedef vector<int> vi;
#define m1 make_pair
#define pb push_back
#define IOS std::ios::sync_with_stdio(false); cin.tie(NULL);cout.tie(NULL);
inline ll gcd(ll a,ll b){if(a==0) return b;return gcd(b%a,a);}
inline ll power(ll a,ll n,ll m){if(n==0) return 1;ll p=power(a,n/2,m);p=(p*p)%m;if(n%2) return (p*a)%m;else return p; }
#define flush fflush(stdout)

const int INF = 0x3f3f3f3f;
const ll LL_INF = 0x3f3f3f3f3f3f3f3f;
 const ll MOD = 100000000;
 bool check(string s1,string s2,int i)
 {
   int l1=s1.length(),l2=s2.length();
   
     string s=s1.substr(0,i);//l=0;
     int f=0,z=0;
      for(int j=0;j<l1;j++)
      {
        if(s1[j]!=s[f++])
        {
          z=1;break;
        }
        //else
        //l++;
        if(f==i)
        {
          f=0;
          //l=0
        }
      }
      if(!z)
      {
        //mn=min(mn,i);
        for(int j=0;j<l2;j++)
      {
        if(s2[j]!=s[f++])
        {
          z=1;break;
        }
        //else
        //l++;
        if(f==i)
        {
          f=0;
          //l=0
        }
      }
      if(!z)
      return 1;
      else
      return 0;
      }
      else
      return 0;
 }
 int main()
 {
 string s1,s2;
 cin>>s1>>s2;
 if(s1.length()>s2.length())
 {
   string s;
   s=s1;
   s1=s2;
   s2=s;
 }
 int l1=s1.length(),l2=s2.length();int mn=INF;
 for(int i=1;i<=sqrt(l1);i++)
 {
 
  if(((l1%i)==0)&&((l2%i)==0))
  {
     bool p=check(s1,s2,i);
     if(p)
     mn=min(mn,i);
     p=check(s1,s2,l1/i);
     if(p)
     mn=min(mn,l1/i);
  }
 }
   if(mn==INF)
   cout<<"0"<<endl;
   else
   {
     int ans=0;
     for(int i=mn;i<=l1;i+=mn)
     if(((l1%i)==0)&&((l2%i)==0))
     ans++;
     cout<<ans<<endl;
   }
   
 }

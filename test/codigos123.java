#include <bits/stdc++.h>
#define pi 3.1415926535897932384626
using namespace std;

struct vec
{
    long double x,y;
    bool operator ==(const vec &a) const{
        return x==a.x&&y==a.y;
    }
    bool operator <(const vec &a) const{
        if(a.x!=x) return x<a.x;
        return y<a.y;
    }
    vec operator +(const vec &a) const{
        return {x+a.x,y+a.y};
    }
    vec operator *(const long double &a) const{
        return {x*a,y*a};
    }
    vec operator -(const vec &a) const{
        return {x-a.x,y-a.y};
    }
    vec operator /(const long double &a) const{
        return {x/a,y/a};
    }
    long double len() const{
        return (x*x+y*y);
    }
    long double dot(const vec &a) const{
        return x*a.x+y*a.y;
    }
    long double crs(const vec &a) const{
        return x*a.y-y*a.x;
    }
    vec proj(const vec &a) const{
        return (a/a.len())*(*this).dot(a)/a.len();
    }
};


struct P
{
    int x,y;
    bool operator <(const P &a) const{
        //if(x!=a.x)
         return x>a.x;

    }
};

bool as(P a,P b)
{
    if(a.x!=b.x) return a.x>b.x;
    return a.y<b.y;
}


long long x,y,z,mod=998244353;
//vector<long long> v,v1;
vector<int> v,v1[1];
//vector<long long> v1;
int i,n,m,k,a,d,b,c,h,dx[10]={1,0,-1,0},dy[10]={0,1,0,-1};
int e;
int l[1];

int o[111112];

int j[2];
stack<int> s;
//set<int> s;
queue<int> q,q1;
P u[1],u1[2];
char r[1];
//string r,r1;
//2147483647
//'1'==49;
//'A'==65;
//'a'==97;
//unordered_
map<int,int> p;
//v.resize(unique(v.begin(),v.end())-v.begin());

//mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
//rng();

int main()
{
    scanf("%d",&a);
    for(int t=1;t<=a;t++)
    {
        scanf("%d %d %d",&n,&m,&k);
        if(n==m) puts("OBEY");
        else
        {
            if(n>m) swap(n,m);
            if((m-__gcd(n,m)-1)/n+1>=k) puts("REBEL");
            else puts("OBEY");
        }
    }
}


/*
    TOP GUN: MAVERICK!!
                                */
#include<bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp> 
//#include <boost/functional/hash.hpp>
#include <ext/pb_ds/tree_policy.hpp>
using namespace __gnu_pbds;
using namespace std;
typedef long long int lli;
lli mod=1e9+7ll;
lli INF=1e17;
#define sqr(x) (x) * (x)
#define bip(n) __builtin_popcountll(n)//no of ones bit in binary!!
#define bictz(n) __builtin_ctzll(n)//no of trailing zeroes in binary!!
#define biclz(n) __builtin_clzll(n)//no of leading zeroes in binary!!
#define bffs(n) __builtin_ffsll(n)//index of first one bit!!
typedef pair<lli,lli> ll;
#define mem1(a,x) fill(&a[0], &a[0] + sizeof(a) / sizeof(a[0]), x)
#define mem2(a,x) fill(&a[0][0], &a[0][0] +sizeof(a)/sizeof(a[0][0]),x)
#define mem3(a,x) fill(&a[0][0][0], &a[0][0][0] +sizeof(a)/sizeof(a[0][0][0]),x)
#define fi1 ifstream fin("input.txt")
#define of1 ofstream fout("output.txt")
int fmx(int x, int y) { return (((y-x)>>(31))&(x^y))^y; }
int fmi(int x, int y) { return (((y-x)>>(31))&(x^y))^x; }
typedef tree<lli,null_type,less<lli>,rb_tree_tag,tree_order_statistics_node_update> ost;
lli n,q,z,y,k,m;
const double pi1=3.14159265358979323846;
//unordered_map<pair<ll,lli>,lli> mp;
lli me(lli a,lli b,lli M)
{
    if(b==0)
    return 1;
    else if(b%2==0)
    return me((a*a)%M,b/2,M);
    else
    return (a%M*me((a*a)%M,(b-1)/2,M)%M)%M;
}
lli mI(lli a,lli m)
{
    return me(a,m-2,m);
}
//lli tot=0;
vector<lli> pf(string s) {
    int n = (int)s.length();
    vector<lli> pi(n);
    for (int i = 1; i < n; i++) {
        int j = pi[i-1];
        while (j > 0 && s[i] != s[j])
            j = pi[j-1];
        if (s[i] == s[j])
            j++;
        pi[i] = j;
    }
    return pi;
}
lli mk[1005][1005];
bool checkp(lli jj)
{
    int fl=0;
    for(int j=2;j<=sqrt(jj);j++)
    {
        if(jj%j==0)
        fl=1;
    }
    if(!fl&&jj>1)
    return true;
    return false;
}
int main()
{
    ios_base::sync_with_stdio(0);
    scanf("%lld",&n);
    lli a,b;
    unordered_map<lli,lli> vis;
    for(int i=1;i<=1000000;i++)
    {
        lli jj=i;
        jj=jj*jj*jj;
        vis[jj]=i;
    }
    for(int i=1;i<=n;i++)
    {
        scanf("%lld%lld",&a,&b);
        lli aa=a*b;
        lli bb=vis[aa];
        lli cc=bb*bb*bb;
        if(vis[aa])
        {
            if(a%bb==0&&b%bb==0)
            printf("Yes\n");
            else
            printf("No\n");
        }
        else
        printf("No\n");
    }
}
#include <bits/stdc++.h>
using namespace std;
typedef  long long ll;
#define speed      ios::sync_with_stdio(false)
#define rng(i,a,b) for (int i=a;i>=int(b);i--)
#define rep(i,a,b) for(int i=a;i<=int(b);++i)
#define lop(i,n)   for(int i=0;i<int(n);i++)
#define cler(x,a)  memset(x,a,sizeof(x))
#define all(x)     (x).begin(),(x).end()
#define pb(x)      push_back(x)
#define sz(x)      (x.size())
#define f first
#define s second
#define sc(x) scanf("%d",&x)
#define pr(x) printf("%c",x)
//freopen("output.txt","w",stdout);
//freopen("input.txt","r",stdin);
/*
for (int i=0;i<n;i++)            Hi    ^_^  hack me if you can :P
*/
bool prime[1007];
int n;
void sieve()
{
    for(int i=4; i<=1005; i+=2)
        prime[i]=false,prime[i-1]=true;
    prime[2]=true;
    for(int i=3; i<=1000; i+=2)
    {
        if(prime[i])
        {
            for(int j=i*i; j<=1005; j+=i*2)
                prime[j]=false;

        }

    }

}
int main()
{
    speed;
    sieve();
    sc(n);
    vector<int> ans;
        for (int i = 1; i <= n; i++) {
                if (prime[i]) {
            int q = 1;
            while (q <= n / i) {
                q *= i;
                ans.push_back(q);
            }
                }
        }
        cout << sz(ans) << endl;
        for (int i : ans) {
            printf("%d ", i);
        }

    return 0;
}
/*
 fflush(stdout);
 cout.flush();
    ll A,B,n,x;
    scanf("%I64d%I64d%I64d%I64d",&A,&B,&n,&x);
    if(A==1)printf("%I64d",(x+n%MOD*B)%MOD);
    else
    {
        ll res=fp(A,n)*x%MOD;
        res+=(fp(A,n)-1)*fp(A-1,MOD-2)%MOD*B;
        printf("%I64d",(res%MOD+MOD)%MOD);
    }

bool cmp(string x,string y)   {return x+y<y+x;}
int dx[]= {0,0 ,1,-1, 1,1,-1,-1};
int dy[]= {1,-1,0,0 , 1,-1,1,-1};
bool inside (int i,int j) {return (i>=1 && i<=n && j>=1 && j<=m);}

ll pw(ll a,ll k){
ll res=1;a%=MOD;while(k){if(k&1)res=res*a%MOD;a=a*a%MOD;k>>=1;}
return res;}

bool prime[100007];
void sieve()
{
    for(int i=4; i<=100005; i+=2)
        prime[i]=false,prime[i-1]=true;
    prime[2]=true;
    for(int i=3; i<=1000; i+=2)
    {
        if(prime[i])
        {
            for(int j=i*i; j<=100005; j+=i*2)
                prime[j]=false;

        }

    }

}

    ll a,b,n,x,na,nb;
    cin>>a>>b>>n>>x;
    while(n){
        if (n&1){
            x=(a*x+b)%MOD;
        }
        n>>=1;
        na=a*a%MOD;
        nb=(a*b+b)%MOD;
        a=na;
        b=nb;
    }
    cout<<x;
*/

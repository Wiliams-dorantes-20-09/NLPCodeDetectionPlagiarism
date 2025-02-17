#include<algorithm>
#include<iostream>
#include<cstdlib>
#include<vector>
#include<cstdio>
#include<cmath>

#define x first
#define y second
#define pb push_back
#define mp make_pair
#define ll long long
using namespace std;

const int N=100005;

vector < pair<int, int> > a[N];
int j, f[N], n, k, i, x;

bool comp(pair<int, int> x, pair<int, int> y)
{
    return (x.x<y.x||(x.x==y.x&&x.y<y.y));
}

main()
{
    cin.tie(0);
    ios_base::sync_with_stdio(0);
    //freopen("1.txt","r",stdin);
    cin>>n;
    for(i=0; i<n; i++)
    {
        cin>>x>>k;
        a[k].pb(mp(x, i+1));
    }
    for(i=1; i<=100000; i++)
        sort(a[i].begin(), a[i].end(), comp);
    for(i=1; i<=100000; i++)
        if(a[i].size())
        {
            n=a[i].size();
            if(a[i][0].x!=0)
            {
                cout<<"NO";
                return 0;
            }
            for(j=0; j<n; j++)
            {
                f[a[i][j].x]=0;
                f[max(0, a[i][j].x-1)]=0;
            }
            for(j=0; j<n; j++)
                if(!f[a[i][j].x])f[a[i][j].x]=a[i][j].y;
            for(j=1; j<n; j++)
                if(a[i][j].x-a[i][j-1].x>1)
                {
                    cout<<"NO";
                    return 0;
                }
            for(j=1; j<n; j++)
                if(a[i][j].x>0&&a[i][j].y<f[a[i][j].x-1])
                {
                    cout<<"NO";
                    return 0;
                }
        }
    cout<<"YES";
}

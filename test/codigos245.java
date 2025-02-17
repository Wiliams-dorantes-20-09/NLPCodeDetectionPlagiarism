#include <bits/stdc++.h>
#define int long long
#define inf 1e18
using namespace std;
const int N = 1123456;
int read()
{
    int x;
    scanf("%I64d", &x);
    return x;
}
vector <pair <int, int> > v[N];
bool used[N];
int tin[N];
int pin[N];
int timer;
void dfs(int x, int p)
{
    used[x] = 1;
    tin[x] = pin[x] = ++timer;
    for(int i = 0; i < v[x].size(); i ++)
    {
        int to = v[x][i].first;
        if(to == p)
            continue;
        if(used[to])
        {
            pin[x] = min(pin[x], tin[to]);
        }
        else
        {
            dfs(to, x);
            pin[x] = min(pin[x], pin[to]);
            if(pin[to] > tin[x])
                v[x][i].second ++;
        }
    }
}
int tout[N];
int pa[N / 10][25];
int d[N];
void dfs2(int x, int p, int s)
{
    d[x] = s;
    tin[x]  = ++timer;
    used[x] = 1;
    pa[x][0] = p;
    for(int i = 1; i < 20; i ++)
        pa[x][i] = pa[pa[x][i - 1]][i - 1];
    for(int i = 0; i < v[x].size(); i ++)
    {
        int to = v[x][i].first;
        if(!used[to])
        {
            dfs2(to, x, s + v[x][i].second);
        }
    }
    tout[x]  = ++timer;
}
bool upper(int a, int b)
{
    return tin[a] <= tin[b] && tout[a] >= tout[b];
}
int lca(int a, int b)
{
    if(upper(a, b)) return a;
    if(upper(b, a)) return b;
    for(int i = 19; i >= 0; i --)
    {
        if(!upper(pa[a][i], b))
        {
            a = pa[a][i];
        }
    }
    return pa[a][0];
}
main()
{
    int n, m, i, j, x, y;
    cin >> n >> m;
    for(i = 1; i <= m; i ++)
    {
        x = read();
        y = read();
        v[x].push_back(make_pair(y, 0));
        v[y].push_back(make_pair(x, 0));
    }
    dfs(1, -1);
    timer = 0;
    for(i = 1; i <= n; i ++)
    {
        tin[i] = 0;
        used[i] = 0;
    }
    dfs2(1, 1, 0);
    int k;
    cin >> k;
    for(i = 1; i <= k; i ++)
    {
        x = read();
        y = read();
        int l = lca(x, y);
        cout << d[x] + d[y] - 2 * d[l] << endl;
    }
}



#include<bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
int n, m, k, t, p = 1, P[N];
int Find(int v)
{
    if (P[v] < 0)
        return (v);
    return (P[v] = Find(P[v]));
}
int main()
{
    scanf("%d%d%d", &n, &m, &k);
    if (k == 1) return puts("0");
    for (int i = 1; i <= n; i++)
        P[i] = -1;
    for (int i = 0, v, u; i < m; i++)
    {
        scanf("%d%d", &v, &u);
        if ((u = Find(u)) != (v = Find(v)))
            P[v] += P[u], P[u] = v;
    }
    for (int i = 1; i <= n; i++)
        if (Find(i) == i)
            p = -1ll * p * P[i] % k, t ++;
    if (t == 1)
        return puts("1");
    for (int i = 1; i <= t - 2; i++)
        p = 1ll * p * n % k;
    return !printf("%d", p);
}

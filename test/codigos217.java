#include <bits/stdc++.h>
using namespace std;

const int MAXN = 1005;
int a[MAXN];

int main()
{
    int n;
    int revcnt = 0;
    int ansl, ansr;


    // freopen("D:\\1.in", "r", stdin);
    // freopen("D:\\1.out", "w", stdout);

    cin >> n;
    for(int i = 1; i <= n; i++) cin >> a[i];
    for(int i = 1; i <= n; i++)
    if(i != a[i])
    {
        revcnt++;
        if(revcnt != 1) break;
        ansl = i; ansr = a[i];

        for(int j = a[i], k = i; j >= i; j--, k++)
        if(a[j] != k)
        {
            revcnt = -1;
            break;
        }

        if(revcnt == -1) break;
        i = a[i];
    }

    if(revcnt != 1)
        cout << 0 << " " << 0 << endl;
    else
        cout << ansl << " " << ansr << endl;


	return 0;
}

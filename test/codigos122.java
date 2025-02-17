#include <iostream>
#include <string>
#include<algorithm>

using namespace std;

int a[1111], n, m, minans, maxans, nn, b[11111];

int main () {
    cin >> nn >> m;
    for(int i = 1; i <= m; i++)
        cin >> a[i];
    sort(a + 1, a + m + 1);
    for(int i = 1; i <= m; i++)
        b[i] = a[i];
    n = nn;
    while(n > 0)
    {
        int cur = 1;
        while(b[cur] == 0)
            cur++;
        minans += b[cur];
        b[cur]--;
        n--;
    }

    n = nn;
    for(int i = 1; i <= m / 2; i++)
    {
        int t = a[i];
        a[i] = a[m - i + 1];
        a[m - i + 1] = t;
    }

    while(n > 0)
    {
        int maxx = 1;
        for(int i = 1; i <= m; i++)
            if(a[i] > a[maxx])
                maxx = i;
        maxans += a[maxx];
        a[maxx]--;
        n--;
    }
    cout << maxans << ' ' << minans << endl;
    return 0;
}
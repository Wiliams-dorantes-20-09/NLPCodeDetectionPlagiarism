#include <bits/stdc++.h>
using namespace std;

const int MAXN = 56; 
int a[MAXN];
int ans[2];

int main()
{
    int n;

    scanf("%d", &n);
    for(int i = 0; i < n / 2; ++i)
        scanf("%d", &a[i]);
    sort(a, a + n / 2); 
    for(int i = 0; i <= 1; ++i)
        for(int j = 0; j < n / 2; ++j)
            ans[i] += abs(a[j] - j * 2 - i - 1); 
    printf("%d\n", min(ans[0], ans[1]));

    return 0;
}

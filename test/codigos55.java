#include <algorithm>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <iostream>
using namespace std;

int main(void)
{
    int t;
    long long x, y;

    scanf("%d", &t);
    while(t --)
    {
        scanf("%I64d %I64d", &x, &y);

        puts(y + 1 == x ? "NO" : "YES");
    }

    return 0;
}
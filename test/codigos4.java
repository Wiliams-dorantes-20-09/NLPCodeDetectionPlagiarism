#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <cmath>
#include <iomanip>
#include <fstream>
#include <stack>
#include <queue>
#include <deque>
#include <set>
#include <map>
//#include <unordered_map>
//#include <unordered_set>
#include <stdio.h>
#include <stdlib.h>
#include <cstdio>
#include <cstdlib>
#include <csignal>
#include <bitset>
#include <functional>
#include <ctime>
//#include <tuple>
#include <cassert>
#include <cstring>
#include <list>
//#include <array>
#include <iterator>
//#include <type_traits>
#include <numeric>
#include <cstdio>

#define PI 3.1415926535897932384626433832795

using namespace std;

typedef long long ll;

void solve() {
    ll a, b, n, s;
    scanf("%lld %lld %lld %lld", &a, &b, &n, &s);
    ll k = s - a*n;
    if (k < 0) {
        k = s - (s/n)*n;
    }
    if(k > b) {
        printf("NO\n");
    }else printf("YES\n");
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    // freopen("input.txt","r", stdin);
    // freopen("output.txt","w",stdout);
    int q;
    scanf("%d", &q);
    while (q--)
    {
        /* code */
        solve();
    }
    

    return 0;
}
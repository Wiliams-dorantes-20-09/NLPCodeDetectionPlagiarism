#include <iostream>
#include <cstdio>
#include <cmath>
#include <string>
#include <algorithm>
#include <vector>
#include <queue>
#include <deque>
#include <stack>
#include <map>
#include <set>
#include <ctime>
#include <memory.h>
#include <assert.h>
#include <complex>
#include <ctime>  
#include <cstdlib>
using namespace std;

#pragma comment(linker, "/STACK:100000000")

#define mp make_pair
#define pb push_back
#define sz(x) (int)(x).size()
#define ll long long
#define ull unsigned long long

int main() {
    //freopen("cycle2.in", "rt", stdin);
    //freopen("cycle2.out", "wt", stdout);

    int n;
    scanf("%d", &n);
    int cnt = 0;
    for(int i = 0; i < n; i++) {
        int p, q;
        scanf("%d %d", &p, &q);
        if(p + 2 <= q) cnt++;
    }

    printf("%d", cnt);
    return 0;
}
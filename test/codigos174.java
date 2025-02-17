#include<bits/stdc++.h>
#define CLR(a)              memset(a, 0, sizeof(a))
#define SET(a, x)           memset(a, x, sizeof(a))
#define SORT(v)             sort(v.begin(), v.end())
#define REV(v)              reverse(v.begin(), v.end())
#define FOR(i, n)           for (int i=0; i<n; i++)
#define FOR1(i, n)          for (int i=1; i<=n; i++)
#define ROF(i, n)           for (int i=n-1; i>=0; i--)
#define ROF1(i, n)          for (int i=n; i>=1; i--)
#define LOOP(i, x, n)       for (int i=x; i<=n; i++)
#define READ(x)             freopen(x, "r", stdin);
#define WRITE(x)            freopen(x, "w", stdout);
#define fastIO()            ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define PI                  acos(-1.0)
#define pb                  push_back
#define mp                  make_pair
#define fi                  first
#define se                  second

using namespace std;

typedef long long              ll;
typedef unsigned long long     ull;
typedef vector<int>            vi;
typedef pair<int, int>         pii;
typedef pair<string, int>      psi;
typedef pair<char, int>        pci;

const double eps = 1e-9;

int fx[] = {-1, 1, 0, 0, -1, -1, 1, 1};
int fy[] = {0, 0, -1, 1, -1, 1, -1, 1};

int kx[] = {1, 1, 2, 2, -1, -1, -2, -2};
int ky[] = {2, -2, 1, -1, 2, -2, 1, -1};

//set < int > q;
//set < int > :: iterator it;
#define MX 1000000009
bitset < MX > M;
deque < int > dq;
int main()
{
    int n, k; scanf("%d%d", &n, &k);

    FOR1(i, n){
        int id; scanf("%d", &id);

        if (dq.size() > 0 && M.test(id) != 0){
            continue;
        }
        if (dq.size() >= k){
            M.reset(dq.back());
            dq.pop_back();
        }
        M.set(id);
        dq.push_front(id);
//        for (auto id : dq)
//            printf("%d ", id);
//        puts("");
    }
    printf("%d\n", dq.size());
    for (auto id : dq)
        printf("%d ", id);
    return 0;
}

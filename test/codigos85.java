#include "cstdio"
#define NMAX 100001
using namespace std;
struct {
    int u, v, l;
} r[NMAX];
int n, m, k, rs = 1000000001, hasFlour[NMAX];
int main() {
    scanf("%d%d%d", &n, &m, &k);
    for (int i = 0; i < m; i++)
        scanf("%d%d%d", &r[i].u, &r[i].v, &r[i].l);
    if (k > 0) {
        int x;
        for (int i = 0; i < k; i++) {
            scanf("%d", &x);
            hasFlour[x] = 1;
        }    
    }
    for (int i = 0; i < m; i++)
        if ((hasFlour[r[i].u] + hasFlour[r[i].v] == 1)&&(r[i].l < rs))
            rs = r[i].l;
    if (rs == 1000000001)
        printf("-1");
    else
        printf("%d", rs);
    return 0;
}
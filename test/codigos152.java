#include <bits/stdc++.h>

using namespace std;

const int N = 1e6;

#define int long long

vector <pair <int,int> > ans[N];
int a[N], b[N];
bool used[N];


signed main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n, m, k;
    cin >> n >> m >> k;
    set <int> s[1000];
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    for (int i = 0; i < n; i++) {
        int z;
        cin >> z;
        b[i] = z;
        s[z].insert(a[i]);
    }
    int kol = 0;

    for (int i = 0; i < k; i++) {
        int lol, kek;
        cin >> lol;
        lol--;
        kek = a[lol];
        lol = b[lol];
        int to = *s[lol].rbegin();
        if (to != kek) {
            kol++;
            s[lol].erase(kek);
        }
    }
    cout << kol;
}

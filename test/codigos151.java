#include <bits/stdc++.h>
using namespace std;
#pragma GCC diagnostic ignored "-Wmissing-declarations"

#define FINAL_OUT(x) {cout << (x) << '\n'; exit(0);}

#define SHOW(x) std::cout << #x << " = " << x << std::endl;


inline int safe_mul(int x, int y) __attribute__ ((warn_unused_result));


vector<pair<int,int> > tsh[3];

int main()
{
//    freopen("in.txt", "r", stdin);
    //freopen("out.txt", "w", stdout);
	ios_base::sync_with_stdio(0);
	cin.tie(nullptr); cout.tie(nullptr);

    int n;
    cin >> n;
    vector<int> p(n);
    for(int& x : p)
        cin >> x;

    vector<int> a(n);
    for(int& x : a)
        cin >> x;

    vector<int> b(n);
    for(int& x : b)
        cin >> x;

    for(int i = 0; i < n; ++i)
    {
        tsh[a[i] - 1].emplace_back(p[i], i);
        if (a[i] != b[i])
            tsh[b[i] - 1].emplace_back(p[i], i);
    }

    for(int i = 0; i < 3; ++i)
        sort(tsh[i].rbegin(), tsh[i].rend());

    vector<int> used(n + 1, 0);

    int m;
    cin >> m;
    stringstream out;
    while (m--)
    {
        int x;
        cin >> x;
        --x;
        while (!tsh[x].empty() && used[tsh[x].back().second] == 1)
            tsh[x].pop_back();
        if (tsh[x].empty())
            out << "-1 ";
        else
        {
            out << tsh[x].back().first << ' ';
            used[tsh[x].back().second] = 1;
        }
    }
    cout << out.str();
}



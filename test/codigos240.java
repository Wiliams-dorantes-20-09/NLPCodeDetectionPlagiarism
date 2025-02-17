#include <iostream>
#include <vector>
#include <string>
#include <set>
#include <map>
#include <algorithm>
#include <cmath>
#include <stack>

using namespace std;



int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    string s, t;
    cin >> s >> t;
    vector<int> ab, ba;
    for (int i = 0; i < n; ++i)
    {
        if (s[i] != t[i])
        {
            if (s[i] == 'a')
                ab.push_back(i+1);
            else
                ba.push_back(i+1);
        }
    }

    if ((ab.size() + ba.size()) & 1)
        return cout << -1, 0;

    vector<pair<int, int> > ans;
    for (int i = 1; i < ab.size(); i += 2)
        ans.push_back(make_pair(ab[i], ab[i-1]));

    for (int i = 1; i < ba.size(); i += 2)
        ans.push_back(make_pair(ba[i], ba[i-1]));
    if (ab.size() & 1)
    {
        int a = ab.back();
        int b = ba.back();

        ans.push_back(make_pair(a, a));
        ans.push_back(make_pair(a, b));
    }

    cout << ans.size() << endl;
    for (int i = 0; i < ans.size(); ++i, cout << "\n")
        cout << ans[i].first << " " << ans[i].second;
}

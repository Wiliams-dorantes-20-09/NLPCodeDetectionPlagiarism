//In the name of Allah

#include<bits/stdc++.h>

using namespace std;

string s;
int ans;

int main()
{
    cin >> s;
    int cnt = 1;
    for(int i = 1; i < (int)s.size(); i ++)
    {
        if(s[i] == s[i - 1])
            cnt ++;
        else
        {
            ans += (cnt + 4) / 5;
            cnt = 1;
        }
    }
    ans += (cnt + 4) / 5;
    cout << ans << endl;
    return 0;
}

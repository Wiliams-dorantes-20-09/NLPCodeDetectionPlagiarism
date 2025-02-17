#include <bits/stdc++.h>
using namespace std;

bool check(string s, string t)
{
	int i = 0, j = 0;
	while(i < s.size() and j < t.size())
	{
		if(s[i] == t[j]) j++;
		i++;
	}
	return j == t.size();
}

int main()
{
	string s, t;
	cin >> s >> t;
	int ans = 0;
	for(int i = 0; i < s.size(); i++)
		for(int j = i; j < s.size(); j++)
		{
			string str = s.substr(0, i) + s.substr(j + 1);
			if(check(str, t)) ans = max( ans, (int)s.size() - (int)str.size() );
		}
	cout << ans << '\n';	

	return 0;
}
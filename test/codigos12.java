#include <bits/stdc++.h>

using namespace std;

long long f(long long x)
{
	x++;
	while(x%10==0){x/=10;}
	return x;
}

int main()
{
	long long x;
	cin >> x;
	set<long long> s;
	while(s.find(x)==s.end())
	{
		s.insert(x);
		//cout << x << endl;
		x=f(x);
	}
	cout << s.size() << endl;
}
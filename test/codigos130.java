//besme taala
//ya_hossein
#include<bits/stdc++.h>
using namespace std;
int o;
int neg[1000000], pos[1000000], on, ot, op;
int main()
{
	string a;
	cin >> a;
	for(int i = 0; a[i]; i++)
	{
		if(a[i] == '+')
		{
			if(on)
			{
				on--;
				pos[op] = neg[on];
				op++;
			}
			else
			{
				o++;
				pos[op] = o;
				op++;
			}
		}
		else
		{
			if(op)
			{
				op--;
				neg[on] = pos[op];
				on++;
			}
			else
			{
				o++;
				neg[on] = o;
				on++;
			}
		}
	}
	cout << o;
}
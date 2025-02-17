#include <bits/stdc++.h>
using namespace std;

typedef pair<int,int> ii;
int n;
ii a[1005];

void print(vector<int> rs) {
	cout<<rs.size()<<"\n";
	for(int x:rs)
		cout<<x<<' ';
	exit(0);
}

void case1() {
	vector<int> rs;
	for(int i=1;i<=n;i++)
		if(a[i].first%2==a[i].second%2)
			rs.push_back(i);
	print(rs);
}

void case2() {
	vector<int> rs;
	for(int i=1;i<=n;i++)
		if(a[i].first%2==0)
			rs.push_back(i);
	print(rs);
}

void process() {
	bool hasGroup1=false,hasGroup2=false;
	for(int i=1;i<=n;i++) {
		if(a[i].first%2==a[i].second%2)
			hasGroup1=true;
		else
			hasGroup2=true;
	}
	if(hasGroup1&&hasGroup2)
		case1();
	else {
		hasGroup1=false,hasGroup2=false;
		for(int i=1;i<=n;i++)
			if(a[i].first%2==0)
				hasGroup1=true;
			else
				hasGroup2=true;
		if(hasGroup1&&hasGroup2)
			case2();
	}
	for(int i=1;i<=n;i++) {
		a[i].first=(a[i].first-a[i].first%2)/2;
		a[i].second=(a[i].second-a[i].second%2)/2;
	}
	process();
}

int main() {
	ios_base::sync_with_stdio(false);
	// freopen("input","r",stdin);
	cin>>n;
	for(int i=1;i<=n;i++) {
		cin>>a[i].first>>a[i].second;
		a[i].first+=1e6;
		a[i].second+=1e6;
	}
	process();
}
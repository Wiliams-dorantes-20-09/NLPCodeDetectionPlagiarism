#include<bits/stdc++.h>
#define MOD 1000000007
#define ll long long
#define mp make_pair
#define pb push_back
#define N 100010
using namespace std;
int tree[N][11][11][5];
string s;
int getval(char x){
	if(x == 'A')
		return 1;
	if(x == 'T')
		return 2;
	if(x == 'G')
		return 3;
	if(x == 'C')
		return 4;
}
void update(int x, char y, int t = 0){
	int a = getval(s[x]);
	int b = getval(y);
	s[x] = y;
	for(int i = x; i < N; i += (i & (-1 * i))){
		for(int j = 1; j <= 10; j++){
			//cerr << i << " " << x % j << " " << " " << j << " " << b << "UPDATE" << '\n';
			if(t == 0)
				tree[i][x % j][j][a]--;
			tree[i][x % j][j][b]++;
			//cerr << i << " " << x % j << " " << j << " " << b << " " << tree[i][x % j][j][b] << "UPDATE\n";
		}
	}
}
int query(int a, int ind, int mod, char x){
	int ans = 0;
	for(int i = a; i > 0; i -= (i & (-1 * i))){
		//cerr << i << " " << ind << " " << mod << " " << getval(x) << " " << tree[i][ind][mod][getval(x)] << "QUERY\n";
		ans += tree[i][ind][mod][getval(x)];
	}
	//cerr << ans << '\n';
	return ans;
}
int queryrng(int x, int y, int ind, int mod, char a){
	return query(y, ind, mod, a) - query(x - 1, ind, mod, a); 
}
int main(){
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> s;
	s = "#" + s;
	for(int i = 1; i <= s.length(); i++){
		update(i, s[i], 1);
	}
	int q;
	cin >> q;
	while(q--){
		int t;
		cin >> t;
		if(t == 1){
			int x;
			char c;
			cin >> x >> c;
			update(x, c);
		}
		else if(t == 2){
			int l, r;
			cin >> l >> r;
			string e;
			cin >> e;
			int ans = 0;
			for(int i = 0; i < e.length(); i++){
				//cerr << l << " " << r << " " << ((l % e.length()) + i + e.length()) % e.length() << " " << e[i] << '\n';
				ans += queryrng(l, r, ((l % e.length()) + i + e.length()) % e.length(), e.length(), e[i]);
			}
			cout << ans << '\n';
		}
	}

}
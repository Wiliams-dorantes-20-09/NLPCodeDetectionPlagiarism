#include <bits/stdc++.h>
using namespace std;

char s[505][505];
int dx[2] = {0, 1};
int dy[2] = {1, 0};
int acc[505][505];
int n, m;
bool valid(int x, int y) {
	return x >= 0 && x < n && y >= 0 && y < m;
}

bool good(int x1, int y1, int x2, int y2) {
	if (!valid(x1, y1) || !valid(x2, y2))
		return false;
	return s[x1][y1] == '.' && s[x2][y2] == '.';
}

int get(int x1, int y1, int x2, int y2, int acc[505][505]) {
	if (x2 < x1 || y2 < y1)
		return 0;
	int ans = acc[x2][y2];
	if (x1)
		ans -= acc[x1 - 1][y2];
	if (y1)
		ans -= acc[x2][y1 - 1];
	if (x1 && y1)
		ans += acc[x1 - 1][y1 - 1];
	return ans;
}

int ymeen[505][505], ta7t[505][505];

int main() {
	ios::sync_with_stdio(false);

	scanf("%d%d", &n, &m);
	for (int i = 0; i < n; i++)
		scanf("%s", s[i]);

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			if (good(i, j, i, j + 1))
				ymeen[i][j] = 1;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			if (good(i, j, i + 1, j))
				ta7t[i][j] = 1;

	for (int i = 0; i < n; i++)
		for (int j = 1; j < m; j++)
			ymeen[i][j] += ymeen[i][j - 1];
	for (int j = 0; j < m; j++)
		for (int i = 1; i < n; i++)
			ymeen[i][j] += ymeen[i - 1][j];


	for (int i = 0; i < n; i++)
		for (int j = 1; j < m; j++)
			ta7t[i][j] += ta7t[i][j - 1];
	for (int j = 0; j < m; j++)
		for (int i = 1; i < n; i++)
			ta7t[i][j] += ta7t[i - 1][j];



	int q; scanf("%d", &q);

	while (q--) {
		int x1, y1, x2, y2;
		scanf("%d%d%d%d", &x1, &y1, &x2, &y2);
		x1--; y1--; x2--; y2--;
		int ans = get(x1, y1, x2, y2 - 1, ymeen) + get(x1, y1, x2 - 1, y2, ta7t);
		printf("%d\n", ans);
	}

	return 0;
}


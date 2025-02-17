#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <stdio.h>
#include <string.h>
#include <map>
#include <vector>
#include <stack>
#include <queue>
#include <deque>
#include <algorithm>
#include <cmath>
#include <set>
//#include <unordered_map>
#include <utility>
//#include <unordered_set>
#include <iostream>
using namespace std;
#define MAXN  200001
#define ll long long int
#define MOD 1000000007


#define FOR(a,b,c) for (int (a)=(b);(a)<(c);++(a))
#define FORN(a,b,c) for (int (a)=(b);(a)<=(c);++(a))
#define FORD(a,b,c) for (int (a)=(b);(a)>=(c);--(a))
#define FORSQ(a,b,c) for (int (a)=(b);(a)*(a)<=(c);++(a))
#define FORC(a,b,c) for (char (a)=(b);(a)<=(c);++(a))
#define FOREACH(a,b) for (auto &(a) : (b))
#define REP(i,n) FOR(i,0,n)
#define REPN(i,n) FORN(i,1,n)
#define MAX(a,b) a = max(a,b)
#define MIN(a,b) a = min(a,b)
#define SQR(x) ((LL)(x) * (x))
#define RESET(a,b) memset(a,b,sizeof(a))
#define fi first
#define se second
#define mp make_pair
#define pb push_back
#define ALL(v) v.begin(),v.end()
#define ALLA(arr,sz) arr,arr+sz
#define SIZE(v) (int)v.size()
#define SORT(v) sort(ALL(v))
#define REVERSE(v) reverse(ALL(v))
#define SORTA(arr,sz) sort(ALLA(arr,sz))
#define REVERSEA(arr,sz) reverse(ALLA(arr,sz))
#define PERMUTE next_permutation
#define TC(t) while(t--)

int n;
int p[101];
bool visited[26];
int main()
{
    RESET(visited, 0);
    visited['a'-'a'] = visited['e'-'a'] = visited['i'-'a'] = visited['o'-'a'] = visited['u'-'a'] = visited['y'-'a'] = true;
    cin >> n;
    REP(i, n)
    {
        cin >> p[i];
    }
    string line;
    getline(cin, line);
    bool work = true;
    REP(i, n)
    {
        getline(cin, line);
        //cout << line << endl;
        if (work == false)
            ;//continue;
        int cnt = 0;
        REP(i, line.length())
        {
            if (isalpha(line[i]) && visited[line[i]-'a'])
                cnt += 1;
        }
        if (cnt != p[i])
            work = false;
        //cout << cnt << endl;
    }
    if (work)
        cout << "YES\n";
    else
        cout << "NO\n";
  
}
#include <bits/stdc++.h>
#define ll long long

using namespace std;
map < int , int > mp;
map < int , int >::iterator it;
int a[110],b[110];

int main()
{
    int n;   cin >> n;
    for(int i = 0;i<n;i++)  cin >> a[i];
    int m;  cin >> m;
    for(int i = 0;i<m;i++)  cin >> b[i];
    for(int i = 0;i<m;i++){
        for(int j = 0;j<n;j++){
            if(b[i] % a[j] == 0){
                mp[b[i]/a[j]]++;
            }
        }
    }
    if(!mp.size())  cout << 0;
    else  {
        it = mp.end();
        it--;
        cout << it->second;
    }
    return 0;
}

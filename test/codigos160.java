#include <bits/stdc++.h>
using namespace std;
long long n,res;
int main(){


    cin >> n;
    res = n + 1;
    for (int i = 1;i * i <= n;i++){
        res = min(res,i + (n + i - 1)/i);
    }
    cout << res;
}

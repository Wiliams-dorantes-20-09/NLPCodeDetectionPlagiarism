#include <bits/stdc++.h>

using namespace std;
static long long det(long long n){
    if(n == 0)return 0;
    long long ans = 0;
    ans += 2*det(n / 2) + 1;
    return ans;
}
static int check(long long cur,long long pos, long long n){
        while(pos != cur){
        if(pos > cur)
            pos = cur - (pos - cur);
        cur /= 2;
        n /= 2;
    }
    return n % 2;
}
int main()
{
    long long n, l, r;
    cin >> n >> l >> r;
    long long tot = det(n);
    int ans = 0;
    while(l <= r){
        ans += check(tot / 2 + 1,l,n);
        ++l;
    }
    cout << ans;
}

#include <bits/stdc++.h>
#define ll long long
using namespace std;

int main() {
    int n,m;
    cin>>n>>m;
    vector< int > a(n);
    int N=n;
    for(int i=0;i<N;i++)
       scanf("%d",&a[i]);
    vector< int > cnt(n);
    for(int i=0;i<n;i++)
    {
        cnt[i]=1;
        if(i&&a[i]==a[i-1])cnt[i]+=cnt[i-1];
    }
    while(m--){
        int l,r,x;
        scanf("%d %d %d",&l,&r,&x);
        l--; r--;
        if(a[r]!=x){
            printf("%d\n",r+1);continue;
        }
        if(cnt[r]>=(r-l+1)){
            printf("-1\n");continue;
        }

        printf("%d\n",r-cnt[r]+1);continue;
    }

    return 0;
}
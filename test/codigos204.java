#include<bits/stdc++.h>
using namespace std;

int arr[10005];
int mark[10005];
int main()
{
    int i,j,n,m,t;
    scanf("%d",&n);
    for(i=1;i<=n;i++){
        scanf("%d",&arr[i]);
    }
    int last=arr[1],cnt=0;
    for(i=1;i<=n;i++){
        last=max(last,arr[i]);
        if(last==i){
            cnt++;
        }
    }
    cout<<cnt<<endl;
}
#include <bits/stdc++.h>
using namespace std;
int n,m;
const int sz=105;
int a[sz][sz];
int canr[sz];
int mnc[sz];
int mnr[sz];
map<int,int> ansr1,ansr2;

int go1(){
    int k1=0;
    for(int i=0;i<n;i++){
        if(mnc[0]==a[i][0]){
            ansr1[i]=0;
            continue;
        }
        if(canr[i]&&mnr[i]-(a[i][0]-mnc[0])>=0){
            ansr1[i]=a[i][0]-mnc[0];
            k1+=ansr1[i];
        }
        else return -1;

    }
    k1+=mnc[0];
    for(int j=1;j<m;j++){
        k1+=mnc[j];
        for(int i=0;i<n;i++){
            if(a[i][j]-ansr1[i]!=mnc[j]) return -1;
        }
    }
    return k1;
}

int go2(){
    int k2=0;
    for(int j=0;j<m;j++){
        if(mnr[0]==a[0][j]){
            ansr2[j]=0;
            continue;
        }
        if(mnc[j]-(a[0][j]-mnr[0])>=0){
            ansr2[j]=a[0][j]-mnr[0];
            k2+=ansr2[j];
        }
        else return -1;
    }
    k2+=mnr[0];
    for(int i=1;i<n;i++){
        k2+=mnr[i];
        for(int j=0;j<m;j++){
            if(a[i][j]-ansr2[j]!=mnr[i]) return -1;
        }
    }
    return k2;
}

int main()
{
    //freopen("in.txt","r",stdin);
    //freopen("out.txt","w",stdout);
    memset(mnc,600,sizeof(mnc));
    memset(mnr,600,sizeof(mnr));
    memset(canr,1,sizeof(canr));
    scanf("%d %d",&n,&m);
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            scanf("%d",&a[i][j]);
            mnr[i]=min(mnr[i],a[i][j]);
            if(a[i][j]==0) canr[i]=0;
            mnc[j]=min(mnc[j],a[i][j]);
        }
    }
    int k1=go1();
    int k2=go2();
    if(k1==-1||k2==-1){
        printf("-1");
        return 0;
    }
    printf("%d\n",min(k1,k2));
    if(k1<=k2){
        for(auto u:ansr1){
            int N=u.second;
            while(N--) printf("row %d\n",u.first+1);
        }
        for(int j=0;j<m;j++){
            while(mnc[j]--) printf("col %d\n",j+1);
        }
    }else{
        for(auto u:ansr2){
            int N=u.second;
            while(N--) printf("col %d\n",u.first+1);
        }
        for(int i=0;i<n;i++){
            while(mnr[i]--) printf("row %d\n",i +1);
        }
    }

    return 0;
}

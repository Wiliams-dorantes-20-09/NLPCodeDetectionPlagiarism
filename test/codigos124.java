///a
#include <stdio.h>

int n,s,a[111],fg[1111];

int main(){
    scanf("%d", &n);
    for(int i=0; i<n; i++){
        scanf("%d",&a[i]);
        fg[a[i]]=1;
    }
    for(int j=0; j<n; j++){
        for(int k=j+1; k<n; k++){
            s=a[k]+a[j];
            if(fg[s]){
                for(int i=0; i<n; i++)if(a[i]==s){
                    printf("%d %d %d\n",i+1,j+1,k+1);
                    return 0;
                }
            }
        }
    }
    puts("-1");
    return 0;
}

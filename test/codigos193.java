#include<bits/stdc++.h>

using namespace std;

int main(){
    
    int a,b;
    
    cin>>a>>b;
    
    int Ans = 0;
    
    while(1){
        
        if(a > b){
            
            break;
        }
        
        Ans++;
        
        a *= 3;
        
        b *= 2;
    }
    
    cout<<Ans;
}
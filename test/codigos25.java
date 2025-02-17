#include <bits/stdc++.h>
typedef long long ll;
using namespace std;

vector < vector < int > > G(200500);
int cnt[200500];
vector < int > ve ;
vector < int > res(200500);


void dfs(int node , int parent , int gcd , int deep){


    int ans = -1 ;

    vector < int > div ;

    for(int i = 1 ; i * i <= ve[node] ; i++){

          if(ve[node] % i == 0){
                 cnt[i]++ ;
                 div.push_back(i);

                 if(cnt[i] >= deep - 1) ans = max(ans , i) ;

                 if(ve[node]/i != i){

                      div.push_back(ve[node]/i);
                      cnt[ve[node]/i]++ ;

                      if(cnt[ve[node]/i] >= deep - 1) ans = max(ans , ve[node]/i );
                 }
          }
    }

    res[node] = max(gcd , ans);

    for(auto child : G[node]){
           if(child == parent) continue ;
           dfs(child , node , __gcd(ve[node] , gcd) , deep + 1) ;
    }


    for(auto it : div) cnt[it]--;
}



int main()
{
    ios::sync_with_stdio(false) ;

    int n ; cin >> n ;

    ve.push_back(0);

    for(int i = 1 ; i <= n ; i++){
         int x ; cin >> x ;
         ve.push_back(x);
    }

    for(int i = 1 ; i < n ; i++){
          int u , v ;
          cin >> u >> v ;
          G[u].push_back(v);
          G[v].push_back(u);
    }

    dfs(1 , -1 , 0 , 1);

    for(int i = 1 ; i <= n ; i++)
        cout << res[i] << " " ;

    return 0;
}

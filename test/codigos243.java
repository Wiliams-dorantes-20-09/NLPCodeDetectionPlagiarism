#include <bits/stdc++.h>

#define ll long long
#define pii pair<int,int>
//#define f first
//#define s second
#define pll pair<ll,ll>
#define all(x) x.begin(), x.end()
#define loop(xxx, yyy) for(int xxx = 0; xxx < yyy; xxx++)

using namespace std;

vector<pii> res;
int n,e;
set<int> s;

int main() {
    scanf("%d",&n);
    int l = 1;
    for(int i = 1; i <= n; i++){
        scanf("%d",&e);
        if(s.find(e) != s.end()){
            res.push_back({l,i});
            l = i+1;
            s.clear();
        }else{
            s.insert(e);
        }
    }
    if(res.empty()){
        printf("%d\n",-1);
        return 0;
    }

    res.back().second = n;
    printf("%d\n",res.size());
    for(pii p : res){
        printf("%d %d\n",p.first,p.second);
    }
    return 0;
}

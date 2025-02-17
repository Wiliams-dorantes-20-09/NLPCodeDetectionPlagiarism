#include <bits/stdc++.h>
using namespace std;
int n,m,r,c,x,y;
char a[2005][2005];
bool visited[2005][2005];
int dx[]={0,0,1,-1};
int dy[]={-1,1,0,0};
long long rd[2005][2005];
long long ld[2005][2005];
deque<pair<int,int> > q;

long long mini(long long &a,long long b){return a=min(a,b);}
long long maxi(long long &a,long long b){return a=max(a,b);}

bool valid(int i,int j) {return i>=0&&j>=0&&i<n&&j<m;}

int main()
{
    //freopen("in.txt","r",stdin);
    //freopen("out.txt","w",stdout);
    scanf("%d%d%d%d%d%d",&n,&m,&r,&c,&x,&y);
    for(int i=0;i<n;i++) scanf(" %s",&a[i]);
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++) ld[i][j]=rd[i][j]=1e18;
    }
    r--; c--;
    int ans=0;
    q.push_back({r,c});
    visited[r][c]=1;
    ld[r][c]=rd[r][c]=0;
    while(!q.empty()){
        int cr=q.front().first,cc=q.front().second;
        q.pop_front();
        for(int i=0;i<4;i++){
            int nr=cr+dx[i];
            int nc=cc+dy[i];
            if(!valid(nr,nc)||a[nr][nc]!='.'||visited[nr][nc]) continue;
            mini(ld[nr][nc],(i==0)+ld[cr][cc]);
            mini(rd[nr][nc],(i==1)+rd[cr][cc]);
            if(i<=1) q.push_back({nr,nc});
            else q.push_front({nr,nc});
            visited[nr][nc]=1;
        }
    }
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(a[i][j]!='.') continue;
            if(ld[i][j]<=x&&rd[i][j]<=y) ans++;
        }
    }
    printf("%d",ans);
    return 0;
}

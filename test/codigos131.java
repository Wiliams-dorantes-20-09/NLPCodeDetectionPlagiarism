#include<bits/stdc++.h>
using namespace std;
set<int> a[200005];
int main()
{
int n;
int i;
scanf("%d",&n);
set<int>::iterator I;
int x;
for(i=1;i<=n;i++)
{
scanf("%d",&x);
a[x].insert(i);
}
vector<int> ans;
int cur = 0;
while(1)
{
if(a[cur].size())
{
I = a[cur].begin();
x = *I;
ans.push_back(x);
a[cur].erase(x);
cur++;
}
else {
if(cur>=3)cur-=3;
else break;
}
}
if(ans.size()==n)
{
printf("Possible\n");
for(i=0;i<n;i++)
printf("%d ",ans[i]);
}
else printf("Impossible");



return 0;
}
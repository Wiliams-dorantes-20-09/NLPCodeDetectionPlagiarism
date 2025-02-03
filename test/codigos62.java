#include <iostream>
#include <bitset>

using namespace std;

bitset<300000001> g;
int l,r,i,j;
int main()
{
    g.set();
    cin >> l >> r;
    int ans = 0;
    if ((l<=2) && (2<=r))           ans++;
    if (l<=2) l = 3;
    
    
    for (i=3;(j=i*i)<=r;i+=2)
        if (g[i])
        {
                        for (;j<=r;j+=(i << 1))
                            g[j] = 0;
        }
    while ((l & 3) != 1) l++;
    for (i=l;i<=r;i+=4)
           if (g[i]) ans++;

    cout << ans << endl;
   // system("pause");
}

#include <iostream>
#define LMAX 200005

using namespace std;

bool use[4];
int sol[4];

int n;

int ans = 999999999;
char cAns[LMAX];
char s[LMAX];

char l[] = "RGB";

void solve()
{
    int act = 0;
    for (int i=0;i<n;++i)
    {
        if (s[i] != l[sol[i%3+1]-1])
        {
            ++act;
        }
    }

    if (act < ans)
    {
        ans = act;
        for (int i=0;i<n;++i)
        {
            cAns[i] = l[sol[i%3+1]-1];
        }
    }
}

void bkt(int k)
{
    if (k-1==3)
    {
        solve();
        return ;
    }
    for (int i=1;i<=3;++i)
    {
        if (use[i])
        {
            continue;
        }
        use[i] = true;
        sol[k] = i;
        bkt(k+1);
        use[i] = false;
    }
}

int main()
{
    cin>>n;
    cin.get();
    cin.getline(s, LMAX);
    bkt(1);
    cout<<ans<<'\n';
    cout<<cAns<<'\n';
    return 0;
}

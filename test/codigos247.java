#include<bits/stdc++.h>
using namespace std;

#define ll long long 


int main()
{
    int n;
    cin>>n;
    vector<int>v(n),a(n);
    for(int i=0;i<n;i++)
    {
        cin>>v[i]; a[i]=v[i];
    }
    sort(a.begin(),a.end()); int k=0;
    for(int i=0;i<n;i++)
    {
        if(v[i]!=a[i])
        k++;
        if(k>2)
        {
            cout<<"NO\n"; return 0;;
        }
    }
    cout<<"YES\n";
}
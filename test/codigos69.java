#include <iostream>
#include<bitset>
#include<vector>
#include<cmath>

using namespace std;

bool check(vector <long long> ,long long,long long,long long);

int main()
{
    int n,l,r,x,a,c=0;
    vector<long long>v;
    vector<long long> subset;
    cin>>n>>l>>r>>x;

    while(n--){
        cin>>a;
        v.push_back(a);
    }

    for(int i=0;i<pow(2,v.size());i++){
        subset.clear();
        bitset<32>b(i);
        for(int j=0;j<v.size();j++)
            if(b[j])
                subset.push_back(v[j]);
        if(check(subset,l,r,x))
            c++;
    }

    cout<<c;

    return 0;
}

bool check(vector <long long> sub,long long l,long long r,long long x){
    bool b=true;
    long long s=0,min=1000000,max=0;

    for(int i=0;i<sub.size();i++){
        s+=sub[i];
        if(sub[i]<min)
            min=sub[i];
        if(sub[i]>max)
            max=sub[i];
    }

    if(s<l || s>r || (max-min)<x)
        b=false;

    if(b)
        return true;
    else
        return false;
}

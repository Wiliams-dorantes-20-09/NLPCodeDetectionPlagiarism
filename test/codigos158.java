#include <iostream>
#include <cmath>

using namespace std;

int main()
{
    long long int a,b;
    cin >> a >> b;
    long long int x=min(a,b);
    cout << (long long int)(tgamma(x+1)+1e-9) << endl;
    return 0;
}
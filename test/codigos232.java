#include <iostream>

using namespace std;

int main()
{
    long long n;
    cin >> n;
    if (n % 2)
        return cout << 0, 0;
    cout << (n / 2 - 1) / 2;
    return 0;
}
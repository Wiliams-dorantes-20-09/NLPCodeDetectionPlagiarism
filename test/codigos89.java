
 #include <iostream>
#include <complex>
#include <algorithm>
#include <bits/stdc++.h>
using namespace std;
int main()
{
    int n, kol= 0, x = 0, y = 0;
    cin >> n;
    string kek;
    cin >> kek;
    for(int i = 0; i < kek.size()-1; i++){
        if(kek[i] == 'U'){
            y++;
        }
        else
            x++;
        if(x == y && kek[i] == kek[i+1]) kol++;
    }
    cout << kol;


}

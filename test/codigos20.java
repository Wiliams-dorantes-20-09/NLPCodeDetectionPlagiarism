# include <bits/stdc++.h>

using namespace std;

int main(){
    string s;
    cin >> s;
    int cnt = 100;
    while(cnt--){
        int n = 0;
        for (int i = 0; i < s.size(); i++)
            n = (n * 10 + (s[i] - '0')) % 7;
        if(n == 0 && s[0] != '0'){
            cout << s << endl;
            return 0;
        }
        next_permutation(s.begin(), s.end());
    }
    cout << "0" << endl;
    return 0;
}
#include<bits/stdc++.h>
using namespace std;

#define MX 1000005
int A[MX];
int F[10];

bool err;

int main()
{
    int n; scanf("%d", &n);
    for (int i = 1; i <= n; i++){
        scanf("%d", &A[i]);
        F[A[i]]++;
        if (A[i] == 7 || A[i] == 5){
            err = true;
        }
    }

    if (err){
        printf("-1\n");
        return 0;
    }

    if (F[2] >= F[4] && F[1] >= F[4]){
        F[2] -= F[4];
        F[1] -= F[4];
    } else err = true;

    int take_2 = 0, take_3 = 0;

    if (F[2] + F[3] >= F[6] && F[1] >= F[6]){
        if (F[2] < F[3]){
            take_2 =F[2];
            take_3 = F[6] - F[2];

        }
        else{
            take_3 = F[3];
            take_2 = F[6] - F[3];
        }
        F[2] -= take_2;
        F[3] -= take_3;
        F[1] -= F[6];
    } else err = true;

    if (F[1] > 0 || F[2] > 0 || F[3] > 0) err = true;

    if (err){
        printf("-1\n");
        return 0;
    }

    for (int i = 1; i <= F[4]; i++){
        printf("1 2 4\n");
    }

    for (int i = 1; i <= take_2; i++){
        printf("1 2 6\n");
    }

    for (int i = 1; i <= take_3; i++){
        printf("1 3 6\n");
    }
}

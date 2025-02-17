/**
 * @author khokharnikunj8
 */

#pragma comment(linker, "/stack:200000000")
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")

#include <bits/stdc++.h>

using namespace std;

class segment {
public :
    vector<long long> tree;
    vector<long long> lazy;

    segment(int n) {
        tree.resize(4 * n + 5, 0);
        lazy.resize(4 * n + 5, 0);
    }

    void push(int node, int start, int end) {
        if (lazy[node] != 0) {
            tree[node] += lazy[node];
            if (start != end) {
                lazy[node << 1] += lazy[node];
                lazy[node << 1 | 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }


    void update(int node, int start, int end, int l, int r, long long value) {
        if (l > r) return;
        if (start > r || l > end) return;
        push(node, start, end);
        if (l <= start && end <= r) {
            lazy[node] += value;
            push(node, start, end);
            return;
        }
        int mid = (start + end) >> 1;
        update(node << 1, start, mid, l, r, value);
        update(node << 1 | 1, mid + 1, end, l, r, value);
        tree[node] = min(tree[node << 1], tree[node << 1 | 1]);
    }
};

class EPermutationSeparation {
public:
    void solve(std::istream &in, std::ostream &out) {
        int n;
        in >> n;
        vector<int> ar(n, 0);
        vector<int> values(n, 0);
        vector<int> identity(n + 1, 0);
        for (int i = 0; i < n; i++) in >> ar[i];
        for (int i = 0; i < n; i++) in >> values[i];
        for (int i = 0; i < n; i++) identity[ar[i]] = values[i];
        segment sg(n + 1);
        long long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += identity[i];
            sg.update(1, 1, n, i, i, sum);
        }
        long long ans = LONG_LONG_MAX;
        sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += values[i];
            sg.update(1, 1, n, ar[i], n, -values[i]);
            sg.update(1, 1, n, 1, ar[i] - 1, values[i]);
            ans = min(ans, sg.tree[1]);
            ans = min(ans, sum);
        }
        out << ans << "\n";


    }
};


int main() {
    EPermutationSeparation solver;
    std::ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    std::istream &in(std::cin);
    std::ostream &out(std::cout);
    solver.solve(in, out);
    return 0;
}

#include <bits/stdc++.h>

using namespace std;
const int K = 40;
const long long md = 1e9 + 7;
const int N = 1e5 + 20;

struct ptree_t {
    struct node_t {
        int v, l, r;
        int x;
    };

    vector<node_t> t;
    int L, R;

    ptree_t(int l, int r) {
        L = l;
        R = r;
    }

    int modify(int v, int l, int r, int i, int x) {
//        cerr << "modify "  << v << " " << l << " " << r << " " << i << " " << x << endl;
        int idx = get_index();
        t[idx] = t[v];
        t[idx].v = idx;

        if (l == r) {
            t[idx].x = x;
            return idx;
        }

        int c = (l + r) >> 1;
        if (i <= c) {
            int vv = modify(t[idx].l, l, c, i, x);
            t[idx].l = vv;
        } else {
            int vv = modify(t[idx].r, c + 1, r, i, x);
            t[idx].r = vv;
        }
        t[idx].x = t[t[idx].l].x + t[t[idx].r].x;
        return idx;
    }


    int modify(int v, int i, int x) {
//        cerr << v << " " << i << " " << x << endl;
        return modify(v, L, R, i, x);
    }

    int initialize(int l, int r, int x) {
        int v = get_index();
        t[v].v = v;
        if (l == r) {
            t[v].x = x;
            return v;
        }

        int c = (l + r) >> 1;
        int vl = initialize(l, c, x);
        t[v].l = vl;
        int vr = initialize(c + 1, r, x);
        t[v].r = vr;
        t[v].x = t[t[v].l].x + t[t[v].r].x;
        return v;
    }

    int initialize(int x) {
        return initialize(L, R, x);
    }

    int query(int ll, int rr, int l, int r, int v) {
        if (r < ll || rr < l)
            return 0;
        if (ll <= l && r <= rr)
            return t[v].x;
        int c = (l + r) >> 1;
        return
            query(ll, rr, l, c, t[v].l) +
            query(ll, rr, c + 1, r, t[v].r);
    }

    int query(int v, int l, int r) {
        return query(l, r, L, R, v);
    }

    int get_index() {
        int index = t.size();
        t.resize(t.size() + 1);
        t[index].v = index;
        t[index].l = t[index].r = -1;
//        cerr << "index " << index << endl;
        return index;
    }

    void print(int v, int l, int r) {
        if (l == r) {
            cout << t[v].x << " ";
            return;
        }
        int c = (l + r) >> 1;
        print(t[v].l, l, c);
        print(t[v].r, c + 1, r);
    }

    void print(int v) {
        print(v, L, R);
        cout << "\n";
    }
};

int main() {
    ios::sync_with_stdio(false);

#ifdef VK_LOCAL
//    freopen("output.txt", "w", stderr);
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif // VK_LOCAL

    int n, k;
    cin >> n >> k;

    vector<int> a(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    vector<queue<int> > idx(N);

    vector<int> roots;

    ptree_t tree(0, n - 1);
    int cur_root = tree.initialize(0);

    for (int i = 0; i < n; i++) {
        cur_root = tree.modify(cur_root, i, 1);
        idx[a[i]].push(i);
        if (idx[a[i]].size() > k) {
            int j = idx[a[i]].front();
            idx[a[i]].pop();

            cur_root = tree.modify(cur_root, j, 0);
        }

        roots.push_back(cur_root);
//        tree.print(cur_root);
    }

    int q;
    cin >> q;
    int last_answer = 0;
    while (q--) {
        int x, y;
        cin >> x >> y;

        int l = (x + last_answer) % n + 1;
        int r = (y + last_answer) % n + 1;
        if (l > r)
            swap(l, r);

        l--;
        r--;
        int answer = tree.query(roots[r], l, r);
        cout << answer << "\n";
        last_answer = answer;
    }

    return 0;
}

#include <bits/stdc++.h>
#define err(args...) {}
#ifdef DEBUG
#include "_debug.cpp"
#endif
using namespace std;
using ll = long long;
using ld = long double;
template <typename T> using lim = numeric_limits<T>;
template <typename T> istream& operator>>(istream& is, vector<T>& a) { for(T& x : a) { is >> x; } return is; }
template <bool Directed, typename TEdge, bool Index> struct graph {
    using EType = TEdge;
    vector<TEdge> edges;
    vector<vector<int>> adj;
    graph(int n) : adj(n + Index) {}
    graph(int n, int m) : graph(n) { edges.reserve(m << not Directed); }
    TEdge& operator()(int e) { return edges[e]; }
    vector<int>& operator[](int u) { return adj[u]; }
    int size() { return adj.size() - Index; }
    void add_edge(const TEdge& e) {
        adj[e.u].push_back(edges.size());
        edges.push_back(e);
        if(not Directed) {
            adj[e.v].push_back(edges.size());
            edges.push_back(e.reverse());
        }
    }
};
struct edge {
    int u, v;
    edge reverse() const { return {v, u}; }
    friend ostream& operator<<(ostream& os, const edge& e) {
        return os << "(" << e.u << ", " << e.v << ")";
    }
};
template <typename T> using f = function<T>;
template <typename TEdge> struct dfs_params {
    f<void(int)> pre_node{[](int) -> void {}};
    f<void(int)> pos_node{[](int) -> void {}};
    f<void(TEdge&)> pre_edge{[](TEdge&) -> void {}};
    f<void(TEdge&)> pos_edge{[](TEdge&) -> void {}};
    int root = 0;
};
template <bool Directed, typename TEdge, bool Index, typename TParamsetter = f<void(dfs_params<TEdge>&)>>
vector<int> dfs(graph<Directed, TEdge, Index>& g, const TParamsetter& psetter = [](dfs_params<TEdge>&) {}) {
    static_assert(is_convertible<decltype(psetter), f<void(dfs_params<TEdge>&)>>::value, "psetter must be void(dfs_params<TEdge>&)");
    dfs_params<TEdge> params;
    psetter(params);
    vector<int> component(g.adj.size());
    function<void(int, int)> dfs = [&](int u, int c) {
        component[u] = c;
        params.pre_node(u);
        for(int e : g[u]) if(not component[g(e).v]) {
            params.pre_edge(g(e)), dfs(g(e).v, c), params.pos_edge(g(e));
        }
        params.pos_node(u);
    };
    if(params.root) {
        dfs(params.root, 1);
    } else {
        for(int u = Index, c = 0; u < g.adj.size(); u++) if(not component[u]) {
            dfs(u, ++c);
        }
    }
    return component;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    vector<string> s(n);
    cin >> s;
    set<char> used;
    for(string& ss : s) {
        used.insert(ss.begin(), ss.end());
    }
    graph<0, edge, 0> g(n + used.size());
    map<char, int> m;
    int id = 0;
    for(char c : used) {
        m[c] = id++;
    }
    vector<bool> seen(used.size());
    for(int i = 0; i < n; i++) {
        fill(seen.begin(), seen.end(), false);
        for(char c : s[i]) {
            if(not seen[m[c]]) {
                g.add_edge({i, n + m[c]});
                seen[m[c]] = true;
            }
        }
    }
    auto comp = dfs(g);
    cout << *max_element(comp.begin(), comp.end()) << endl;
    return 0;
}

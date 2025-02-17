/**
 * @author khokharnikunj8
 */

#include <bits/stdc++.h>

using namespace std;

void ATwoRegularPolygons(std::istream &in, std::ostream &out) {
    int n, m;
    in >> n >> m;
    if (n % m == 0) out << "YES\n";
    else out << "NO\n";

}

int main() {
    class Solver {
    public:
        void solve(std::istream &in, std::ostream &out) {
            return ATwoRegularPolygons(in, out);
        }
    };
    Solver solver;
    std::ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    std::istream &in(std::cin);
    std::ostream &out(std::cout);
    int n;
    in >> n;
    for (int i = 0; i < n; ++i) {
        solver.solve(in, out);
    }

    return 0;
}

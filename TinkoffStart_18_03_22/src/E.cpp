#include <bits/stdc++.h>

using namespace std;

int main() {
    int n, k;
    cin >> n >> k;
    vector<int> arr(n);
    for (int i = 1; i <= n; ++i) {
        arr[i - 1] = i;
    }
    int ans = 0;
    do {
        int hash = 0;
        for (int i = 1; i <= n; ++i) {
            hash = (hash + arr[i - 1] * i) % k;
        }
        if (hash == 0) ans++;
    } while (next_permutation(arr.begin(), arr.end()));
    cout << ans;
}

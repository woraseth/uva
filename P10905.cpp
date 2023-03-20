// draft
#include <iostream>
#include <algorithm>
#include <sstream>
#include <vector>
#include <string>
using namespace std;

bool compare(string a, string b) {
    if (a[0] < b[0])
        return false; 
    int m = min(a.length(), b.length());
    for (int i = 0 ;i < m; i++) {
        if (a[0] < b[0])
            return false; 
    }
    return true;
}

main() {
    int n;
    cin >> n;
    while (n != 0) {
        vector<string> v;
        for (int i = 0; i < n; i++) {
            string s;
            cin >> s; 
            v.push_back(s);
        }
        
        sort(v.begin(), v.end(), compare);   
        for (string s : v) {
            cout << s;
        }
        cout << endl;
        cin >> n;
    }

}


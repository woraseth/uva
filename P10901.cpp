// draft
#include <iostream>
#include <fstream>
#include <algorithm>
#include <queue>
#include <string>
using namespace std;

main() {
    //ifstream cin("c:\\temp\\input.txt");  
    int test;
    int n, m, t;
    cin >> test;

    for (int i = 0 ;i < test; i++) {
        queue<pair<int,int>> q[2];
        cin >> n >> t >> m;
        int car[m];
        for (int j = 0 ;j < m; j++) {
            int time;
            string side;
            cin >> time;
            cin >> side;
            q[side == "left" ? 0 : 1].push({time,j});
        }
        int large = 200000000;
        q[0].push({large, large});
        q[1].push({large, large});

        int side = 0;   // 0 is left
        int time = 0;
        while (q[0].size() > 1 || q[1].size() > 1) {
            int another_side = side == 0 ? 1 : 0;
            if (q[side].front().first <= time) {
                int count = 0;
                while (q[side].front().first <= time) {
                    count++;
                    if (count > n) break;
                    car[q[side].front().second] = time + t;
                    q[side].pop();
                }
                side = another_side;
                time += t;
            } else if (q[side].front().first > q[another_side].front().first) {
                side = another_side;
                time = q[another_side].front().first;
                time += t;
                
            } else {
                time = q[side].front().first;
            }
        }
        for (int i = 0 ;i < m; i++) {
            cout << car[i] << endl;
        }
        cout << endl;
    }
    

}


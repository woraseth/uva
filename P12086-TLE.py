# 12086 - Potentiometers.  TLE

class Fenwick:
    def __init__(self, arr):
        self.n = len(arr)
        self.bit = [0] * (self.n + 1)
        self.arr = arr[:]
        for i, val in enumerate(arr):
            self._add_internal(i, val)

    def set(self, idx, x):
        delta = x - self.arr[idx]
        self.arr[idx] = x
        self._add_internal(idx, delta)

    def sum(self, l, r):
        return self._prefix(r) - self._prefix(l - 1)

    def _add_internal(self, idx, delta):
        i = idx + 1
        while i <= self.n:
            self.bit[i] += delta
            i += i & -i

    def _prefix(self, idx):
        if idx < 0:
            return 0
        res, i = 0, idx + 1
        while i > 0:
            res += self.bit[i]
            i -= i & -i
        return res

import sys
it = iter(sys.stdin.read().split())

cse = 0
while True:
    n = int(next(it))
    if n == 0:
        break

    arr = [int(next(it)) for i in range(n)]
    fw = Fenwick(arr)
    cse += 1
    if cse > 1:
        print()
    print(f'Case {cse}:')
    while True:
        cmd = next(it)
        if cmd == 'END':
            break
        elif cmd == 'S':
            fw.set(int(next(it))-1, int(next(it)))
        else:
            print(fw.sum(int(next(it))-1, int(next(it))-1))


'''
cse = 0
while True:
    n = int(sys.stdin.readline())
    if n == 0:
        break

    arr = [int(sys.stdin.readline()) for i in range(n)]
    fw = Fenwick(arr)
    cse += 1
    if cse > 1:
        print()
    print(f'Case {cse}:')
    while True:
        cmd = sys.stdin.readline()
        if cmd.strip() == 'END':
            break
        cmd = cmd.split()
        if cmd[0] == 'S':
            fw.set(int(cmd[1])-1, int(cmd[2]))
        else:
            #print(cmd[1], cmd[2])
            print(fw.sum(int(cmd[1])-1, int(cmd[2])-1))

'''
'''
import sys



cse = 0
while True:
    n = int(sys.stdin.readline())
    if n == 0:
        break

    arr = [int(sys.stdin.readline()) for i in range(n)]
    fw = Fenwick(arr)
    cse += 1
    if cse > 1:
        print()
    print(f'Case {cse}:')
    while True:
        cmd = input()
        if cmd == 'END':
            break
        cmd = cmd.split()
        if cmd[0] == 'S':
            fw.set(int(cmd[1])-1, int(cmd[2]))
        else:
            #print(cmd[1], cmd[2])
            print(fw.sum(int(cmd[1])-1, int(cmd[2])-1))

'''
'''
cse = 0
while True:
    n = int(input())
    if n == 0:
        break

    arr = [int(input()) for i in range(n)]
    fw = Fenwick(arr)
    cse += 1
    if cse > 1:
        print()
    print(f'Case {cse}:')
    while True:
        cmd = input()
        if cmd == 'END':
            break
        cmd = cmd.split()
        if cmd[0] == 'S':
            fw.set(int(cmd[1])-1, int(cmd[2]))
        else:
            #print(cmd[1], cmd[2])
            print(fw.sum(int(cmd[1])-1, int(cmd[2])-1))

'''

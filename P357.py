# 357
amount = 30000
coins = [1,5,10,25,50]
cols = amount + 1
rows = len(coins)
m = [[1] * cols for _ in range(rows)]
#m[0] = [1] * cols
#m[0][0] = 0 # not used

for r in range(1, rows):
  coin = coins[r]
  for c in range(1, cols):
    if coin > c:
      m[r][c] = m[r-1][c]
    else:
      #m[r][c] = max(m[r-1][c], m[r][c-coin]) + 1
      m[r][c] = m[r-1][c] + m[r][c-coin]


import sys

for line in sys.stdin.readlines():
  x = int(line)
  y = m[-1][x]
  if y == 1:
    print(f'There is only 1 way to produce {x} cents change.')
  else:
    print(f'There are {y} ways to produce {x} cents change.')
  

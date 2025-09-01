# 10110 Light, more light

'''
while True:
    n = int(input())
    if n == 0:
        break
    x = False
    for i in range(n):
        j = i+1
        if n % j == 0:
            x = not x
    print('yes' if x else 'no')
'''
while True:
    n = int(input())
    if n == 0:
        break
    print('yes' if n == int(n**0.5)**2 else 'no')

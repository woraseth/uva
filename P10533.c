// 10533 - Digit Primes
// has to use index for 'end'

#include <stdio.h>
#include <stdlib.h>

#define isComposite_length 1000001
int isComposite[isComposite_length];
int dp[30200];
int dpLen;

void sieve(int n) {
  int i, j;
  dpLen = 0;
  isComposite[0] = 1;
  isComposite[1] = 1;
  for (i = 2; i < isComposite_length; i++) {
    if (!isComposite[i]) {
      int m = i;
      int s = 0;
      while (m != 0) {
        s += m % 10;
        m /= 10;
      }
      if (!isComposite[s]) {
        dp[dpLen++] = i;
      }
      for (j = i + i; j < isComposite_length; j += i) {
        isComposite[j] = 1;
      }
    }
  }
  dp[dpLen] = 2000000000;  // terminate
}

int main() {
  sieve(1000000);
  int t, tt;
  scanf("%d", &tt);
  for (t = 0; t < tt; t++) {
    int start, end;
	scanf("%d", &start);
	scanf("%d", &end);
	int i = 0;
    while (dp[i++] < start);

    int j;
    if (end > 809213) j = dpLen - 1;
    else if (end > 626953) j = 25000;
    else if (end > 453371) j = 20000;
    else if (end > 287851) j = 15000;
    else j = 10000;
    
	while (dp[j--] > end);

    printf("%d\n", j - i+3);
  }
}

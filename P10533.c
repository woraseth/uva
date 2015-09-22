//   10533 - Digit Primes
// 0.483s

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
	int i;
	
	if (start < 42863) i = 0;
	else if (start < 102547) i = 2000;
	else if (start < 159473) i = 4000;
	else if (start < 221873) i = 6000;
	else if (start < 287851) i = 8000;
	else if (start < 352423) i = 10000;
	else if (start < 420421) i = 12000;
	else if (start < 489343) i = 14000;
	else if (start < 557671) i = 16000;
	else if (start < 626953) i = 18000;
	else if (start < 698413) i = 20000;
	else if (start < 772573) i = 22000;
	else if (start < 847129) i = 24000;
	else if (start < 920651) i = 26000;
	else if (start < 995833) i = 28000;
	else i = 30000;
    
    while (dp[i++] < start);

    int j;
    if (end > 995833) j = dpLen - 1;
    else if (end > 920651) j = 30000;
    else if (end > 847129) j = 28000;
    else if (end > 772573) j = 26000;
    else if (end > 698413) j = 24000;
    else if (end > 626953) j = 22000;
    else if (end > 557671) j = 20000;
    else if (end > 489343) j = 18000;
    else if (end > 420421) j = 16000;
    else if (end > 352423) j = 14000;
    else if (end > 287851) j = 12000;
    else if (end > 221873) j = 10000;
    else if (end > 159473) j = 8000;
    else if (end > 102547) j = 6000;
    else if (end > 42863) j = 4000;
    else j = 2000;
    
	while (dp[j--] > end);

    printf("%d\n", j - i+3);
  }
}

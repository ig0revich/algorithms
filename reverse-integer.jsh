//usr/bin/env jshell -R -ea "$0" "$@"; exit $?
/*
Given a 32-bit signed integer, reverse digits of an integer.

Note:
Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Example 1:

Input: x = 123
Output: 321

Example 2:

Input: x = -123
Output: -321

Example 3:

Input: x = 120
Output: 21

Example 4:

Input: x = 0
Output: 0
 
Constraints:
-2^31 <= x <= 2^31 - 1 */
int reverse(int x) {
   int rev = 0;
   while(x != 0) {
      int pop = x % 10;
      x /= 10;
      if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
      if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0; 
      rev = rev * 10 + pop;
   }
   return rev;
}

assert 123 == reverse(321)
assert -875765 == reverse(-567578)

int[] inp = {123, 0, 111, 2323, -7890, -2147483648};

for(int i=0; i<inp.length; i++) {
   System.out.println(
      String.format("%d reversed: %d", inp[i], reverse(inp[i])));
}
/exit

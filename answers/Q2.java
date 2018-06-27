public static void checkPrime(int x){
    // To test whether an int x is a prime
    int maxFactor = (int)Math.sqrt(x);   // find the nearest integral square root of x
    assume x is a prime;
    for (int factor = 2; factor <= maxFactor; ++factor) {
       if (x is divisible by factor) {
          x is not a prime;
          break;    // a factor found, no need to find more factors
       }
    }
 }

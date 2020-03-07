package Utils;

public class SievePrime {
	private static int [] primes = new int [GenCryptoUtils.PRIME_SIZE];
	
    public static void sieve(int n) { 
        boolean prime[] = new boolean[n+1]; 
        for(int i=0;i<n;i++) 
            prime[i] = true;  
        for(int p = 2; p*p <=n; p++) { 
            if(prime[p] == true){ 
                for(int i = p*p; i <= n; i += p) 
                    prime[i] = false; 
            } 
        }
        int p=0;
        for(int i = 2; i <= n; i++) { 
            if(prime[i] == true) {
            	primes[p] = i;
            	p++;
            }                 
        }
    }
    
    public static int [] getPrimes() {
    	sieve(GenCryptoUtils.PRIME_N);
    	return primes;
    }
}

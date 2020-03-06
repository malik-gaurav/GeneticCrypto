import java.util.Random;

public class gabtp {
	
	public static int[] primes = new int[25];
	public static Random rnd = new Random();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		keyGen();
	}
	public static void keyGen() {
		
		String[] rndInts = new String[16]; //16 random chars
		int[][] arrChar = new int[16][8]; //binary format 8 bits
		int rndInt;
		for(int i=0;i<rndInts.length;i++) {
			rndInt = 65+rnd.nextInt(26);//range(A-Z)
			rndInts[i] = Integer.toBinaryString(rndInt);
			rndInts[i]="0"+rndInts[i];
			for(int j=0;j<8;j++) {
				arrChar[i][j]=rndInts[i].charAt(j)-48;//char to int
			}
		}
		SoE(100);
		int[][] arrPrm = new int[16][8];
		int rndPrm;
		String rndPrmBinary;
		for(int i=0;i<16;i++) {
			rndPrm = rnd.nextInt(25);
			rndPrmBinary = Integer.toBinaryString(primes[rndPrm]);
			while(rndPrmBinary.length()<8) {
				rndPrmBinary="0"+rndPrmBinary;
			}
			for(int j=0;j<8;j++) {
				arrPrm[i][j]=rndPrmBinary.charAt(j)-48;
			}
		}
		crossover(arrChar,arrPrm);
		mutation(arrChar,arrPrm);
	}

    public static void SoE(int n) { 
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
    
    public static void crossover(int[][] A, int[][] B){
    	int[] pts = new int[16];
    	for(int i=0;i<16;i++) {
    		pts[i] = 1+rnd.nextInt(7); 
    	}
    	for(int i=0;i<16;i++) {
    		int j=0,temp;
    		while(j<pts[i]) {
    			temp=A[i][j];
    			A[i][j]=B[i][j];
    			B[i][j]=temp;
    			j++;
    		}
    	}
    }
    
    public static void mutation(int[][] A, int[][] B) {
    	for(int i=0;i<16;i++) {
    		A[i][0]=((A[i][0]==0)?1:0);
    		A[i][7]=((A[i][7]==0)?1:0);
    		B[i][0]=((B[i][0]==0)?1:0);
    		B[i][7]=((B[i][7]==0)?1:0);
    	}
    }
    
}

import java.util.Random;

import Operators.*;
import Utils.GenCryptoUtils;
import Utils.SievePrime;

public class KeyGen {
	
	private static Random rnd = new Random();
	
	public static int [][] keyGen() {
		
		String[] rndInts = new String[GenCryptoUtils.KEY_SIZE]; //16 random chars
		int[][] arrChar = new int[GenCryptoUtils.KEY_SIZE][GenCryptoUtils.BINARY_SIZE]; //binary format 8 bits
		
		int rndInt;
		for(int i=0;i<rndInts.length;i++) {
			rndInt = 65+rnd.nextInt(26);//range(A-Z)
			rndInts[i] = Integer.toBinaryString(rndInt);
			rndInts[i]="0"+rndInts[i];
			for(int j=0;j<GenCryptoUtils.BINARY_SIZE;j++) {
				arrChar[i][j]=rndInts[i].charAt(j)-48;//char to int
			}
		}
		int [] primes = SievePrime.getPrimes();
		
		int[][] arrPrm = new int[GenCryptoUtils.KEY_SIZE][GenCryptoUtils.BINARY_SIZE];
		int rndPrm;
		String rndPrmBinary;
		for(int i=0;i<16;i++) {
			rndPrm = rnd.nextInt(25);
			rndPrmBinary = Integer.toBinaryString(primes[rndPrm]);
			while(rndPrmBinary.length()<GenCryptoUtils.BINARY_SIZE) {
				rndPrmBinary="0"+rndPrmBinary;
			}
			for(int j=0;j<8;j++) {
				arrPrm[i][j]=rndPrmBinary.charAt(j)-48;
			}
		}
		Crossover.cross(arrChar,arrPrm);
		Mutation.mutate(arrChar,arrPrm);
		
		return arrChar;
	}
}

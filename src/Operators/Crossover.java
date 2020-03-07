package Operators;

import java.util.Random;

import Utils.GenCryptoUtils;

public class Crossover {
	private static Random rnd = new Random();
	public static void cross(int [][]A, int [][]B) {
		int[] pts = new int[GenCryptoUtils.KEY_SIZE];
    	for(int i = 0; i < GenCryptoUtils.KEY_SIZE; i++) {
    		pts[i] = 1+rnd.nextInt(7); 
    	}
    	for(int i = 0; i < GenCryptoUtils.KEY_SIZE; i++) {
    		int j = 0,temp;
    		while(j < pts[i]) {
    			temp = A[i][j];
    			A[i][j] = B[i][j];
    			B[i][j] = temp;
    			j++;
    		}
    	}
	}
}

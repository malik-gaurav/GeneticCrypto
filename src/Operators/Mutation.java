package Operators;

import Utils.GenCryptoUtils;

public class Mutation {
	public static void mutate(int [][]A, int [][]B) {
		for(int i = 0; i < GenCryptoUtils.KEY_SIZE; i++) {
    		A[i][0] = ((A[i][0]==0)?1:0);
    		A[i][7] = ((A[i][7]==0)?1:0);
    		B[i][0] = ((B[i][0]==0)?1:0);
    		B[i][7] = ((B[i][7]==0)?1:0);
    	}
	}
}

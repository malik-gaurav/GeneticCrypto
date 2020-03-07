
public class GenCryptoMain {
	public static void main(String[] args) {
		int [][] key = KeyGen.keyGen();
		
		for(int i = 0; i < key.length; i++) {
			for(int j = 0; j < key[i].length; j++) {
				System.out.print(key[i][j]);
			}
			System.out.println();
		}
	}
}

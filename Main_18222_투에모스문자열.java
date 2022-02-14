import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_18222_투에모스문자열 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long K = Long.parseUnsignedLong(br.readLine());
		K--;
		
		int s = 0;
		while(true){
            if(K == 0) break;
            s += K%2;
            K = K/2;
        }
        
        if(s % 2 == 0) System.out.println(0);
        else System.out.println(1);
		
//		int s = Long.bitCount(K);
//		if(s % 2 == 0) System.out.println(0);
//		else System.out.println(1);
	}

}

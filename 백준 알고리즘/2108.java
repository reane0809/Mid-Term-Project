import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] list = new int[8001];

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			list[temp + 4000] += 1;
		}

		boolean minFlag = false;
		int min = 0, max = 0, sum = 0;	
		int mode = 0;
		int modeIdx = 0;

		boolean modeFlag = false; // 최빈값 중복..
		
		int cnt = 0; 
		int median = 0; 
		for (int i = 0; i < list.length; i++) {
			if (list[i] != 0) {
				if (!minFlag) {
					min = i-4000;
					minFlag = true;
				}
				max = i-4000;
				sum += list[i]*(i-4000);
			
				
				if (cnt <= (N / 2)) {
				
					cnt += list[i];
					median = i - 4000;
				}

				
				if (mode < list[i]) {
					modeIdx = i;
					mode = list[i];
					modeFlag = false;
					
					
				} else if (mode == list[i] && !modeFlag) {
					modeIdx = i;	
					modeFlag = true;	
				}
				
			}

		}
		
		System.out.println(Math.round((double)sum/N));
		System.out.println(median);
		System.out.println(modeIdx - 4000);
		System.out.println(max-min);
	}

}

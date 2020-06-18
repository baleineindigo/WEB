package algorithm01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.xml.bind.annotation.W3CDomHandler;

public class GunManTest {

	public static void main(String[] args)throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] scores = new int[T];
		
		for(int tcn=1; tcn<=T; tcn++){
			int Score = 0;
			HashMap<Integer,Integer> bangs = new HashMap<Integer,Integer>();
			int X = sc.nextInt();
			int Y = sc.nextInt();
			
			char[ ][ ] map = new char[X][Y];
			
			for(int i=0; i<X; i++){			
				for(int j=0; j<Y ;j++){
					map[i][j] = sc.next().charAt(0);				
				}	
			}//fill map
//////////////////////////////////////////////////////////////////////////////
			System.out.println("starting "+tcn+"th game");
			for(int i=0; i<X; i++){			
				for(int j=0; j<Y ;j++){
					if (map[i][j]=='G') {
						System.out.println("GUNMAN @ "+i+" / "+j);
						// up start
						for (int up = i-1; up> -1; up--) {
							char item = map[up][j];
							if (item=='W' || item=='G') {
								System.out.println("up "+up+"/"+j+" is "+item);
								break;
							}else if (item=='T') {
								if (bangs.remove(up, j)) {
									bangs.put(up, j);
									System.out.println("ALREADY BANG! up "+up+"/"+j+" is "+item);
									break;
								}else {
									System.out.println("BANG! up "+up+"/"+j+" is "+item);
									Score++;
									bangs.put(up, j);
									break;
								}
								
							}else if(item=='0'){
								System.out.println("0");
								continue;
							}
						}// up end
						System.out.println("-----finished up");
						///////////////////////
						// down start
						for (int down = 1; i+down < X; down++) {
							char item = map[i+down][j];
							if (item=='W' || item=='G') {
								System.out.println("down "+(i+down)+"/"+j+" is "+item);
								break;
							}else if (item=='T') {							
								if (bangs.remove(i+down, j)) {
									bangs.put(i+down, j);
									System.out.println("ALREADY BANG! down "+(i+down)+"/"+j+" is "+item);
									break;
								}else {
									System.out.println("BANG! down "+(i+down)+"/"+j+" is "+item);
									Score++;
									bangs.put(i+down, j);
									break;
								}
								
							}else if(item=='0'){
								System.out.println("0");
								continue;
							}
						}// down end
						System.out.println("-----finished down");
						///////////////////////
						// left start
						for (int left = j-1; left> -1; left--) {
							char item = map[i][left];
							if (item=='W' || item=='G') {
								System.out.println("left "+i+"/"+left+" is "+item);
								break;
							}else if (item=='T') {
								if (bangs.remove(i, left)) {
									bangs.put(i, left);
									System.out.println("ALREADY BANG! left "+i+"/"+left+" is "+item);
									break;
								}else {
									System.out.println("BANG! left "+i+"/"+left+" is "+item);
									Score++;
									bangs.put(i, left);
									break;
								}
								
							}else if(item=='0') {
								System.out.println("0");
								continue;
							}
						}// left end
						System.out.println("-----finished left");
						///////////////////////
						//right start
						for (int right = 1; j+right< Y; right++) {
							System.out.println(i+"/"+(j+right));
							char item = map[i][j+right];
							if (item=='W' || item=='G') {
								System.out.println("right "+i+"/"+(j+right)+" is "+item);
								break;
							}else if (item=='T') {
								if (bangs.remove(i,j+right)) {
									bangs.put(i,j+right);
									System.out.println("already BANG! right "+i+"/"+(j+right)+" is "+item);
									break;
								}else {
									System.out.println("BANG! right "+i+"/"+(j+right)+" is "+item);
									bangs.put(i,j+right);
									Score++;
									break;
								}
								
							}else if(item=='0') {
								System.out.println("0");
								continue;
							}
						}// right end
						System.out.println("-----finished right");
						///////////////////////
					} else { //if문시작
						continue;
					}//if문끝
				}//forLopp 2	
			}//답안
		scores[tcn-1] = Score;
		System.out.println("finisehd "+tcn+"th game........");
		}//tcn for
	for (int z : scores) {
		System.out.println("SCORE ::: " +z);
	}
	}//main	
}//class




/*
Input Data
 
2
5 7
T 0 T 0 G 0 G
0 W T W W W 0
T W G 0 T W T
0 0 0 T G W 0
0 0 T 0 0 W 0
2 10
T W 0 G 0 W 0 G 0 W
G 0 T W T 0 T W T 0

*/

/*
Output

#1 6 
#2 2 
 */







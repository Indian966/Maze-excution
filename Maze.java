package Maze1;

/**************** Java 미로찾기 프로그램입니다.**************************
최종 수정일 : 2015.12.01
**************************************************************/
import java.io.FileReader;
import java.io.IOException;



public class Maze {
	
	static int ROW = 20;
	
	static int COL = 42; //40이여야하는데 무슨이유인지 모르나 2개의 열을 더 넣어야 빈칸이 없어지고 제대로 실행이된다
	
	static char[][] maze = new char[ROW][COL];

	public static void main(String[] args) {
		
		FileReader fr = null;
		try {
			
			String Path = Maze.class.getResource("").getPath();
			fr = new FileReader("maze.txt");
			
			int c;
			for (int i = 0; i < ROW; i++) {
				for (int j = 0; j < COL; j++) {
					c = fr.read();
					if (c == '1' || c == '0' || c == 'x')
						maze[i][j] = (char) c;
				}
			}
		} catch (IOException e) {
			
		}
		
		int x, y;
		Element here = new Element(0, 0);
		ArrayStack s = new ArrayStack();
		
		//방향
		while (maze[here.x][here.y] != 'x') {

			x = here.x;     
			y = here.y;
			maze[x][y] = '*';
			s.Direction(x - 1, y + 1); 
			s.Direction(x - 1, y);
			s.Direction(x - 1, y - 1);
			s.Direction(x, y - 1);
			s.Direction(x + 1, y - 1);
			s.Direction(x + 1, y);
			s.Direction(x + 1, y + 1);
			s.Direction(x, y + 1);
			
			if (s.isEmpty()) {
				
				return;
			}
			
			else{ here = s.pop(); } 
			
			for (int i = 0; i < ROW; i++) {
				for (int j = 0; j < COL; j++) {
					System.out.print(maze[i][j]);
				}
				System.out.println();
			}	
			try {              //눈에보기기위해 딜레이함수 사용 
				Thread.sleep(100);								
			} catch (InterruptedException e) {
				
			}
		}
		
		System.out.println("=====끝=====");
	}
}

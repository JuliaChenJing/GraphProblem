package bfs;

//请在文件开头注释里说明一下为什么选择这段代�?作为例�?。确�?文件公开�?��?，然�?�贴链接作为回�?：solution is easy to understand and beautiful.
public class IslandCount {
	
	/*
	 * input:  binaryMatrix = [ [0,    1,    0,    1,    0],
                                [0,    0,    1,    1,    1],
                                [1,    0,    0,    1,    0],
                                [0,    1,    1,    0,    0],
                                [1,    0,    1,    0,    1] 
                               ]

     output: 6 # since this is the number of islands in binaryMatrix.
          # See all 6 islands color-coded below.
	 */
	
	public static void main(String[] args) {
		int[][] binaryMatrix = { { 1, 1 }, { 0, 1 }, { 0, 1 } };
		System.out.println(getNumberOfIslands(binaryMatrix));

		int[][] sea = new int[][] {
			new int[] { 0, 1, 0, 1, 0 }, 
			new int[] { 0, 0, 1, 1, 1 },
			new int[] { 1, 0, 0, 1, 0 },
			new int[] { 0, 1, 1, 0, 0 },
			new int[] { 1, 0, 1, 0, 1 } };

		int numOfIslands = IslandCount.countIslands(sea);
		System.out.println("Number of islands is " + numOfIslands);
	}

	// my method, some situation not considered
	static int getNumberOfIslands(int[][] binaryMatrix) {

		int numOfIslands = 0;
		int row = binaryMatrix.length;
		int column = binaryMatrix[0].length;

		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++) {
				if (binaryMatrix[i][j] == 1) {

					// left top corner, but it could be right top ,so not good
					if (i == 0 && j == 0 && binaryMatrix[i][j] == 1)
						numOfIslands++;

					if ((i - 1 >= 0 && binaryMatrix[i - 1][j] != 1) || (j - 1 >= 0 && binaryMatrix[i][j - 1] != 1))
						numOfIslands++;
				}
			}

		return numOfIslands;

	}

	// https://www.careercup.com/question?id=5708658983829504

	public static int countIslands(int[][] sea) {
		boolean[][] visited = new boolean[sea.length][sea.length];
		// set all values false
		for (int i = 0; i < sea.length; i++) {
			for (int j = 0; j < sea.length; j++) {
				visited[i][j] = false;
			}
		}
		// transfer two matrix
		return countIslandsHelper(sea, visited);
	}

	public static int countIslandsHelper(int[][] sea, boolean[][] visited) {
		int numOfIslands = 0;
		for (int i = 0; i < sea.length; i++) {
			for (int j = 0; j < sea.length; j++) {

				if (visited[i][j])
					continue;
				if (sea[i][j] == 0) {
					visited[i][j] = true;
					continue;
				}
				// ==1 and not visited
				numOfIslands++;
				floodFill(i, j, sea, visited);
			}
		}
		return numOfIslands;
	}

	public static void floodFill(int row, int col, int[][] sea, boolean[][] visited) {
		if (sea[row][col] == 0 || visited[row][col])
			return;// actually this condition is considered already

		visited[row][col] = true;// visited
		if (col < sea.length - 1)
			floodFill(row, col + 1, sea, visited);
		if (row < sea.length - 1)
			floodFill(row + 1, col, sea, visited);
		if (col > 0)
			floodFill(row, col - 1, sea, visited);
		if (row > 0)
			floodFill(row - 1, col, sea, visited);
	}

}

package hard;

public class DungeonGame {
	/**
	 * logic problem
	 */
//	public int calculateMinimumHP(int[][] dungeon) {
//		int rows = dungeon.length;
//		int cols = dungeon[0].length;
//		int[][] health = new int[rows + 1][cols + 1];
//		int[][] healthLeft = new int[rows + 1][cols + 1];
//		for (int i = 1; i < rows; i++) {
//			Arrays.fill(health[i], 1);
//			Arrays.fill(healthLeft[i], 1);
//		}
//		for (int col = 1; col <= cols; col++) {
//			healthLeft[1][col] = healthLeft[1][col - 1] + dungeon[0][col - 1];
//			if (healthLeft[1][col] <= 0) {
//				health[1][col] = health[1][col - 1] + Math.abs(healthLeft[1][col]) + 1;
//				healthLeft[1][col] = 1;
//			} else {
//				health[1][col] = health[1][col - 1];
//			}
//		}
//
//		for (int row = 2; row <= rows; row++) {
//			healthLeft[row][1] = healthLeft[row - 1][1] + dungeon[row - 1][0];
//			if (healthLeft[row][1] <= 0) {
//				health[row][1] = health[row - 1][1] + Math.abs(healthLeft[row][1]) + 1;
//				healthLeft[row][1] = 1;
//			} else
//				health[row][1] = health[row - 1][1];
//		}
//
//		for (int row = 2; row <= rows; row++)
//			for (int col = 2; col <= cols; col++) {
//				if (health[row - 1][col] < health[row][col - 1]) {
//					healthLeft[row][col] = healthLeft[row - 1][col] + dungeon[row - 1][col - 1];
//					if (healthLeft[row][col] <= 0) {
//						health[row][col] = health[row - 1][col] + Math.abs(healthLeft[row][col]) + 1;
//						healthLeft[row][col] = 1;
//					} else
//						health[row][col] = health[row - 1][col];
//				} else if(health[row - 1][col] > health[row][col - 1]) {
//					healthLeft[row][col] = healthLeft[row][col - 1] + dungeon[row - 1][col - 1];
//					if (healthLeft[row][col] <= 0) {
//						health[row][col] = health[row][col - 1] + Math.abs(healthLeft[row][col]) + 1;
//						healthLeft[row][col] = 1;
//					} else
//						health[row][col] = health[row][col - 1];
//				}else {
//					healthLeft[row][col] = Math.max(healthLeft[row -1 ][col],healthLeft[row][col - 1]) + dungeon[row - 1][col - 1];
//					if (healthLeft[row][col] <= 0) {
//						health[row][col] = health[row][col - 1] + Math.abs(healthLeft[row][col]) + 1;
//						healthLeft[row][col] = 1;
//					} else
//						health[row][col] = health[row][col - 1];
//				}
//			}
//		return health[rows][cols];
//	}

	public int calculateMinimumHP(int[][] dungeon) {
		int rows = dungeon.length;
		int cols = dungeon[0].length;
		int[][] health = new int[rows][cols];
		health[rows - 1][cols - 1] = Math.max(1 - dungeon[rows - 1][cols - 1], 1);
		for(int i = rows-2 ; i >=0 ; i--)
		{
			health[i][cols-1] = Math.max(health[i+1][cols-1]-dungeon[i][cols-1], 1);
		}
		for(int j = cols-2 ; j >=0 ; j--)
		{
			health[rows-1][j] = Math.max(health[rows-1][j+1]-dungeon[rows-1][j], 1);
		}
		
		for(int row = rows - 2; row >=0 ;row--)
			for(int  col = cols-2;col >=0 ;col--) {
				health[row][col]=Math.max(health[row+1][col], health[row][col+1])-dungeon[row][col];
				health[row][col] = health[row][col] > 0 ?health[row][col] : 1;
			}
		return health[0][0];
	}

}

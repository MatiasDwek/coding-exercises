package other;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreasureIsland {

	// private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	//
	public static int minSteps(char[][] grid) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(0, 0));
		grid[0][0] = 'D'; // mark as visited
		for (int steps = 1; !q.isEmpty(); steps++) {
			for (int sz = q.size(); sz > 0; sz--) {
				Point p = q.poll();

				for (int[] dir : DIRS) {
					int r = p.r + dir[0];
					int c = p.c + dir[1];

					if (isSafe(grid, r, c)) {
						if (grid[r][c] == 'X')
							return steps;
						grid[r][c] = 'D';
						q.add(new Point(r, c));
					}
				}
			}
		}
		return -1;
	}

	private static boolean isSafe(char[][] grid, int r, int c) {
		return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != 'D';
	}

	private static final int DIRS[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	private static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static boolean isSafe2(char[][] grid, int r, int c) {
		if (r >= grid.length || r < 0)
			return false;
		if (c >= grid[0].length || c < 0)
			return false;
		if (grid[r][c] == 'D')
			return false;
		else
			return true;
	}

	private static int minSteps2(char[][] grid) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(0, 0));
		grid[0][0] = 'D';

		int steps = 1;
		while (!q.isEmpty()) {
			for (int sz = q.size(); sz > 0; sz--) {
				Point p = q.poll();

				for (int[] dir : DIRS) {
					int r = p.r + dir[0];
					int c = p.c + dir[1];
					if (isSafe2(grid, r, c)) {
						if (grid[r][c] == 'X')
							return steps;
						q.add(new Point(r, c));
						grid[r][c] = 'D';
					}
				}
			}
			steps++;
		}
		return -1;

	}

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] grid = { { 'O', 'O', 'O', 'O' },
					      { 'O', 'D', 'D', 'O' },
					      { 'D', 'O', 'O', 'O' },
					      { 'X', 'D', 'D', 'O' } };

		System.out.println(minSteps2(grid));

	}
}

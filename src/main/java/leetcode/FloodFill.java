package leetcode;

/**
 * https://leetcode.com/problems/flood-fill/
 */
public class FloodFill {
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image[sr][sc] == newColor)
			return image;
		
		int prevColor = image[sr][sc];
		image[sr][sc] = newColor;
		if (sr > 0 && image[sr - 1][sc] == prevColor)
			floodFill(image, sr - 1, sc, newColor);
		if (sc > 0 && image[sr][sc - 1] == prevColor)
			floodFill(image, sr, sc - 1, newColor);
		if (sr < image.length-1 && image[sr + 1][sc] == prevColor)
			floodFill(image, sr + 1, sc, newColor);
		if (sc < image[0].length-1 && image[sr][sc + 1] == prevColor)
			floodFill(image, sr, sc + 1, newColor);
		return image;
	}
}

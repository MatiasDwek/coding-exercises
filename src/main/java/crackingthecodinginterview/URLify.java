package crackingthecodinginterview;

/**
 * Exercice 1.3
 */
public class URLify {
	public static void main(String[] args) {
		char[] url = {'t', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', 0, 0, 0, 0,};
		urlify(url);
		System.out.println(url);
	}
	
	private static void urlify(char[] url) {
		
		int countOfSpaces = countSpaces(url);
		
		for (int i = url.length-1; i >= 0 ; i--) {
			if (url[i] == 0)
				continue;
			else if (url[i] != ' ') {
				url[i + 2*countOfSpaces] = url[i];
			} else {
				countOfSpaces--;
				putUrlSpace(url, i + 2*countOfSpaces);
			}
		}
		
	}
	
	private static int countSpaces(char[] url) {
		int countOfSpaces = 0;
		for (char c : url) {
			if (c == ' ')
				countOfSpaces++;
		}
		
		return countOfSpaces;
	}
	
	private static void putUrlSpace(char[] url, int index) {
		url[index] = '%';
		url[index+1] = '2';
		url[index+2] = '0';
	}
}

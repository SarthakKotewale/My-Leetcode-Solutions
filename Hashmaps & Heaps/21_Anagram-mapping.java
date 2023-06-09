/* 1. You are given two integer arrays(A and B), where B is an anagram of A.
2. B is an anagram of A means B is made by randomizing the order of the elements in A.
3. For every element in A, you have to print the index of that element in B.

Note -> Both arrays(A and B) are of the same length. 

Sample Input
6
1 2 3 4 5 2
4 3 2 1 5 2
Sample Output
3 2 1 0 4 5 */



import java.util.*;

public class Main {
	public static int[] anagramMappings(int[] arr1, int[] arr2) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for(int i = 0 ;i < arr2.length ;i++) {
			if(map.containsKey(arr2[i])){
				map.get(arr2[i]).add(i);
			}else{
				ArrayList<Integer> a = new ArrayList<>();
				a.add(i);
				map.put(arr2[i],a);
			}
		}
		int[] ans = new int[arr1.length];
		for(int i = 0 ; i < arr1.length; i++) {
			ans[i] = map.get(arr1[i]).remove(0);
		}
		
		return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = s.nextInt();
		}
		for (int j = 0; j < b.length; j++) {
			b[j] = s.nextInt();
		}
		int[] res = anagramMappings(a, b);
		for (int j = 0; j < res.length; j++) {
			System.out.print(res[j] + " ");
		}
	}

}
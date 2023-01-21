/*A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

 

Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"] */

class Solution {
    //DC 21.1.23
    public List<String> restoreIpAddresses(String s) {
	List<String> result = new ArrayList<>();
	if (s == null || s.length() == 0 || s.length() > 12) return result;

	restoreIpAddressesHelper(s, 0, 0, new StringBuilder(), result);
	return result;
}

private void restoreIpAddressesHelper(String s, int index, int count, 
									  StringBuilder sb, List<String> result) {
	// Base cases
	if (index == s.length() && count == 3) {
		result.add(sb.toString());
		return;
	}
	if (count > 3) return;

	for (int i = index; i < s.length(); i++) {
		String part = s.substring(index, i + 1);

		if (part.length() == 0 || part.length() > 1 && part.charAt(0) == '0' || 
		   Integer.valueOf(part) > 255) break; // No point of exploring more, so break from the loop

		int len = sb.length();
		// Choose
		sb.append(part);

		// Explore
		if (i + 1 == s.length())
			restoreIpAddressesHelper(s, i + 1, count, sb, result);
		else {
			sb.append("."); // Add . in each time, except the last part
			restoreIpAddressesHelper(s, i + 1, count + 1, sb, result);
		}		
		// Unchoose
		sb.setLength(len);
	}        
}
}
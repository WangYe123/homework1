public class Solution { 
	//基本思路是建一个额外的数组去记录重复字符出现的位置，这里假设只能出现ASCll码。
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1)
        {
            return n; //排除数组长度为1或者0的情况
        }
		int start = 0;
		int end = 1;
		int max = 1;
		int [] existTable = new int [256];//下标代表重复出现的是什么字符，数组内容代表该字符上次出现的顺序
		Arrays.fill(existTable, -1);
		existTable[s.charAt(start)] = 0;
		while(end < n)
		{
			if (existTable[s.charAt(end)] >= start)
			{
				start = existTable[s.charAt(end)] + 1;
			}
			max = Math.max(max, end- start +1);
			existTable[s.charAt(end)] = end;
			end++;
		}
		return max;
        
    }
}
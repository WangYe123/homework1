public class Solution { 
	//����˼·�ǽ�һ�����������ȥ��¼�ظ��ַ����ֵ�λ�ã��������ֻ�ܳ���ASCll�롣
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1)
        {
            return n; //�ų����鳤��Ϊ1����0�����
        }
		int start = 0;
		int end = 1;
		int max = 1;
		int [] existTable = new int [256];//�±�����ظ����ֵ���ʲô�ַ����������ݴ�����ַ��ϴγ��ֵ�˳��
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
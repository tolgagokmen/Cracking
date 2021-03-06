/*
This is really good for understanding the mapping relationship between two arrays/lists.
Here we choose to use List Collection because here we need to use the indexOf() method.
*/

public class Solution {
    public int romanToInt(String s) {
        int[] num = {1,5,10,50,100,500,1000};
        List<Character> roman = Arrays.asList('I','V','X','L','C','D','M');
                
        int len = s.length();
        int sum = num[roman.indexOf(s.charAt(len-1))];

        for(int i = len-2; i>=0; i--){
                int ind1 = roman.indexOf(s.charAt(i));
                int ind2 = roman.indexOf(s.charAt(i+1));
                if(ind1>=ind2)
                        sum += num[ind1];
                else
                        sum -= num[ind1];                        
        }
                
        return sum;
    }
}
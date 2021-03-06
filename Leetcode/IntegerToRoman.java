/*
This is a super great example for how to play with enumerate arrays
*/

public class Solution {
    public String intToRoman(int num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans ={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        int i=0;
        String re = "";
        
        while(num>0){
            if(num>=nums[i]){
                num -= nums[i];
                re += romans[i];
            } else
                i++;
        }
        
        return re;
    }
}
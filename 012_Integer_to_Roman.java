public class Solution {
    private int addOneCharacter(int num, StringBuilder result){
        if(num>=1000){
            result.append('M');
            num-=1000;
        }
        else if(num>=900){
            result.append('C');
            num+=100;
        }
        else if(num>=500){
            result.append('D');
            num-=500;
        }
        else if(num>=400){
            result.append('C');
            num+=100;
        }
        else if(num>=100){
            result.append('C');
            num-=100;
        }
        else if(num>=90){
            result.append('X');
            num+=10;
        }
        else if(num>=50){
            result.append('L');
            num-=50;
        }
        else if(num>=40){
            result.append('X');
            num+=10;
        }
        else if(num>=10){
            result.append('X');
            num-=10;
        }
        else if(num>=9){
            result.append('I');
            num+=1;
        }
        else if(num>=5){
            result.append('V');
            num-=5;
        }
        else if(num>=4){
            result.append('I');
            num+=1;
        }
        else{
            result.append('I');
            num-=1;
        }
        return num;
    }
    
    public String intToRoman(int num) {
        StringBuilder result=new StringBuilder();
        while (num>0){
            num=addOneCharacter(num,result);
        }
        return result.toString();
    }
}

import java.util.Scanner;
class Alphabet{
    void displayAlpha(int n){
        if(n<=0 || n>99){
            System.out.println("Range should be in 0 to 99");
        }
        else{
            if(n>=26){
                for(char c='A';c<='Z';c++){
                    System.out.print(c+" ");
                }
            }
            else{
                for(int i=90-n+1;i<=90;i++){
                    System.out.print((char)i+" ");
                }
            }
        }
    }
}
class AlphabetDriver{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        String temp="";
        for(int i=0;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                temp+=str.charAt(i);
            }
        }
        int n=Integer.parseInt(temp);
        Alphabet alpha = new Alphabet();
        alpha.displayAlpha(n);
        scan.close();
    }
}
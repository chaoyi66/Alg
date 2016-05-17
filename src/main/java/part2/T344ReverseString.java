package part2;

public class T344ReverseString {
	
	public static void main(String[] args) {
		 System.out.println(reverseString(null));
	}

    public static String reverseString(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--)
        	sb.append(s.charAt(i));
        return sb.toString();
    }
    
    public static String reverseString1(String s) {
        return new StringBuffer(s).reverse().toString();
    }
    
    public String reverseString2(String s) {
        char[] c = s.toCharArray();
        for (int i=0,j=c.length-1;i<j;i++,j--){
            char temp = c[i];
            c[i]=c[j];
            c[j]=temp;
        }
        return new String(c);
    }


}

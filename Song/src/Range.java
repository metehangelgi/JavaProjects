import java.util.StringTokenizer;

public class Range {
    public static int min;
    public static int max;
    public static String str;

    public Range(String s){
        str = s;
    }
    public static Range parse(String s){
        //range
        if (s.contains("-")){
            StringTokenizer parse = new StringTokenizer(s, "-");
            String strMin = parse.nextToken();
            min = Integer.parseInt(strMin);
            String strMax = parse.nextToken();
            max = Integer.parseInt(strMax);

        }else{
            min = Integer.parseInt(s);
            max = min;
        }
        Range rangeObj = new Range(str);
        return rangeObj;
    }
    public boolean contains(int n){
        if (min <= n && n <= max){
            return true;
        }
        return false;
    }
    public int getMin(){
        return min;
    }
    public int getMax(){
        return max;
    }
}
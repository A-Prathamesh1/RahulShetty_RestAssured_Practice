package StringsDemo;

public class StringVSStringBufferVSStringBuilder {
    public static void stringConcatenationFrenzy(String s){
        for(int i = 0; i < 100_000; i++){
            s = s.concat(" world");
        }
    }

    public static void stringBuilderConcatenationFrenzy(StringBuilder s){
        for(int i = 0; i < 100_000; i++){
            s = s.append(" world");
        }
    }

    public static void stringBufferConcatenationFrenzy(StringBuffer s){
        for(int i = 0; i < 100_000; i++){
            s = s.append(" world");
        }
    }

    public static void main(String[] args) {
        String s = new String("Hello");
        long start_time = System.currentTimeMillis();
        stringConcatenationFrenzy(s);
        long end_Time = System.currentTimeMillis();
        System.out.println("string: " + (end_Time - start_time)+ "ms");

        StringBuilder s1 = new StringBuilder("Hello");
        start_time = System.currentTimeMillis();
        stringBuilderConcatenationFrenzy(s1);
        end_Time = System.currentTimeMillis();
        System.out.println("stringBuilder: " + (end_Time - start_time) + "ms");

        StringBuffer s2 = new StringBuffer();
        start_time = System.currentTimeMillis();
        stringBufferConcatenationFrenzy(s2);
        end_Time = System.currentTimeMillis();
        System.out.println("stringBuffer: " + (end_Time - start_time)+ "ms");

    }
}

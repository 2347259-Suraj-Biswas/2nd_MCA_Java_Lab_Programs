public class Lab_2_2 {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer("Hello");
        sb.append("Suraj");
        System.out.println(sb);
        sb.insert(2, "Biswas");
        System.err.println(sb);
        sb.replace(3, 5, "SB");
        System.out.println(sb);
        sb.delete(2, 4);
        System.out.println(sb);
        System.out.println(sb.charAt(2));
        sb2.setCharAt(2,'e');
        System.out.println(sb2);
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        sb.ensureCapacity(20);
        System.out.println(sb.capacity());
        System.out.println(sb2.toString());
        System.out.println(sb.substring(6));
        System.out.println(sb.substring(6,8));
    }
}

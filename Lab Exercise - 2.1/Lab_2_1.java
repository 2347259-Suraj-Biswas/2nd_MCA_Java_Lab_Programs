public class Lab_2_1 {
    public static void main(String[] args) {
        String str = "We realizes that while our workers were thriving, the\r\n" + //
                "surrounding villages were still suffering. It became our goal to uplift their\r\n" + //
                "quality of life as well. I remember seeing a family of 4 on a motorbike in the\r\n" + //
                "heavy Bombay rain — I knew I wanted to do more for these families who were\r\n" + //
                "risking their lives for lack of an alternative The alternative mentioned here\r\n" + //
                "is the Tata Nano, which soon after came as the worlds cheapest car on retail\r\n" + //
                "at a starting price of only Rs 1 lakh. These were the words of Ratan Tata in a\r\n" + //
                "recent post by Humans of Bombay which formed the basis of his decision to come\r\n" + //
                "up with a car like Tata Nano.";

        String str2 = "Bombay is an old name!".intern();
        String str3 = "bombay is an old Name!".intern();
        int str4 = 12;

        char[] ch = new char[10];
        String[] words = str2.split("\\s");
        byte[] get_bytes = str2.getBytes();

        System.out.println(str.charAt(5));
        System.out.println("\n");
        System.out.println(str.compareTo(str2));
        System.out.println("\n");
        System.out.println(str.concat(str2));
        System.out.println("\n");
        System.out.println(str.contains("Bombay"));
        System.out.println("\n");
        System.out.println(str.endsWith("Nano."));
        System.out.println("\n");
        System.out.println(str.equals(str2));
        System.out.println("\n");
        System.out.println(str2.equalsIgnoreCase(str3));
        System.out.println("\n");
        System.out.println(String.format("What is Mumbai's old name? Ans= %s", str2));
        System.out.println("\n");
        for (int i = 0; i < get_bytes.length; i++) {
            System.out.println(get_bytes[i]);
        }
        System.out.println("\n");
        str2.getChars(5, 8, ch, 0);
        System.out.println(ch);
        System.out.println("\n");
        System.out.println(str.indexOf("villages"));
        System.out.println("\n");
        System.out.println(str.isEmpty());
        System.out.println("\n");
        System.out.println(String.join(",", str2, str3));
        System.out.println("\n");
        System.out.println(str.lastIndexOf("car"));
        System.out.println("\n");
        System.out.println(str.length());
        System.out.println("\n");
        System.out.println(str.replace("Nano", "Nexa"));
        System.out.println("\n");
        System.out.println(str.replaceAll("car", "Truck"));
        System.out.println("\n");
        for (String w : words) {
            System.out.println(w);
        }
        System.out.println(str.startsWith("We"));
        System.out.println("\n");
        System.out.println(str.substring(18));
        System.out.println("\n");
        System.out.println(str.toCharArray());
        System.out.println("\n");
        System.out.println(str.toLowerCase());
        System.out.println("\n");
        System.out.println(str.toUpperCase());
        System.out.println("\n");
        System.out.println(str.trim());
        System.out.println("\n");
        System.out.println(String.valueOf(str4));
        System.out.println("\n");

    }
}
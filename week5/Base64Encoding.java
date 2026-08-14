public class Base64Encoding {

    private static final char[] BASE64 =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
                    .toCharArray();

    public static String encode(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i += 3) {

            int b1 = input.charAt(i);

            int b2 = (i + 1 < input.length()) ? input.charAt(i + 1) : 0;
            int b3 = (i + 2 < input.length()) ? input.charAt(i + 2) : 0;

            // First 6 bits
            int index1 = (b1 >> 2) & 63;

            // Last 2 bits of b1 + first 4 bits of b2
            int index2 = ((b1 & 3) << 4) | ((b2 >> 4) & 15);

            // Last 4 bits of b2 + first 2 bits of b3
            int index3 = ((b2 & 15) << 2) | ((b3 >> 6) & 3);

            // Last 6 bits of b3
            int index4 = b3 & 63;

            result.append(BASE64[index1]);
            result.append(BASE64[index2]);

            if (i + 1 < input.length()) {
                result.append(BASE64[index3]);
            } else {
                result.append('=');
            }

            if (i + 2 < input.length()) {
                result.append(BASE64[index4]);
            } else {
                result.append('=');
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(encode("Cat"));
        System.out.println(encode("Hello World"));
        System.out.println(encode("A"));
        System.out.println(encode("Ma"));
        System.out.println(encode(""));
    }
}
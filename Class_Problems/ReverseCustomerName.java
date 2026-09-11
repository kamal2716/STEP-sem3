public class ReverseCustomerName {

    public static String reverseCustomerName(
            String customerName) {

        StringBuilder reverse =
                new StringBuilder();

        for (int i = customerName.length() - 1;
             i >= 0;
             i--) {

            reverse.append(customerName.charAt(i));
        }

        return reverse.toString();
    }

    public static void main(String[] args) {

        String customerName = "Sunil";

        String reversed =
                reverseCustomerName(customerName);

        System.out.println(
                "Original Name: " + customerName);

        System.out.println(
                "Reversed Name: " + reversed);
    }
}
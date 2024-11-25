import java.security.MessageDigest;

// SHA
public class Main {
    public static void main(String[] args) throws Exception {
        String message = "Hello World!";
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        byte[] hashBytes = md.digest(message.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        System.out.println("Hashed text (SHA-256): " + hexString);

    }
}
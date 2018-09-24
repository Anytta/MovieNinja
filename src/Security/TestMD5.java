package Security;

import java.security.NoSuchAlgorithmException;

public class TestMD5 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String pass = "akunice";

        String hash1 = MD5.hash(pass);
        System.out.println("Hash1: " + hash1);
        String hash2 = MD5.hash(pass);
        System.out.println("Hash2: " + hash2);

        System.out.println("Are equals: " + hash1.equals(hash2));
    }


}

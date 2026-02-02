import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        // Input berupa sebuah kata dengan susunan huruf acak
        Scanner scan = new Scanner(System.in);
        String inputText;
        System.out.println("Input sembarang kata dengan susunan huruf acak : ");
        inputText = scan.nextLine();
        checkPalindromeStr(inputText);
    }

    static int compare(String palindromeStr, String textToCompare) {
        int[] result = new int[textToCompare.length()];

        for (int i = 0; i < palindromeStr.length(); i++) {
            for (int j = 0; j < result.length; j++) {
                if (palindromeStr.charAt(i) == textToCompare.charAt(j)) {
                    if(result[j] == 1){
                        continue;
                    } else {
                        result[j] = 1;
                        break;
                    }
                } else {
                    continue;
                }
            }
        }

        int valid = 1;

        for (int k = 0; k < result.length; k++) {
            if (result[k] == 0) {
                valid = 0;
                break;
            } else {
                continue;
            }
        }

        return valid;
    }

    static void checkPalindromeStr(String anyWord) {
        // List kata palindrome
        String[] palindromes = {
                "isi", "kakak", "kapak", "masam",
                "radar", "sinis", "tamat", "malam",
                "katak", "kodok", "taat", "level",
                "telolet", "kasurrusak", "kasurinirusak"
        };

        int[] valid = {0, 0};

        // Check for exact match
        for (int i = 0; i < palindromes.length; i++) {
            if (palindromes[i] == anyWord) {
                valid[0] = 1;
                valid[1] = i;
                break;
            } else {
                continue;
            }
        }

        // Check palindrome by word
        if (valid[0] == 0) {
            for (int i = 0; i < palindromes.length; i++) {
                if (anyWord.length() != palindromes[i].length()) {
                    continue;
                } else {
                    if (compare(palindromes[i], anyWord) == 0) {
                        continue;
                    } else {
                        valid[0] = 1;
                        valid[1] = i;
                        break;
                    }
                }
            }
        }

        if(valid[0] == 0){
            System.out.printf("Huruf pembentuk teks " + anyWord + " tidak dapat membentuk palindrome!");
        } else {
            System.out.println("Huruf pembentuk teks " + anyWord + " dapat membentuk palindrome " + palindromes[valid[1]]);
        }
    }
}

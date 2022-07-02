package JL.P0005;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Duy Thanh
 */
public class Count {

    //charmap + wordmap
    Map<Character, Integer> charCounter = new HashMap<>();
    Map<String, Integer> wordCounter = new HashMap<>();

    /**
     * Show count
     */
    public void display() {
        System.out.println(wordCounter);
        System.out.println(charCounter);
    }

    /**
     * Ham tach chuỗi thành mảng kí tự
     *
     * @param content user input
     */
    public void analyze(String content) {
        //dem key co san
        for (char ch : content.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                continue;
            }
            if (!charCounter.containsKey(ch)) {
                charCounter.put(ch, 1); //nếu chưa có key thì nó sẽ thêm vào 1 key mới
            } else {
                charCounter.put(ch, ((int) charCounter.get(ch)) + 1); //có key rồi thì auto cộng cho key có sẵn
            }
        }

        //dung phan tach chuoi thanh cac pt
        StringTokenizer tokenizer = new StringTokenizer(content);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (!wordCounter.containsKey(token)) {
                wordCounter.put(token, 1);
            } else {
                wordCounter.put(token, ((int) wordCounter.get(token)) + 1);
            }
        }
    }

    /**
     * Main run
     *
     * @param args user input
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String choice;
        // vong lap nhap content
        do {
            System.out.println("Enter your content: ");
            String content = sc.nextLine();
            //loop check user input null 
            while (content.trim().isEmpty()) {
                System.out.println("Please enter agian!");
                content = sc.nextLine();
            }
            Count counter = new Count();
            counter.analyze(content);
            counter.display();
            do {
                // check yes/no continue to program
                System.out.println("Do you wanna continue(y/n)?");
                choice = sc.nextLine();
                if (!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N")) {
                    System.out.println("Just Y or N");
                }
            } while (!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N"));
        } while (!choice.equalsIgnoreCase("N"));

    }
}

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        File file = new File("D://Changed.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader("D://code.txt")); FileWriter writer = new FileWriter("D://Changed.txt")){
            StringBuilder stb = new StringBuilder();
            file.createNewFile();
            String text;
            Pattern pattern = Pattern.compile("(/\\*([\\S\\s]*)\\*/)|(//.*)");
            while ((text = reader.readLine()) != null) {
                stb.append(text);
                stb.append("\n");
            }
            text = stb.toString();
            Matcher matcher = pattern.matcher(stb);
            text = matcher.replaceAll("");
            System.out.println(text);
            writer.write(text);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
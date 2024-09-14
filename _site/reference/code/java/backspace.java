import java.util.*;

public class backspace {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.next();
        Stack<Character> editor = new Stack<>();
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == '<')
                editor.pop();
            else
                editor.push(line.charAt(i));
        }
        StringBuilder buildString = new StringBuilder();
        while(!editor.isEmpty()) {
            buildString.append(editor.pop());
        }
        System.out.println(buildString.reverse().toString());
    }
}

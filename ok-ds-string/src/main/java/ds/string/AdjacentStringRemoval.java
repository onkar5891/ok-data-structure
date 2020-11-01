package ds.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import static java.util.Objects.isNull;

public class AdjacentStringRemoval {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                System.out.println(remove(sc.next()));
                System.out.println(rmStack(sc.next()));
            }
        }
    }

    static String rmStack(String str) {
        if (isNull(str)) {
            return null;
        } else if (str.isEmpty() || str.length() == 1) {
            return str;
        }

        Deque<Character> stack = uniqueChars(str);
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        if (str.equals(sb.toString())) {
            return sb.toString();
        }
        return rmStack(sb.toString());
    }

    private static Deque<Character> uniqueChars(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        boolean dup = false;
        for (int i = 0; i < str.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(str.charAt(i));
            } else if (stack.peek() == str.charAt(i)) {
                dup = true;
            } else {
                if (dup) {
                    dup = false;
                    stack.pop();
                }
                stack.push(str.charAt(i));
            }
        }
        if (dup) {
            stack.pop();
        }
        return stack;
    }

    static String remove(String str) {
        if (isNull(str)) {
            return null;
        } else if (str.isEmpty() || str.length() == 1) {
            return str;
        }

        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length() - 1; ) {
            char ch = sb.charAt(i);
            int len = adjRemoval(sb.substring(i + 1), ch);
            if (len > 0) {
                sb.delete(i, i + len + 1);
            } else {
                i++;
            }
        }

        if (str.equals(sb.toString())) {
            return sb.toString();
        }
        return remove(sb.toString());
    }

    private static int adjRemoval(String str, char ch) {
        if (str.charAt(0) == ch) {
            if (str.length() > 1) {
                return 1 + adjRemoval(str.substring(1), str.charAt(0));
            }
            return 1;
        }
        return 0;
    }
}

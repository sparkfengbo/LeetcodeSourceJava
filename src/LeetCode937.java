import java.util.Arrays;

public class LeetCode937 {

    public static void main(String[] args) {

        String[] res = reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"});

        System.out.println("");
    }

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }

    public static String[] reorderLogFiles2(String[] logs) {
        for (int i = 1; i < logs.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                String si = logs[j + 1];
                String prevS = logs[j];
                if (getType(si) == TYPE_LOG_ALPHA) {
                    if (getType(prevS) == TYPE_LOG_NUMBER
                    ) {
                        swap(logs, j + 1, j);
                    } else if (getContent(prevS).compareTo(getContent(si)) > 0) {
                        swap(logs, j + 1, j);
                    } else if (getContent(prevS).compareTo(getContent(si)) == 0 && getIndicator(prevS).compareTo(getIndicator(si)) > 0) {
                        swap(logs, j + 1, j);
                    }
                }
            }
        }
        return logs;
    }

    private static String getIndicator(String log) {
        int spaceIndex = log.indexOf(" ", 0);
        return log.substring(0, spaceIndex);
    }

    private static String getContent(String log) {
        int spaceIndex = log.indexOf(" ", 0);
        return log.substring(spaceIndex + 1);
    }


    private static void swap(String[] logs, int i, int j) {
        String temp = logs[i];
        logs[i] = logs[j];
        logs[j] = temp;
    }

    private static int getType(String s) {
        int spaceIndex = s.indexOf(" ", 0);
        if (s.charAt(spaceIndex + 1) >= 'a' && s.charAt(spaceIndex + 1) <= 'z') {
            return TYPE_LOG_ALPHA;
        }
        return TYPE_LOG_NUMBER;
    }

    private static final int TYPE_LOG_NUMBER = 0;
    private static final int TYPE_LOG_ALPHA = 1;

}

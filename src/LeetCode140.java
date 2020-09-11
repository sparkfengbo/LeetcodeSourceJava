import utils.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode140 {

    /**
     * dp[i] : s[0:i-1] can word break => target: dp[n]
     * dp[i] = true  if any dp[j] && s[j + 1 : i] in wordlist  0 <= j < i
     * <p>
     * dp[0] = s[0] in worldlist
     *
     * @param s
     * @param wordDict
     * @return
     */

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();

        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        Utils.printList(wordBreak("leetcode", wordDict));

        wordDict.clear();
        wordDict.add("apple");
        wordDict.add("pen");
        Utils.printList(wordBreak("applepenapple", wordDict));

        wordDict.clear();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        Utils.printList(wordBreak("catsandog", wordDict));
    }
}

package 校招2019.美丽联合;

import java.util.*;
import java.io.*;

/**
 * Created by James on 2018/9/27 19:57.
 */
public class Main2 {
    public static void main(String[] args) {

    }

        private void solve(List<String> res,String s,String cur,Set<String> wordDict){
            if(s.length()<=0) {
                res.add(cur);
                return;
            }
            for(String str:wordDict){
                int len = str.length();
                if(len<=s.length() && s.substring(0,len).equals(str)){
                    solve(res,s.substring(len),cur.length()==0?str:cur+" "+str,wordDict);
                }
            }
        }
        public List<String> wordBreak(String s, Set<String> wordDict) {
            List<String> res = new LinkedList<>();
            if(!isWordBreak(s,wordDict))
                return res;

            solve(res,s,"",wordDict);
            return res;
        }
        private boolean isWordBreak(String s,Set<String> wordDict){
            int length = s.length();
            boolean[] words = new boolean[length];

            for(int i = 1;i<=length;i++){
                int j;
                for(j = 0;j<i;j++){
                    String substr = s.substring(j,i);
                    if(wordDict.contains(substr) && (j==0 || words[j-1])) {
                        words[i-1] = true;
                        break;
                    }
                }
                if(j == i)
                    words[i-1] = false;
            }
            return words[length-1];
        }



}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       
       Set<String> wordset = new HashSet<>(wordList);

       if(!wordset.contains(endWord)) return 0;

       Set<String> begin = new HashSet<>();
       Set<String> end = new HashSet<>();

       begin.add(beginWord);
       end.add(endWord);
       int lvl = 1;
       while(!begin.isEmpty() && !endWord.isEmpty()){
        if(begin.size()> end.size()){
            Set<String> temp = begin;
            begin = end;
            end = temp;
        }

        Set<String> nextword = new HashSet<>();

        for(String s : begin){
            char[] word = s.toCharArray();

            for(int i =0;i<word.length;i++){
                char org = word[i];

                for(char c = 'a';c<='z';c++){

                    if(c==org) continue;
                    word[i] = c;



                    String wordpresent = new String(word);

                    if(end.contains(wordpresent)){
                        return lvl+1;
                    }

                    if(wordset.contains(wordpresent)){
                        nextword.add(wordpresent);
                        wordset.remove(wordpresent);
                    }


            }
                word[i] = org;
            }
        }
        begin =  nextword;
        lvl++;
       }

       return 0;
    }
}
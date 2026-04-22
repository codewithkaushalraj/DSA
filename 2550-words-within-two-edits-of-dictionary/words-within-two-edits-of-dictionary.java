class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {

        List<String> ans = new ArrayList<>();
        if (queries.length == 0 || dictionary.length == 0)
            return ans;

        for (int i = 0; i < queries.length; i++) {
            String queryword = queries[i];
            String word = "";
            for (int j = 0; j < dictionary.length; j++) {
                String dictionaryword = dictionary[j];
                int count = 0;
                int k = 0;
                while (k != dictionaryword.length()) {
                    if (queryword.charAt(k) != dictionaryword.charAt(k))
                        count++;
                    k++;
                }
                if (count <= 2) {
                    if (!word.equals(queryword)) {
                        word = queryword;
                        ans.add(queryword);
                    }
                }
            }

        }

        return ans;

    }
}
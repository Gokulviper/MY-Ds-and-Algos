package DynamicProgramming.CatlanNumber;

import java.util.*;

class DiffWaysTocomputeAddParenthesis {

    public List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> map = new HashMap<>();
        if (map.containsKey(expression)){
            return map.get(expression);
        }
        List<Integer> ans=new ArrayList<>();
        if (expression.isEmpty()){
           return ans;
        }

        for (int i = 0; i <expression.length() ; i++) {
            char ch=expression.charAt(i);
            if(ch=='+'||ch=='*'||ch=='-') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (ch){
                            case '*':
                                ans.add(l*r);
                                break;
                            case '-':
                                ans.add(l-r);
                                break;
                            case '+':
                                ans.add(l+r);
                                break;
                        }
                    }
                }
            }
        }
        if(ans.size()==0){
            ans.add(Integer.parseInt(expression));
        }
        map.put(expression,ans);
        return ans;
    }

    }
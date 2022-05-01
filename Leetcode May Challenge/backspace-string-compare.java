class Solution {
    public boolean backspaceCompare(String s, String t) {
         return newstring(s).equals(newstring(t));
    }
  
    public String newstring(String s){
       Stack<Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++){
          if(s.charAt(i) == '#' && !stk.isEmpty()){
            stk.pop();
          }else if(s.charAt(i) != '#'){
            stk.push(s.charAt(i));
          }
        }
      StringBuilder sb = new StringBuilder();
      while(!stk.isEmpty()){
        sb.insert(0, stk.pop());
      }
      return sb.toString();
    }
}
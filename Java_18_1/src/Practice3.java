
public class Practice3 {
    public static String solution(char[] str, char[] find, char[] to) {
       String finalStr = "";
       char[] tempStr = str.clone();
       int idx = 0;

       do{
          idx = findIndex(tempStr,find);

          if(idx != -1){
              for (int i = 0; i < idx; i++) {
                  finalStr += tempStr[i];
              }
              for (int i = 0; i < to.length; i++) {
                  finalStr += to[i];
              }
              for(int i=idx + find.length;i<tempStr.length;i++){
                  finalStr += tempStr[i];
              }
              tempStr = finalStr.toCharArray(); //뒤에 또 Java를 바꾸기위해서 지금까지 만든 거 tempStr에 저장해놓고
              finalStr =""; //다시 빈 문자열로 놓고 반복
          }
       }while(idx != -1);
        finalStr = new String(tempStr);
        return finalStr;
    }

    public static int findIndex(char[] str, char[] find){
        int idx = -1;
        boolean isMatch = false;
        for (int i = 0; i < str.length; i++) {
            if(str[i] == find[0] && str.length-i >= find.length){
                isMatch = true;

                for (int j = 1; j < find.length; j++) {
                    if(str[i+j] != find[j]){
                        isMatch = false;
                        break;
                    }
                }
            }
            if(isMatch){
                idx = i;
                break;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        // Test code
        String str = "Hello Java, Nice to meet you! Java is fun!";
        String find = "Java";
        String to = "자바";

        // 기존 String replace
        System.out.println(str.replace(find, to));

        // 자체 구현 replace
        char[] strExArr = str.toCharArray();
        char[] findArr = find.toCharArray();
        char[] toArr = to.toCharArray();
        System.out.println(solution(strExArr, findArr, toArr));

        strExArr = "POP".toCharArray();
        findArr = "P".toCharArray();
        toArr = "W".toCharArray();
        System.out.println(solution(strExArr, findArr, toArr));
    }
}

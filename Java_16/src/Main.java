// Java 프로그래밍 - 람다식

interface ComputeTool {
    public abstract int compute(int x, int y);

 //   public abstract int compute2(int x, int y);
}



public class Main {

    public static void main(String[] args) {

        ComputeTool cTool1 = new ComputeTool(){ //객체를 만들 떄 익명클래스로 만듦
            @Override
            public int compute(int x, int y) {
                return x+y;
            }
//            @Override
//            public int compute2(int x, int y) {
//                return x-y;
//            }
        };
        System.out.println(cTool1.compute(3,4));
        // 람다식
        ComputeTool cTool2 = (x,y) -> { return x+y; };
        System.out.println(cTool2.compute(5,7));

    }
}

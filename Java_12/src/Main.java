// Java 프로그래밍 - 내부 클래스

//내부클래스 구조
class Outer{
    public void print(){
        System.out.println("Outer.print");
    }
    class Inner{
        public void innerPrint(){
            Outer.print();
        }
    }

    static class InnerStaticClass{
        void innerPrint(){
 //           Outer.this.print(); static에서 nonstatic으로 접근이 불가
        }
    }
}

abstract class Person{ //추상클래스
    public abstract void printInfo();

}

class Student extends Person{ //추상클래스를 상속받아 추상메소드 구현

    @Override
    public void printInfo() {
        System.out.println("Student.printInfo");
    }
}
public class Main {

    public static void main(String[] args) {

//      외부 클래스
        Outer o1 = new Outer();

//      내부 클래스 - 인스턴스
        Outer.Inner i1 = new Outer().new Inner();

//      내부 클래스 - 정적
        Outer.InnerStaticClass is1 = new Outer.InnerStaticClass();

//      익명 클래스
        Person p1 = new Person() {
            @Override
            public void printInfo() {
                System.out.println("Main.printInfo");
            }
        };

    }

}

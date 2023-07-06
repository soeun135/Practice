// Java 프로그래밍 - 입출력_2

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
//      1. 파일 쓰기
//      FileWriter
        FileWriter fw = new FileWriter("./Java_13_2/memo.txt"); //현재 폴더에 memo라는 파일 만듦
        String memo = "헤드라인 \n";
        fw.write(memo);

        memo = "1월 28일 소은 생일 \n";
        fw.write(memo);

        fw.close();

//      PrintWriter
        PrintWriter pw = new PrintWriter("./Java_13_2/memo1.txt");
        memo = "헤드빙빙";
        pw.println(memo); //별도로  \n안해줘도 됨

        memo = "7/6 배고픔";
        pw.println(memo);

        pw.close();

//      파일 이어 쓰기
        FileWriter fw2 = new FileWriter("./Java_13_2/memo.txt",true);
        memo="코딱지 \n";
        fw2.write(memo);
        fw2.close();

        PrintWriter pw2 = new PrintWriter(new FileWriter("./Java_13_2/memo1.txt",true));
        memo="차돌곱도리탕 시킴";
        pw2.println(memo);

        pw2.close();

//      2. 파일 입력
        BufferedReader br = new BufferedReader(new FileReader("./Java_13_2/memo1.txt"));

        while(true){
            String line = br.readLine(); //파일 한 줄 씩 읽어들임
            if(line == null) //읽을 데이터 없으면
                break;
            else
                System.out.println(line);
        }
        br.close();
    }
}

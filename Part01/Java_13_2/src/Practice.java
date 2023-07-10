// Practice
// JamesArthurGosling.txt 파일을 읽은 후 원하는 단어 변경하여 새로 저장해보자.

import java.io.*;
import java.util.Scanner;

public class Practice {
    public static void main(String[] args) throws IOException {
        String inputFile = "./JamesArthurGosling.txt";
        String outputFile = "./JamesArthurGosling_edit.txt";

        // 찾을 단어 / 변경 단어 입력 받기
        Scanner sc = new Scanner(System.in);
        System.out.print("찾을 단어 :");
        String findWord = sc.nextLine();
        System.out.println("바꿀단어 :");
        String newWord = sc.nextLine();

        // 파일 읽기, 변경 및 저장
            //파일 읽기
        BufferedReader br = new BufferedReader(new FileReader("./Java_13_2/JamesArthurGosling.txt"));

        FileWriter fw = new FileWriter("./Java_13_2/JamesArthurGosling_edit.txt");
//      PrintWriter pw = new PrintWriter("./Java_13_2/JamesArthurGosling_edit.txt");
        while(true){
            String line = br.readLine();

            if(line == null) break;

            line = line.replace(findWord, newWord);
            fw.write(line + "\n");
            // pw.println(line);
        }
        br.close();
        fw.close();
        //pw.close();
    }
}

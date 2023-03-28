package Udemy.EF220.aplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Udemy.EF220.entiites.produto;

public class program {
public static void main(String [] args) throws ParseException{   
Locale.setDefault(Locale.US);
    Scanner sc= new Scanner(System.in);
List<produto> list= new ArrayList<>();
System.out.println("enter file path");
String sourceFilestr = sc.nextLine();
File sourceFile  = new File(sourceFilestr);  
String soucefolderStr = sourceFile.getParent();
System.out.print(soucefolderStr);
 boolean suceess = new File (soucefolderStr + "\\out").mkdir();
System.out.print ("folder created" + suceess);
String targetFileStr = soucefolderStr + "\\out\\summary.csv";


try (BufferedReader br = new BufferedReader(new FileReader(sourceFilestr))) {
String itemCsv = br.readLine();
while (itemCsv  != null){
   String[] fields = itemCsv.split(",");
   String name = fields[0];
   double price = Double.parseDouble(fields[1]);
   int quantity = Integer.parseInt(fields[2]);
   list.add(new produto(name , price , quantity));
   itemCsv= br.readLine();
}
try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))){

for (produto item :list){
    bw.write(item.getName() +"," +String.format("%.2f" +item.Total()));
    bw.newLine();
}

System.out.println(targetFileStr + "Created");

}catch (IOException e ){
    System.out.println("errror writing file" +e.getMessage());
}

}catch (IOException e ){
    System.out.println("errror writing file" +e.getMessage());
}

sc.close();
}}

package week5;

import java.util.Scanner;

public class Array2 {
   public static void main(String[] args){
      Scanner scanner=new Scanner(System.in);
      System.out.print("Total siswa: ");
      int totSiswa = scanner.nextInt();
      System.out.print("Total daftar nilai: ");
      int totMatkul = scanner.nextInt();

      int[][] array = new int[totSiswa][totMatkul];

      for (int i = 0 ; i < totSiswa ; i++){
         for (int j= 0 ; j < totMatkul ; j++){
            System.out.print("Siswa ke-" + (i+1) +", ");
            System.out.print("Masukkan nilai ke-" + (j+1) +": ");
            array [i][j] = scanner.nextInt();
         }
      }
      
      System.out.println("Nilai :");
      daftarNilai(totSiswa,totMatkul, array);
      scanner.close();
   }


   public static void daftarNilai(int totSiswa, int totMatkul, int[][] array){
      for (int i = 0 ; i < totSiswa ; i++){
         System.out.println("Siswa ke-" + (i+1));
         for (int j= 0 ; j < totMatkul ; j++){
            System.out.println("|--->Nilai ke-" + (j+1) +": " + array[i][j]);
         }
         System.out.println("");
      }
   };
}
package week4;
import java.util.Scanner;

public class Mainquiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Quiz quiz = new Quiz();

        System.out.println("Selamat Datang di Quiz Pengetahuan Umum!");
        System.out.println("Jawab Semua Pertanyaan Dengan Memilih Nomor!");

        // Looping untuk menampilkan pertanyaan
        for (int i = 0; i < quiz.getQuestionCount(); i++) {
            quiz.displayQuestion(i);

            System.out.print("Masukkan Jawaban Anda: ");
            int userAnswer = scanner.nextInt();
            quiz.checkAnswer(i, userAnswer);
        }

        // Menampilkan skor akhir
        int score = quiz.getScore();
        System.out.println("\nKuis Selesai! Skor Akhir Anda: " + score);

        // Memberikan feedback berdasarkan skor
        if (score == quiz.getQuestionCount() * 10) {
            System.out.println("Selamat! Anda menjawab semua pertanyaan dengan benar!");
        } else if (score >= 20) {
            System.out.println("Bagus! Tapi masih bisa lebih baik!");
        } else {
            System.out.println("Tetap semangat! Coba lagi untuk hasil lebih baik!");
        }

        scanner.close();
    }
}
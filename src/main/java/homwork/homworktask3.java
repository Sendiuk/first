package homwork;

public class homworktask3 {

        public static void main(String[] args) {
            int[] grades = {85, 92, 76, 81, 95};
            for (int grade : grades) {
                if (grade > 90) {
                    System.out.println(grade + " - відмінна оцінка!");
                } else if (grade < 80) {
                    System.out.println(grade + " - треба підтягнути.");
                } else {
                    System.out.println(grade + " - нормальна оцінка.");
                }
            }



//        int[] grades = {85, 92, 76, 81, 95}; // створили масив оцінок
//        StudentGrades studentGrades = new StudentGrades(grades); // створили об'єкт
//
//        studentGrades.printGrades();
//        System.out.println("Мінімальна оцінка: " + studentGrades.getMinGrade());
//        System.out.println("Максимальна оцінка: " + studentGrades.getMaxGrade());
//        System.out.println("Середня оцінка: " + studentGrades.getAverageGrade());
    }
}

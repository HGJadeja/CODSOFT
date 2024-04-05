import java.util.*;

public class task2_StudentGradeCalc {
    //instance variables grade and gradeInfo
    private String grade;
    private String gradeInfo;
    
    public static void main(String[] args) {
        task2_StudentGradeCalc calc = new task2_StudentGradeCalc();
        System.out.println("This is Student Grade Calculator !!");
        System.out.println("----------------------------------------------");
        System.out.println("Enter required fields which is asked in following");
        calc.CalculateStudentGrade();
    }

    public void CalculateStudentGrade(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nHow many Subjects you learned:");
        int s = sc.nextInt();

        double[] subjects = new double[s];
        double totalMarks=0.0;
        

        for(int i=0;i<s;i++){
            System.out.print("Enter Sub-"+(i+1)+" Marks(out of 100):");
            subjects[i]=sc.nextDouble();
        }

        for(int i=0;i<subjects.length;i++){
             totalMarks =  totalMarks + subjects[i];
        }
        //convert total marks into int
        int totalMarksint = (int) Math.round(totalMarks);

        //calculate percentage in double
        double percentage = (double) totalMarksint / (double) s;
        
        if(percentage>=90 && percentage<=100){
            grade = "A+";
            gradeInfo = "Distinction";
        }
        else if(percentage>=80 && percentage<90){
            grade = "A";
            gradeInfo = "Very Good";
        }
        else if(percentage>=70 && percentage<80){
            grade = "B+";
            gradeInfo = "Satisfactory Performance";
        }
        else if(percentage>=60 && percentage<70){
            grade = "B";
            gradeInfo = "Satisfactory Performance";
        }
        else if(percentage>=50 && percentage<60){
            grade = "C+";
            gradeInfo = "Fair.Some improvement needed";
        }
        else if(percentage>=40 && percentage<50){
            grade = "C";
            gradeInfo = "Fair.Significant improvement needed";
        }
        else if(percentage<=0 && percentage<40){
            grade = "F";
            gradeInfo = "Fail.Unsatisfactory Performance";
        }
        

        System.out.println("");
        System.out.println("");
        System.out.println(":: Result ::");
        System.out.println("");
        System.out.println("Total Marks: "+totalMarksint);
        System.out.println("Percentage: "+percentage);
        System.out.println("Grade: "+grade);
        System.out.println("\t"+gradeInfo);
        
    }

}

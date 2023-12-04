import javax.swing.JOptionPane;

public class countGrade {
    public static void main(String[] args) {
        int max = 100;
        double totalMarks = 0.0;
        boolean invalidOption = false;


        while (true) {
            JOptionPane.showMessageDialog(null, "WelCome  Student Mark Sheet");
            String totalsubject = JOptionPane.showInputDialog("Enter Total Subject :");
            int TotalSubject = Integer.parseInt(totalsubject);

            
            for (int i = 1; i <= TotalSubject; i++) {
                String subjectmarks = JOptionPane.showInputDialog("Enter Subject Marks:" + i + "  " + "(Out of 100) :");
                double SubjectMarks = Double.parseDouble(subjectmarks);
                if (max >= SubjectMarks) {
                    totalMarks = SubjectMarks + totalMarks;
                } else {
                    // JOptionPane.showMessageDialog(null, "your marks is INVALID");
                    invalidOption = true;
                    break;

                }

            }
            if (invalidOption) {
                JOptionPane.showMessageDialog(null, "your marks is INVALID");
            } else {
                double totalAverage = (totalMarks / TotalSubject);
                String grade = CalculateGrade(totalAverage);

                String result = "totalMarks:" + " " + totalMarks + "\ntotalAverage:" + " " + totalAverage
                        + "\nGrade is:"
                        + " " + grade;

                JOptionPane.showMessageDialog(null, result);
                JOptionPane.showMessageDialog(null,"Thank You");

            }

        }
    }

    // double totalAverage = 0.0;

    public static String CalculateGrade(double totalAverage) {

        if (totalAverage >= 90) {

            return "A+";

        } else if (totalAverage >= 75) {
            return "A";

        } else if (totalAverage >= 65) {
            return "B";

        } else if (totalAverage >= 55) {
            return "C+";

        } else if (totalAverage >= 45) {
            return "C";

        } else {
            return "F";
        }

    }
}
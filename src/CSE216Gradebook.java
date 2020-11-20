import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class CSE216Gradebook {
	private static CSE216Gradebook instance = new CSE216Gradebook();
	
    private HashMap<CSE216Student, ArrayList<Double>> gradeTable;
    
    private CSE216Gradebook() {
        // singleton! (do not define)
    }
    
    public CSE216Gradebook Instance() {
        return instance;
    }
    
    /**
     * Gets the given student's grade list.
     * @param s student
     * @return student's list of grades
     */
    public ArrayList<Double> getStudentGrades(CSE216Student s) {
        if(s == null) {
            return null;
        }
    	return gradeTable.get(s);
    }
    
    /**
     * Gets the given student's grade list.
     * @param lastName
     * @param firstName
     * @return
     */
    public ArrayList<Double> getStudentGrades(String lastName, String firstName) {
        CSE216Student s = new CSE216Student(lastName, firstName);
        return gradeTable.get(s);
    }
    
    /**
     * Sets the given student's grade list.
     * @param s student
     * @param grades
     */
    public void setStudentGrades(CSE216Student s, ArrayList<Double> grades) {
        if(s != null) {
            gradeTable.put(s, grades);
        }
    }
    
    /**
     * Sets the given student's grade list.
     * @param lastName
     * @param firstName
     * @param grades
     */
    public void setStudentGrades(String lastName, String firstName, ArrayList<Double> grades) {
        CSE216Student s = new CSE216Student(lastName, firstName);
        if(s != null) {
            gradeTable.put(s, grades);
        }
    }
    
    /**
     * Adds a grade for the given student.
     * @param s student
     * @param grade
     */
    public void addGrade(CSE216Student s, double grade) {
        ArrayList<Double> grades = gradeTable.get(s);
        if(grades != null) {
            grades.add(grade);
            gradeTable.put(s, grades);
        }
    }
    
    /**
     * Adds a grade for the given student.
     * @param lastName
     * @param firstName
     * @param grade
     */
    public void addGrade(String lastName, String firstName, double grade) {
        CSE216Student s = new CSE216Student(lastName, firstName);
        addGrade(s, grade);
    }
    
    /**
     * Removes the given student's last grade.
     * @param s student
     * @return last grade, removed
     */
    public double removeGrade(CSE216Student s) {
        ArrayList<Double> grades = gradeTable.get(s);
        if(grades == null) {
        	return 0.0;
        }
        double grade = grades.remove(grades.size() - 1);
        gradeTable.put(s, grades);
        return grade;
    }
    
    /**
     * Removes the given student's last grade.
     * @param lastName student's last name
     * @param firstName student's first name
     * @return last grade, removed
     */
    public double removeGrade(String lastName, String firstName) {
        CSE216Student s = new CSE216Student(lastName, firstName);
        return removeGrade(s);
    }
    
    public double calcAvgStudentGrade(CSE216Student s) {
        ArrayList<Double> grades = gradeTable.get(s);
        if(grades == null) {
            return 0.0;
        }
        
        double sum = 0.0;
        for(double grade : grades) {
        	sum += grade;
        }
        return sum / grades.size();
    }
    
    public double calcAvgStudentGrade(String lastName, String firstName) {
        CSE216Student s = new CSE216Student(lastName, firstName);
        return calcAvgStudentGrade(s);
    }
    
    public double calcAvgClassGrade() {
    	Collection<ArrayList<Double>> gradeLists = gradeTable.values();
    	
    	double sum = 0.0;
    	for(ArrayList<Double> gradeList : gradeLists) {
    		double gradeSum = 0.0;
    		for(double d : gradeList) {
    			gradeSum += d;
    		}
    		sum += (gradeSum / gradeList.size());
    	}
    	return sum / gradeLists.size();
    }
}

package com.setu.dsa;

/**
 * Represents a student grade using percentage scoring (0-100).
 * Extends StudentGrade to provide percentage-based grading functionality.
 * 
 * @author SETU
 * @version 1.0
 */
public class PercentageGrade extends StudentGrade {
    
    /** The percentage grade (0-100) */
    private int grade;
    
    /**
     * Constructs a new PercentageGrade with the specified student and module names.
     * 
     * @param studentName the name of the student
     * @param moduleName the name of the module
     */
    public PercentageGrade(String studentName, String moduleName) {
        setStudentName(studentName);
        setModuleName(moduleName);
    }
    
    /**
     * Sets the percentage grade.
     * 
     * @param grade the percentage grade to set (must be between 0 and 100)
     * @throws IllegalArgumentException if grade is less than 0 or greater than 100
     */
    public void setGrade(int grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
        this.grade = grade;
    }
    
    /**
     * Gets the percentage grade.
     * 
     * @return the percentage grade
     */
    @Override
    public int getGrade() {
        return grade;
    }
    
    /**
     * Classifies the percentage grade into a category.
     * 
     * @return "Distinction" for 70-100, "Merit" for 50-69, "Pass" for 40-49, "Fail" for 0-39
     */
    @Override
    public String classifyGrade() {
        if (grade >= 70) {
            return "Distinction";
        } else if (grade >= 50) {
            return "Merit";
        } else if (grade >= 40) {
            return "Pass";
        } else {
            return "Fail";
        }
    }
}

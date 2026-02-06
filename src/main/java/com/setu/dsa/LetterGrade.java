package com.setu.dsa;

/**
 * Represents a student grade using letter grading (A-E).
 * Extends StudentGrade to provide letter-based grading functionality.
 * 
 * @author SETU
 * @version 1.0
 */
public class LetterGrade extends StudentGrade {
    
    /** The letter grade (A-E) */
    private char grade;
    
    /**
     * Constructs a new LetterGrade with the specified student and module names.
     * 
     * @param studentName the name of the student
     * @param moduleName the name of the module
     */
    public LetterGrade(String studentName, String moduleName) {
        setStudentName(studentName);
        setModuleName(moduleName);
    }
    
    /**
     * Sets the letter grade using a character.
     * 
     * @param grade the letter grade to set (A-E, case insensitive)
     * @throws IllegalArgumentException if grade is not between A and E
     */
    public void setGrade(char grade) {
        // TODO: Accept A-E (case insensitive), throw IllegalArgumentException otherwise
    }
    
    /**
     * Sets the letter grade using a String.
     * Convenience method for setting grade from String input.
     * 
     * @param grade the letter grade to set as a String (A-E, case insensitive)
     * @throws IllegalArgumentException if grade is not between A and E or String is invalid
     */
    public void setGrade(String grade) {
        // TODO: Accept A-E (case insensitive), throw IllegalArgumentException otherwise
    }
    
    /**
     * Gets the numeric value of the letter grade.
     * 
     * @return 1 for A, 2 for B, 3 for C, 4 for D, 5 for E
     */
    @Override
    public int getGrade() {
        // TODO: Return 1 for A, 2 for B, 3 for C, 4 for D, 5 for E
        return 0;
    }
    
    /**
     * Classifies the letter grade into a category.
     * 
     * @return "Distinction" for A or B, "Merit" for C, "Pass" for D, "Fail" for E
     */
    @Override
    public String classifyGrade() {
        // TODO: Return 'Distinction' for A or B, 'Merit' for C, 'Pass' for D, 'Fail' for E
        return null;
    }
}

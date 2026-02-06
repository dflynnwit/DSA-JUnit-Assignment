package com.setu.dsa;

/**
 * Abstract class representing a student's grade in a module.
 * This class provides the common structure for different grading systems.
 * 
 * @author SETU
 * @version 1.0
 */
public abstract class StudentGrade {
    
    /** The name of the student */
    private String studentName;
    
    /** The name of the module */
    private String moduleName;
    
    /**
     * Gets the student's name.
     * 
     * @return the student's name
     */
    public String getStudentName() {
        return studentName;
    }
    
    /**
     * Sets the student's name.
     * 
     * @param studentName the student's name to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    /**
     * Gets the module name.
     * 
     * @return the module name
     */
    public String getModuleName() {
        return moduleName;
    }
    
    /**
     * Sets the module name.
     * 
     * @param moduleName the module name to set
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    
    /**
     * Classifies the grade into a category (e.g., Distinction, Merit, Pass, Fail).
     * This method must be implemented by concrete subclasses.
     * 
     * @return the classification of the grade
     */
    public abstract String classifyGrade();
    
    /**
     * Gets the grade value.
     * The representation depends on the grading system used.
     * This method must be implemented by concrete subclasses.
     * 
     * @return the grade value
     */
    public abstract int getGrade();
}

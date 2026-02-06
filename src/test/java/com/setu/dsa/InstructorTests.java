package com.setu.dsa;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive instructor tests for grading student implementations.
 * These tests verify that PercentageGrade and LetterGrade are correctly implemented.
 * All tests should PASS when the student implementation is correct.
 * 
 * @author SETU Instructor
 * @version 1.0
 */
public class InstructorTests {
    
    private PercentageGrade percentageGrade;
    private LetterGrade letterGrade;
    
    @BeforeEach
    public void setUp() {
        percentageGrade = new PercentageGrade("Test Student", "Data Structures");
        letterGrade = new LetterGrade("Test Student", "Algorithms");
    }
    
    @AfterEach
    public void tearDown() {
        percentageGrade = null;
        letterGrade = null;
    }
    
    // ========================================================================
    // PERCENTAGE GRADE TESTS
    // ========================================================================
    
    @Test
    @DisplayName("Test PercentageGrade object creation with student and module names")
    public void testPercentageGradeCreation() {
        assertEquals("Test Student", percentageGrade.getStudentName());
        assertEquals("Data Structures", percentageGrade.getModuleName());
    }
    
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 50, 70, 99, 100})
    @DisplayName("Test valid percentage grades are accepted")
    public void testValidPercentageGrades(int grade) {
        assertDoesNotThrow(() -> percentageGrade.setGrade(grade));
        percentageGrade.setGrade(grade);
        assertEquals(grade, percentageGrade.getGrade());
    }
    
    @ParameterizedTest
    @ValueSource(ints = {-1, -50, 101, 150, 200})
    @DisplayName("Test invalid percentage grades throw IllegalArgumentException")
    public void testInvalidPercentageGradesThrowException(int invalidGrade) {
        assertThrows(IllegalArgumentException.class, () -> {
            percentageGrade.setGrade(invalidGrade);
        }, "Should throw IllegalArgumentException for grade: " + invalidGrade);
    }
    
    @ParameterizedTest
    @CsvSource({
        "70, Distinction",
        "85, Distinction",
        "100, Distinction"
    })
    @DisplayName("Test percentage grades 70-100 classify as Distinction")
    public void testPercentageDistinction(int grade, String expected) {
        percentageGrade.setGrade(grade);
        assertEquals(expected, percentageGrade.classifyGrade());
    }
    
    @ParameterizedTest
    @CsvSource({
        "50, Merit",
        "60, Merit",
        "69, Merit"
    })
    @DisplayName("Test percentage grades 50-69 classify as Merit")
    public void testPercentageMerit(int grade, String expected) {
        percentageGrade.setGrade(grade);
        assertEquals(expected, percentageGrade.classifyGrade());
    }
    
    @ParameterizedTest
    @CsvSource({
        "40, Pass",
        "45, Pass",
        "49, Pass"
    })
    @DisplayName("Test percentage grades 40-49 classify as Pass")
    public void testPercentagePass(int grade, String expected) {
        percentageGrade.setGrade(grade);
        assertEquals(expected, percentageGrade.classifyGrade());
    }
    
    @ParameterizedTest
    @CsvSource({
        "0, Fail",
        "20, Fail",
        "39, Fail"
    })
    @DisplayName("Test percentage grades 0-39 classify as Fail")
    public void testPercentageFail(int grade, String expected) {
        percentageGrade.setGrade(grade);
        assertEquals(expected, percentageGrade.classifyGrade());
    }
    
    @Test
    @DisplayName("Test percentage boundary: 39 is Fail, 40 is Pass")
    public void testPercentageBoundary39To40() {
        percentageGrade.setGrade(39);
        assertEquals("Fail", percentageGrade.classifyGrade());
        
        percentageGrade.setGrade(40);
        assertEquals("Pass", percentageGrade.classifyGrade());
    }
    
    @Test
    @DisplayName("Test percentage boundary: 49 is Pass, 50 is Merit")
    public void testPercentageBoundary49To50() {
        percentageGrade.setGrade(49);
        assertEquals("Pass", percentageGrade.classifyGrade());
        
        percentageGrade.setGrade(50);
        assertEquals("Merit", percentageGrade.classifyGrade());
    }
    
    @Test
    @DisplayName("Test percentage boundary: 69 is Merit, 70 is Distinction")
    public void testPercentageBoundary69To70() {
        percentageGrade.setGrade(69);
        assertEquals("Merit", percentageGrade.classifyGrade());
        
        percentageGrade.setGrade(70);
        assertEquals("Distinction", percentageGrade.classifyGrade());
    }
    
    // ========================================================================
    // LETTER GRADE TESTS
    // ========================================================================
    
    @Test
    @DisplayName("Test LetterGrade object creation with student and module names")
    public void testLetterGradeCreation() {
        assertEquals("Test Student", letterGrade.getStudentName());
        assertEquals("Algorithms", letterGrade.getModuleName());
    }
    
    @ParameterizedTest
    @ValueSource(chars = {'A', 'B', 'C', 'D', 'E'})
    @DisplayName("Test valid uppercase letter grades are accepted")
    public void testValidUppercaseLetterGrades(char grade) {
        assertDoesNotThrow(() -> letterGrade.setGrade(grade));
    }
    
    @ParameterizedTest
    @ValueSource(chars = {'a', 'b', 'c', 'd', 'e'})
    @DisplayName("Test valid lowercase letter grades are accepted (case insensitive)")
    public void testValidLowercaseLetterGrades(char grade) {
        assertDoesNotThrow(() -> letterGrade.setGrade(grade));
    }
    
    @ParameterizedTest
    @ValueSource(chars = {'F', 'G', 'Z', 'X', '1', '5', '@'})
    @DisplayName("Test invalid letter grades throw IllegalArgumentException")
    public void testInvalidLetterGradesThrowException(char invalidGrade) {
        assertThrows(IllegalArgumentException.class, () -> {
            letterGrade.setGrade(invalidGrade);
        }, "Should throw IllegalArgumentException for grade: " + invalidGrade);
    }
    
    @ParameterizedTest
    @CsvSource({
        "A, 1",
        "B, 2",
        "C, 3",
        "D, 4",
        "E, 5"
    })
    @DisplayName("Test getGrade returns correct numeric values for letters")
    public void testLetterToNumericConversion(char letter, int expectedNumber) {
        letterGrade.setGrade(letter);
        assertEquals(expectedNumber, letterGrade.getGrade());
    }
    
    @ParameterizedTest
    @CsvSource({
        "a, 1",
        "b, 2",
        "c, 3",
        "d, 4",
        "e, 5"
    })
    @DisplayName("Test getGrade returns correct numeric values for lowercase letters")
    public void testLowercaseLetterToNumericConversion(char letter, int expectedNumber) {
        letterGrade.setGrade(letter);
        assertEquals(expectedNumber, letterGrade.getGrade());
    }
    
    @ParameterizedTest
    @CsvSource({
        "A, Distinction",
        "B, Distinction"
    })
    @DisplayName("Test letter grades A and B classify as Distinction")
    public void testLetterDistinction(char grade, String expected) {
        letterGrade.setGrade(grade);
        assertEquals(expected, letterGrade.classifyGrade());
    }
    
    @Test
    @DisplayName("Test letter grade C classifies as Merit")
    public void testLetterMerit() {
        letterGrade.setGrade('C');
        assertEquals("Merit", letterGrade.classifyGrade());
    }
    
    @Test
    @DisplayName("Test letter grade D classifies as Pass")
    public void testLetterPass() {
        letterGrade.setGrade('D');
        assertEquals("Pass", letterGrade.classifyGrade());
    }
    
    @Test
    @DisplayName("Test letter grade E classifies as Fail")
    public void testLetterFail() {
        letterGrade.setGrade('E');
        assertEquals("Fail", letterGrade.classifyGrade());
    }
    
    @Test
    @DisplayName("Test String overload for setGrade with valid input")
    public void testLetterGradeStringOverload() {
        letterGrade.setGrade("A");
        assertEquals(1, letterGrade.getGrade());
        
        letterGrade.setGrade("c");
        assertEquals(3, letterGrade.getGrade());
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"F", "Z", "AA", "1", ""})
    @DisplayName("Test String overload throws exception for invalid input")
    public void testInvalidStringGradeThrowsException(String invalidGrade) {
        assertThrows(IllegalArgumentException.class, () -> {
            letterGrade.setGrade(invalidGrade);
        }, "Should throw IllegalArgumentException for grade: " + invalidGrade);
    }
    
    @Test
    @DisplayName("Test case insensitivity: uppercase and lowercase produce same results")
    public void testCaseInsensitivity() {
        letterGrade.setGrade('A');
        int upperResult = letterGrade.getGrade();
        String upperClassification = letterGrade.classifyGrade();
        
        letterGrade.setGrade('a');
        int lowerResult = letterGrade.getGrade();
        String lowerClassification = letterGrade.classifyGrade();
        
        assertEquals(upperResult, lowerResult);
        assertEquals(upperClassification, lowerClassification);
    }
}

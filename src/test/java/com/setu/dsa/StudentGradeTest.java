package com.setu.dsa;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Student test class for testing PercentageGrade and LetterGrade implementations.
 * 
 * INSTRUCTIONS FOR STUDENTS:
 * - Create at least 8-10 @Test methods to test PercentageGrade and LetterGrade classes
 * - Test valid inputs, invalid inputs, boundary cases, and all classification categories
 * - Use appropriate JUnit assertions: assertEquals(), assertThrows(), assertTrue(), etc.
 * - Follow the example test structure provided below
 * 
 * @author Student Name - Add your name here
 * @version 1.0
 */
public class StudentGradeTest {
    
    private PercentageGrade percentageGrade;
    private LetterGrade letterGrade;
    
    /**
     * Set up test fixtures before each test method.
     * This method runs before EACH test method.
     */
    @BeforeEach
    public void setUp() {
        percentageGrade = new PercentageGrade("John Doe", "Data Structures");
        letterGrade = new LetterGrade("Jane Smith", "Algorithms");
    }
    
    /**
     * Clean up after each test method.
     * This method runs after EACH test method.
     */
    @AfterEach
    public void tearDown() {
        // TODO: Clean up test objects if needed
        // Example:
        // percentageGrade = null;
        // letterGrade = null;
    }
    
    /**
     * Example test method showing the basic structure.
     * This tests that a PercentageGrade object can be created successfully.
     */
    @Test
    public void testPercentageGradeCreation() {
        // Arrange
        PercentageGrade grade = new PercentageGrade("Test Student", "Test Module");
        
        // Act
        String studentName = grade.getStudentName();
        String moduleName = grade.getModuleName();
        
        // Assert
        assertEquals("Test Student", studentName, "Student name should match");
        assertEquals("Test Module", moduleName, "Module name should match");
    }
    
    // ========================================================================
    // STUDENTS: ADD YOUR TEST METHODS BELOW
    // ========================================================================
    // Create at least 8-10 additional @Test methods to thoroughly test:
    //
    // PercentageGrade tests:
    // - Test setting valid grades (0, 50, 70, 100)
    // - Test boundary cases (39, 40, 49, 50, 69, 70)
    // - Test invalid grades throw IllegalArgumentException (-1, 101, 150)
    // - Test grade classifications (Distinction, Merit, Pass, Fail)
    //
    // LetterGrade tests:
    // - Test setting valid letter grades (A, B, C, D, E)
    // - Test case insensitivity (a, b, c, d, e)
    // - Test invalid grades throw IllegalArgumentException (F, Z, X)
    // - Test getGrade() returns correct numbers (A=1, B=2, etc.)
    // - Test grade classifications (Distinction, Merit, Pass, Fail)
    //
    // Example test structure:
    //
    // @Test
    // public void testPercentageDistinction() {
    //     percentageGrade.setGrade(85);
    //     assertEquals("Distinction", percentageGrade.classifyGrade());
    // }
    //
    // @Test
    // public void testInvalidPercentageThrowsException() {
    //     assertThrows(IllegalArgumentException.class, () -> {
    //         percentageGrade.setGrade(-1);
    //     });
    // }
    // ========================================================================
    
    @Test
    public void testPercentageDistinction() {
        percentageGrade.setGrade(85);
        assertEquals("Distinction", percentageGrade.classifyGrade());
    }

    @Test
    public void testPercentageMerit() {
        percentageGrade.setGrade(60);
        assertEquals("Merit", percentageGrade.classifyGrade());
    }

    @Test
    public void testPercentagePass() {
        percentageGrade.setGrade(45);
        assertEquals("Pass", percentageGrade.classifyGrade());
    }

    @Test
    public void testPercentageFail() {
        percentageGrade.setGrade(30);
        assertEquals("Fail", percentageGrade.classifyGrade());
    }

    @Test
    public void testInvalidPercentageThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            percentageGrade.setGrade(-1);
        });
    }

    @Test
    public void testPercentageAbove100ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            percentageGrade.setGrade(101);
        });
    }

    @Test
    public void testLetterGradeA() {
        letterGrade.setGrade('A');
        assertEquals(1, letterGrade.getGrade());
        assertEquals("Distinction", letterGrade.classifyGrade());
    }

    @Test
    public void testLetterGradeD() {
        letterGrade.setGrade('D');
        assertEquals(4, letterGrade.getGrade());
        assertEquals("Pass", letterGrade.classifyGrade());
    }

    @Test
    public void testInvalidLetterThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            letterGrade.setGrade('F');
        });
    }

    @Test
    public void testInvalidStringGradeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            letterGrade.setGrade("");
        });
    }
}

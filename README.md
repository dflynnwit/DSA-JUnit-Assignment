# Worksheet 1 – JUnit Testing

## Assignment Overview

Create an abstract Java class called `StudentGrade` with two concrete subclasses: `PercentageGrade` and `LetterGrade`. Write comprehensive JUnit 5 tests to verify the implementation.

This assignment teaches fundamental concepts in object-oriented programming, test-driven development (TDD), and automated testing with JUnit 5.

## Learning Objectives

By completing this assignment, you will:
- Master JUnit 5 testing annotations and assertions in Java
- Practice Test-Driven Development (TDD) methodology
- Understand abstract classes and inheritance in Java
- Learn proper exception handling and validation
- Develop skills in boundary testing and edge case analysis
- Experience automated grading through GitHub Actions

## Assignment Requirements

### Part 1: Implement the Classes

You need to complete the implementation of three Java classes located in `src/main/java/com/setu/dsa/`:

#### 1. StudentGrade (Abstract Class) - Already Implemented
An abstract class that provides common functionality for student grades:
- `studentName` and `moduleName` fields with getters/setters
- Abstract methods: `classifyGrade()` and `getGrade()`

#### 2. PercentageGrade (Extends StudentGrade)
Implement the TODO methods in this class:

- **`setGrade(int grade)`**: 
  - Accept grades from 0 to 100
  - Throw `IllegalArgumentException` if grade < 0 or grade > 100
  
- **`getGrade()`**: 
  - Return the stored percentage grade
  
- **`classifyGrade()`**: 
  - Return "Distinction" for grades 70-100
  - Return "Merit" for grades 50-69
  - Return "Pass" for grades 40-49
  - Return "Fail" for grades 0-39

#### 3. LetterGrade (Extends StudentGrade)
Implement the TODO methods in this class:

- **`setGrade(char grade)`**: 
  - Accept letters A-E (case insensitive)
  - Throw `IllegalArgumentException` for invalid letters
  
- **`setGrade(String grade)`**: 
  - Overload that accepts String input
  - Convert to char and validate (A-E only)
  
- **`getGrade()`**: 
  - Return numeric value: A=1, B=2, C=3, D=4, E=5
  
- **`classifyGrade()`**: 
  - Return "Distinction" for A or B
  - Return "Merit" for C
  - Return "Pass" for D
  - Return "Fail" for E

### Part 2: Write JUnit Tests

Create **at least 8-10 test methods** in `src/test/java/com/setu/dsa/StudentGradeTest.java`.

Your tests should cover:
1. **Valid input tests**: Test that valid grades are accepted and stored correctly
2. **Invalid input tests**: Test that invalid grades throw `IllegalArgumentException`
3. **Boundary tests**: Test edge cases (39/40, 49/50, 69/70 for percentages)
4. **Classification tests**: Verify all grade classifications work correctly
5. **Getter/setter tests**: Ensure student and module names work properly
6. **Case sensitivity tests**: For LetterGrade, test both uppercase and lowercase

**Required annotations:**
- `@BeforeEach`: Initialize test objects before each test
- `@AfterEach`: Clean up after each test (optional but recommended)
- `@Test`: Mark each test method

**Useful JUnit assertions:**
- `assertEquals(expected, actual)`: Check equality
- `assertThrows(ExceptionType.class, () -> { code })`: Verify exceptions
- `assertTrue(condition)`: Check boolean conditions
- `assertNotNull(object)`: Verify object is not null

## Setup Instructions

### Prerequisites
- Java Development Kit (JDK) 17 or higher
- Apache Maven 3.6 or higher
- IntelliJ IDEA, Eclipse, or VS Code with Java extensions

### IntelliJ IDEA Setup
1. Clone this repository to your local machine
2. Open IntelliJ IDEA
3. Select **File** → **Open**
4. Navigate to the project directory and select the `pom.xml` file
5. Click **Open as Project**
6. IntelliJ will automatically import the Maven project and download dependencies
7. Wait for the indexing and dependency resolution to complete

### Eclipse Setup
1. Clone this repository to your local machine
2. Open Eclipse
3. Select **File** → **Import**
4. Choose **Maven** → **Existing Maven Projects**
5. Browse to the project directory and select it
6. Click **Finish**
7. Eclipse will automatically configure the project and download dependencies

### Visual Studio Code Setup
1. Install the "Extension Pack for Java" from the VS Code marketplace
2. Clone this repository
3. Open the project folder in VS Code
4. VS Code will automatically detect the Maven project

## Running Tests

### In IntelliJ IDEA
- **Run all tests**: Right-click on `src/test/java` → **Run 'All Tests'**
- **Run single test class**: Right-click on the test file → **Run 'TestClassName'**
- **Run single test method**: Click the green arrow next to the test method
- **Use Maven**: Open Maven tool window → **Lifecycle** → **test**

### In Eclipse
- **Run all tests**: Right-click on `src/test/java` → **Run As** → **JUnit Test**
- **Run single test**: Right-click on the test file → **Run As** → **JUnit Test**

### Command Line
```bash
# Compile the project
mvn clean compile

# Run all tests
mvn test

# Run only instructor tests
mvn test -Dtest=InstructorTests

# Run only student tests
mvn test -Dtest=StudentGradeTest

# Run with verbose output
mvn test -X
```

## Development Workflow (TDD Approach)

Follow these steps for Test-Driven Development:

1. **Read the requirements** for one method (e.g., `PercentageGrade.setGrade()`)
2. **Write a test** that would pass if the method was implemented correctly
3. **Run the test** - it should fail (RED phase)
4. **Implement the method** with minimal code to make the test pass
5. **Run the test again** - it should now pass (GREEN phase)
6. **Refactor** if needed to improve code quality (REFACTOR phase)
7. **Commit your changes** to Git
8. **Repeat** for the next method

### Example TDD Cycle

```java
// 1. Write the test first
@Test
public void testValidPercentageGrade() {
    percentageGrade.setGrade(75);
    assertEquals(75, percentageGrade.getGrade());
}

// 2. Run test → FAILS (method not implemented)

// 3. Implement the method
public void setGrade(int grade) {
    if (grade < 0 || grade > 100) {
        throw new IllegalArgumentException("Grade must be between 0 and 100");
    }
    this.grade = grade;
}

// 4. Run test → PASSES
// 5. Commit and move to next feature
```

## Grading Rubric (100 points)

| Criteria | Points | Description |
|----------|--------|-------------|
| **Test Quantity** | 20 | At least 8 @Test methods in StudentGradeTest.java |
| **Test Setup** | 10 | Includes @BeforeEach and @AfterEach methods |
| **Student Tests Pass** | 30 | All tests in StudentGradeTest.java pass |
| **Instructor Tests Pass** | 40 | All tests in InstructorTests.java pass (validates correct implementation) |

### Breakdown of Instructor Tests
The `InstructorTests.java` file contains comprehensive tests that verify:
- ✅ Valid grades are accepted
- ✅ Invalid grades throw exceptions
- ✅ Boundary cases work correctly
- ✅ All classification categories return correct values
- ✅ Case insensitivity for letter grades
- ✅ Numeric conversions for letter grades

**All instructor tests must pass to receive full credit.**

## Tips for Success

### General Tips
- 📖 **Read the TODO comments** carefully in each method
- 🧪 **Test frequently** - run tests after implementing each method
- 🔍 **Test edge cases** - boundaries are where bugs hide (e.g., 39 vs 40)
- ❌ **Test failures** - verify that invalid inputs throw exceptions
- 📝 **Write clear test names** - use descriptive method names like `testPercentageDistinction()`

### Testing Tips
- Use `assertEquals()` for comparing values
- Use `assertThrows()` for exception testing:
  ```java
  assertThrows(IllegalArgumentException.class, () -> {
      percentageGrade.setGrade(-1);
  });
  ```
- Test both uppercase and lowercase letters for LetterGrade
- Don't forget to test boundary values (39, 40, 49, 50, 69, 70)

### Common Mistakes to Avoid
- ❌ Not throwing exceptions for invalid inputs
- ❌ Forgetting to test boundary cases
- ❌ Not handling case insensitivity in LetterGrade
- ❌ Having fewer than 8 test methods
- ❌ Not using @BeforeEach to initialize test objects
- ❌ Copy-pasting test code without understanding it

## Automated Grading

This assignment uses **GitHub Actions** for automated grading. Every time you push code:

1. ✅ Code is compiled
2. ✅ All tests are run
3. ✅ Test count is verified (≥ 8 @Test methods)
4. ✅ @BeforeEach annotation is checked
5. ✅ Results are displayed

### Viewing Autograding Results

1. Go to your repository on GitHub
2. Click the **Actions** tab
3. Click on the latest workflow run
4. Expand each step to see detailed results
5. Green checkmarks ✅ = passing
6. Red X ❌ = failing (click to see why)

## Submission

### How to Submit
1. Complete your implementation in the Java files
2. Write your tests in `StudentGradeTest.java`
3. Commit your changes:
   ```bash
   git add .
   git commit -m "Completed JUnit assignment"
   git push
   ```
4. Check GitHub Actions to verify your grade
5. Continue improving until all tests pass

### What Gets Graded
- Your implementation in `PercentageGrade.java` and `LetterGrade.java`
- Your tests in `StudentGradeTest.java`
- Number of test methods (≥ 8)
- Presence of @BeforeEach annotation
- Whether all tests pass

## Resources

### JUnit 5 Documentation
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [JUnit 5 API Documentation](https://junit.org/junit5/docs/current/api/)

### Java Documentation
- [Java 17 API Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/)
- [Java Exceptions Tutorial](https://docs.oracle.com/javase/tutorial/essential/exceptions/)

### Testing Best Practices
- [Test-Driven Development](https://en.wikipedia.org/wiki/Test-driven_development)
- [Unit Testing Best Practices](https://stackify.com/unit-testing-basics-best-practices/)

## Getting Help

If you encounter issues:
1. 📖 Review this README carefully
2. 🧪 Run tests locally to see specific error messages
3. 🔍 Check GitHub Actions logs for detailed feedback
4. 💬 Ask questions in the course forum or during office hours
5. 👥 Collaborate with classmates (but write your own code!)

## Project Structure

```
DSA-JUnit-Assignment/
├── .github/
│   └── workflows/
│       └── classroom.yml          # Autograding workflow
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── setu/
│   │               └── dsa/
│   │                   ├── StudentGrade.java      # Abstract base class
│   │                   ├── PercentageGrade.java   # TODO: Implement
│   │                   └── LetterGrade.java       # TODO: Implement
│   └── test/
│       └── java/
│           └── com/
│               └── setu/
│                   └── dsa/
│                       ├── StudentGradeTest.java  # TODO: Write 8+ tests
│                       └── InstructorTests.java   # Grading tests (do not modify)
├── pom.xml                        # Maven configuration
├── .gitignore                     # Git ignore rules
└── README.md                      # This file
```

## License

This project is created for educational purposes as part of the Data Structures and Algorithms course at South East Technological University (SETU).

---

**Good luck with your assignment! Remember: Write tests first, implement second, and test often!** 🚀

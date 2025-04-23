# Kotlin Lotto Project

## Features to Implement

**1. Input Handling and Validation**
* Read purchase amount for lottery tickets
* Validate that the amount is non-negative and divisible by 1,000 KRW
* Read winning numbers as comma-separated input (6 unique numbers between 1-45)
* Read bonus number (between 1-45, not in winning numbers)
* Implement error handling for invalid inputs (throw IllegalArgumentException)

**2. Domain Model**
* Use the provided Lotto class to represent lottery tickets
    * Store 6 unique numbers between 1-45
    * Implement validation logic
    * Add methods to check matches with winning numbers
* Create a LottoRank enum to represent prize categories
    * Define prize amounts for each rank
    * Implement logic to determine rank based on matches

**3. Game Logic**
* Generate lottery tickets based on purchase amount
* Generate random unique numbers (1-45) for each ticket
* Compare user tickets with winning numbers and bonus number
* Determine prize rank for each ticket
* Calculate total winnings and return rate

**4. Output Formatting**
* Display purchased lottery tickets
* Show winning statistics for each prize category
* Display total return rate formatted to one decimal place
* Format output according to the specified requirements

**5. Testing**
* Unit tests for Lotto class functionality
* Unit tests for prize determination logic
* Tests for input validation
* Integration tests for the complete workflow

## Project Structure
````
src/
├── main/kotlin/
│   └── lotto/
│       ├── domain/
│       │   ├── LottoGenerator.kt
│       │   ├── LottoRank.kt
│       │   └── WinningChecker.kt
│       ├── view/
│       │   ├── InputView.kt
│       │   └── OutputView.kt
│       ├── Application.kt
│       └── Lotto.kt
└── test/kotlin/
    └── lotto/
        ├── domain/
        │   ├── LottoGeneratorTest.kt
        │   ├── LottoRankTest.kt
        │   └── WinningCheckerTest.kt
        ├── LottoTest.kt
        └── ApplicationTest.kt
````
## Specific Requirements

**Programming Requirements:**
* Keep functions under 10 lines to ensure they perform a single responsibility
* Avoid using `else` statements
    * In many cases, early `return` can eliminate the need for `else`
* Use **Enum classes** where applicable
* Separate business logic from UI logic
    * Use dedicated classes such as `InputView` and `OutputView` to clearly isolate UI-related code from core functionality
* Implement unit tests for all logic, except for UI interactions (System.out, System.in)
    * If not familiar with writing unit tests, refer to `LottoTest` as a learning reference

**Error Handling:**
* If the user inputs invalid data, throw an IllegalArgumentException and re-prompt input
* Handle only specific exception types such as IllegalArgumentException or IllegalStateException, not generic Exception
* Error messages must start with [ERROR]

**Prize Categories:**
* 1st Prize: Match 6 numbers / 2,000,000,000 KRW
* 2nd Prize: Match 5 numbers + bonus number / 30,000,000 KRW
* 3rd Prize: Match 5 numbers / 1,500,000 KRW
* 4th Prize: Match 4 numbers / 50,000 KRW
* 5th Prize: Match 3 numbers / 5,000 KRW

**Implementation Approach**
I will follow these principles in my implementation:
* Keep functions small and focused, each one doing only one thing
* Limit nesting depth to a maximum of 2 levels
* Use proper exception handling for invalid inputs
* Follow Kotlin coding conventions
* Make small, feature-focused commits following AngularJS commit message conventions
* Write comprehensive tests with JUnit 5 and AssertJ

**Development Plan**
1. Set up basic project structure
2. Implement Lotto class functionality
3. Create input handling and validation
4. Implement lottery ticket generation
5. Add winning number checking logic
6. Implement prize calculation
7. Add output formatting
8. Write tests for all components
9. Refactor as needed to improve code quality
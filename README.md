# 🎲 Kotlin Lotto Project 🎯

## 🚀 Features to Implement

### 1. Input Handling and Validation ✅
- Read purchase amount for lottery tickets ✅
- Validate that the amount is non-negative and divisible by 1,000 KRW ✅
- Read winning numbers as comma-separated input (6 unique numbers between 1-45) ✅
- Read bonus number (between 1-45, not in winning numbers) ✅
- Implement error handling for invalid inputs (`throw IllegalArgumentException`) ✅

### 2. Domain Model 🏗️
- Use the provided `Lotto` class to represent lottery tickets ✅
  - Store 6 unique numbers between 1-45 ✅
  - Implement validation logic ✅
  - Add methods to check matches with winning numbers ✅
- Create a `LottoRank` enum to represent prize categories ✅
  - Define prize amounts for each rank ✅
  - Implement logic to determine rank based on matches ✅

### 3. Game Logic 🎮
- Generate lottery tickets based on purchase amount ✅
- Generate random unique numbers (1-45) for each ticket ✅
- Compare user tickets with winning numbers and bonus number ✅
- Determine prize rank for each ticket ✅
- Calculate total winnings and return rate ✅

### 4. Output Formatting 📊
- Display purchased lottery tickets ✅
- Show winning statistics for each prize category ✅
- Display total return rate formatted to one decimal place ✅
- Format output according to the specified requirements ✅

### 5. Testing 🧪
- Unit tests for Lotto class functionality ✅
- Unit tests for prize determination logic ✅
- Unit tests for the following components:
  - [x] LottoGenerator - test random number generation ✅
  - [x] InputView - test validation logic ✅
  - [x] OutputView - test formatting ✅
  - [x] Application - test integration of components ✅
- Integration tests:
  - [x] End-to-end workflow with valid inputs ✅
  - [x] Error handling with invalid inputs ✅
  - [x] Edge cases (e.g., zero tickets, all winning tickets) ✅

## 📝 Final Code Review Checklist
- [ ] Verify all functions are under 10 lines
- [ ] Remove any remaining `else` statements with early returns
- [ ] Ensure indentation depth doesn't exceed 2 levels
- [ ] Check for consistent naming conventions
- [ ] Verify error messages start with "[ERROR]"
- [ ] Confirm all tests pass with `./gradlew clean test`
- [ ] Review code for opportunities to apply Week 1 feedback
- [ ] Final review of code formatting and documentation

## 📁 Project Structure
```
src/
├── main/kotlin/
│   └── lotto/
│       ├── domain/
│       │   ├── LottoGenerator.kt   ✅
│       │   ├── LottoRank.kt        ✅
│       │   └── WinningChecker.kt   ✅
│       ├── view/
│       │   ├── InputView.kt        ✅
│       │   └── OutputView.kt       ✅
│       ├── Application.kt          ✅
│       └── Lotto.kt                ✅
└── test/kotlin/
    └── lotto/
        ├── domain/
        │   ├── LottoGeneratorTest.kt   ✅
        │   ├── LottoRankTest.kt        ✅
        │   └── WinningCheckerTest.kt   ✅
        ├── view/
        │   ├── InputViewTest.kt        ✅
        │   └── OutputViewTest.kt       ✅
        ├── LottoTest.kt                ✅
        └── ApplicationTest.kt          ✅
```

## 🏆 Prize Categories
- 1st Prize: Match 6 numbers / 2,000,000,000 KRW
- 2nd Prize: Match 5 numbers + bonus number / 30,000,000 KRW
- 3rd Prize: Match 5 numbers / 1,500,000 KRW
- 4th Prize: Match 4 numbers / 50,000 KRW
- 5th Prize: Match 3 numbers / 5,000 KRW

## 💡 Implementation Approach
I followed these principles in my implementation:
- ✨ Keep functions small and focused, each one doing only one thing
- 🔍 Limit nesting depth to a maximum of 2 levels
- 🛡️ Use proper exception handling for invalid inputs
- 📏 Follow Kotlin coding conventions
- 📝 Make small, feature-focused commits following AngularJS commit message conventions
- 🧪 Write comprehensive tests with JUnit 5 and AssertJ

## 📅 Development Plan
1. 🏗️ Set up basic project structure ✅
2. 🎫 Implement Lotto class functionality ✅
3. ⌨️ Create input handling and validation ✅
4. 🎲 Implement lottery ticket generation ✅
5. 🔍 Add winning number checking logic ✅
6. 💰 Implement prize calculation ✅
7. 📊 Add output formatting ✅
8. 🧪 Write tests for all components ✅
  - Complete LottoGeneratorTest ✅
  - Complete InputViewTest ✅
  - Complete OutputViewTest ✅
  - Complete ApplicationTest ✅
9. 🔄 Final code review and refactoring ⚠️
  - Apply feedback from Week 1
  - Fix bug in return rate calculation for zero tickets ✅
  - Ensure all requirements are met

## 🔄 Progress Tracker
- [x] Project setup with initial README ✅
- [x] Enhanced Lotto class with validation ✅
- [x] Created InputView for handling user input ✅
- [x] Created OutputView for displaying lottery tickets ✅
- [x] Implemented LottoGenerator for creating tickets ✅
- [x] Added LottoRank enum for prize classifications ✅
- [x] Added methods to Lotto for checking matches ✅
- [x] Implemented WinningChecker for verifying results ✅
- [x] Added method to display winning statistics ✅
- [x] Completed integration of all components ✅
- [x] Complete unit tests for all components ✅
- [x] Fixed edge case with zero tickets return rate ✅
- [ ] Final review and code quality improvements

## 📋 Applying Feedback from Week 1
- [x] Used meaningful variable and method names ✅
- [x] Avoided hardcoded values (used constants in LottoRank) ✅
- [x] Separated business logic from UI (domain vs view packages) ✅
- [x] Ensured methods do only one thing ✅
- [x] Used Kotlin's built-in APIs (groupingBy, eachCount, etc.) ✅
- [x] Maintained appropriate indentation and formatting ✅
- [x] Structured code with blank lines between logical sections ✅
- [ ] Verify all methods maintain single responsibility
- [ ] Ensure code formatting follows Kotlin conventions

## 🧪 Test Implementation
- Created parameterized tests to check multiple input scenarios
- Used mock inputs for Console.readLine() in InputViewTest
- Captured System.out for verifying outputs in OutputViewTest
- Implemented proper exception testing with assertThatThrownBy
- Fixed ApplicationTest to properly test exception cases
- Added test for zero division edge case in return rate calculation

*Happy coding! 🍀*
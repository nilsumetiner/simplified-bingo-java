# Simplified Bingo (Tombala) Simulation in Java

A robust, object-oriented console simulation of a multi-player Bingo game implemented in Java, leveraging the Java Collections Framework and strict encapsulation principles.

## 📌 Game Logic
- **Players**: Supports up to 6 players simultaneously. Each player receives a unique `Card` initialized with 20 distinct random numbers (range: 0–90).
- **Dealer**: Manages a randomized pool of numbers (0–90) using an in-place shuffle algorithm (`Collections.shuffle`). Numbers are drawn sequentially without repetition.
- **Winning Condition**: The first player to mark all 20 drawn numbers on their card triggers an immediate win (BINGO!).

## 🧠 Software Architecture & OOP Highlights
- **Encapsulation & Immutability**: All class fields are declared `private final`. The `Card` class returns an unmodifiable view (`Collections.unmodifiableSet`) to prevent external state mutation.
- **Collections Framework**:
  - `Set<Integer>` (`HashSet`): Ensures fast $O(1)$ lookups when checking whether drawn numbers exist on player cards.
  - `List<Integer>` (`ArrayList`): Manages the dealer's draw pile efficiently.
- **Loose Coupling**: Clean domain separation between `Player`, `Card`, and `Dealer`, orchestrated by `Main`.

## 📁 Class Structure
- `Card`: Generates distinct numbers and tracks player matches.
- `Player`: Associates player identity with a game card and checks drawn numbers.
- `Dealer`: Shuffles and distributes game numbers without duplicates.
- `Main`: Manages setup, execution loop, and terminal status reporting.

## 🚀 How to Run

### Prerequisites
- JDK 8 or higher installed.

### Execution Steps
1. Clone the repository:
   ```bash
   git clone [https://github.com/nilsumetiner/simplified-bingo-java.git](https://github.com/nilsumetiner/simplified-bingo-java.git)
   cd simplified-bingo-java/SimplifiedBingoGame/src
   ```
2. Compile and run:
   ```bash
   javac Main.java
   java Main
   ```

## 📝 Sample Console Output
```text
--- Starting Simplified Bingo Game ---
Total Players: 6
--------------------------------------
Dealer drew: 16
Dealer drew: 54
...
Dealer drew: 79

BINGO! We have a winner!
Winner Name: Ethan
Winning Card: [33, 69, 6, 7, 8, 73, 42, 75, 77, 78, 46, 79, 15, 81, 17, 51, 53, 86, 30, 63]
```

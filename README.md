# N Queens Problem

This repository contains an implementation of the **N Queens Problem** using a backtracking algorithm. The N Queens problem is a classic combinatorial challenge where the goal is to place N queens on an N×N chessboard such that no two queens threaten each other.

## Table of Contents

1. [About the Problem](#about-the-problem)
2. [How It Works](#how-it-works)
3. [Usage](#usage)
4. [Input and Output](#input-and-output)
5. [Limitations](#limitations)

## About the Problem

The N Queens problem is a famous problem in computer science and mathematics. The challenge is to place N queens on an N×N chessboard such that:
- No two queens share the same row.
- No two queens share the same column.
- No two queens are on the same diagonal.

The backtracking approach is commonly used to solve this problem efficiently.

## How It Works

The backtracking algorithm solves the N Queens problem by:
1. Starting with an empty chessboard.
2. Attempting to place a queen in each row, one row at a time.
3. Recursively placing queens in subsequent rows while ensuring that no queen threatens another.
4. Backtracking to the previous row when a valid placement cannot be found.

This process continues until all queens are placed or all possibilities are exhausted.

## Usage

### Running the Program

1. Compile the script:
   ```bash
   javac App.java
   ```

2. Run the script:
   ```bash
   java App
   ```

3. Optionally, specify the size of the chessboard (N), whether it prints the solution and whether it shows progress indicator as a command-line argument:
   ```bash
   java App 12 --log --show-progress
   ```
   
No external libraries are required for this implementation.

## Input and Output

### Input

- The size of the chessboard (N).

### Output

- The number of unique solutions
- All possible solutions, each represented as a chessboard with `Q` marking queen positions and `.` marking empty squares.
- Example output for `N = 4` and `--log` tag:
  ```
  Solution 1:
  . Q . .
  . . . Q
  Q . . .
  . . Q .

  Solution 2:
  . . Q .
  Q . . .
  . . . Q
  . Q . .

  Found 2 unique solutions after 0s
  ```

## Limitations

- The algorithm becomes computationally expensive as N increases due to the factorial growth of possibilities.
- For large values of N (e.g., N > 14), execution time may be significant.

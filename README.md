# Finance Tracker Console App

## Introduction

### What is this?

This is a Java console application designed to facilitate tracking finances across multiple accounts beyond the limitations of simple online bank transaction statements.

### Why use it?

In the realm of personal finance, the constant flow of pending bill payments, fund transfers, and day-to-day transactions often leaves users unaware or uncertain of their exact financial standing at any given moment. This app aims to address this issue by providing a centralized platform for monitoring finances across various accounts.

### About this project

This product is a smaller single day project, hense the very straightforward components, logic, and simple data access and modification abilities. The opportunity to track finances and gain some more coding practice created a 2-for-1 growth opportunity. While the current version contians heavy simplicity at its core, the intention is to evolve it into a more comprehensive solution with a true graphical user interface (GUI). This future iteration will aim to enhance user accessibility and personalization, moving beyond the hardcoded features intended solely for personal use.

## Components

### Main Page File:

- **Get user response:** Prompt the user with the question "Which account are you wanting to look at?".
    - **Account Options:**
        - "Account 1"
        - "Account 2"
    - **Options:**
        1. Show account history
        2. Withdraw
        3. Deposit
        4. Choose another account
            - Return to account page

### Action File:

- **Show account history:**
    - *Print each line of the account file*
- **Withdraw:**
    - Record date/time
    - 1. Ask user for the amount being withdrawn in USD (subtract the amount from the user's total)
    - 2. Ask user for a short input on the withdraw reason (max 20 characters)
    - 3. Ask the user to confirm withdraw info is correct
        - Y/N
        - Return to (1) if N
        - Continue if Y
- **Deposit:**
    - Record date/time
    - 1. Ask user for the amount being deposited in USD (add the amount to the user's total)
    - 2. Ask user for a short input on the deposit reason (max 20 characters)
    - 3. Ask the user to confirm deposit info is correct
        - Y/N
        - Return to (1) if N
        - Continue if Y

### Account Files:

- Account name at the top of the file
- Format: "*Date* *Time* *amount deposited/withdrawn* *Reason* Total: *Total amount in the chosen account after deposit/withdraw*"
- Data stored in ".txt" files for simplicity purposes


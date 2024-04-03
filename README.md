# Finance Tracker Console App

## Introduction

### What is this?

This is a Java console application designed to facilitate tracking finances across multiple accounts in a manner that transcends the limitations of simple transaction statements.

### Why use this?

In the realm of personal finance, the constant flow of pending bill payments, fund transfers, and day-to-day transactions often leaves users unaware or uncertain of their exact financial standing at any given moment. This app aims to address this issue by providing a centralized platform for monitoring finances across various accounts.

## Components

### Main Page File:

- **Get user response:** Prompt the user with the question "Which account are you wanting to look at?".
    - **Account Options:**
        - "Paypal"
        - "Chase"
    - **Options:**
        1. Show account history
        2. Withdraw
        3. Deposit
        4. Choose another account
            - Return to account page

### Action File:

- **Show account history:**
    - *Print each line of the file*
- **Withdraw:**
    - Record date/time
    - 1. Ask user for the amount being withdrawn in USD (subtract the amount from the user's total)
    - 2. Ask user for a short input on the withdraw reason (max 20 characters)
    - 3. Ask the user to confirm withdraw info is correct
        - Y/N
        - Return to 1 if N
        - Continue if Y
- **Deposit:**
    - Record date/time
    - 1. Ask user for the amount being deposited in USD (add the amount to the user's total)
    - 2. Ask user for a short input on the deposit reason (max 20 characters)
    - 3. Ask the user to confirm deposit info is correct
        - Y/N
        - Return to 1 if N
        - Continue if Y

### Account Files:

- Account name at the top of the file
- Format: "*Date* *Time* *amount deposited/withdrawn* *Reason* Total: *Total amount in the chosen account after deposit/withdraw*"
- Data stored in ".txt" files for simplicity purposes


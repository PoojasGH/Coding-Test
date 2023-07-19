# Coding-Test
please read the explanation of the code below

Explanation:

newspaperData: This is a HashMap that stores the subscription prices for each newspaper. The key is the newspaper name, and the value is an array of subscription prices for each day of the week.

main method: The main method is the entry point of the program. It initializes the newspaper subscription data, sets the weekly budget and the number of subscriptions allowed, and then calculates and prints all possible combinations of subscriptions within the budget for two different budgets (40 and 35).

getCombination method: This method takes the newspaperData, the number of subscriptions, and the budget as input parameters and calculates all possible combinations of newspaper subscriptions that fit within the given budget. It uses a set to avoid duplicate combinations.

calculateTotalExpense method: This method takes the array of subscription prices for a newspaper and the number of subscriptions as input parameters and calculates the total expense for the given number of days. It sums the prices up to the number of subscriptions or the length of the prices array, whichever is smaller.

The program uses nested loops to iterate through each pair of newspapers in newspaperData, excluding combinations of the same newspaper. It calculates the total expenses for each pair and adds the combination to the set of combinations

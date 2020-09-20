# igreendata
Development server
To run project, go to BankAccountApplication.java and run as SpringBoot Application if using Eclipse/Intellij. To run from command prompt, execute mvn spring-boot:run from the prompt.

Upon server start up, new Accounts and Transactions will be loaded from data.sql (H2 in memory database) located in src/main/resources.

APIs can be accessed via http://localhost:8080 Example:

GET localhost:8080/accounts/

GET localhost:8080/accounts/9467563426/transactions


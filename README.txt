CALCULATOR features:
This voting calculator counts votes for parties and candidates.

List of Candidates was provided as xml file.

Each voter is allowed to vote only one time - MultipleClientValidator in validator package.
Each voter need to pass valid pesel. Program checks if voter is 18 years old and if voter haven't lost 
voting rights. List of blocked voters - without voting rights- is in separate xml file - AgeValidator and BlockedListValidator.

Program is using Hibernate (entity and DAO packages) and mySQL database ( need to be configurated separately).
Database stores information about name, surname and pesel however pesel is stored in hased form in database (security package). 
Program allows to give invalid vote - for example by selecting more then one Candidate.
Program can also create voting results in form of pdf file (statistic package).

Layout package is using SWING.
Maven repository was used to download all necessary libraries. 


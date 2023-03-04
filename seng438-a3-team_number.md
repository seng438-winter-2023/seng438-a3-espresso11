**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group \#:       | 18 |
|-----------------|---|
| Student Names:  |  Muteeba Jamal |
|                 |  Shahzill Naveed |
|                 |  Iman Niaz |
|                 |  Rumaisa Talukder |

(Note that some labs require individual reports while others require one report
for each group. Please see each lab document for details.)

# 1 Introduction

The purpose of this lab is to expand the tests we developed in assignment 2. We were supposed to use the Junit framework to test different algorithms for JFreeChart, similar to the previous assignment. The difference in the two assignments is that this assignment utilizes a different technique called white-box coverage criteria which helps us develop our tests. We used this technique to write tests for the lines, statements and branches.

# 2 Manual data-flow coverage calculations for X and Y methods

Range.combine()
![image](https://user-images.githubusercontent.com/101993148/222874712-9aadea1c-1adf-46c5-a6e8-2e5d9c870f4f.png)

**Def and use:**

def(1) : {range1,range2}

def(6) : {l,u, new Range()}

use(2) : {range1} 

use(3) : {range2}

use(4) : {range2}

use(5) : {range1}

use(6) : {range1, range2, l , u, new Range()}

**DU pairs per variable:**

range1 : (1,2) , (1,5) , (1,6)

range2 : (1,3) , (1,4) , (1,6)

u : (6,6)

l : (6,6)

new Range() : (6,6)

**Pairs covered for test cases**
| Test Cases       | Pairs Covered |
|-----------------|------------|
|  firstRangeNull()  | range1 : (1, 2)  |
|                 | range2 : (1, 3)  |
| secondRangeNull()  | range1 : (1, 2) , (1, 5)  |
|                 |  range2 : (1, 4) |
| bothRangeNull()  | range1 : (1, 2) |
|                 |  range2 : (1, 3) |
| identicalRanges()  | range1 : (1, 2) , (1, 6) |
|                 |  range2 : (1, 4) , (1, 6)|
|                 |  l : (6, 6) |
|                 |  u : (6, 6) |
|                 |  new Range() : (6, 6) |
| continuousRanges()  | range1 : (1, 2) , (1, 6) |
|                 |  range2 : (1, 4) , (1, 6)|
|                 |  l : (6, 6) |
|                 |  u : (6, 6) |
|                 |  new Range() : (6, 6) |

**DU pair coverage**

coverage = (DU pairs covered / Total pairs) * 100 = (9/9)*100 = 100%

**DataUtilities.calculateColumnTotal()**
![image](https://user-images.githubusercontent.com/101993148/222879406-6a0a451f-6eac-4634-b7d3-5792138c0db6.png)

**Def and use:**

def(1) : {data, column}

def(2) : {total, rowCount}

def(3) : {r}

def(4) : {n}

def(6) : {total}

def(7) : {n}

use(1) : {data}

use(2) : {data} 

use(3) : {r, rowCount} 

use(4) : {data, r, column}

use(5) : {n}

use(6) : {n}

use(7) : {r}

use(8) : {total} 

**DU pairs per variable:**

data : (1,1) , (1,2) , (1,4)

column : (1,4)

total : (2,6) , (2,8) , (6,8)

rowCount : (2,3)

r : (3,3) , (3,4) , (3,7) , (7,3)

n : (4,5) , (5,6)

**Pairs covered for test cases**

| Test Cases       | Pairs Covered |
|-----------------|------------|
|  calculateColumnTotalForThreeRows()  | data : (1,1) , (1,2) , (1,4)  |
|                 | column : (1,4) |
|                 | total : (2,6) , (2,8) , (6,8) |
|                 | rowCount : (2,3) |
|                 | r : (3,3) , (3,4) , (3,7) , (7,3) |
|                 | n : (4,5) , (5,6) |
|  calculateColumnTotalForMutipleColumns()  | data : (1,1) , (1,2) , (1,4)  |
|                 | column : (1,4) |
|                 | total : (2,6) , (2,8) , (6,8) |
|                 | rowCount : (2,3) |
|                 | r : (3,3) , (3,4) , (3,7) , (7,3) |
|                 | n : (4,5) , (5,6) |
|  NegativeColumn()  | data : (1,1) , (1,2) |
|                 | rowCount : (2,3) |
|                 | r : (3,3) |
|  NullValuesForColumn()   | data : (1,1) |

**DU pair coverage**

coverage = (DU pairs covered / Total pairs) * 100 = (14/14)*100 = 100%



# 3 A detailed description of the testing strategy for the new unit test

We used our old tests from assignment two which had the coverage for DataUtilites in a decent range however, for Range it was very low. So we made tests for the methods that we skipped in assignment 3.  They were divided as follows: Muteeba did three, Iman did three, Shahzill did two and Rumaisa did one. The members who did less development contributed in other areas. Additionally, we added more tests to provide more branch, line and method coverage.

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

Some test cases we designed using coverage information are CalculateRowTotalOutOfBounds(), NegativeRow() and create2DNumberArrayNullArgument() in DataUtilites. These test cases expect an IndexOutOfBoundsException which we did not cover before. Additionally, we designed some test cases for clones which are cloneNegative() and clonePositive() in DataUtilities. These test cases allowed us to increase the overall coverage. Since we now had more lines in our code, the percentage of green lines to red lines increased and hence our overall line percentage increased. Moreover, sincee we added more methods, our total methods increased to about 82 in range and 30 in data utilities. This significantly increased our method coverage as well. Lastly, since there were more bytes in each line, our instruction coverage increased drastically as well. In conclusion, adding the five tests mentioned above, our test coverage for line, method and instruction increased for both, our Range tests as well as DataUtilities tests.

# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

Line coverage for Range:
![image](https://user-images.githubusercontent.com/101993148/222327588-1b586def-2b06-4583-9796-44d92224d225.png)
![image](https://user-images.githubusercontent.com/101993148/222327671-01572a39-9ae9-4b05-8b03-dd3e09b16b81.png)
![image](https://user-images.githubusercontent.com/101993148/222327703-f1439481-f325-45ae-920e-37f3a8c868e2.png)
![image](https://user-images.githubusercontent.com/101993148/222327724-061f333d-fffd-472b-9b23-f32093701e17.png)
Line coverage for DataUtilities:
![image](https://user-images.githubusercontent.com/101993148/222327781-25461c93-ca7c-4640-8e3b-ed33628c91ea.png)
![image](https://user-images.githubusercontent.com/101993148/222327808-43ffec61-6b26-4f2d-a8d2-01839f873c07.png)

Method coverage for Range:
![image](https://user-images.githubusercontent.com/101993148/222327876-9dea5109-eb94-4860-925c-c61b36aaa65e.png)
![image](https://user-images.githubusercontent.com/101993148/222327901-f00d8d12-cb6f-4b56-a2bc-ecfc6cd9ea90.png)
![image](https://user-images.githubusercontent.com/101993148/222327916-b8d5f842-82cf-4cfc-a214-1ca8ce89f128.png)
![image](https://user-images.githubusercontent.com/101993148/222327930-09c09f3d-159a-4c9a-a673-61096f08c830.png)
Method coverage for DataUtilities:
![image](https://user-images.githubusercontent.com/101993148/222327972-6a786e12-96f2-4b00-ace6-5486015c519b.png)
![image](https://user-images.githubusercontent.com/101993148/222327985-759afa87-9618-4f65-99bd-1aa8506192b5.png)

Instruction coverage for Range:
![image](https://user-images.githubusercontent.com/101993148/222328080-81e5d5f8-88e1-4f48-a29d-2db14dc6aee1.png)
![image](https://user-images.githubusercontent.com/101993148/222328095-f78b8574-27e6-4c8d-8d86-7b0b6e4f9094.png)
![image](https://user-images.githubusercontent.com/101993148/222328112-55b912a3-a18e-457b-8d47-ee65b80bbcab.png)
![image](https://user-images.githubusercontent.com/101993148/222328125-b9886bbf-df29-433e-bf22-088a94f14dec.png)
Instruction coverage for DataUtilities:
![image](https://user-images.githubusercontent.com/101993148/222328232-5abe8401-2dee-4222-9a32-170c4e9564db.png)
![image](https://user-images.githubusercontent.com/101993148/222328298-1b774320-a737-47e7-8a38-88f573593b90.png)



# 6 Pros and Cons of coverage tools used and Metrics you report

Our group decided to initially use EclEmma. Just as we started our code coverage testing, we ran into a problem. EclEmma was not showing code coverage for the branch method. So we had to try other provided methods. We faced a similar issue with the methods that we tried. Hence, we decided to stick with EclEmma and switch our code coverage method from branch to instruction coverage. Overall, EclEmma was a very useful tool as it showed us exactly which lines were causing problems. The lines are color coded with green lines being the ones that were read correctly by the system and red lines being the ones that were not read by the system. This allowed us to pinpoint the errors and fix it. However, EclEmma did not have built in coverages for condition coverage and statement coverage. We were recommended to use these two types of coverages in our assignment description but we had to improvise and use other types of coverages.

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

In requirements-based test generation, the source code of the program being tested is unknown and the test conditions are based on the program requirements. In coverage-based test generation, the source code is known and the test conditions are built with that knowledge.
Requirements-based testing has the advantage of providing a more accurate estimation of how long it will take to test the program, making it easier to plan the testing. However, if requirements provided are too brief, it may be difficult to design the tests and certain scenarios may be left out in the test conditions.
Coverage-based testing informs the test engineers about how much of a requirement is covered by the testing, and allows the creation of additional test cases to increase coverage. However, coverage-based testing measures the coverage of the code that has been written and is not concerned if the code for a specific function has not been implemented or have been omitted from the program.

# 8 A discussion on how the team work/effort was divided and managed

All team members worked together on each part of the lab, including discussing portions done by one member to the rest of the team. We had ZOOM calls to divide our workload, determine which test tools to use and discuss our progress including any requirements we needed to test. We worked on creating unit tests until coverage was improved as much as possible. The lab report was split between members after a mutual agreement, and team members were consulted to check the information written down for each of the sections.

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

We decided to use EclEmma for our test coverages. After downloading and setting it up, we realised that it did not provide branch coverage for both of our classes whereas method and line coverage worked perfectly. To overcome this, we decided to use other coverage tools provided to us but encountered the same difficulty and hence emailed the TA regarding the issue. We were instructed to use another type of coverage and we ended up choosing the instruction coverage to finish our project. 

# 10 Comments/feedback on the lab itself

Some of the figures in the instructions document were missing which made it harder to setup the project. Moreover, during the intial setup process, we were not instructed to include any external jars and only realised that after setting up the whole project. Desired coverage percentage was provided for only three coverages. Since we chose a different one, we were not sure what percentage of that specific coverage is required. Overall, this was our first experience with actual code coverage and it taught us many required skills for our future careers. 

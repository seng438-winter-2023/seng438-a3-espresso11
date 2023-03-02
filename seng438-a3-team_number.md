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

Text…

# 2 Manual data-flow coverage calculations for X and Y methods

Text…

# 3 A detailed description of the testing strategy for the new unit test

Text…

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

Text…

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

Text…

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Text…

# 8 A discussion on how the team work/effort was divided and managed

Text…

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

We decided to use EclEmma for our test coverages. After downloading and setting it up, we realised that it did not provide branch coverage for both of our classes whereas method and line coverage worked perfectly. To overcome this, we decided to use other coverage tools provided to us but encountered the same difficulty and hence emailed the TA regarding the issue. We were instructed to use another type of coverage and we ended up choosing the instruction coverage to finish our project. 

# 10 Comments/feedback on the lab itself

Some of the figures in the instructions document were missing which made it harder to setup the project. Moreover, during the intial setup process, we were not instructed to include any external jars and only realised that after setting up the whole project. Desired coverage percentage was provided for only three coverages. Since we chose a different one, we were not sure what percentage of that specific coverage is required. Overall, this was our first experience with actual code coverage and it taught us many required skills for our future careers. 

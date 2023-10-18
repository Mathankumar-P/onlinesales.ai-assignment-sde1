# OnlineSales.ai-Assignemt-SDE1

Before getting started make sure to setup devlopment environment.


## Environment Setup

**Java Development Kit (JDK) - 17**:
Ensure you have JDK installed on your system. You can download it from Oracle's official [website](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).

**Apache Maven**: Install Apache Maven. You can download it from the official Maven [website](https://maven.apache.org/install.html).

**Postman**: Install Postman, a popular API testing tool, from the official [website](https://www.postman.com/downloads/).

**IntelliJ IDEA**: Install IntelliJ IDEA, your preferred Integrated Development Environment (IDE), from the official [website](https://www.jetbrains.com/edu-products/download/other-IIE.html).


## Run Locally

Clone the project

```bash
  git clone https://github.com/Mathankumar-P/onlinesales.ai-assignment-sde1
```

Import Project into IntelliJ IDEA:

```bash
Open IntelliJ IDEA.

- Click on "Open" and navigate to the root folder of your project.
- Select the pom.xml file and click "Open" to import the project and Build the Project:
- In IntelliJ IDEA, click on "Build" in the top menu.
- Select "Build Project" to build your Maven project. Run the Application:
- In IntelliJ IDEA, open the main application file AssignmentAppilcation.java Right click inside the file and select "Run".
- The application will start and be accessible at http://localhost:8080 
```



## Task-1 : probability

For Task-1, I have taken the example of rolling dice events

``` bash
- for every API request ProbabilityController diceRoll method invokes the ProbabilityService which provides the random probability for each request.
- then it invokes the rollDice method, which will randomly select and add the values in the hashmap for a max event count times and return as a response.
```

Postman
``` bash
Method: GET
Api Link : http://localhost:8080/api/diceRoll?eventCount=500

Example output for Event count 500 :

{
    "1": 73,
    "2": 85,
    "3": 60,
    "4": 177,
    "5": 97,
    "6": 8
}

Manipulate the eventCount details. based on the event count the occurrences distributes
```


## Task-2 : Evaluate Math Expression


```bash
Web API used to evaluate the math Expression
api.mathjs.org
example => http://api.mathjs.org/v4/?expr=2*(7-3)

- MathExperssion controller using CompletableFuture invoked the evaluate expression method inside service,
which makes the web API call using RestTemplate and Stores inside the List of CompletableFuture<string>
- Now from the returned values the expression is extracted and using StringBuilder it is converted into a string
and provided as a response

```
Postman
```bash
Method: POST
Link => http://localhost:8080/api/evaluate
in the request body add raw JSON format
----------------------------
[ "2 * 4 * 4",
"5 / (7 - 5)",
"sqrt(5^2 - 4^2)", 
"sqrt(-3^2 - 4^2)" ]
----------------------------
output
2 * 4 * 4 => 32
5 / (7 - 5) => 2.5
sqrt(5^2 - 4^2) => 3
sqrt(-3^2 - 4^2) => 5i
----------------------------
```

Concurrency
```bash
Using CompletableFuture for concurrent requests allows us to perform multiple operations concurrently without blocking the main thread. 
This significantly improves the overall performance and responsiveness of the application.

The main features of CompletableFuture
-Asynchronous Execution
-Non-Blocking
-Parallelism
```
## Task3 - Debugging Python script

added Test3.py with changed code

```python
def compute(n):
    if n < 10:
        out = n ** 2
    elif n < 20:
        out = 1
        for i in range(1, n-9):  # Change1 => n-10 to n-9"
            out *= i
    else:
        lim = n - 20
        out = lim * lim
        out = out - lim
        out = out // 2  # Change2 => / to // for integer division
    print(out)

n = int(input("Enter an integer: "))
compute(n)

```

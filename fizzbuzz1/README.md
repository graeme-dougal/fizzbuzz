FizzBuzz Step 1

Write some code that prints out the following for a contiguous range of numbers:

* the number
* 'fizz' for numbers that are multiples of 3
* 'buzz' for numbers that are multiples of 5
* 'fizzbuzz' for numbers that are multiples of 15

e.g. if I run the program over a range from 1-20 I should get the following output

1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz


Can be run via the maven exec plugin as follows (1 and 20 can be substituted for additional values to run with a different range

 mvn clean compile exec:java -Dexec.args="1 20" -Dexec.mainClass=com.tiderian.fizzbuzz.FizzBuzzApp

FizzBuzz Step 3

Enhance your existing solution to perform the following:

* Produce a report at the end of the program showing how many times the following were output
** fizz
** buzz
** fizzbuzz
** lucky
** an integer

e.g. if I run the program over a range from 1-20 I should get the following output

1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz
fizz: 4
buzz: 3
fizzbuzz: 1
lucky: 2
integer: 10 

(Integer is 10 because there were 10 numbers that were not altered in any way).

Can be run via the maven exec plugin as follows (1 and 20 can be substituted for additional values to run with a different range
 - mvn clean compile exec:java -Dexec.args="1 20" -Dexec.mainClass=com.tiderian.fizzbuzz.FizzBuzzApp

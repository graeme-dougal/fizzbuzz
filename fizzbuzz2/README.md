FizzBuzz Step 2

Enhance your existing FizzBuzz solution to perform the following:

* If the number contains a three you must output the text 'lucky'. This overrides any existing behaviour

e.g. if I run the program over a range from 1-20 I should get the following output

1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz


Can be run via the maven exec plugin as follows (1 and 20 can be substituted for additional values to run with a different range
 - mvn clean compile exec:java -Dexec.args="1 20" -Dexec.mainClass=com.tiderian.fizzbuzz.FizzBuzzApp

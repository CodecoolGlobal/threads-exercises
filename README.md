## Exercise 1 (Creating and starting threads):
* Create Runnable object by implementing Runnable interface (e.g. using lambda or anonymous class)
* implement run() method body which will print current thread name, status and id.
* Create 5 threads by passing runnable object to Thread class constructor.
* Start threads by calling start() method on every thread object and run main() method.

* Write own class which will extend the Thread class, override and implement run() method with the same functionality as above.
* Create an object of your class and start a thread.


## Exercise 2 (Using sleep() and interrupt() methods):
* Start a new thread in main method passing CounterRunner object as parameter and check if counting to 10000 works.
* Put sleep() method in the proper place in CounterRunner class to simulate counting every one second. 
* Run the thread again and check if counting works slower.
* Try to interrupt the thread in main method by calling interrupt() method on thread object. What happened? 
* Change the moment of calling interrupt() method 10 seconds after starting the CounterRunner thread.

## Exercise 3 (Using join() method):
* Use join() method in such way that println() method to be run after calculating fibonnaci series (check FibonacciGeneratorThread class)

## Exercise 4 (Using synchronized keyword):
* First, run the main method without any changes and check what is going on.
* Try to fix it. 

## HOMEWORK - Exercise 5 (Producer and Consumer pattern)
* Try to implement Producer Consumer pattern with given template

Concurrent utilities
-----------------------------------------------------------------------
## Exercise 6 (Working with Future):
* Implement Callable interface which will calculate nth fibonacci number for a larger number e.g. (45)
* Create executor service using Executors util class 
* Pass the callable to executorService using proper method which returns Future
* Using while loop wait until future will be done
* When future will be ready get the value
* Print it
* Shutdown executor service

## Exercise 7 (Countdown latch):
Counter class:
* Implement a thread Counter which will take a CountDownLatch and int maxValue as parameters in the constructor. 
* Implement method run which will increment count value every one second up to maxValue
* If counting will be over, call countDown() method on the countDownLatch.

App class:
* Create CountDownLatch object with value 3 (new CountDownLatch(3))
* Create 3 threads of type Counter in main method.
* Pass the CountDownLatch object to every thread object and different maxValues to each thread e.g. 30, 10, 50
* Start the 3 threads, manually or using ExecutorService (choose one you wish)
* Make the main thread to await on CountDownLatch for all threads to stop waiting.

## Exercise 8:
* Create class ThreadA
* Create class ThreadB
* Using Exchanger, exchange from ThreadA string "from A" and print it
* Using Exchanger, exchange from ThreadB string "from B" and print it

## Exercise 9:
* Implement producer consumer using java builtIn blocking queue implementation

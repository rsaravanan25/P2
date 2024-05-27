# Project 0: Person201

## Goals

* To modify a simple Java class, modify two driver programs, and create a new class to demonstrate understanding of classes, methods, and instance variables.
* To learn about running Java programs using the VSCode IDE
* To learn about using Git for project management.
* To learn about CompSci201 workflow for assignments: Git, Gradescope, helper hours.


## Developing the classes in Project P0: Person201

My goal was to modify three programs/classes (`Person201.java`, `Person201Demo.java`, and `Person201NearbyDemo.java`) and create a new program (`Person201Farthest.java`) to generate the desired output. 


### Run `Person201Demo.java` and change `Person201.java`

First run the main method in `Person201Demo.java`, the output will be:

```
037.80N,122.27W claire courons
001.29S,036.82E ricardo harambee
040.71N,073.96W julie help
000.00N,000.00E null null
names: claire ricardo julie null 
```

Make changes to `Person201.java` by modifying the default constructor so the output will be as shown. Use the comments for the constructor 
to help understand how to do this, see the [help-doc/faq](docs/details.md) for more details.

```
037.80N,122.27W claire courons
001.29S,036.82E ricardo harambee
040.71N,073.96W julie help
035.93N,079.01W Owen woto
names: claire ricardo julie Owen
```

Now that you've done this, change the `main` method in file `Person201Demo.java` by creating a new `Person201` variable named `s` (short for Sam) with the value shown:

`Person201 s = new Person201("Sam", 44.9978, -93.2650, "hello");`

Add variable `s` after variable `c` (and before the call of `new`) in the definition of array `people` and run the program. The
output should be as shown here:

```
037.80N,122.27W claire courons
001.29S,036.82E ricardo harambee
040.71N,073.96W julie help
045.00N,093.27W Sam hello
035.93N,079.01W Owen woto
names: claire ricardo julie Sam Owen 
```

### Running Person201NearbyDemo, Modify Person201.java, and changing Data Source

Run the program `Person201NearbyDemo`. It reads a data file and finds all the people in the data file who are within 50 miles of a person named Ricardo who lives near Seattle. The program prints there are no people because the method `Person201.distanceFrom` returns the value _100_ instead of the correct distance to the parameter `other`. Modify the body of `Person201.distanceFrom` so that it calls
`Person201Utilities.distance` and passes the correct parameters to get the distance between `this` object and the parameter `other`. Then rerun
`Person201NearbyDemo` -- you should see data from 16 people who are within 50 miles of Ricardo.

Lines 20-22 specify three data sources: a regular text file named `large` in the `data` folder, an encrypted file in the same `data` folder (line 21), and an encrypted URL (line 22). Verify by commenting out/uncommenting each line that those sources all produce the same results, e.g., 16 people within 50 miles of Ricardo. After verifying the results are the same, write a new line that reads data from the URL specified by the
variable `largeURL`. You'll need to call the appropriate method in `Person201Utilities` to read a URL for a plain-text file. Verify that you get the same results since that URL references the same data as the file `large` in the `data` folder. You'll answer questions about these
runs in the Analysis section. 


### Create and Run a New Java Class: **Person201Farthest.java**

In the `src` folder create a new Java class named `Person201Farthest` (name the file `Person201Farthest.java`) that has only a `public static void main method` that allows the program to run. When run, the method should read the file `large.txt` in the `data` folder and determine the two `Person201` objects that are the farthest apart. You may find the code in `Person201NearbyDemo.java` useful in reasoning about the code you write. The program should print the objects that are farthest apart among all the objects created and returned when `PersonUtilities.readFile` is called from the code you write.

The `main` method you write *must* use the code below 
```
public static void main(String[] args) throws Exception {
        String file = "data/large.txt";
        double max = 0;
        Person201 a = null;
        Person201 b = null;
        // write code here 
        System.out.printf("farthest distance is %3.2f between %s and %s\n",max,a.getName(),b.getName());
    }
```


## Checklist

- Modify `Person201.java` by changing code in two places.
- Verify that running `Person201Demo.java` matches the expected output after modifying `Person201.java`
- Add a new `Person201` object in the `Person201Demo.java` program and verify that running `Person201Demo.java` matches the expected output.
- Run `Person201NearbyDemo.java` after modifying the method `distanceFrom` in  `Person201`, and verify the results hold reading the same data 
four different ways: a text file, an encrypted text file, and the same via URLs.
- Create a new class `Person201Farthest` with a `main` method to find the people maximally distant from each other.


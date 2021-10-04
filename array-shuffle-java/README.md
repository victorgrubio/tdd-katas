# TDD Kata
- Exercise: `Array Shuffle`
- Language & test-framework: `Java, JUnit`

## Problem description

Write a program to shuffle an array.

Start by writing a function which will accept two integer arguments (min,max) and generate a random integer between min and max where:
- min is an inclusive lower bound
- max is an exclusive upper bound

For example (1,7) should generate random integers from {1,2,3,4,5,6} suitable for a dice roll.
How will you test this?

Use this function to write shuffle:
- Iterate through the array and for each element[i]
- generate a random integer (min=r,max=array.size)
- swap the integers at indexes i and r

The shuffle function
- does not mutate the array argument
- returns an array
- the returned array is randomly shuffled!
- the returned array is a permutation of the array argument

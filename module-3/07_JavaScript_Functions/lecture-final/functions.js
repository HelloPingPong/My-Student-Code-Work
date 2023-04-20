function sayHello() {
    console.log("Hello World");
}

/****************************************************
 *  DEALING WITH UNKNOWN PARAMETERS
 ****************************************************/

/*
    All paramters sent are available in the arguments object
*/
function unknownParams() {
    console.table(arguments);

    // Arguments may look like an array, but it is an object.  Array.from() can be used to convert to an array.
    const argsAsArray = Array.from(arguments);
    console.table(argsAsArray);
}

/*
    Can define a function to accept an unknown number of paramters using the Rest Paramter
*/
function unknownParamsWithRestParameter(...args) {
    console.table(args);
}

/*
    The spread operator ... spreads and array, string, object such that each individual element/character becomes its own argument
    when calling a method
*/
function callingAFunctionWithTheSpeadOperator() {
    const ourArray = [1,2,3,4,5];
    unknownParams(...ourArray);

    const ourString = 'Tech Elevator';
    unknownParams(...ourString);
}

/****************************************************
 *  ANONYMOUS FUNCTIONS
 ****************************************************/

function sum(x,y) {
    return x + y;
}

// Functions don't need a name, but can be stored in a variable
const sumNumbers = function (x, y) {
    return x + y;
}

console.log( sumNumbers(2,4) );

// A function stored in a variable can be reassigned to another variable
const anotherName = sumNumbers;

console.log ( anotherName(5, 5) );

// Anonymouse functions can be defined with => instead of the function keyword
const sumNumbersAgain = (x,y) => {
    return x + y;
}

printToConsole( sumNumbersAgain );

// Can write a function that takes another function as an parameter
function printResults(func) {
    console.log( func(10,20) );
}

// Can pass a function as a parameter of another function
printResults( sumNumbersAgain );

// Can define an anonymouse function when needed to pass as an argument
printResults( (x,y) => { return x * y} );

/****************************************************
 *  ARRAY FUNCTIONS
 ****************************************************/

const intArray = [10,20,30,40,50];

// Summing an array using a traditional for loop
let sumOfArray = 0;
for (let i = 0; i < intArray.length; i++) {
    let x = intArray[i];
    sumOfArray += x;
}

/***********************
 * FOREACH
 * forEach( func )
 * 
 * funct takes the argument (currentValue, currentIndex)
 */
// print the array using a forEach
intArray.forEach( x => { 
    console.log(x); 
} );

// Summing an array using a forEach
let sumOfArrayAgain = 0;
intArray.forEach( x => {
    sumOfArrayAgain += x;
});

// Print each element with the index
intArray.forEach( (element, index) => {
    console.log( `${index}: ${element}` );
});


/***********************
 * REDUCE
 * reduce( func, startingValue ) returns the final accumulated value
 * 
 * func takes the arguments (accumulator, currentValue) and returns the new accumulated value
 */
// Sum the array using reduce  (accumulator, currentValue) => { return the new accumulated value }
let sumByReduce = intArray.reduce( (sum, currentElement) => {
    return sum += currentElement;
}, 0 );

console.log(sumByReduce);

const stringArr = ['Hello', 'John', 'Rachelle', 'Steve', 'Matt'];
let newStr = stringArr.reduce( (newStringBeingBuilt, currentStr) => {
    return newStringBeingBuilt + " " + currentStr + ", ";
}, '' );

console.log(newStr)

let newStrWithoutEndingComma = stringArr.reduce( (accumulateStr, currentStr, currentIndex, theArray) => {
    let buildingStr = accumulateStr + " " + currentStr;
    if (currentIndex < theArray.length - 1) {
        buildingStr += ", ";
    }
    return buildingStr;
});

console.log(newStrWithoutEndingComma);

/***********************
 * FILTER
 * filter( func ) returns a new array with only the values that match the filter
 * 
 * func( currentValue ) return TRUE to keep that value or FALSE to remove it
 */
const numArr = [10,12,22,20,25,13,27,41];

const filteredArray = numArr.filter( currentValue => {
    return currentValue % 5 === 0;
});

console.log(filteredArray);

const no4LetterWords = stringArr.filter( currentStr => {
    return currentStr.length != 4;
});

console.log( no4LetterWords );

const filteredByIndex = numArr.filter( (currentValue, currentIndex) => {
    return currentIndex % 2 === 0;
});

console.log( filteredByIndex );

/***********************
 * MAP
 * map( func ) returns a new array with each element transformed by the function
 * 
 * func( currentValue ) return the new element for that index in the new array
 */
const eachElementMultipliedBy2 = numArr.map( currentValue => {
    return currentValue * 2;
});

console.log( eachElementMultipliedBy2 );

const allWordsCapitalized = no4LetterWords.map( currentStr => { 
    return currentStr.toUpperCase();
});

console.log(allWordsCapitalized);

const fizzArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];

const fizzedBuzzed = fizzArray.map( currentValue => {

    if ( !(currentValue % 3) && !(currentValue % 5) ) {
        return 'FizzBuzz';
    } 
    if ( !(currentValue % 3) ) {
        return 'Fizz';
    }
    if ( !(currentValue % 5) ) {
        return 'Buzz';
    }
    return currentValue;
});

// Map creates a new array with the changed values
console.log(fizzedBuzzed);
// The original array is not changed
console.log(fizzArray);


/*
    PROBLEM: for our fizzArray - find the sum of all numbers in the array multipled by 10, but only for 
    numbers that not a multiple of 3
*/
// Use filter to remove all numbers that are a multiple of 3
// On the result of filter use map to multiple all numbers by 10
// Then on the result of the filter use reduce to sum the filtered numbers

const finalSum = fizzArray.filter( currentValue => {
    return !(currentValue % 3);
}).map( currentValue => {
    return currentValue * 10;
}).reduce( (ongoingSum, currentValue) => {
    return ongoingSum += currentValue;
});

console.log(finalSum);
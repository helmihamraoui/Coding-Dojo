// Problem 1
// Prediction: 
const cars = ['Tesla', 'Mercedes', 'Honda'];
const [randomCar] = cars;
const [, otherRandomCar] = cars;
console.log(randomCar); // Output: Tesla
console.log(otherRandomCar); // Output: Mercedes
// randomCar = 'Tesla', otherRandomCar = 'Mercedes'
// The destructuring syntax extracts the first item into `randomCar` and the second item into `otherRandomCar`.

// Problem 2
const employee = {
    employeeName: 'Elon',
    age: 47,
    company: 'Tesla',
};
const { employeeName: otherName } = employee;
console.log(otherName); // Output: Elon
// console.log(employeeName); // Error: employeeName is not defined
// Prediction: 
// otherName = 'Elon'. Reference to employeeName will throw an error because `employeeName` is not defined in the current scope.

// Problem 3
const person = {
    name: 'Phil Smith',
    age: 47,
    height: '6 feet',
};
const password = '12345';
const { password: hashedPassword } = person;
console.log(password); // Output: 12345
console.log(hashedPassword); // Output: undefined
// Prediction: 
// password = '12345'. hashedPassword = undefined because `password` does not exist in the `person` object.

// Problem 4
const numbers = [8, 2, 3, 5, 6, 1, 67, 12, 2];
const [, first] = numbers;
const [,,, second] = numbers;
const [,,,,,,,, third] = numbers;
console.log(first === second); // Output: false
console.log(first === third); // Output: true
// Declaring a new variable for the 4th index
const fourth = numbers[4];
console.log(fourth); // Output: 6
// Prediction: 
// first = 2, second = 5, third = 2.
// first !== second, but first === third.

// Problem 5
const lastTest = {
    key: 'value',
    secondKey: [1, 5, 1, 8, 3, 3],
};
const { key } = lastTest;
const { secondKey } = lastTest;
const [, willThisWork] = secondKey;
console.log(key); // Output: value
console.log(secondKey); // Output: [1, 5, 1, 8, 3, 3]
console.log(secondKey[0]); // Output: 1
console.log(willThisWork); // Output: 5
// Prediction: 
// key = 'value'. secondKey = [1, 5, 1, 8, 3, 3]. secondKey[0] = 1. willThisWork = 5.

// Problem 6

var beatles = ['Paul', 'George', 'John', 'Ringo'];
function printNames(names) {
    function actuallyPrintingNames() {
        for (var index = 0; index < names.length; index++) {
            var name = names[index];
            console.log(name + ' was found at index ' + index);
        }
        console.log('name and index after loop is ' + name + ':' + index);
    }
    actuallyPrintingNames();
}
printNames(beatles);
// Output: 
// Paul was found at index 0
// George was found at index 1
// John was found at index 2
// Ringo was found at index 3
// name and index after loop is Ringo:4
// Prediction: 
// Scopes: Global scope (beatles), printNames scope, actuallyPrintingNames scope.

// Problem 7
function actuallyPrintingNames() {
    for (let index = 0; index < names.length; index++) {
        let name = names[index];
        console.log(name + ' was found at index ' + index);
    }
    // console.log('name and index after loop is ' + name + ':' + index); // Error: name and index are not defined
}
// Prediction: 
// Will throw an error because `name` and `index` are block-scoped with `let` and are inaccessible outside the loop.

// Problem 8
const beatles = ['Paul', 'George', 'John', 'Ringo'];
function printNames(names) {
    function actuallyPrintingNames() {
        for (let index = 0; index < names.length; index++) {
            const name = names[index];
            console.log(name + ' was found at index ' + index);
        }
    }
    actuallyPrintingNames();
}
printNames(beatles);
// Prediction: 
// Output logs each name with index due to block-scoped variables, no errors.
// Output: 
// Paul was found at index 0
// George was found at index 1
// John was found at index 2
// Ringo was found at index 3

// Problem 9
const planet = {
    name: 'Jupiter',
    milesFromSun: 49849,
    mass: 393983,
    composition: ['gas', 'liquid', 'oxygen'],
};
const planetCopy = { ...planet };
console.log(planet.composition[0] === planetCopy.composition[0]); // Output: true
console.log(planet === planetCopy); // Output: false

// Prediction: 
// planet.composition[0] === planetCopy.composition[0]: true because both reference the same array object.
// planet === planetCopy: false because they are separate objects.
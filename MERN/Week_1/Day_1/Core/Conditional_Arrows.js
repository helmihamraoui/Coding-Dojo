// Problem 1 
const checkAgeNinja = (age) => age > 18 ? "You are good to go!" : "Sorry! You must be 18 or older!";
console.log(checkAgeNinja(20)); // Output: You are good to go!
console.log(checkAgeNinja(16)); // Output: Sorry! You must be 18 or older!

// Problem 2 
const isRainingNinja = (raining) => raining ? "Get your rain jacket!" : "No rain on today's forecast!";
console.log(isRainingNinja(true)); // Output: Get your rain jacket!
console.log(isRainingNinja(false)); // Output: No rain on today's forecast!

// Problem 3
const isEvenNinja = (number) => number % 2 === 0 ? "That's an even number!" : "That's an odd number!";
console.log(isEvenNinja(4)); // Output: That's an even number!
console.log(isEvenNinja(7)); // Output: That's an odd number!

// Problem 4
const compareNumbersNinja = (num1, num2) => 
    num1 > num2 
        ? `${num1} is more than ${num2}!` 
        : `${num1} is less than ${num2}!`;
console.log(compareNumbersNinja(10, 5)); // Output: 10 is more than 5!
console.log(compareNumbersNinja(3, 7)); // Output: 3 is less than 7!

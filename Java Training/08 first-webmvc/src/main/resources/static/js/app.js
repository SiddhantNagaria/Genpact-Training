//var, let, const

/*

var lang = "Js";
var lang = "Python";
console.log("using var " + lang);


let lang2 = "JS";
//let lang2 = "Python";
lang2 = "Python";
console.log("using let " + lang2);

const pi = 3.14;
//pi = 3.21;
console.log("using const " + pi);

function testScope() {
	if (true) {
		var x = 10;	//function scope
		let y = 20;	// block scope
		const z = 30;	// block scope
		console.log("from block : ", x);
		console.log("from block : ", y);
		console.log("from block : ", z);
	}
	console.log("from function : ", x);
	console.log("from function : ", y);
	console.log("from function : ", z);
}

testScope();

*/


/*
//Operators = 
//arithmetic operator +  - / * % **

//Comparison operators  == != === !==
	//-> == compare values only
	//-> === compare value and data type both
	
	console.log(5==5);
	console.log(5==8);
	console.log(5=="5");
	console.log(5==="5");
	console.log(5!=8);
	console.log(5!="8");
	console.log(5!==8);
	console.log(5!=="8");
	
	
	
// Logical Operators
//		&& || NOT

let mark = 25;
console.log(mark>18 && mark <100);
console.log(mark>18 || mark <100);

//Ternary operator "?"

let marks = 50;
let result = marks>=50 ? "pass" : "Fail";
console.log(result);	

*/

//Template Literals
//	- introduced on ES6 = new way to create strings in Js
//	- more powerful and flexible than normal strings
//	- using backticks
//	- `string value`

/*
let names = "Siddhant Nagaria";
let msg = "Hello " + names;

let msg2 = `hello ${names}`
console.log(msg);
console.log(msg2);

*/


/*


// Embedded expressions - Math, functions
let a = 10;
let b = 20;
let result = `sum : ${a+b}`;
console.log(result);

function welcome(named){
	return `hello ${named}`;
}

let hello = `Hello ${welcome("Siddhant")}`;
console.log(hello);


// arrays
let nums = [101,102,404,"Siddhant"];
console.log(nums);


//objects
let user = {
	name:"siddant",
	city:"delhi"
}
let info = `User name ${user.name} and city is ${user.city}`;
console.log(info);

//strings
let string1 = "JavaSCript ES6";
console.log("length " + string1.length);
console.log("uppercase " + string1.toLocaleUpperCase());
console.log("lowercase " + string1.toLowerCase());
console.log("substring " + string1.substring(1,6));
console.log("includs Script " + string1.includes("script"));
console.log("starts with Java" + string1.startsWith("java"));
console.log("ends with 6 " + string1.endsWith("6"));

//split and join strngs

let data = "HTML, CSS , JS", React;

let topics = data.split(",");
console.log("splitted data" + topics);


let joineddata = topics.join(" | ");
console.log("joined data " + joineddata) ;

//relpace and trim
let msg = "learning Js ES6 in this session";
console.log("trimmed data " + msg.trim());
console.log("replace msgg " + msg.replace("ES6","ES7"));



*/




//Arrays

/*
let tech = ["java", "python", "DS", "AI", "ML", "React"];
console.log("technologies : " + tech);

//access elements 
console.log(tech);
console.log(tech[2]);
console.log(tech[4]);
console.log(tech.length);

//add remove elements

tech.push("Golang");	//add at end
console.log("technologies ", tech);
tech.push("Spring");
console.log("technologies ", tech);
tech.unshift("MySQL"); 	//add at start
console.log("technologies ", tech);
tech.pop();	//remove from last
console.log("technologies ", tech);
tech.shift();		//rmeove from first
console.log("technologies ", tech);
console.log(tech.indexOf("java"));
console.log(tech.indexOf("ML"));
console.log(tech.indexOf("AI"));

//Iterate over arrays
//for loop
for (let i = 0; i < tech.length; i++) {
	console.log(`tech at ${i + 1} : ${tech[i]}`);
}

//for of loop
for (let t of tech) {
	console.log("using for of loop : " + t);
}
//forEachLoop
tech.forEach((t, index) => {
	console.log(`Index ${index} : ${t}`);
});


//Higher Order Elements
//map() filter() reduce() sort()

//Map
let nums = [1, 22, 42, 0, 45, 74, 23, 82];
let squares = nums.map(x => x ** 2);
console.log("squares : ", squares);

//filter
let above30 = nums.filter(x => x > 30);
console.log("nums greater than 30 : ", above30);

//reduce() - give you a single output - sum, max
let sumNums = nums.reduce((a, val)=>a+val,0);
console.log("sum of nums is ", sumNums);

//sort
// js sort as strings (lexicographical order)
// provide a compare function
// if a-b<0 -> a before b
// if a-b>0 -> b before a
// if a-b=0 -> no change
nums.sort((a,b)=>a-b);
console.log("sorted nums : ", nums);

nums.sort((a,b)=>b-a);
console.log("descending nums : ", nums);

*/


/*
//slice() - extracts a portion without modifying the original array

let nums = [11, 31, 51, 21];
let nums2 = nums.slice(1, 3);
console.log(nums2);

//splice() - add/remove elements - modifies the original array
//array.splice(startIndex, deleteCount, itemsToAdd)
nums.splice(1, 2);
console.log(nums);
nums.splice(1, 0, 34) // [11,34,21]
console.log(nums);


//concat()
let num3 = [101, 201, 301];
let newNums = nums.concat(num3);
console.log(newNums);

//spread(...) -
//	copy one arry to another, merge two arrays , add elements
let num4 = [...num3];
console.log(num4);

let num5 = [...nums, ...num4];
console.log(num5);

let arr = [10, 20];
let newArr = [5, ...arr, 25];

//array destructuring - extract value in variables out of an array

let tech = ['java', 'python', 'js', 'react'];
let [lang1, lang2, lang3, lang4] = tech;
console.log(lang1);
console.log(lang2);
console.log(lang3);
console.log(lang4);

//skip vsome value
let [lang11, lang22, lang44] = tech;
console.log(lang11);
console.log(lang22);
console.log(lang44);


//MultiDimensional Arrays

let matrix = [
	[1, 2, 3],
	[4, 5, 6],
	[7, 8, 9]
];
console.log(matrix);

//find() - return first matching element
let numbers = [5, 12, 8, 130, 144];
let search_num = numbers.find(n => n > 10);
console.log(search_num);

//findIndex - return index of first matched element 
let search_idx = numbers.findIndex(n=>n>20);
console.log(search_idx);

//some() - check that elements match -> true
console.log(numbers.some(n=>n>120));

//every() - all elements match condition
console.log(numbers.every(n=>n%2==0));

// array.from() - convert other things to array
let str = "python";
console.log(Array.from(str));

//array.of() - create array from arguments
let arr_of = Array.of(1001,2001,3001);
console.log(arr_of);

//nested array - 
let nested_array = [10, [20,30],[40,50]];
//flat()= - flattens the nested array
console.log(nested_array.flat(1));
console.log(nested_array.flat(2));
console.log(nested_array.flat(3));

//flatMap() -  map + flat

let nums_n = [10,20,30];
let output = nums_n.flatMap(n=>[n,n*2]);
console.log(output);

//isArray() - check if value is an array
console.log(Array.isArray([1,2,3]));	//true
console.log(Array.isArray("python"));	//false

*/

//OBJECTS
//key value pairs 
let user = {
	name: "XYZ",
	age: "25",
	city: "new delhi"
}
console.log(user);
console.log(user["age"]);
console.log(user.city);

//update
user.city = "mumbai";
console.log("updated city", user.city);
console.log(user);

//add
user.email = "abc@asd.com";
console.log("added a email", user.email);
console.log(user);

//delete
delete user.email;
console.log("after email deletion", user);

//Objects with methods - functions inside objects
let student = {
	name: "student 1",
	marks: 90,
	display: function() {
		console.log("marks scored : " + this.marks);
	}
};
console.log("student", student);
student.display();

let employee = {
	name: "zxc",
	age: 25,
	address: {
		city: "new delhi",
		pincode: 123456,
		state: "maharastra"
	}
};
console.log("EMP", employee);
console.log("address city : ", employee.address.city);


//array of objects - most used - hotel(object) - list of all hotels - array of objects
let emp = [
	{ id: 123, name: "siddhant" },
	{ id: 234, name: "rahul" },
	{ id: 345, name: "rohit" },
	{ id: 567, name: "rahul" },
]
console.log(emp);
console.log(emp[1]);


//loop through objects
let student2 = {
	name: "student 1",
	marks: "90",
	course: "computer science"
}

for (let key in student2) {
	console.log(key, " : ", student2[key]);
}


//keys() = return keys only
//values() = return values
//entries() = whole entry of object
console.log(Object.keys(student2));
console.log(Object.values(student2));
console.log(Object.entries(student2));

//spread operator with objects
//copy
let student_new = { ...student2 };
console.log(student_new);

//merge
let st = {
	email: "st@gmail.com",
	city: "New Delhi"
}
let student_merged = { ...student2, ...st };
console.log(student_merged);

let product = {
	id: 101,
	name: "Laptop",
	price: 50000.00
};

//object destructing
let { id, name, price } = product;
console.log(id, name, price);

//constructor function - create many objects 
function Person(name, age, city) {
	this.name = name,
		this.age = age,
		this.city = city;
}
let p1 = new Person("ankit", 25, "noida");
let p2 = new Person("ankita", 21, "bombay");
console.log(p1, p2);

//object.freeze() - no change allowed

let obj = { a: 10 };
Object.freeze(obj);
obj.a = 20;
console.log(obj.a);


//seal() = properties cannot be added or removed but can be modified
let obj2 = { b: 30 };
Object.seal(obj2);
obj2.b = 40;
console.log(obj2.b);
obj2.c = 50;
console.log(obj2.c);

//optional chaining 
//used to avoid errors when accessing nested properties
let emp2 = {
	name: "XYZ",
	age: 25,
	address: {
		city: "new Delhi",
		pincode: 123456,
		state: "UP"
	}
};
console.log(emp2);
console.log(emp2.address?.city);
console.log(emp2.address?.street);


//send some data over network - JSON format
//{"name": "Emp1","age": 25};

//COnversions - objects -> json or json or JSON -> object

//covert object to json
let jsonStr = JSON.stringify(emp2);
console.log("obj to json",jsonStr)
let obj3 = JSON.parse(jsonStr);
console.log("json to obj",obj3);


//switch -> take 3 inputs - num1, num2, operator -> add, sub , multiply, divide
//default case

//while ->
//let data = [10,"strings",....] -> 4 nos, 3 strings,
//using while - create a new array that contain number only

let num1 = 10;
let num2 = 5;
let operator = "multiply"; // can be "add", "sub", "multiply", "divide"

switch (operator) {
  case "add":
    console.log("Result:", num1 + num2);
    break;
  case "sub":
    console.log("Result:", num1 - num2);
    break;
  case "multiply":
    console.log("Result:", num1 * num2);
    break;
  case "divide":
    if (num2 !== 0) {
      console.log("Result:", num1 / num2);
    } else {
      console.log("Cannot divide by zero");
    }
    break;
  default:
    console.log("Invalid operator. Use add, sub, multiply, or divide.");
}

let data = [10, "hello", 25, "world", 42, "js", 7];
let onlyNumbers = [];

let i = 0;
while (i < data.length) {
  if (typeof data[i] === "number") {
    onlyNumbers.push(data[i]);
  }
  i++;
}

console.log("Numbers only:", onlyNumbers);








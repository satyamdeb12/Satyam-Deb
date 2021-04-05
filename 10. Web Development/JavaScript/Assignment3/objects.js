class Rectangle{
    constructor(width,height){
        this.width = width;
        this.height = height;
    }
}

let rect1 =  new Rectangle(10,20);
console.log(rect1.width);
console.log(rect1.height);
rect1.width = 30;
console.log(rect1.width);

//Q2
Rectangle.prototype.getArea = function(){
    return this.width * this.height;
}

//Q3

//The below code prints 20 instead of 200 because spelling mistake in r.height

let r = new Rectangle(4, 5);
r.hieght = 50;
r.getArea();


//Q4

var obj = {
    firstName: 'John',
    lastName: 'Murfy'
}

console.log(obj.firstName);
console.log(obj.lastName);

//Q5
console.log(obj.middlename); //returns undefined

obj.middlename = 'Lake'
console.log(obj.middlename); 

//Q6

let str = "({firstName:'vamsi', lastName:'krishna'})";

console.log(eval(str));


//Q7

var json = '{"firstName":"vamsi","lastName":"krishna"}'

console.log(JSON.parse(json));



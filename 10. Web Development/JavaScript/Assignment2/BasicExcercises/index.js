//Q1

function composedValue(f1,f2,value){
    return f1(f2(value));
}

function square(x) { return(x*x); }
function double(x) { return(x*2); }

composedValue(square, double, 5); 

//Q2

let compose = (f1,f2)=>(value)=>f1(f2(value));
var f1 = compose(square, double);
f1(5);

//Q3

function isEven(num) { return(num%2 == 0); }

function find(arr,func){
    for(let i=0; i<arr.length; i++){
        if(func(arr[i])){
            return arr[i];
        }
    }
}

find([1, 3, 5, 4, 2], isEven);

//Q4

function map(arr,func){
    var a = new Array();
    for(let i=0; i<arr.length; i++){
        a.push(func(arr[i]));
    }
    return a;
}


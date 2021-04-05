//Q1

function isEven(num) { return(num%2 == 0); }

function find(arr,func){
    if(func(arr.slice(0,1))){
        return arr.slice(0,1)[0];
    }
    return find(arr.slice(1,),func);
}

find([1, 3, 5, 4, 2], isEven);

//Q2

function map(arr,func){
    if(arr.length==1){
        return func(arr[0]);
    }
    return [func(arr.slice(0,1)[0])].concat(map(arr.slice(1,),func));
}

function multiply(num){
    return num*2;
}

map([1,2,3,4,5], multiply);

//Q3



let x = function(something){
    
};
console.log(x);


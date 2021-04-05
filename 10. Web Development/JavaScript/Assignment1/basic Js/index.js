

//Q1

var fourNums = [Math.random(),Math.random(),Math.random(),Math.random()];
console.log(fourNums);
//Q2

var hundredNums = new Array();

for(let i=0; i<100;i++){
    hundredNums.push(Math.random());
}
console.log(hundredNums);
//Q3

var strings = ["1.2", "2.3", "3.4"];

function numberArray(strings){
    for(i=0;i<strings.length;i++){
        strings[i] = parseFloat(strings[i]);
    }
    console.log(strings);
}

var nums = numberArray(strings);

//Q4

//Applied two pointer method
function longestToken(str){
    var token = "";
    var ptr1 = 0;
    var ptr2 = 0;
    while(ptr1<str.length && ptr2<str.length){
        
            if(str[ptr2]=="a" && str[ptr2+1]=="b"){
                let temp = str.substring(ptr1,ptr2);
                if(temp != "" && temp.length >token.length){
                    token = temp;
                }
                ptr1 = ptr2+1+1;
                ptr2 = ptr2+1+1;
            }else if(str[ptr2] == "a"){
                let temp = str.substring(ptr1,ptr2);
                if(temp != "" && temp.length >token.length){
                    token = temp;
                }
                ptr1 = ptr2+1;
                ptr2 = ptr2+1;
            }else{
                ptr2 = ptr2+1;
            }
        
    }
    return token;
}

//Q5

var test1 = ["stop", "quit", "exit"];

function lengthOfNonQWords(arr){
    return arr.filter(s=>{
        if(s.indexOf("q") == -1){
            return s;
        }
    }).reduce((accu,item)=>{
        return accu.length + item.length;
    });
}

// ANOTHER SET OF QUESTIONS

//Q1

console.log("hello world");

//Q2

function greet(){
    alert( "Welcome "+prompt("what is your name?"));
}

//Q3

function greetOnlyIfAliceOrBob(){
    var name = prompt("what is your name");
    if(name == "Alice" || name=="Bob"){
        alert("Welcome "+name);
    }
}

//Q4

function sumOfN(){
    var n = prompt("provide number");
    var sum = n*((n+1)/2);
    alert(sum);
}

//Q5

function sumOfMultiplesOfThreeOrFive(){
    var num = prompt("provide number");
    var sum=0;
    for(let i=1; i<=num;i++){
        if(i%3==0 || i%5==0){
            sum += i;
        }
    }

    alert(sum);
}

//Q6

function sumOrProduct(){
    var n = prompt("provide number");
    var num = prompt("Enter 1 for sum and 2 for product");
    if(num==1){
        var sum = n*((n+1)/2);
        alert(sum);
    }else{
        var product=1;
        for(let i=1; i<=n;i++){
            if(i%3==0 || i%5==0){
                product *= i;
            }
        }
        alert(product);
    }
}

//Q7

function tables(){
    var str = "Tables \<br>";
    for(let i=2; i<=12;i++){
        for(let j=1;j<=10;j++){
            str += " "+i+ "*"+ j +" = "+ i*j+" | ";
        }
        str += "\<br>";
    }
    document.querySelector(".tables").innerHTML=str;
}
tables();


//Q8

function primeFactorsTo(max)
{
    var store  = [], i, j, primes = [];
    for (i = 2; i <= max; ++i) 
    {
        if (!store [i]) 
          {
            primes.push(i);
            for (j = i << 1; j <= max; j += i) 
            {
                store[j] = true;
            }
        }
    }
    return primes;
}

//Q9

function guessNumber(){
    var secret = 5;
    var num = prompt("guess secret number below 10");
    var guessed = false;
    while(!guessed){
        if(num==null){
            break;
        }
        if(num==secret){
            alert("correct guess");
            guessed = true;
            break;
        }else if(num>secret){
            num = prompt(""+num+ " was too large");
        }else{
            num =  prompt(""+num+ " was too low");
        }
        
    }
}

//Q10

var yearsPrinted = 0;
var currentYear = 2021;

function leapYears() {
    while (yearsPrinted < 30) { 
        if ((currentYear % 4 === 0) && (!((currentYear % 100===0) && (currentYear % 400 !== 0)))) {
          
            document.write(currentYear + "<br>");
            yearsPrinted++;
            currentYear++;
        } else {
            currentYear++;
        }
    }       
}







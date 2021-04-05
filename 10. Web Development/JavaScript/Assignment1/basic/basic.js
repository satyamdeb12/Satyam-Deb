function evenOdd(number){
    if(number%2==0){
        return "even";
    }
    return "odd";
}

function max(num1, num2, num3){
    if(num1 > num2 && num1 >num3){
        return num1;
    }else if(num2>num3 && num2>num1){
        return num2;
    }
    return num3;
}

function padChars(num, str){
    return str.repeat(num);
}

if(Math.random()>0.5){
    document.querySelector(".message").innerHTML="Have a good day";
}else{
    document.querySelector(".message").innerHTML="Have a bad day";
}


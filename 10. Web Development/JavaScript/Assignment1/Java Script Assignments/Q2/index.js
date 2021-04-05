var input1 = document.querySelector(".input1");
var input2 = document.querySelector(".input2");
var input3 = document.querySelector(".input3");

count = 0;

var arr = new Array();

while(count<3){
    var result = prompt("enter input"+(count+1)+" between 1 and 30");
    if(result>1 && result<30 ){
        arr.push(result);
        count++;
    }else{
        alert("Your input in valid, Enter again...");
    }
}

input1.innerText = "*".repeat(arr[0]);
input2.innerText = "*".repeat(arr[1]);
input3.innerText = "*".repeat(arr[2]);
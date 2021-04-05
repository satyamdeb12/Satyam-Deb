var text = document.querySelector(".input");
var error = document.querySelector(".error");
var result = document.querySelector(".result");

document.querySelector(".submit").addEventListener("click", function(){
    var fahr = text.value;
    if(text.value == 0){
        error.innerText = "*Field Required"
    }else{
        var cels = (fahr - 32.0) * 5.0/9.0;
        result.innerText = "In Celsius "+cels;
    }
    
});
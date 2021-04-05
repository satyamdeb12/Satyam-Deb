var result = document.querySelector(".result");
var calculate =  document.querySelector(".calculate");

var isSelected = false;


function start(){
    var selected = initPrompt();
    

    if(selected == null){
        return;
    }

        let isValid = false;
        while(!isValid){
            
            if(selected == Number.NAN || selected<1 || selected>8){
                alert("selection is invalid, select again");
                selected = initPrompt();
                
            }else{
                isValid = true;
            }
            
        }

        switch(parseInt(selected)){
            case 1:
                console.log("in add");
                return parseInt(getNum1())+parseInt(getNum2());
            case 2:
                return parseInt(getNum1())-parseInt(getNum2());
            case 3:
                return parseInt(getNum1())*parseInt(getNum2());
            case 4:
                return parseInt(getNum1())/parseInt(getNum2());
            case 5:
                return Math.pow(parseInt(getNum1()),parseInt(getNum2()));
            case 6:
                var arr = new Array();
                var isInputStopped = false;
                while(!isInputStopped){
                    let i = prompt("provide number");
                    if(i=="***"){
                       isInputStopped = true;
                    }else{
                        arr.push(parseInt(i));
                    }
                }
                return arr.reduce((a, b) => a + b, 0)/arr.length;
            case 7:
                return;
            default:
                console.log("in while");
        }
    
}

function initPrompt(){
    return prompt(`
    1. Add 
    2. Subtract
    3. Multiply
    4. Divide
    5. Exponent
    6. Mean
    7. Quit `);
}

function getNum1(){
    let num1 = Number.NAN;
    while(num1 == Number.NAN){
        num1 = prompt("Provide number 1");
        };
        return num1;
}

function getNum2(){
    let num2 = Number.NAN;
                while(num2 == Number.NAN){
                    num2 = prompt("Provide number 2");
                };
                return num2;
}

calculate.addEventListener("click", ()=>result.innerText = `${s}`);

var s = start();



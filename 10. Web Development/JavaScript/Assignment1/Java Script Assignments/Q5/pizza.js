var form = document.querySelector("#form");

var username = document.querySelector(".name");
var email = document.querySelector(".email");
var extraCheese = document.querySelector(".extraCheese");
var pepperoni = document.querySelector(".pepperoni");
var olives = document.querySelector(".olives");
var pepper = document.querySelector(".pepper");
var bacon = document.querySelector(".bacon");
var tomatoes = document.querySelector(".tomatoes");
var mushrooms = document.querySelector(".mushrooms");

var delivery = document.querySelector("#delivery");
var pickup = document.querySelector("#pickup");

var tip15 = document.querySelector("#tip15");
var tip20 = document.querySelector("#tip20");
var tip25 = document.querySelector("#tip25");

var address = document.querySelector("#address");

var table = document.querySelector("#table");

var submit = document.querySelector("#submit");
var showSummary = document.querySelector("#showSummary");
submit.addEventListener("click", ()=>showSummary.disabled = false);

var arr = new Array();

arr.push(extraCheese);
arr.push(pepperoni);
arr.push(olives);
arr.push(pepper);
arr.push(bacon);
arr.push(tomatoes);
arr.push(mushrooms);

showSummary.addEventListener("click", function(){
    console.log(extraCheese.checked);

    arr.filter(x=>x.checked==true);

    var toppings = ``;
    
    for(let i=0; i<arr;i++){
        toppings += `<tr>
        <td>Topping${i+1}</td>
        <td>${arr[i].value}</td>
        </tr>`;
    }

    var a = [tip15,tip20,tip25];

    a.filter(x=>x.selected==true);

    var total=0;
    var deliveryFee = 0;
    var toppingFee = arr.length * 1.5;
    if(delivery.checked){
        deliveryFee = 5;
    }

    total = (10+toppingFee+deliveryFee)*1.0+(a[0].value/100);


    console.log(arr);

    var str=`
        <tr>
            <td>Name</td>
            <td>${username.value}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${email.value}</td>
        </tr>
        <tr>
            <td>Address</td>
            <td>${address.value}</td>
        </tr>
        <tr>
            <td>Toppings</td>
            <td>${username.value}</td>
        </tr>
        ${toppings}
        <tr>
        <td>Delivary?</td> <td>${delivery.checked}</td>
        <tr>
        <tr>
        <td>Tip Amount</td><td>${a[0].value}% <td>
        </tr>
        <tr>
        <td>Total</td> <td>$${total}</td>
        </tr>
    `;

    table.innerHTML += str;


});
//Q21

function concateAndSort(list1,list2){
    return (list1.concat(list2)).sort();
}

//Q22

function rotateList(list,k){
    for(let i=0;i<k;i++){
        list.push(list.shift());
    }
    return list;
}

//Q23

function Fibonacci(){
	var before = 0;
	var actual = 1;
	var next = 1;
    var num = 100;
    var arr = new Array();

	for(let i = 0; i < num; i++){
        arr.push(next);
		before = actual + next;
		actual = next
		next = before
	}

    return arr;
}

//Q24

function listOfDigits(num){
    var x = ""+num;
    return x.split("").map(parseFloat);
    
}

//Q25




//Q11

function largest(list){
    var large = list[0];
    for(let i=1;i<list.length;i++){
        if(list[i]>large){
            large = list[i];
        }
    }
    return large;
}

//Q12
//Applied two pointer method to reverse list inplace.
function reverse(list){
    var start = 0;
    var end = list.length-1;
    while(start<=end){
        let temp = list[start];
        list[start] = list[end];
        list[end]  = temp;
        start +=1;
        end -=1;
    }

    return list;
}

//Q13

function findElement(list,ele){
    for(let i=0;i<list.length;i++){
        if(list[i]==ele){
            return true;
        }
    }
    return false;
}

//Q14

function returnOddElements(list){
    return list.filter(function(x,index){
        return index%2 !=0;
    });
}

//Q15

function totalOfList(list){
    
    var sum=0;

    for(let i=0;i<list.length;i++){
        list[i] = list[i]+sum;
        sum = list[i];
    }
    return list;
}

//Q16

function isPalindrome(str){
    return str == str.split('').reverse().join('');
}

//Q17

function sumUsingForLoop(list){
    var sum=0;
    for(let i=0;i<list.length;i++){
        sum += list[i];
    }
    return sum;
}

function sumUsingWhileLoop(list){
    var sum=0;
    let i=0;
    while(i<list.length){
        sum += list[i];
        i +=1;
    }
    return sum;
}

function sumUsingRecursion(list){
    if(list.length==1){
        return list[0];
    }
    return list.pop() + sumUsingRecursion(list);
}

//Q18

var nums = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20];

function perfectSquares(nums){
    return nums.forEach(function(x){
        return x*x;
    });
}

//Q19

function concateLists(list1,list2){
    return list1.concat(list2);
}

//Q20

function concateAlternatively(list1, list2){
    var arr = new Array();
    for(let i=0;i<list1.length;i++){
        arr.push(list1[i]);
        arr.push(list2[i]);
    }
    return arr;
}
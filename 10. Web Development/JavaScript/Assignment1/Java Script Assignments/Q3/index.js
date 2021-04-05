var rows = prompt("Enter number of rows :");
var columns = prompt("Enter number of Columns :");

var str = "<Table border='1'>";

console.log(rows,columns);
for(let i=1; i<=rows; i++){
    console.log(i);
    str += "<tr>";
    for(let j=1; j<=columns; j++){
        str = str + `
        <td>(${i},${j})</td>
        `;
    }
    str += "</tr>";
}

str += "</Table>";

document.write(str);

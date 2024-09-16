let str='{"firstName":"Alex","lastName":"Hunter","email":"alex@yahoo.com","age":24, "city":"london", "country":"england"}';
let ans={}
let obj=JSON.parse(str);
for(let key in obj)
{
    if(key!=='email'&&typeof obj[key]==='string')
    obj[key]=obj[key].toUpperCase();
}
console.log("JSON Object")
console.log(obj)

delete obj.email;

let jsonString = JSON.stringify(obj);
console.log("Converted String")
console.log(jsonString)



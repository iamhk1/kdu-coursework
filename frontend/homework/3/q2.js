let days=['Sunday','Monday','Tuesday','Wednesday','Thursday','Friday']
function trim(days)
{
    return days.map(day => day.substring(0, 3).toUpperCase());
}



function encode(str)
{
    str=str.trim();
    let ans="";
    for(let i=0;i<str.length;i++)
    {
        let ch=str[i];
        if(ch=='a')
        {
            ans+='4';
        }
        else if(ch=='e')
        {
            ans+='3';
        }
        else if(ch=='i')
        {
            ans+='1';
        }
        else if(ch=='o')
        {
            ans+='0';
        }
        else if(ch=='s')
        {
            ans+='5';
        }
        else 
        {
            ans+=ch;
        }
    }
    return ans;
}
console.log(trim(days))
console.log("Encoded String ",encode("javascript is cool"))
let tips=[]
let amount=[]
function tipCalculator(bill)
{
   bill.forEach(amt => {
    let tip=0;
    if(amt<50)
    {
        tip=0.2*amt;
    }
    else if(amt<=200)
    {
        tip=0.15*amt;
    }
    else {
        tip=0.1*amt;
    }
    tips.push(tip);
    amount.push(amt+tip);
   });
}

tipCalculator([30,100,300])
console.log("Tips")
console.log(tips);
console.log("Amount")
console.log(amount);


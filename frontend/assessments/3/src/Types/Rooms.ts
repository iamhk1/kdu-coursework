export interface AddOn
{
    name:string,
    cost:string,
    currency:string;
}
export interface Room{
    addOns:AddOn[],
    id:number,
    name:string,
    costPerNight:string,
    currency:string,
    
}
export interface Received{
    roomTypes:Room[];
}

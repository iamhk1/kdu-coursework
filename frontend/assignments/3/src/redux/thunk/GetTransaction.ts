import { createAsyncThunk } from "@reduxjs/toolkit";

export const getTransactions=createAsyncThunk(
    "getTransactions",async()=>{
        try{
            const res=await fetch("https://kdu-automation.s3.ap-south-1.amazonaws.com/mini-project-apis/portfolio-transactions.json");
            const data=await res.json();
            console.log(data)
            return data
        }
        catch(err){
            throw new Error("Wrong URL");
        }
    }
)
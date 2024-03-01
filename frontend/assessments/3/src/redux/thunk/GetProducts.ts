import { createAsyncThunk } from "@reduxjs/toolkit";

export const getProducts=createAsyncThunk(
    "getProducts",async()=>{
        try{
            const res=await fetch("https://kdu-automation.s3.ap-south-1.amazonaws.com/mini-project-apis/assessment-3.json");
            const data=await res.json();
            console.log(data)
            return data
        }
        catch(err){
            throw new Error("Wrong URL");
        }
    }
)
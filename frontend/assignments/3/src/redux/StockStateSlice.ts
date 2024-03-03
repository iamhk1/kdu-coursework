import{PayloadAction, createSlice} from "@reduxjs/toolkit"
import { StockPrice } from "../Types/StockPrice";
interface StockState{
   stockData:StockPrice[]
}

const initialState:StockState={
    stockData:[]
}
const StockStateSlice=createSlice({
    name:"stockstate",
    initialState,
    reducers:{
        addItem:(state,action:PayloadAction<StockPrice>)=>{
            console.log(action.payload,"hello");
            state.stockData.push(action.payload);
        },
        resetData:(state)=>{
            state.stockData=[];
        }
        
    },
})
export const{addItem,resetData}=StockStateSlice.actions;
export const StockStateReducer=StockStateSlice.reducer;
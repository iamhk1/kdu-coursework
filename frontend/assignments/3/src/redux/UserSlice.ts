import{PayloadAction, createSlice} from "@reduxjs/toolkit"
import { Transaction } from "../Types/Transaction";
import { EachStock } from "../Types/EachStock";
import { History } from "../Types/History";
import { AllHistory } from "../Types/AllHistory";
const initialTransaction: Transaction = {
  amount: 10000,
  portfolio: {
    stocks:[]
  }
};
interface UserState{
    portfolioInfo:Transaction
    transactionHistory:History[],
    allHistory:AllHistory[],
    currentState:number,
    state: string;
    errorMessage: string;
}

const initialState:UserState={
   portfolioInfo: initialTransaction,
   transactionHistory:[],
   allHistory:[],
   currentState:1,
   state: "",
   errorMessage: ""
}
const UserSlice=createSlice({
    name:"currentState",
    initialState,
    reducers:{
        addToHistory:(state,action:PayloadAction<History>)=>{
            state.transactionHistory.push(action.payload);
        },
        toggleState:(state,action:PayloadAction<number>)=>{
            state.currentState=action.payload;
        },
        addToPortfolio: (state, action: PayloadAction<EachStock>) => {
            const addedStock = action.payload;
            const existingStockIndex = state.portfolioInfo.portfolio.stocks.findIndex(
              (stock) => stock.stock_symbol === addedStock.stock_symbol
            );
          
            if (existingStockIndex !== -1) {
             
              state.portfolioInfo.portfolio.stocks[existingStockIndex].quantity += addedStock.quantity;
            } else {
             
              state.portfolioInfo.portfolio.stocks.push(addedStock);
            }
           
        },
        updatePrice:(state,action:PayloadAction<number>)=>{
            state.portfolioInfo.amount-=action.payload;
        },
        sellStock:(state,action:PayloadAction<EachStock>)=>{
            
            const { stock_symbol, quantity } = action.payload;
            const portfolio = state.portfolioInfo.portfolio;
            const stockIndex = portfolio.stocks.findIndex(stock => stock.stock_symbol === stock_symbol);
          
            if (stockIndex !== -1) {
              
              portfolio.stocks[stockIndex].quantity -= quantity;
            }
        },
        increasePrice:(state,action:PayloadAction<number>)=>{
            state.portfolioInfo.amount+=action.payload;
        },

        addToAllHistory:(state,action:PayloadAction<AllHistory>)=>{
            state.allHistory.push(action.payload);
        },
        resetAllHistory:(state)=>
        {
          state.allHistory=[];
        }

    } 
})


export const{toggleState,addToPortfolio,addToHistory,updatePrice,increasePrice,sellStock,addToAllHistory,resetAllHistory}=UserSlice.actions;
export const UserReducer=UserSlice.reducer;
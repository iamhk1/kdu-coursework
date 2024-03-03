import{PayloadAction, createSlice} from "@reduxjs/toolkit"
import { TransactionPortfolio } from "../Types/TransactionPortfolio"
import { getTransactions } from "./thunk/GetTransaction"

interface PortfolioTransactionState{
 transactionPortfolio:TransactionPortfolio[],
 state: string;
 errorMessage: string;
}

const initialState:PortfolioTransactionState={
  transactionPortfolio:[],
  state: "",
  errorMessage: ""
}
const PorftolioTransactionSlice=createSlice({
    name:"PortfolioTransaction",
    initialState,
    reducers:{
        addTransactionToPortfolio:(state,action:PayloadAction<TransactionPortfolio>)=>{
            console.log(action.payload);
            state.transactionPortfolio.push(action.payload);
        }
            
    },
    extraReducers(builder) {
        builder
          .addCase(getTransactions.pending, (state) => {
            state.state="pending"
          })
          .addCase(getTransactions.fulfilled, (state, action) => {
            state.transactionPortfolio = action.payload;
            state.state = "fulfilled";
            console.log("Congratulations");
          })
          .addCase(getTransactions.rejected, (state, action) => {
            state.errorMessage = action.error.message!;
            state.state = "rejected";
          });
      },
})
export const{addTransactionToPortfolio}=PorftolioTransactionSlice.actions;
export const PortfolioTransactionReducer=PorftolioTransactionSlice.reducer;
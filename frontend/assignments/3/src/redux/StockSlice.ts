import{PayloadAction, createSlice} from "@reduxjs/toolkit"
import { Stock } from "../Types/Stock"
import { getStocks } from "./thunk/GetStocks";
interface StockState{
  watchlist:Stock[];
   stocks:Stock[],
   state: string;
   errorMessage: string;
}

const initialState:StockState={
  watchlist:[],
   stocks:[],
   state:"",
   errorMessage:""
}
const StockSlice=createSlice({
    name:"stocks",
    initialState,
    reducers:{
        populateItem:(state,action:PayloadAction<Stock[]>)=>{
            state.stocks=action.payload;
        },
        toggleWishlist:(state,action:PayloadAction<string>)=>{
          const stockSymbolToToggle = action.payload;
          state.stocks.forEach((stock) => {
            if (stock.stock_symbol === stockSymbolToToggle) {
              stock.selected = !stock.selected; 
            }
          });
          
        },
        addToWishlist: (state, action: PayloadAction<string>) => {
          const stockToAdd = state.stocks.find(item => item.stock_symbol === action.payload);
          if (stockToAdd) {
            stockToAdd.selected = true;
            state.watchlist.push(stockToAdd);
          }
        },
        removeFromWishlist: (state, action: PayloadAction<string>) => {
          const indexToRemove = state.watchlist.findIndex(item => item.stock_symbol === action.payload);
          if (indexToRemove !== -1) {
            state.watchlist.splice(indexToRemove, 1);
            const stockToRemove = state.stocks.find(item => item.stock_symbol === action.payload);
            if (stockToRemove) {
              stockToRemove.selected = false;
            }
          }
        },     
    },
    extraReducers(builder) {
        builder
          .addCase(getStocks.pending, (state) => {
            state.state="pending"
          })
          .addCase(getStocks.fulfilled, (state, action) => {
            state.stocks = action.payload;
            state.stocks.map((stock)=>stock.selected=false);
            console.log(state.stocks);
            state.state = "fulfilled";
          })
          .addCase(getStocks.rejected, (state, action) => {
            state.errorMessage = action.error.message!;
            console.log("rejected in slice")
            state.state = "rejected";
          });
      },
})
export const{toggleWishlist,addToWishlist,removeFromWishlist}=StockSlice.actions;
export const StockReducer=StockSlice.reducer;
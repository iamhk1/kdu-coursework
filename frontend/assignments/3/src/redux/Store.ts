import { configureStore } from "@reduxjs/toolkit";
import { UserReducer } from "./UserSlice";
import { StockReducer } from "./StockSlice";
import { StockStateReducer } from "./StockStateSlice";
import { PortfolioTransactionReducer } from "./PortfolioTransactions";
export const store=configureStore({
    reducer:{
        currentState:UserReducer,
        stock:StockReducer,
        stockState:StockStateReducer,
        portfolioTransaction:PortfolioTransactionReducer,
    }
})


export type RootState=ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch;
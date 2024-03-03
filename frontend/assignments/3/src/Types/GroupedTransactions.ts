import { TransactionPortfolio } from "./TransactionPortfolio";
export interface GroupedTransaction {
    date: string;
    transactions: TransactionPortfolio[];
}
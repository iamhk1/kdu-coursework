import { TransactionPortfolio } from "../Types/TransactionPortfolio"; 
import{GroupedTransaction} from"../Types/GroupedTransactions"

export function groupSortAndSortNewestFirst(transactions: TransactionPortfolio[]): GroupedTransaction[] 
{
 
  const convertTimestampToDate = (timestamp: string): Date =>
    new Date(timestamp);
  const transactionsWithDates = transactions.map((transaction) => ({
    ...transaction,
    date: convertTimestampToDate(transaction.timestamp),
  }));
  const groupedTransactions: Record<string, TransactionPortfolio[]> = {};
  transactionsWithDates.forEach((transaction) => {
    const dateString = transaction.date.toLocaleDateString();
    if (!groupedTransactions[dateString]) {
      groupedTransactions[dateString] = [];
    }
    groupedTransactions[dateString].push(transaction);
  });
  Object.values(groupedTransactions).forEach((group) => {
    group.sort((a, b) => b.date.getTime() - a.date.getTime());
  });
  const result: GroupedTransaction[] = Object.entries(groupedTransactions).map(
    ([date, transactions]) => ({
      date,
      transactions,
    })
  );
  result.sort(
    (a, b) =>
      b.transactions[0].date.getTime() - a.transactions[0].date.getTime()
  );
  return result;
}
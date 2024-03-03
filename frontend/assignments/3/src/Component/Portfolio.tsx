import styled from "styled-components";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { DatePicker } from "@mui/x-date-pickers/DatePicker";
import {  RootState } from "../redux/Store";
import {  useSelector } from "react-redux";
import { useEffect, useState } from "react";
import { groupSortAndSortNewestFirst } from "./Sort";
import { GroupedTransaction } from "../Types/GroupedTransactions";
const Center = styled.div`
  width: 100%;
  padding: 4vw 4vw;
  display: flex;
  justify-content: space-between;
  position: relative;
  @media (max-width: 550px) {
    flex-direction: column;
  }
`;
const Left = styled.div`
  width: 30%;
  @media (max-width: 550px) {
    width: 100%;
  }
`;
const LeftContent = styled.div`
  width: 100%;
  border: 2px solid #000;
  background-color: #e9ecef;
  border-radius: 15px;
  position: sticky;
  top: 10%;
`;
const Filters = styled.div``;
const Heading = styled.div`
  display: flex;
  padding: 10px;
  justify-content: space-between;
  border-bottom: 1px solid #000;
`;
const FilterHeading = styled.h4`
  font-size: 1.3rem;
  font-weight: 400;
`;
const ClearAll = styled.button`
  border: none;
  color: #227dec;
`;
const SearchBox = styled.div`
  display: flex;
  padding: 10px;
  border-bottom: 1px solid #000;
  justify-content: center;
`;
const Search = styled.input`
  background-color: transparent;
  border: 1px solid #000;
  font-size: 1rem;
  outline: none;
  width: 90%;
  text-align: center;
  border-radius: 3px;
  color: #7f8081;
`;
const DateContent = styled.div`
  display: flex;
  padding: 10px;
  gap: 5px;
  border-bottom: 1px solid #000;
`;
const CheckboxContent = styled.div`
  padding: 10px;
  border-bottom: 1px solid #000;
`;
const CheckboxContent1 = styled.div`
  padding: 10px;
  max-height: 200px;
  overflow-y: scroll;
`;
const Checkbox = styled.div`
  display: flex;
  gap: 10px;
  padding: 5px;
`;
const CheckboxInput = styled.input.attrs({ type: "checkbox" })`
  background-color: #e9ecef;
  color: #7f8081;
`;
const CheckboxText = styled.h4`
  font-size: 1rem;
  font-weight: 400;
  color: #7f8081;
`;
const Right = styled.div`
  width: 60%;
  @media (max-width: 550px) {
    width: 100%;
  }
`;
const RightContent = styled.div`
  width: 100%;
`;
const DateComponent = styled.div`
  padding: 10px;
  margin: 30px 0px;
  border-bottom: 1px dashed #353434;
  p {
    color: #8b8b8c;
  }
`;
const StockDetails = styled.div`
  padding: 10px;
  border-bottom: 1px solid#000;
  display: flex;
  justify-content: space-between;
`;
const StockName = styled.p`
  color: #5f5f60;
  font-size: 1rem;
  width: 180px;
`;
const StockSymbol = styled.p`
  font-size: 1rem;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #333334;
`;
const TransactionAmount = styled.p`
  font-size: 1rem;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #5f5f60;
`;
const TimePart = styled.div`
  display: flex;
  gap: 6px;
  align-items: center;
`;
const Time = styled.p`
  font-size: 1rem;
  color: #5f5f60;
`;
const PassedSymbol = styled.div`
  height: 10px;
  width: 10px;
  border-radius: 50%;
  background-color: #a8d4b1;
`;

const FailedSymbol = styled.div`
  height: 10px;
  width: 10px;
  border-radius: 50%;
  background-color: #e76c6d;
`;
export function Portfolio() {
    const [isCheckedPassed, setIsCheckedPassed] = useState(false);
    const [isCheckedFailed, setIsCheckedFailed] = useState(false);
    const [filtered,setFiltered]=useState<GroupedTransaction[]>(
        []
        )
        useEffect(()=>{
            const filteredArray = res.filter((group) => {
                if (isCheckedPassed && isCheckedFailed) {
                  return true;
                } else if (isCheckedPassed) {
                  return group.transactions.some((transaction) => transaction.status === 'Passed');
                } else if (isCheckedFailed) {
                  return group.transactions.some((transaction) => transaction.status === 'Failed');
                }
                return false;
              });
              setFiltered(filteredArray);
             

        },[isCheckedPassed,isCheckedFailed])
  const stocks = useSelector((state: RootState) => state.stock.stocks);

 
  const portfolioTransactionArray = useSelector(
    (state: RootState) => state.portfolioTransaction.transactionPortfolio
  );
  
    const res = groupSortAndSortNewestFirst(portfolioTransactionArray);
   

    const formatTimestamp = (timestamp) => {
      const date = new Date(timestamp);
      const options = { hour: "numeric", minute: "2-digit" };
      return date.toLocaleTimeString([], options);
    };

    const handlePassedChange = () => {
        setIsCheckedPassed(!isCheckedPassed);
       
      };
    
      const handleFailedChange = () => {
        setIsCheckedFailed(!isCheckedFailed);
       
      };

    return (
      <Center>
        <Left>
          <LeftContent>
            <Filters>
              <Heading>
                <FilterHeading>Filters</FilterHeading>
                <ClearAll>Clear All</ClearAll>
              </Heading>
            </Filters>
            <SearchBox>
              <Search placeholder="Search for a Stock"></Search>
            </SearchBox>
            <DateContent>
              <LocalizationProvider dateAdapter={AdapterDayjs}>
                <DatePicker />
              </LocalizationProvider>
              <LocalizationProvider dateAdapter={AdapterDayjs}>
                <DatePicker />
              </LocalizationProvider>
            </DateContent>
            <CheckboxContent>
              <Checkbox>
                <CheckboxInput
                  type="checkbox"
                  checked={isCheckedPassed}
                  onChange={handlePassedChange}
                />
                <CheckboxText>Passed</CheckboxText>
              </Checkbox>
              <Checkbox>
                <CheckboxInput
                  type="checkbox"
                  checked={isCheckedFailed}
                  onChange={handleFailedChange}
                />
                <CheckboxText>Failed</CheckboxText>
              </Checkbox>
            </CheckboxContent>

            <CheckboxContent1>
              {stocks.map((stock, index) => (
                <Checkbox key={index}>
                  <CheckboxInput />
                  <CheckboxText>{stock.stock_name}</CheckboxText>
                </Checkbox>
              ))}
            </CheckboxContent1>
          </LeftContent>
        </Left>
        <Right>
          <RightContent>
            {res.map((group) => (
              <div key={group.date}>
                <DateComponent>
                  <p>{group.date}</p>
                </DateComponent>
                {group.transactions.map((transaction, index) => (
                  <RightContent key={index}>
                    <StockDetails>
                      <StockName>{transaction.stock_name}</StockName>
                      <StockSymbol>{transaction.stock_symbol}</StockSymbol>
                      <TransactionAmount>
                        {transaction.transaction_price}
                      </TransactionAmount>
                      <TimePart>
                        <Time>{formatTimestamp(transaction.timestamp)}</Time>
                        {transaction.status === "Passed" ? (
                          <PassedSymbol />
                        ) : (
                          <FailedSymbol />
                        )}
                      </TimePart>
                    </StockDetails>
                  </RightContent>
                ))}
              </div>
            ))}
          </RightContent>
        </Right>
      </Center>
    );
  }


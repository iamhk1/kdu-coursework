import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import { AppDispatch, RootState } from "../redux/Store";
import { useEffect, useState ,useRef} from "react";
import { useNavigate } from "react-router-dom";
import { addItem,resetData } from "../redux/StockStateSlice";
import { StockPrice } from "../Types/StockPrice";
import { io } from "socket.io-client";
import { EachStock } from "../Types/EachStock";
import { addToHistory, addToPortfolio, updatePrice,increasePrice,sellStock,addToAllHistory, resetAllHistory } from "../redux/UserSlice";
import { History } from "../Types/History";
import { AllHistory } from "../Types/AllHistory";
import { TransactionPortfolio } from "../Types/TransactionPortfolio";
import { addTransactionToPortfolio } from "../redux/PortfolioTransactions";

const AllComponents = styled.div`
  display: flex;
  padding: 20px 20px;
  gap: 5px;
`;
const LeftComponent = styled.div`
  width: 75%;
`;
const LeftTop = styled.div`
  display: flex;
  justify-content: space-between;
  
  padding: 10px 15px;
`;
const StockSymbol = styled.div`
  display: flex;
  align-items: center;
  border: 1px solid #000;
  padding: 2px 4px;
`;
const Price = styled.div`
  display: flex;
  align-items: center;
  border: 1px solid #000;
  padding: 2px 4px;
  gap: 15px;
  padding: 10px 20px;
`;
const Quantity = styled.div`
  display: flex;
  border: 1px solid #000;
`;
const InputQuantity = styled.input`
  width: 120px;
  padding: 8px 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 14px;
  outline: none;
  text-align: center;
`;

const Buttons = styled.div`
  display: flex;
  justify-content: space-between;
  gap: 3px;
`;

const Button1 = styled.button`
  color: #2f9e44;
  border: 1px solid #2f9e44;
  background-color: #b2f2bb;
  padding: 16px 20px;
  text-align: center;
  text-decoration: none;
  font-size: 16px;

  cursor: pointer;
`;

const Button2 = styled.button`
  background-color: #ffc9c9;
  border: 1px solid #e03131;
  color: #e03131;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  cursor: pointer;
`;

const LeftBottom = styled.div`
  width: 95%;
  border: 1px solid #000;
  overflow: hidden;
  position: relative;
  margin-left: 15px;
`;
const Box = styled.div`
  width: 20px;
  background-color: ${(props) => (props.positive ? "#b2f2bb" : "#ffc9c9")};
  border:1px solid ${(props) => (props.positive ? "#2f9e44" : "#e03131")};
  
`;

const Component = styled.div`
  position: absolute;
   bottom: 0;
   left: 0;
  display: flex;
  gap:2px;
  align-items: flex-end;
`;

const EntireGrid = styled.div`
  height: 500px;
  width: 100%;
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(100px, 1fr)); 
  grid-template-rows: repeat(7, 125px); 
  overflow: hidden; 
  
`;

const GridItem = styled.div`
  border: 0.1px dashed #706f6f;
`;
const RightComponent = styled.div`
  width: 25%;
  height: 475px;
  display: flex;
  flex-direction: column;
  gap: 10px;
`;

const History1 = styled.div`
  padding: 10px;
  border-radius: 4px;
  border: 1px solid #000;
  width: 100%;
  height: 50%;
  overflow-x: scroll;
`;
const Details = styled.div`
  padding: 10px;
  border-radius: 4px;
  border: 1px solid #000;
  width: 100%;
  height: 300px;
  overflow-y: scroll;
  p{
    font-size: 1.1rem;

  }
  h5{
    font-size: 1rem;
    margin-bottom: 10px;
  }
`;

const StyledSelect = styled.select`
  font-size: 13px;
  border: none;
  outline: none;
  background-color: transparent;
`;
const Logo = styled.div`
  border: 1px solid #f1930b;
  font-size: 15px;
  padding: 7px 7px;
  margin-right: 3px;
  background-color: #ffec99;
  color: #f1930b;
`;

const Amount = styled.h3`
  font-weight: 500;
  font-weight: 500;
  color: ${(props) => (props.priceIncreased ? "#2f9e44" : "#e03131")};
`;
const Arrow = styled.h3<{ priceIncreased: boolean }>`
  font-size: 20px;
  color: ${(props) => (props.priceIncreased ? "#2f9e44" : "#e03131")};
  content: ${(props) => (props.priceIncreased ? '"\u2191"' : '"\u2193"')};
`;
const EachHistory = styled.div`
  border: 1px solid #000;
  padding: 8px;
  border-radius: 10px;
  margin-top: 10px;
  display: flex;
  justify-content: space-between;
`;
const HistoryLeft = styled.div`
  display: flex;
  flex-direction: column;
  h2 {
    font-weight: 500;
    font-size: 18px;
  }
  h4 {
    font-weight: 500;
    font-size: 13px;
  }
`;
const HistoryRight = styled.div`
  display: flex;
  align-items: center;
  color: ${(props) => (props.isBuy ? 'green' : 'red')};
`;


export function Stock() {
  const [socket, setSocket] = useState();
  const navigate = useNavigate();
  const reduxDispatch: AppDispatch = useDispatch();
  const portfolio=useSelector((state:RootState)=>state.currentState.portfolioInfo);
  const stocks = useSelector((state: RootState) => state.stock.stocks);
  const stockData=useSelector((state:RootState)=>state.stockState.stockData);
  const history=useSelector((state:RootState)=>state.currentState.transactionHistory);
  const allHistory=useSelector((state:RootState)=>state.currentState.allHistory);
  const quantityRef = useRef<HTMLInputElement>(null);
  
  useEffect(() => {
    const socket = io("http://localhost:3000");
    setSocket(socket);
    socket.emit('joinRoom',{stockSymbol})
    socket.on('message',(message)=>{
     
    })
    reduxDispatch(resetAllHistory());
    socket.on('Transaction',(transactionData)=>{
      
      reduxDispatch(addToAllHistory(transactionData));
    })
    return () => {
      socket.disconnect();
    };
    
  }, [navigate]);

  const handleBuy = () => {
    const transaction: TransactionPortfolio = {
      stock_name:stock1.stock_name ,
      stock_symbol: stock1.stock_symbol,
      transaction_price: 0,
      timestamp: new Date().toISOString(),
      status: ""
    };
    const quantityString = quantityRef.current?.value || "";
    if (quantityString !== "") {
      const quantity = parseInt(quantityString, 10);
      
      const total = price * quantity;
      transaction.transaction_price=total;
      
      if (total > portfolio.amount) {
        transaction.status="Failed"
      }
      else {
        transaction.status="BUY";
        const addStock: EachStock = {
          stock_symbol: stock1.stock_symbol,
          stock_name: stock1.stock_name,
          price: price,
          quantity: quantity
        };
      const newHistory: History = {
        quantity: quantity,
        type: "BUY",
        date: new Date().toISOString().replace(/\.\d{3}/, '') + 'Z',
    };
    const historyItem: AllHistory = {
      stock_symbol: stock1.stock_symbol,
      stock_name: stock1.stock_name,
      price: price,
      quantity: quantity,
      type: "BUY",
      name: "John Doe"
  };
   
      socket.emit("NewTransaction",(historyItem));
      reduxDispatch(addToPortfolio(addStock));
      reduxDispatch(updatePrice(total));
      reduxDispatch(addToHistory(newHistory));
      }
    }
    
    reduxDispatch(addTransactionToPortfolio(transaction));
};
const handleSell = () => {
  const transaction: TransactionPortfolio = {
    stock_name:stock1.stock_name ,
    stock_symbol: stock1.stock_symbol,
    transaction_price: 0,
    timestamp:new Date().toISOString().replace(/\.\d{3}/, '') + 'Z',
    status: ""
  };
  const quantityString = quantityRef.current?.value || "";
  if (quantityString !== "") {
    const quantityToSell = parseInt(quantityString, 10);
    const totalamt=quantityToSell*price;
    transaction.transaction_price=totalamt;
    
    const stockToSell = portfolio.portfolio.stocks.find(
      (stock) => stock.stock_symbol === stock1.stock_symbol
    );
    if (stockToSell&&quantityToSell <= stockToSell.quantity) {
      transaction.status="SELL";
      const addStock: EachStock = {
        stock_symbol: stock1.stock_symbol,
        stock_name: stock1.stock_name,
        price: price,
        quantity: quantityToSell
    };
      const newHistory: History = {
              quantity: quantityToSell,
              type: "SELL",
              date: new Date().toString(),
          };
          const historyItem: AllHistory = {
            stock_symbol: stock1.stock_symbol,
            stock_name: stock1.stock_name,
            price: price,
            quantity: quantityToSell,
            type: "SELL",
            name: "John Doe"
        };
      socket.emit("NewTransaction",(historyItem));    
      reduxDispatch(sellStock(addStock));
      reduxDispatch(increasePrice(totalamt));
      reduxDispatch(addToHistory(newHistory));
    } else {
     
      transaction.status="FAILED";
    }
  }
  else{
    transaction.status="FAILED";
  }
  
  reduxDispatch(addTransactionToPortfolio(transaction));
};


  const handleStockChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    const selectedStock = event.target.value;
    const stock1 = stocks.filter(
      (stock) => stock.stock_symbol === selectedStock
    )[0];
    setPrice(stock1.base_price);
    setPrevPrice(stock1.base_price);
    reduxDispatch(resetData());
    navigate(`/stock-details/${selectedStock}`);
  };
  const urlParts = window.location.pathname.split("/");
  const stockSymbol = urlParts[urlParts.length - 1];

  const stock1 = stocks.filter(
    (stock) => stock.stock_symbol === stockSymbol
  )[0];
  const logoText = stock1 ? stock1.stock_name.slice(0, 3) : "";
  const [price, setPrice] = useState(stock1.base_price);
  const [prevPrice, setPrevPrice] = useState(stock1.base_price);

  function generateRandomPrice() {
    const randomNumber = Math.floor(Math.random() * 11);
    let newPrice: number;
    if (randomNumber <= 5) {
      const percentageChange = Math.floor(Math.random() * 12);
      newPrice = parseFloat((price * (1 + percentageChange / 100)).toFixed(2));
    } else {
      const percentageChange = Math.floor(Math.random() * 12);
      newPrice = parseFloat((price * (1 - percentageChange / 100)).toFixed(2));
    }
    const updatePrice: StockPrice = {
      price: newPrice, 
      positive: newPrice>=price
      };
    reduxDispatch(addItem(updatePrice));
    setPrevPrice(price);
    setPrice(newPrice);

  }

  useEffect(() => {
    const intervalId = setInterval(() => {
      generateRandomPrice();
    }, 5000);
    return () => clearInterval(intervalId);
  }, [price]);
  return (
    <AllComponents>
      <LeftComponent>
        <LeftTop>
          <StockSymbol>
            <Logo>{logoText}</Logo>
            <StyledSelect onChange={handleStockChange} value={stock1?.stock_symbol}>
  {stocks.map((stock) => (
    <option key={stock.stock_name} value={stock.stock_symbol}>
      {stock.stock_name}
    </option>
  ))}
</StyledSelect>
          </StockSymbol>
          <Price>
            <h3>Price</h3>
            <Amount priceIncreased={price > prevPrice}>{price}</Amount>
            <Arrow priceIncreased={price > prevPrice}>
              {price > prevPrice ? "\u2191" : "\u2193"}
            </Arrow>
            <h5>{(((price - prevPrice) / prevPrice) * 100).toFixed(2)}%</h5>
          </Price>
           <Quantity>
        <InputQuantity
          ref={quantityRef}
          placeholder="Enter Quantity"
        />
      </Quantity>
      <Buttons>
      <Button1 onClick={handleBuy} >
         BUY
      </Button1>
      <Button2 onClick={handleSell} >
          SELL
      </Button2>
      </Buttons>
        </LeftTop>
        <LeftBottom>
      <EntireGrid>
      {Array.from({ length: 40 }).map((_, index) => (
        <GridItem key={index}></GridItem>
      ))}
      </EntireGrid>
      <Component>
      {stockData.map((data, index) => (
        <Box
          key={index}
          style={{ height: `${data.price / 30}px` }}
          positive={data.positive}
        ></Box>
      ))}
    </Component>
    </LeftBottom>
      </LeftComponent>
      <RightComponent>
      <History1>
  <h3>History</h3>
  {history.map((transaction, index) => (
    <EachHistory key={index}>
      <HistoryLeft>
        <h2>{transaction.quantity} Stocks</h2>
        <h4>{transaction.date}</h4>
      </HistoryLeft>
      <HistoryRight isBuy={transaction.type === 'BUY'}>
  {transaction.type}
</HistoryRight>
    </EachHistory>
  ))}
</History1>
        <Details>
            {allHistory.map((historyItem, index) => (
                <div key={index}>
                    <p>{historyItem.name} {historyItem.type} {historyItem.quantity}  Share Of {historyItem.stock_name}</p>
                    <h5>{new Date().toLocaleString()}</h5>
                </div>
            ))}
        </Details>
      </RightComponent>
    </AllComponents>
  );
}
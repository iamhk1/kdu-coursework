import styled from "styled-components";
import Pagination from "@mui/material/Pagination";
import Stack from "@mui/material/Stack";
import {  useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { AppDispatch, RootState } from "../redux/Store";
import { toggleState } from "../redux/UserSlice";
import { Tab, Tabs } from "@mui/material";
import { toggleWishlist, addToWishlist, removeFromWishlist } from "../redux/StockSlice";
import { Link } from "react-router-dom";
const Content = styled.div`
  width: 100%;
  height: 80%;
  display: flex;
  align-items: center;
  justify-content: center;
`;

const Items = styled.div`
  width: 70%;
  height: 95%;
  border: 4px solid #979393;
  border-radius: 30px;
  position: relative;
`;

const PaginationContainer = styled.div`
  position: absolute;
  bottom: 10px;
  left: 30%;
  @media (max-width: 750px) {
    left: 10%;
  }
  @media (max-width: 500px) {
    left: 0;
  }
`;


const TableWrapper = styled.table`
  width: 100%;
  border-collapse: collapse;
`;

const Headings = styled.thead`
  th {
    text-align: left;
    padding: 8px 13px;
    border-bottom: 2px solid #979393;
  }
`;

const TableData = styled.td`
  padding: 12px;
  border-bottom: 1px solid #979393;
  @media (max-width: 500px) {
    padding: 13px;
  }
`;
const StyledImg = styled.img`
  height: 18px;
  width: 18px;
`;
const linkStyle = {
  textDecoration: "none",
  color: "inherit", 
};
export function Center() {
  const [page, setPage] = useState(1);
  const userState = useSelector(
    (state: RootState) => state.currentState.currentState
  );
  const watchlist = useSelector((state: RootState) => state.stock.watchlist);
  const stocks = useSelector((state: RootState) => state.stock.stocks);
  const reduxDispatch: AppDispatch = useDispatch();

  const [isHovered, setIsHovered] = useState(false);
  const handleMouseEnter = () => {
    setIsHovered(true);
  };

  const handleMouseLeave = () => {
    setIsHovered(false);
  };

  function handleChange(_event: React.SyntheticEvent, newValue: number) {
    reduxDispatch(toggleState(newValue));
    setPage(1);
  }

  function ChangeImgState(stockSymbol: string) {
    let curStock=stocks.filter((stock)=>stock.stock_symbol===stockSymbol)[0];
    
    reduxDispatch(toggleWishlist(stockSymbol));
    if(curStock.selected===false)
    reduxDispatch(addToWishlist(stockSymbol));
    else 
    reduxDispatch(removeFromWishlist(stockSymbol));
  }

  const itemsPerPage = 7;
  const startIndex = (page - 1) * itemsPerPage;
  const endIndex = startIndex + itemsPerPage;

  const handlePageChange = (
    event: React.ChangeEvent<unknown>,
    value: number
  ) => {
    setPage(value);
  };
  let data = userState === 1 ? stocks : watchlist;
  

  return (
    <>
      <Tabs
        value={userState}
        onChange={handleChange}
        aria-label="lab API tabs example"
      >
        <Tab label="Explore" value={1} />
        <Tab label="My WatchList" value={2} />
      </Tabs>
      <Content>
        <Items>
          <TableWrapper>
            <Headings>
              <tr>
                <th style={{ width: "70%" }}>Company</th>
                <th style={{ width: "15%" }}>Base Price</th>
                <th style={{ width: "15%" }}>Watchlist</th>
              </tr>
            </Headings>
            <tbody>
              {data.slice(startIndex,endIndex).map((item) => (
                <tr key={item.stock_symbol}>
                  <TableData> 
                  <Link to={`/stock-details/${item.stock_symbol}`} style={linkStyle}>
                    {item.stock_name}
                  </Link>
                  </TableData>
                  <TableData>{item.base_price}</TableData>
                  <TableData onClick={() => ChangeImgState(item.stock_symbol)}>
                    {item.selected ? (
                      <StyledImg
                        src={
                          isHovered
                            ? "../../images/remove.png"
                            : "../../images/check.png"
                        }
                        alt="Not Selected"
                        onMouseEnter={handleMouseEnter}
                        onMouseLeave={handleMouseLeave}
                      />
                    ) : (
                      <StyledImg
                        src="../../images/plus.png"
                        alt="Not Selected"
                      />
                    )}
                  </TableData>
                </tr>
              ))}
            </tbody>
          </TableWrapper>
          <PaginationContainer>
            <Stack spacing={1}>
              <Pagination
                count={Math.ceil(data.length / itemsPerPage)}
                color="primary"
                onChange={handlePageChange}
              />
            </Stack>
          </PaginationContainer>
        </Items>
      </Content>
    </>
  );
}

import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import { AppDispatch, RootState } from "./redux/Store";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { DatePicker } from "@mui/x-date-pickers/DatePicker";
import { Room } from "./Types/Rooms";
const Heading = styled.div`
  font-size: 2vw;
  text-align: center;
  padding: 20px 0px;
`;
const Center = styled.div`
  padding: 20px;
`;
const Content = styled.div`
  width: 100%;
  background-color: #f08a5d;
  h4 {
    font-size: 18px;
    font-weight: 500;
    color: #fff;
    padding: 10px 5px;
  }
`;
const Buttons = styled.div`
  display: flex;
  gap: 2vw;
  margin-top: 10px;
  button {
    padding: 2vw 5vw;
  }
`;
const Dates = styled.div`
  display: flex;
  gap: 4vw;
  margin-top: 10px;
`;

export function Info() {
  const reduxDispatch: AppDispatch = useDispatch();
  const activeBtn = useSelector(
    (state: RootState) => state.product.activeButton
  );
  console.log(activeBtn);
  const items = useSelector((state: RootState) => state.product.items);
  const data: Room = items.filter((item) => item.name == activeBtn)[0];
  console.log(data);

  function selectChannel(event: any) {
    console.log(event.target.innerHTML);
    const btn = event.target.innerHTML;
    if (activeBtn !== btn) {
      reduxDispatch(btn);
    }
  }
  return (
    <>
      <Heading>Hotel Booking</Heading>
      <Center>
        <Content>
          <h4>Select Room Type</h4>
        </Content>
        <Buttons>
          <button onClick={selectChannel}>Single Room</button>
          <button onClick={selectChannel}>Twin Room</button>
          <button onClick={selectChannel}>Deluxe</button>
          <button onClick={selectChannel}>Presidential Suite</button>
        </Buttons>
      </Center>
      <Center>
        <Content>
          <h4>Select Date</h4>
        </Content>
        <Dates>
          <LocalizationProvider dateAdapter={AdapterDayjs}>
            <DatePicker />
          </LocalizationProvider>
          <LocalizationProvider dateAdapter={AdapterDayjs}>
            <DatePicker />
          </LocalizationProvider>
        </Dates>
      </Center>
      <>
        <Buttons>
          <button>Sumbit</button>
        </Buttons>
      </>
    </>
  );
}



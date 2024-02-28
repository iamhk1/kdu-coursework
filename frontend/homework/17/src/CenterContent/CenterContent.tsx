import { Product } from "../Types/Types";
import { useSelector } from "react-redux";
import { RootState } from "../redux/Store";
import { Link } from "react-router-dom";
import ClipLoader from "react-spinners/ClipLoader";
import "react-toastify/dist/ReactToastify.css";
const centerdiv: React.CSSProperties = {
  width: "100%",
  display: "flex",
  padding: "0px 0px 0px 50px",
  flexWrap: "wrap",
};
const eachItem = {
  width: "20%",
  backgroundColor: "#fff",
  margin: "0 4vw 4vw 0",
  marginBottom: "30px",
};
const img = {
  height: "150px",
  width: "70%",
};
const imgPart = {
  display: "flex",
  alignItems: "center",
  justifyContent: "center",
};
const linkStyle = {
  textDecoration: "none",
  color: "#000",
};
const aboutstyle = {
  height: "fit-content",
  display: "flex",
  alignItems: "center",
  padding: "0px 5px",
  gap: "5px",
  justifyContent: "space-between",
  marginTop: "10px",
};
const loader: React.CSSProperties = {
  position: "absolute",
  left: "50%",
  top: "50%",
};
const priceStyle = {
  color: "#666598",
};
export function CenterContent() {
  const searchItem = useSelector(
    (state: RootState) => state.product.searchedItems
  );
  const state = useSelector((state: RootState) => state.product.state);
  if (state === "pending") {
    return (
      <div style={loader}>
        <ClipLoader color="#A9A9A9" size={150} />
      </div>
    );
  }
  return (
    <div className="Center" style={centerdiv}>
      {searchItem.map((product: Product) => (
        <div className="eachdiv" style={eachItem} key={product.id}>
          <Link style={linkStyle} to={`/product/${product.id}`}>
            <div className="image" style={imgPart}>
              <img style={img} src={product.image} alt={product.title} />
            </div>
            <div className="about" style={aboutstyle}>
              <div className="name">
                <h4>{product.title}</h4>
              </div>
              <div className="price">
                <h3 style={priceStyle}>${product.price}</h3>
              </div>
            </div>
          </Link>
        </div>
      ))}
    </div>
  );
}


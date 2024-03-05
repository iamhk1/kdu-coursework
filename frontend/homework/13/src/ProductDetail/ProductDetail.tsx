import { useContext } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { ThemeContext } from "../App";
const heading :React.CSSProperties={
    fontSize:"30px",
    marginTop:'30px',
    marginBottom:'30px',
    wordWrap: 'break-word',
    textAlign:'center',
    color:"#666598",
    fontWeight:'600'

}
const hh2={
    fontWeight:'500',
    fontSize:'20px'
}
const hh3={
    fontWeight:'500',
    fontSize:'20px',
    color:'grey'
}
const price={
    fontWeight:'500',
    fontSize:'20px',
    color:"#666598"
}
const image={
    height:'300px',
    width:'200px'

}
const center={
    padding:'10px 30px',
    display:'flex',
    justifyContent:'space-between'
    
}
const left={
    width:'45%',
    display:'flex',
    alignItems:'center',
    justifyContent:'center'

}
const right :React.CSSProperties={
    width:'45%',
    display:'flex',
    flexDirection:'column',
    gap:'15px'
}
const button={
    padding:'10px 20px',
    width:'fit-content',
    backgroundColor:'transparent',
    border:'1px solid #1B98E8',
    color:'#1B98E8'

}
export function ProductDetail() {
    const navigate = useNavigate();
    const { id } = useParams(); 
    const { allproducts } = useContext(ThemeContext);
    const product = allproducts.find((product) => product.id === parseInt(id!));
  
    if (!product) {
      return <div>Product not found</div>;
    }
    const toProducts = () => {
        navigate("/"); 
      };
    return(
    <div>
    <h1 style={heading}>{product.title}</h1>
    <div className="center" style={center}>
        <div className="left" style={left}>
        <img style={image} src={product.image} alt={product.title} />
        </div>
        <div className="right" style={right}>
            <h2 style={hh2}>Model: {product.title}</h2>
            <h3 style={hh3}>Category: {product.category}</h3>
            <h3 style={price}>Price:$ {product.price}</h3>
            <p style={hh2}>Product Description:</p>
            <p>{product.description}</p>
            <button style={button} onClick={toProducts}>Back To Products</button>
        </div>
    </div>
  </div>
    )
}
const heading={
    fontSize:"30px",
    color:"#666598"
}
const spanstyle={
    color:'#000',
    marginRight:'6px'
}
const center:React.CSSProperties={
    textAlign:'center',
    margin:'20px 0px',
}


import React from 'react';

export function CenterHeading() {
  const currentUrl = window.location.pathname; 
  
  if (currentUrl === '/') {
    return (
      <div className="centerheading" style={center}>
        <h1 style={heading}><span style={spanstyle}>KDU</span>Marketplace</h1>
      </div>
    );
  } else {
    return null;
  }
}

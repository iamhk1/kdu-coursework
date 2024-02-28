import React, { useEffect } from "react";
import { useSelector } from "react-redux";
import { ToastContainer, toast } from "react-toastify";
import { RootState } from "../redux/Store";
const heading = {
  fontSize: "30px",
  color: "#666598",
};
const spanstyle = {
  color: "#000",
  marginRight: "6px",
};
const center: React.CSSProperties = {
  textAlign: "center",
  margin: "20px 0px",
};



export function CenterHeading() {
  const currentUrl = window.location.pathname;
  const state = useSelector((state: RootState) => state.product.state);
  useEffect(() => {
  if (state === "fulfilled") {
    toast.success("Success", {
      position: "top-center",
    });
  }

  if (state === "rejected") {
    toast.error("Error", {
      position: "top-center",
    });
  }
}, [state]);
  if (currentUrl === "/") {
    return (
       
      <div className="centerheading" style={center}>
        <ToastContainer />
        <h1 style={heading}>
          <span style={spanstyle}>KDU</span>Marketplace
        </h1>
      </div>
    );
  } else {
    return null;
  }
}

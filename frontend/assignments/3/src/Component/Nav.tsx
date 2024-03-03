import { useState } from "react";
import { Link } from "react-router-dom";
import styled from "styled-components";

const Img = styled.img`
  height: 25px;
  width: 30px;
  object-fit: contain;
`;

const Left = styled.div`
  display: flex;
  align-items: center;
  gap: 1.4vw;
`;

const NavStyle = styled.div`
  padding: 10px 20px;
  display: flex;
  justify-content: space-between;
  background-color: #1971c2;
  position: relative;
  /* height: 500px; */
`;

const Summarizer = styled.div``;

const Heading3 = styled.h3`
  color: #fff;
  font-size: 1.2rem;
`;
const Portfolio = styled.div`
 
`;
const StyledLink = styled(Link)`
  text-decoration: none;
  color: inherit;
`;
const Right = styled.div`
  display: flex;
  gap: 1.4vw;

  @media (max-width: 600px) {
    display: none;
  }
`;

const RightCopy = styled.div`
  position: absolute;
  top: calc(100%);
  right: 0;
  background-color: #a19c9c;
  padding: 10px;
  z-index: 1000;
  h3 {
    font-size: 0.8rem;
    color: #fff;
  }
`;

const Hamburger = styled.div`
  display: none;
  cursor: pointer;

  @media (max-width: 600px) {
    display: block;
  }
`;

export function Nav() {
  const [isRightCopyOpen, setIsRightCopyOpen] = useState(false);

  const toggleRightCopy = () => {
    setIsRightCopyOpen(!isRightCopyOpen);
  };

  return (
    <NavStyle>
      <Left>
        <Link to="/">
          <Img src="../../images/graph.png" />
        </Link>
        <Heading3>KDU Stock Market</Heading3>
      </Left>
      <Hamburger onClick={toggleRightCopy}>&#9776;</Hamburger>
      <Right>
        <Summarizer>
          <Heading3>Summarizer</Heading3>
        </Summarizer>
        <Portfolio>
          <Heading3>
            <StyledLink to="/portfolio">My Portfolio</StyledLink>
          </Heading3>
        </Portfolio>
      </Right>
      {isRightCopyOpen && (
        <RightCopy>
          <Summarizer>
            <Heading3>Summarizer</Heading3>
          </Summarizer>
          <Portfolio>
            <Heading3>
              <StyledLink to="/portfolio">My Portfolio</StyledLink>
            </Heading3>
          </Portfolio>
        </RightCopy>
      )}
    </NavStyle>
  );
}

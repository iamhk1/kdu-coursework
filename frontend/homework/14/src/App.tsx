import "./App.css"
import  { useState, useRef, useEffect } from 'react';
const input={
  marginBottom:'50px',
  height:'50px'
}
const h1={
  fontSize:"50px",
}
const mg={
  marginBottom:'200px'
}
export default function App() {
  const [now, setNow] = useState(0);
  const value=useRef(0);
  const intervalRef = useRef<number | null>(null);
  const inputRef = useRef<HTMLInputElement>(null); 
  const scrollTopRef = useRef<HTMLButtonElement>(null);
  useEffect(() => {
    inputRef.current!.focus()
    value.current=value.current+3;
    console.log(value,"from use effect");
  }, []);
  function handleStart() {
    setNow(0);
    value.current=value.current+2;
    value.current=value.current+2;
    console.log(value)
    clearInterval(intervalRef.current!);
    intervalRef.current = setInterval(() => {
      setNow(now => now + 1);
    }, 1000);
  }
  function scrollToTop() {
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }

  function handleStop() {
    clearInterval(intervalRef.current!);
  }

  return (
    <>
      <h1 style={h1}>Time passed: {now}</h1>
      <button onClick={handleStart}>Start</button>
      <button style={mg}onClick={handleStop}>Stop</button>
      <br></br>
      <input style={input} ref={inputRef} />
      <br />
      <input  style={input}/>
      <br />
      <input style={input}/>
      <br />
      <button ref={scrollTopRef} className="scrolltop" onClick={scrollToTop}>Scroll To Top</button>
    </>
  );
}
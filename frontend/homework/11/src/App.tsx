import React, { useEffect, useState } from 'react';
import './App.scss';
import { ApiQuote } from './Types/quotes.types';
import {Quote}from "./Quote/Quote"
import ClipLoader from "react-spinners/ClipLoader";
function App() {
  let [loading, setLoading] = useState(false);
  const[allQuotes,setAllQuotes]=useState<ApiQuote[]>(
    []
    )
  const [quotes,setQuotes]=useState<ApiQuote[]>(
    []
  )
  
  const [filters,setFilter]=useState<string[]>(
    []
  )
  useEffect(() => {
    if (filters.length === 0) {
      setQuotes(allQuotes);
    } else {
      const filteredQuotes = allQuotes.filter(quote => {
        const quoteTagsLower = quote.tags.map(tag => tag.toLowerCase());
        return filters.some(filter => quoteTagsLower.includes(filter.toLowerCase()));
      });
      console.log(filteredQuotes);
      setQuotes(filteredQuotes);
    }
  }, [filters, allQuotes]);

  useEffect(()=>{
    
    fetch("https://api.quotable.io/quotes/random?limit=3")
    .then((response)=>response.json())
    .then((data:ApiQuote[])=>{
      console.log("data",data)
      setAllQuotes(data);
      setQuotes(data);
      
    })
  },[]);
  function deleteFilter(filterName:string)
  {
    console.log("delete called",filterName);
    setFilter(filters.filter((item)=>item !== filterName))

  }
  function newQuote() {
    setLoading(true)
    fetch("https://api.quotable.io/quotes/random")
      .then((response) => response.json())
      .then((data: ApiQuote[]) => {
        console.log("data", data);
        setAllQuotes(prevAllQuotes => [...data, ...prevAllQuotes]);
        setQuotes(prevQuotes => [...data, ...prevQuotes]);
        setLoading(false)
      });
  }

  return (
   <div className="main">
    <div className="content">
    <div className='new-quote' onClick={newQuote}>
      <h3>New Quote<ClipLoader
        loading={loading}
      /></h3>
    </div>
    <div className="filters">
      <h5>Filters</h5>
      <div className="all-filters">
      {filters.map((filter, index) => (
        <p key={index}>
          {filter} <span onClick={() => deleteFilter(filter)}>X</span>
        </p>
      ))}
    </div>
    </div>
   <div className="all-quotes">
    {
      quotes.map((quote)=>{
        return (<Quote key={quote._id} quote={quote} filters={filters} setFilter={setFilter}/>)
       })
    }
   </div>
   </div>
   </div>
  );
}

export default App;

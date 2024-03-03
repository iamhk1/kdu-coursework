import{ApiQuote}from "../Types/quotes.types"
interface QuoteProps{
    quote:ApiQuote,
    filters:string[],
    setFilter:React.Dispatch<React.SetStateAction<string[]>>;
}
export  function Quote({quote,filters,setFilter}:Readonly<QuoteProps>) {
  function addFilter(event:React.MouseEvent<HTMLParagraphElement>)
  {
    const clickedTag = event.currentTarget.textContent;
    console.log(clickedTag,typeof(clickedTag));
    if(clickedTag!=null &&!filters.includes(clickedTag))
    {
      setFilter(prevFilters => [...prevFilters, clickedTag]);
    }
  }
  return (
    <div className="each-quote">
    <div className="quote">
      <h2>{quote.content}</h2>
    </div>
    <div className="author">
      <p>{quote.author}</p>
      <p className='date'>{quote.dateAdded}</p>
    </div>
    <div className="filters">
      {quote.tags.map((tag, index) => (
        <p key={index} onClick={addFilter}>{tag}</p>
      ))}
    </div>
  </div>
  )
}

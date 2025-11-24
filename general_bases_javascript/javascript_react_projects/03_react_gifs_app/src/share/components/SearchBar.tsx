import { useState, type KeyboardEvent } from "react"

interface Props {
    placeholder_search:string
    onQuery: (query:string) => void
}

export const SearchBar = ({placeholder_search = "Buscar", onQuery}:Props) => {
  const [query, setQuery] = useState('');

  const handleSearch = () => {
    onQuery(query);
    setQuery('')
  }

  const handleKeyDown = (event: KeyboardEvent<HTMLInputElement>) => {
        if(event.key === 'Enter') {
            handleSearch()
        }
  }

  return (
    <div className="search-container">
        <input 
            type="text" 
            placeholder={placeholder_search} 
            value={query} 
            onChange={(event) => setQuery(event.target.value)}
            onKeyDown={handleKeyDown}
         />
        <button onClick={handleSearch}>Buscar</button>
    </div>
  )
}

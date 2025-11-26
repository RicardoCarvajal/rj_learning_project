import { useEffect, useState, type KeyboardEvent } from "react"

interface Props {
    placeholder_search:string;
    onQuery: (query:string) => void;
}

export const SearchBar = ({placeholder_search = "Buscar", onQuery}:Props) => {
  const [query, setQuery] = useState('');

  useEffect(() => {// el useEffect se usa cuando se monta el componente
    const timeoutId = setTimeout(() => {
      onQuery(query)
    },700)
  return  () => { //El return se ejecuta cuando el componente se desmonta
      clearTimeout(timeoutId)
    }
  },[query,onQuery])

  const handleSearch = () => {
      onQuery(query);    
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

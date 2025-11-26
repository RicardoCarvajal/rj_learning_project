import { useState } from "react"
import { GifList } from "./gifs/GifList"
import { PreviousSearches } from "./gifs/PreviousSearches"
import { mockGifs } from "./mock-data/gifs.mock"
import { CustomHeader } from "./share/components/CustomHeader"
import { SearchBar } from "./share/components/SearchBar"
import { getGifsByQuery } from "./gifs/actions/get-gifs-by-query.action"

export const GifsApp = () => {
    const [previousTerms, setPreviousTerms] = useState(["superman"])
    
    const handleTermClicked = (term:string)=>{
        console.log(`Click in ${term}`)
    }
    const handleSearch = async (query:string) => {
        query = query.trim().toLowerCase()
        console.log(previousTerms)
        if (query === '') return
        if(previousTerms.includes(query)) return 
        setPreviousTerms([query, ...previousTerms.slice(0,8)])
        const gifs = await getGifsByQuery(query)
        console.log(gifs)
    }
    return (
        <>
            <CustomHeader title="Mis Gifs" description="Los mejores gifs del mundo mundial"/>
            <SearchBar placeholder_search="Busca los mejores gifs" onQuery={handleSearch}/>
            <PreviousSearches searches={previousTerms} onLabelClicked={handleTermClicked}/>
            <GifList gifs={mockGifs}/>
        </>
    )
}


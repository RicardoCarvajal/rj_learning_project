import { useState } from "react"
import { GifList } from "./gifs/GifList"
import { PreviousSearches } from "./gifs/PreviousSearches"
import { mockGifs } from "./mock-data/gifs.mock"
import { CustomHeader } from "./share/components/CustomHeader"
import { SearchBar } from "./share/components/SearchBar"

export const GifsApp = () => {
    const [previousTerms, setPreviousTerms] = useState(["Superman"])
    const handleTermClicked = (term:string)=>{
        console.log(`Click in ${term}`)
    }
    const handleSearch = (query:string) => {
        console.log(query)
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


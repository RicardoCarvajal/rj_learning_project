import { useState } from "react"
import { GifList } from "./gifs/GifList"
import { PreviousSearches } from "./gifs/PreviousSearches"
import { CustomHeader } from "./share/components/CustomHeader"
import { SearchBar } from "./share/components/SearchBar"
import { getGifsByQuery } from "./gifs/actions/get-gifs-by-query.action"
import type { Gif } from "./gifs/actions/gif.interface"

export const GifsApp = () => {
    const [previousTerms, setPreviousTerms] = useState<string[]>([])

    const [gifs, setGifs] = useState<Gif[]>([])

    const handleTermClicked = (term: string) => {
        console.log(`Click in ${term}`)
    }

    const handleSearch = async (query: string) => {
        query = query.trim().toLowerCase()
        if (query === '') return
        if (previousTerms.includes(query)) return
        setPreviousTerms([query, ...previousTerms.slice(0, 8)])
        const gifs_for_api = await getGifsByQuery(query)
        setGifs(gifs_for_api)
    }

    return (
        <>
            <CustomHeader title="Buscador de Gifs" description="Los mejores gifs del mundo mundial" />
            <SearchBar placeholder_search="Busca los mejores gifs" onQuery={handleSearch} />
            <PreviousSearches searches={previousTerms} onLabelClicked={handleTermClicked} />
            <GifList gifs={gifs} />
        </>
    )
}


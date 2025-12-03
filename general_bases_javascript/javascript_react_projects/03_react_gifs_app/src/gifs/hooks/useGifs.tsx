import { useState, useRef } from "react"
import { getGifsByQuery } from "../actions/get-gifs-by-query.action"
import type { Gif } from "../actions/gif.interface"

// const gifsCache: Record<string,Gif[]> = {}

export const useGifs = () =>{

    const [previousTerms, setPreviousTerms] = useState<string[]>([])

    const [gifs, setGifs] = useState<Gif[]>([])

    const gifsCache = useRef<Record<string,Gif[]>>({})

    const handleTermClicked = async (term: string) => {
        if(gifsCache.current[term]){
            setGifs(gifsCache.current[term])
            return
        }
        const gifs_for_api = await getGifsByQuery(term)
        setGifs(gifs_for_api)       
    }

    const handleSearch = async (query: string) => {
        query = query.trim().toLowerCase()
        if (query === '') return
        if (previousTerms.includes(query)) return
        setPreviousTerms([query, ...previousTerms.slice(0, 8)])
        const gifs_for_api = await getGifsByQuery(query)
        setGifs(gifs_for_api)
        gifsCache.current[query] = gifs_for_api;
        console.log(gifsCache)
    }

    return {
        previousTerms,
        gifs,
        handleSearch,
        handleTermClicked,
    }
}
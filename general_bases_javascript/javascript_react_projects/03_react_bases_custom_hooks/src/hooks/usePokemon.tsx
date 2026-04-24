import { useState, useEffect } from 'react'

interface Pokemon {
    id: number
    name: string
    imageUrl: string
}


interface Props {
    id: number
}

export const usePokemon = ({ id }: Props) => {

    const [pokemon, setPokemon] = useState<Pokemon | null>(null)
    const [isLoading, setIsLoading] = useState(true)

    const getPokemontByID = async (id: number) => {
        setIsLoading(true)
        const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${id}`)
        const data = await response.json()

        setPokemon({
            id: id,
            name: data.name,
            imageUrl: `https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png`
        })
        setIsLoading(false)
    }


    useEffect(() => {
        getPokemontByID(id)
    }, [id])




    return {
        //props
        isLoading,
        pokemon,
        //computed
        formattedId: id.toString().padStart(3, '0')
        //methods
    }
}

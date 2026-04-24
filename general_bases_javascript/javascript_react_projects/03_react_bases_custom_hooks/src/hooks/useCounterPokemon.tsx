import { useState } from "react"

export const useCounterPokemon = (defaultNumber: number = 1) => {

    const [counter, setCounter] = useState(defaultNumber)

    const increment = () => {
        setCounter(counter + 1)
    }

    const decrement = () => {
        if (counter <= 1) return

        setCounter(counter - 1)
    }

    return {
        //props
        counter,
        //methods
        increment,
        decrement
    }


}
import { useState, type CSSProperties } from "react"
import './ItemCounter.css'

// const style_section: CSSProperties = {
//     display: 'flex',
//     alignItems: 'center',
//     gap: 10,
//     marginTop: 10,
// }

// const style_span: CSSProperties = {
//     width: 160
// }

interface Props {
    nameProduct: string;
    quantity?: number;
}

export function ItemCounter({ nameProduct, quantity = 1 }: Props) {
    //Los hooks siempre van al inicio del componente

    const [count, setCount] = useState(quantity)

    const handlerClick = () => console.log(`Click en ${nameProduct}`)

    const hadlerAdd = () => {
        handlerClick()
        setCount(count + 1)
    }
    const hadlerSubtract = () => {
        handlerClick()
        if (count === 1) return;
        setCount(count - 1)
    }


    return (
        <section className="item-select">
            <span className="text-item" style={
                {
                    color: count === 1 ? 'red' : 'black'
                }
            }> {nameProduct} </span>
            <button onClick={hadlerAdd}>+1</button>
            <span> {count} </span>
            <button onClick={hadlerSubtract}>-1</button>
        </section>
    )
}
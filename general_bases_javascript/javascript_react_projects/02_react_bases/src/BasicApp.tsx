import { ItemCounter } from "./shopping-cart/Itemcouter";

interface ItemIncart {
    name: string;
    qty: number;
}

const itemsIncart: ItemIncart[] = [
    { name: 'Caraotas negras P/U', qty: 1 },
    { name: 'Frijoles P/U', qty: 2 },
    { name: 'Queso duro por Kg', qty: 3 },
    { name: 'Atun enlatado 100g', qty: 4 },
]

export function BasicApp() {
    return (
        <>
            <h1>Aplicacion Basica</h1>
            <p>Bienvenidos a las bases de React !!</p>

            {itemsIncart.map(({ name, qty }) => {
                return <ItemCounter key={name} nameProduct={name} quantity={qty} />
            })}

            {/* <ItemCounter nameProduct='Caraotas negras P/U' quantity={1} />
            <ItemCounter nameProduct='Frijoles P/U' quantity={1} />
            <ItemCounter nameProduct='queso por Kg' quantity={1} /> */}
        </>
    )
}
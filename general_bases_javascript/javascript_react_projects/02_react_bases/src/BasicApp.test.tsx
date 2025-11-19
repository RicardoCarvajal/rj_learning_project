import { render,screen } from "@testing-library/react";
import { beforeEach, describe, expect, test, vi } from "vitest";
import { BasicApp } from "./BasicApp";
import { ItemCounter } from "./shopping-cart/Itemcouter";

const mockItemCounter = vi.fn( (props:unknown) => {
    return (
        <div data-testid='ItemCounter' name={props.nameProduct} qty= {props.quantity} />
    )
})

vi.mock('./shopping-cart/Itemcouter',()=>({
    ItemCounter: (props: unknown) => mockItemCounter(props)
}))

/*
vi.mock('./shopping-cart/Itemcouter', ()=>({
    ItemCounter: (props: unknown) => <div data-testid='ItemCounter' name={props.nameProduct} qty= {props.quantity} />
}))
*/

describe('BasicApp',() => {

    beforeEach(() => {
        vi.clearAllMocks()
    })


    test('Should match snapshot', () =>{ 
        const {container} = render(<BasicApp />)
        expect(container).toMatchSnapshot()
    })
    test('Should render to correct number of ItemCounter components',()=>{
        render(<BasicApp />)

        const itemCounters = screen.getAllByTestId('ItemCounter')

        expect(itemCounters.length).toBe(4)    
    })
    test('Should render itemCounter with correct props', () =>{
        render(<BasicApp/>)
        expect(mockItemCounter).toHaveBeenCalledTimes(4)
        expect(mockItemCounter).toHaveBeenCalledWith({nameProduct: 'Caraotas negras P/U', quantity: 1 })
    })
})
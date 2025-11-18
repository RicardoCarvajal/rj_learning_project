import { fireEvent, render, screen } from "@testing-library/react";
import { describe, expect, test } from "vitest";
import { ItemCounter } from "./Itemcouter";

describe('Itemcouter', () => {
    test('Should render with default values', () => {

        const nameItem = 'Item'

        render(<ItemCounter nameProduct={nameItem} />)

        expect(screen.getByText(nameItem)).toBeDefined()
        expect(screen.getByText(nameItem)).not.toBeNull()

    })
    test('Should render with default values', () => {
        const nameItem = 'Item'
        const qty = 10

        render(<ItemCounter nameProduct={nameItem} quantity={qty} />)

        expect(screen.getByText(qty)).toBeDefined()

    })
    test('Should increase count when +1 button is pressed', () => {

        render(<ItemCounter nameProduct='Item' quantity={10} />)

        const [buttonAdd] = screen.getAllByRole('button')

        fireEvent.click(buttonAdd)

        expect(screen.getByText(11)).toBeDefined()


    })
    test('Should increase count when -1 button is pressed', () => {

        render(<ItemCounter nameProduct='Item' quantity={5} />)

        const [, buttonSubstrac] = screen.getAllByRole('button')

        fireEvent.click(buttonSubstrac)

        expect(screen.getByText(4)).toBeDefined()


    })
    test('Should increase count when -1 button is pressed and quantity is 1', () => {

        render(<ItemCounter nameProduct='Item' quantity={1} />)

        const [, buttonSubstrac] = screen.getAllByRole('button')

        fireEvent.click(buttonSubstrac)

        expect(screen.getByText(1)).toBeDefined()


    })
    test('Should change to red when count is 1', () => {
        const nameItem = 'Item'

        render(<ItemCounter nameProduct={nameItem} quantity={1} />)

        const itemtext = screen.getByText(nameItem)

        expect(itemtext.style.color).toBe('red')


    })
    test('Should change to black when count is greater than 1', () => {
        const nameItem = 'Item'

        render(<ItemCounter nameProduct={nameItem} quantity={1} />)

        const [buttonAdd] = screen.getAllByRole('button')

        fireEvent.click(buttonAdd)

        const itemtext = screen.getByText(nameItem)

        expect(itemtext.style.color).toBe('black')

    })
})

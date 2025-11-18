import { describe, expect, test } from 'vitest'
import { add, subtrac, multiply } from './math.helper'

describe('add', () => {
    test('Should add two positives numbers', () => {
        //!1 Arrange o preparacion
        const a = 1
        const b = 2

        //!2 Act o aplicar estimulos
        const result = add(a, b)

        //!3 Asset asercion
        expect(result).toBe(a + b)
    })
})

describe('subtrac', () => {
    test('Should subtrac two positives numbers', () => {
        //!1 Arrange o preparacion
        const a = 1
        const b = 2

        //!2 Act o aplicar estimulos
        const result = subtrac(a, b)

        //!3 Asset asercion
        expect(result).toBe(a - b)
    })
})

describe('multiply', () => {
    test('Should multiply two positives numbers', () => {
        //!1 Arrange o preparacion
        const a = 1
        const b = 2

        //!2 Act o aplicar estimulos
        const result = multiply(a, b)

        //!3 Asset asercion
        expect(result).toBe(a * b)
    })
})
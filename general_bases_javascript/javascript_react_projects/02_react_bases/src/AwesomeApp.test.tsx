import { describe, expect, test } from "vitest";
import { render, screen } from '@testing-library/react'
import { AwesomeApp } from "./AwesomeApp";

describe('AwesomeApp', () => {
    test('Should render fullname and last name with conteiner', () => {
        //Modulo que queremos probar
        //Por desestructuracion podemos acceder a la variable conteiner con la cual podemos hacer manipulacion acceso tradicional al DOM de javascript 
        const { container } = render(<AwesomeApp />)

        const h1 = container.querySelector('h1')?.innerHTML // con querySelector buscamos el primer h1 que se consiga y con innerHTML obtenemos el contenido
        const h3 = container.querySelector('h3')?.innerHTML

        expect(h1).toContain('Ricardo José')// Podemos usar toContain para ver si contiene la palabra sin importar el resto del String como por ejemplo que tenga espacios en blanco
        expect(h3).toContain('Carvajal')
    })
    test('Should render fullname and last name with conteiner', () => {
        //Modulo que queremos probar
        render(<AwesomeApp />)

        //Renderizando HTML en un DOM virtual para analizar lo que se renderizo
        //Con el screen pueden probar eventos consa que no se puede hacer con conteiner
        screen.debug()
        const h1 = screen.getByTestId('fullname')

        expect(h1.innerHTML).toContain('Ricardo José')// Podemos usar toContain para ver si contiene la palabra sin importar el resto del String como por ejemplo que tenga espacios en blanco
    })
    test('should match snapshot', () => {
        const { container } = render(<AwesomeApp />)
        expect(container).toMatchSnapshot()//Toma una fotografia del renderizado
    })
})
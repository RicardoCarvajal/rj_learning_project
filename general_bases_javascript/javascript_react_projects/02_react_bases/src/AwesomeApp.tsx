//! Los valores booleanos no representan nada en react si se pueden usar para ejecutar logica en condiciones pero no para presentarlos en pantalla
//! Los objetos no se pueden presentar en react, para hacerlo debemos usar JSON.stringify
//! los valores constantes se aconseja que esten fuera de los componetes de react para que no formen parte del ciclo de revicion y ejecucion de react

import type { CSSProperties } from "react"

const firstName = 'Ricardo'
const secondName = 'José'
const lastName = 'Carvajal'

const favoritePersons = ['Emily', 'Emma', 'Mama']

const isActive = true

const address = { country: 'Venezuela', zipCode: 2001 }

const style_app: CSSProperties = {
    backgroundColor: isActive ? '#f2efff' : '#fafafa',
    borderRadius: 20,
    padding: 10,
}

export function AwesomeApp() {

    return (
        <div>
            <h1 data-testid='fullname'> {firstName} {secondName} </h1>
            <h3 className='superClass'> {lastName} </h3>
            <p> {favoritePersons.join(', ')} </p>
            <h2> {isActive ? 'Activo' : 'No activo'} </h2>
            <p style={style_app}> {JSON.stringify(address)} </p>
        </div >
    )
}
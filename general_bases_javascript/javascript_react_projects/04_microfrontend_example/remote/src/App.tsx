import RemoteButton from './RemoteButton'

export default function App() {
    return (
        <div className="app">
            <h1>Remote App</h1>
            <p>Este es el microfrontend remoto, expuesto como un componente independiente.</p>
            <RemoteButton />
        </div>
    )
}

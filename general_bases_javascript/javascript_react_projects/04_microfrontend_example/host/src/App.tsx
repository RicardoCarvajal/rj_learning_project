import { Suspense, lazy } from 'react'

const RemoteButton = lazy(() => import('remote/Button'))

export default function App() {
    return (
        <div className="app">
            <h1>Host App</h1>
            <p>Este es el shell que consume un componente remoto desde el microfrontend.</p>
            <Suspense fallback={<div>Cargando microfrontend remoto...</div>}>
                <RemoteButton />
            </Suspense>
        </div>
    )
}

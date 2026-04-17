import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import federation from '@originjs/vite-plugin-federation'

export default defineConfig({
    plugins: [
        react(),
        federation({
            remotes: {
                remote: 'http://localhost:4173/assets/remoteEntry.js'
            },
            shared: ['react', 'react-dom']
        })
    ],
    server: {
        host: 'localhost',
        port: 4174,
        strictPort: true
    },
    build: {
        target: 'esnext'
    }
})

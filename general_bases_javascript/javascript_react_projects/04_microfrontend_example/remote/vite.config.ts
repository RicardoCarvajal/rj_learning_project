import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import federation from '@originjs/vite-plugin-federation'

export default defineConfig({
    plugins: [
        react(),
        federation({
            name: 'remote',
            filename: 'remoteEntry.js',
            exposes: {
                './Button': './src/RemoteButton.tsx'
            },
            shared: ['react', 'react-dom']
        })
    ],
    server: {
        host: 'localhost',
        port: 4173,
        strictPort: true,
        cors: true,
        headers: {
            'Access-Control-Allow-Origin': '*'
        }
    },
    build: {
        target: 'esnext'
    }
})

# Microfrontend Example with React + TypeScript

This repository contains a minimal microfrontend example using React, TypeScript and Vite.

- `host` is the main shell application.
- `remote` is a microfrontend exposing a reusable component.

## Run locally

1. Install dependencies:
   ```bash
   npm install
   ```
2. Build and preview the remote app:
   ```bash
   npm run build:remote
   npm run preview:remote
   ```
3. Start the host app:
   ```bash
   npm run dev:host
   ```

Then open:
- `http://localhost:4173` for the remote app preview
- `http://localhost:4174` for the host app

## What it demonstrates

- Module federation-style remote component loading with `@originjs/vite-plugin-federation`
- React + TypeScript setup with Vite
- Host app consuming a remote component at runtime

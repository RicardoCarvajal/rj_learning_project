import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { BasicApp } from './BasicApp'
import { AwesomeApp } from './AwesomeApp'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <BasicApp />
    {/* <AwesomeApp /> */}
  </StrictMode>,
)

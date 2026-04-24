import { useEffect, useState } from "react";

const colors = {
    red: 'bg-red-500 animate-pulse',
    yellow: 'bg-yellow-500 animate-pulse',
    green: 'bg-green-500 animate-pulse',
}

//Primera forma de hacerlo
type TrafficLightColor = 'red' | 'yellow' | 'green'

export const useTrafficLight = (defaultCount: number = 20, defaultColor: TrafficLightColor = 'red') => {

    const [light, setLight] = useState<TrafficLightColor>(defaultColor)
    const [countDown, setCountDown] = useState(defaultCount)

    //Use Effect para countDown
    useEffect(() => {
        if (countDown === 0) {
            return
        };
        console.log({ countDown })
        const intervalID = setInterval(() => {
            console.log('ejecutando el intervalo')
            setCountDown(previewValue => previewValue - 1)
        }, 1000)
        return () => {
            console.log('Cleanup effect')
            clearInterval(intervalID)
        }
    }, [countDown])

    //Use Effect para el cambio de color
    useEffect(() => {
        if (countDown === 0) {
            if (light === 'red') {
                setLight('green')
                setCountDown(20)
            }
            if (light === 'green') {
                setLight('yellow')
                setCountDown(10)
            }
            if (light === 'yellow') {
                setLight('red')
                setCountDown(20)
            }
        };
    }, [countDown, light])

    return {
        //props
        countDown,
        //computed
        percentage: (countDown / 20) * 100,
        greenLight: light === 'green' ? colors.green : "bg-gray-500",
        yellowLight: light === 'yellow' ? colors.yellow : "bg-gray-500",
        redLight: light === 'red' ? colors.red : "bg-gray-500",
        //method
    }
}
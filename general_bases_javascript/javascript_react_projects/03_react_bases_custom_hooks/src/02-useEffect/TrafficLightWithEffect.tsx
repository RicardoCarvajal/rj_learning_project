import { link } from "fs";
import { useEffect, useState } from "react";
import { preview } from "vite";

const colors = {
    red: 'bg-red-500 animate-pulse',
    yellow: 'bg-yellow-500 animate-pulse',
    green: 'bg-green-500 animate-pulse',
}

//Primera forma de hacerlo
type TrafficLightColor = 'red'|'yellow'|'green'



export const TrafficLightWithEffect = () => {

    const [light, setLight] = useState<TrafficLightColor>('red')
    const [countDown, setCountDown] = useState(20)

    //Use Effect para countDown
    useEffect(() => {
        if (countDown === 0) {                     
            return
        };
        console.log({countDown})
        const intervalID = setInterval(() => {
            console.log('ejecutando el intervalo')
            setCountDown(previewValue => previewValue -1)
        },1000)
        return () => {
            console.log('Cleanup effect')
            clearInterval(intervalID)
        }
    },[countDown]) 

    //Use Effect para el cambio de color
    useEffect(() => {
        if (countDown === 0) {
            if (light === 'red'){
                setLight('green')
                setCountDown(20)
            }
            if (light === 'green'){
                setLight('yellow')
                setCountDown(10)
            }            
            if (light === 'yellow'){
                setLight('red')
                setCountDown(20)
            }                        
        };
    },[countDown, light]) 

    return (
        <div className="min-h-screen bg-gradient-to-br from-slate-900 via-gray-900 to-slate-800 flex items-center justify-center p-4">
            <div className="flex flex-col items-center space-y-8">
                <h1 className="text-white text-2xl">Semaforo con useEffect</h1>
                <h2 className="text-white text-xl">Count {countDown}</h2>
                <div className="w-64 bg-gray-700 rounded-full h-2">
                    <div className="bg-blue-500 h-2 rounded-full transition-all duration-1000 ease-linear" style={{width: `${(countDown / 20) * 100}%`}}></div>
                </div>
                <div className={`w-32 h-32 ${light === 'red' ? colors[light] : "bg-gray-500"} rounded-full`}></div>
                <div className={`w-32 h-32 ${light === 'yellow' ? colors[light] : "bg-gray-500"} rounded-full`}></div>
                <div className={`w-32 h-32 ${light === 'green' ? colors[light] : "bg-gray-500"} rounded-full`}></div>
            </div>
        </div>
    );
};

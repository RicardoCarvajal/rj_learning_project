//Las promesas son funciones asincronas para seguir con los procesos


const getLoans = new Promise<number>((resolve,reject) =>{//El tipo de dato number que se declara en la promesa dentro de <> es para el resolve
    setTimeout(() => {
        if (false){
            resolve(1000)
        }else {
            reject('Dinero perdido')
        }
        
    },2000)
})

getLoans
    .then((myMoney)=> console.log(`Este es mi dinero que preste ${myMoney}`))
    .catch((reason) => console.warn(reason))
    .finally(() => {console.log('Seguire con mi vida')})//El finaly siempre se ejecuta asi la promesa se resuelva o se rechase
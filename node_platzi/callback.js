function soyAsincrono(miCallBack) {
    setTimeout(() => {
       console.log("proceso asincrono") 
       miCallBack();
    }, 1000);
}


console.log("Iniciando")
soyAsincrono(() => {
    console.log("Terminando");    
});

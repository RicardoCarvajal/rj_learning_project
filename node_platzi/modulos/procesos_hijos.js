const {exec, spawn} = require('child_process');
/*
exec('node promesas.js',(error,stout, staerr)=>{
    if(error){
        console.error(staerr);
    }else{
        console.error(stout);
    }

});
*/

let proceso = spawn('ls',['-l'])


console.log(proceso.pid); 
console.log(proceso.connected);

proceso.stdout.on('data',(datos)=>{
    console.log(datos.toString());
});



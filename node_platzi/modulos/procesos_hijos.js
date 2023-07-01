const {exec, spawn} = require('child_process');

exec('ls -l | grep total',(error,stout, staerr)=>{
    if(error){
        console.error(staerr);
    }else{
        console.debug("VE")
        console.info(stout);
    }

});

/*
let proceso = spawn('ls',['-l'])


console.log(proceso.pid); 
console.log(proceso.connected);

proceso.stdout.on('data',(datos)=>{
    console.log(datos.toString());
});
*/


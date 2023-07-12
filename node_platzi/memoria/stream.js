const fs = require('fs');
const stream = require('stream');
const util = require('util');


let data = '';

let readableStream = fs.createReadStream(__dirname + '/imput.txt');

readableStream.setEncoding('utf-8');

/*
readableStream.on('data', (chunk)=>{
    data += chunk;
});
*/
readableStream.on('end', ()=>{
    console.log(data);
});


const Transform = stream.Transform;

function Mayusculas() { 
    Transform.call(this);
}

util.inherits(Mayusculas,Transform);

Mayusculas.prototype._transform = function name(chunk, codif, cb) {
chunkMayus = chunk.toString().toUpperCase();    
this.push(chunkMayus);
cb();
}

let mayus = new Mayusculas();

readableStream.pipe(mayus).pipe(process.stdout);
 


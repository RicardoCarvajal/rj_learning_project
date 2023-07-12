const sharp = require('sharp');

sharp('mimg.jpg').resize(80).grayscale().toFile('resize.jpg'); 


console.log("Termina proceso");
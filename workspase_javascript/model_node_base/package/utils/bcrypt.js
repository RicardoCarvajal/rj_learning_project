const bcrypt = require('bcrypt');

const password = "pass2023";

bcrypt.hash(password, 5, (err,hash)=>{
    console.log(hash); 

    bcrypt.compare(password,hash,(err,resp)=>{
        console.log(resp)
    });
});
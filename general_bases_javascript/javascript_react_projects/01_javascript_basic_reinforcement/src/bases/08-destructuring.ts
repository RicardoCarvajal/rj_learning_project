const useState = (name_one:string) => {
    return [name_one, (name_two:string) => {
        console.log(name_two);
    }] as const
}

const [name, setName] = useState('Goku');

console.log(name);

setName('Vegeta');  


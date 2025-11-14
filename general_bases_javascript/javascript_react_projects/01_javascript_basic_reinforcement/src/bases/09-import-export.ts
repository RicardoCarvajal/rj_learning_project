import {heroes,type Hero, Onwer} from "./data/hero.data"

const getHeroById = (id:number):Hero => {
    
    const hero = heroes.find((hero)=>{
        return hero.id === id
    })

    if (!hero){
        throw new Error('No exsiste el id especificaco')
    }

    return hero;
}

console.log(getHeroById(1))

export const getHeroesByOnwer = (onwer: Onwer): Hero[] => {

    const hero_by_onwer = heroes.filter((hero)=>{
        return hero.owner === onwer
    })

    return hero_by_onwer

}
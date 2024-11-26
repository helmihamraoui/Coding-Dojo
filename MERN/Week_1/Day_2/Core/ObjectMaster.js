const pokemon = Object.freeze([
    { "id": 1,   "name": "Bulbasaur",  "types": ["poison", "grass"] },
    { "id": 5,   "name": "Charmeleon", "types": ["fire"] },
    { "id": 9,   "name": "Blastoise",  "types": ["water"] },
    { "id": 12,  "name": "Butterfree", "types": ["bug", "flying"] },
    { "id": 16,  "name": "Pidgey",     "types": ["normal", "flying"] },
    { "id": 23,  "name": "Ekans",      "types": ["poison"] },
    { "id": 24,  "name": "Arbok",      "types": ["poison"] },
    { "id": 25,  "name": "Pikachu",    "types": ["electric"] },
    { "id": 35,  "name": "Clefairy",   "types": ["normal"] },
    { "id": 37,  "name": "Vulpix",     "types": ["fire"] },
    { "id": 52,  "name": "Meowth",     "types": ["normal"] },
    { "id": 63,  "name": "Abra",       "types": ["psychic"] },
    { "id": 67,  "name": "Machamp",    "types": ["fighting"] },
    { "id": 72,  "name": "Tentacool",  "types": ["water", "poison"] },
    { "id": 74,  "name": "Geodude",    "types": ["rock", "ground"] },
    { "id": 87,  "name": "Dewgong",    "types": ["water", "ice"] },
    { "id": 98,  "name": "Krabby",     "types": ["water"] },
    { "id": 115, "name": "Kangaskhan", "types": ["normal"] },
    { "id": 122, "name": "Mr. Mime",   "types": ["psychic"] },
    { "id": 133, "name": "Eevee",      "types": ["normal"] },
    { "id": 144, "name": "Articuno",   "types": ["ice", "flying"] },
    { "id": 145, "name": "Zapdos",     "types": ["electric", "flying"] },
    { "id": 146, "name": "Moltres",    "types": ["fire", "flying"] },
    { "id": 148, "name": "Dragonair",  "types": ["dragon"] }
]);
// 1:
const bListPkmn = pokemon.filter( p => p.id %3== 0 );
console.log(bListPkmn)
// 2:
// const bListPkmn = pokemon.filter(p => p.types.includes("fire"));
// console.log(bListPkmn)
// // 3:
// const bListPkmn = pokemon.filter(p => p.types.length>1);
// console.log(bListPkmn)
// // 4:
// const bListPkmn = pokemon.map(p => p.name);
// console.log(bListPkmn)
// // 5:
// const bListPkmn = pokemon.filter(p => p.id>99).map(p => p.name);
// console.log(bListPkmn)
// // 6:
// const bListPkmn = pokemon.filter(p => p.types.includes("poison")).map(p=>p.name);
// console.log(bListPkmn)
// // 7:
// const bListPkmn = pokemon.filter(p => p.types[1]==="flying" ).map(p => p.types[0]);
// console.log(bListPkmn)
// // 8:
// const bListPkmn = pokemon.filter(p => p.id !=148);
// console.log(bListPkmn)
// // 9:
// const bListPkmn = pokemon.map(p => {
//     if (p.id === 35) {
//     return {
//         ...p,
//         types: p.types.map(type => type === "normal" ? "fairy" : type)
//     };
//     }
//     return p;
// });
// console.log(bListPkmn)
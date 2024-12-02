import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './App.css'
function App() {
  const [pokemons, setPokemons] = useState([]);
  useEffect(() => {
    axios.get("https://pokeapi.co/api/v2/pokemon?limit=151&offset=0")
      .then(response => {
        console.log(response);
        
        setPokemons(response.data.results);
      })
      .catch(error => {
        console.log('Error :', error);
      });
  }, []);

  return (
    <div className='Container mt-5'>
      <h1>Pokémon API</h1>
      <ul>
        {pokemons.map((pokemon, index) => (
          <li key={index} className='pokemon'>
            {pokemon.name}  
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;

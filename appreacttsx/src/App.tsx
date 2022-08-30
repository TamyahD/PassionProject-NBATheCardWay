import React, { useEffect, useState } from 'react';
import logo from './logo.svg';
import newLogo from './nba-logo.svg';
import './App.css';
import axios from 'axios'
import Card from './CustomComponents/Card/Card';
import { stringify } from 'querystring';



interface nbaPlayer {
  id: String,
  first_name: String,
  last_name: String,
  position?: String,
  signature: String,
  team: Team[]
}

interface Team {
  abbreviation: String,
  name: String
}

function App(props: any) {

  async function fetchData() {
    await axios.get("http://localhost:8080/players/list")
      .then((response) => {
        // setPlayerData(response.data);
        // console.log(response.data)
        // setPlayerData(response.data)
        setTemplate(response.data)
        console.log(response.data)

      })
      .catch((error) => {
        console.log(error);
      });
  }
  const [template, setTemplate] = useState([]);

  // const [fName, setFName] = useState('')
  // const [lName, setLName] = useState('')

  // const [isReady, setReady] = useState(false);

  // const [loading, setLoading] = useState<Boolean>(false);
  // const [playerData, setPlayerData] = useState<nbaPlayer>({} as nbaPlayer);


  return (
    <div className="App">
      <header className="App-header">
        <img src={newLogo} className="App-logo" alt="logo" />
        <button onClick={fetchData}>Click me!</button>
      </header>
      <div className='bodyContainer'>
        {template.map((temp, idx) => {
          return (
            <div className='container, body'>
              <Card
                fName={temp['first_name']}
                lName={temp['last_name']}
                position={temp['position']}
                signature={temp['signature']}
                teamAbbrev={temp['team']['abbreviation']}
                teamName={temp['team']['name']}
              />
              {/* <ul className='listContainer'>
                <li>
                </li>
              </ul> */}
              {/* <table className='table'>
                <tbody className='tbody'>
                  <tr>
                    <th className='th'>Player ID</th>
                    <th className='th'>Name</th>
                    <th className='th'>Position</th>
                    <th className='th'>Team</th>
                  </tr>
                  <tr>

                    <td className='td'>{temp['id']}</td>
                    <td className='td'>{temp['first_name'] + " " + temp['last_name']}</td>
                    <td className='td'>{temp['position']}</td>
                    <td className='td'>{temp['team']['abbreviation']}</td>
                    <td className='td'>{temp['team']['name']}</td>
                  </tr>
                </tbody>
              </table> */}
            </div>
          )
        })}
      </div>
    </div>
  )
}

export default App;

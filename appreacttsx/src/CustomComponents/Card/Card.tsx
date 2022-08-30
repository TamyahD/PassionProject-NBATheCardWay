import React from 'react';
import './Card.css';
// import img from './assets/Nba-logo-black-transparent.png';
// import imgPlaceholder from 'src/assets/nba-logo-black-transparent.png';
  
export const Card = (props:any) => {
    // const options = {
    //     method: 'GET',
    //     url: 'https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/Search/ImageSearchAPI',
    //     params: {q: props.first_Name, pageNumber: '1', pageSize: '8', autoCorrect: 'false'},
    //     headers: {
    //       'X-RapidAPI-Key': '84f909541dmsh68f07a6af81f965p1bea91jsn0103f7467384',
    //       'X-RapidAPI-Host': 'contextualwebsearch-websearch-v1.p.rapidapi.com'
    //     }
    //   };
      
    //   axios.request(options).then(function (response) {
    //     console.log(response.data);
    //   }).catch(function (error) {
    //     console.error(error);
    //   });
    

    return (
        <div className="cardContainer">
            <h3 className='fName'>{props.fName}</h3>
            <h3 className='lName'>{props.lName}</h3>
            <img className='playerImg' />
            <p className='position'>{props.position}</p>
            <p className='signature'>Signature: {props.signature}</p>
            <sub className='teamAbbreviation'>{props.teamAbbrev}</sub>
            <p className='teamName'>{props.teamName}</p>
        </div>
    )
}
export default Card;
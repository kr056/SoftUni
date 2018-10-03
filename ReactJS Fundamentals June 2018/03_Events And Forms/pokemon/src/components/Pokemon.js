import React from 'react';

const Pokemon = props => {
    return (
        <div>
            <p>{props.item.name}</p>
            <h3>{props.item.info}</h3>
            <img src={props.item.image} alt="sth" />
        </div>
    );
};

export default Pokemon;

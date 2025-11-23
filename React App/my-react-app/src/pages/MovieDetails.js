// dynamic route component
// show details from a specific movie based on URL parameter - movieID
//useParams => another react hook, lets you read URL paramter
import React from 'react';
import {useParams, Link} from 'react-router-dom';

function MovieDetails(){
    const {movieId} = useParams();

    return(
        <div>
            <h1>Movie Details</h1>
            <p>Movie ID : {movieId}</p>
            <Link to="/">Back to Home</Link>
        </div>
    )
}

export default MovieDetails;
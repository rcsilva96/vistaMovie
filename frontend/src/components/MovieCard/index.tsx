import React from "react";
import MovieScore from "../MovieScore/index.tsx";
import { Link } from "react-router-dom";
import { Movie } from "../../types/movie.ts";

type Props = {

    movie: Movie;

}

function MovieCard( { movie } : Props ) {



  return (
    <div>
      <img
        className="vistamovie-movie-card-image"
        src={movie.image}
        alt={movie.title}
      />
      <div className="vistamovie-card-bottom-container">
        <h3>{movie.title}</h3>
        <MovieScore />
        <Link to={`/form/${movie.id}`}>
          <div className="btn btn-primary vistamovie-btn">Avaliar</div>
        </Link>
      </div>
    </div>
  );
}

export default MovieCard;

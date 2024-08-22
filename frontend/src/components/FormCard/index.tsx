import React, { useEffect, useState } from "react";
import "./styles.css";
import { Link } from "react-router-dom";
import { Movie } from "../../types/movie.ts";
import axios from "axios";
import { BASE_URL } from "../../utils/requests.ts";

type Props = {
  movieId: string;
}

function FormCard( { movieId } : Props) {

    const [movie, setMovie] = useState<Movie>();

    useEffect( () => {

        axios.get(`${BASE_URL}/movies/${movieId}`)
            .then(response => {
                setMovie(response.data)
            });
    }, [movieId]);

  return (
    <div className="vistamovie-form-container">
      <img className="vistamovie-movie-card-image" src={movie?.image} alt={movie?.title} />
      <div className="vistamovie-card-bottom-container">
        <h3>{movie?.title}</h3>
        <form className="vistamovie-form">
          <div className="form-group vistamovie-form-group">
            <label htmlFor="email">Informe seu email</label>
            <input type="email" className="form-control" id="email" />
          </div>
          <div className="form-group vistamovie-form-group">
            <label htmlFor="score">Informe sua avaliação</label>
            <select className="form-control" id="score">
              <option>1</option>
              <option>2</option>
              <option>3</option>
              <option>4</option>
              <option>5</option>
            </select>
          </div>
          <div className="vistamovie-form-btn-container">
            <button type="submit" className="btn btn-primary vistamovie-btn">
              Salvar
            </button>
          </div>
        </form>
        <Link to="/">
          <button className="btn btn-primary vistamovie-btn mt-3">Cancelar</button>
        </Link>
      </div>
    </div>
  );
}

export default FormCard;

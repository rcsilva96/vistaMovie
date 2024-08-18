import React from "react";
import "./styles.css";

function Form() {
  const movie = {
    id: 1,
    image:
      "https://media.themoviedb.org/t/p/w533_and_h300_bestv2/ekP6EVxL81lZ4ivcqPsoZ72rY0h.jpg",
    title: "O Grande Mestre 4",
    count: 888,
    score: 5,
  };

  return (
    <div className="vistamovie-form-container">
      <img className="vistamovie-movie-card-image" src={movie.image} alt="O Grande Mestre 4" />
      <div className="vistamovie-card-bottom-container">
        <h3>"O Grande Mestre 4"</h3>
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
        <button className="btn btn-primary vistamovie-btn mt-3">Cancelar</button>
      </div>
    </div>
  );
}

export default Form;

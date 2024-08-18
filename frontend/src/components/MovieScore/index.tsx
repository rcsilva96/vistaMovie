import React from "react";
import "./styles.css";
import MovieStars from "../MovieStars";

function MovieScore() {

    const score = 3.5;
    const count = 888;

  return (
    <div className="vistamovie-score-container">
      <p className="vistamovie-score-value">
        {score > 0 ? score.toFixed(1) : "-"}
      </p>
      <MovieStars />
      <p className="vistamovie-score-count">{count} avaliações</p>
    </div>
  );
}

export default MovieScore;

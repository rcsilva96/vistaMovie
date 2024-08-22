import React from "react";
import "./styles.css";
import MovieStars from "../MovieStars/index.tsx";

type Props ={
  score: number;
  count: number;
}

function MovieScore( {score, count } : Props ) {

  return (
    <div className="vistamovie-score-container">
      <p className="vistamovie-score-value">
        {score > 0 ? score.toFixed(1) : "-"}
      </p>
      <MovieStars score={score}/>
      <p className="vistamovie-score-count">{count} avaliações</p>
    </div>
  );
}

export default MovieScore;

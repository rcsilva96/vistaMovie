import React from "react";
import "./styles.css";
import {ReactComponent as Arrow} from "../../assets/img/arrow.svg";
import { MoviePage } from "../../types/movie";

type Props = {

  page: MoviePage;
  onChange: Function;
}



function Pagination( { page, onChange }: Props) {

  return (
    <div className="vistamovie-pagination-container">

      <div className="vistamovie-pagination-box">

        <button className="vistamovie-pagination-button" disabled={page.first} onClick={ () => onChange(page.number - 1)}>
          <Arrow />
        </button>

        <p>{`${page.number + 1 } de ${page.totalPages}`}</p>

        <button className="vistamovie-pagination-button" disabled={page.last} onClick={ () => onChange(page.number + 1)}>
          <Arrow className="vistamovie-flip-horizontal" />
        </button>

      </div>

    </div>
  );
}

export default Pagination;

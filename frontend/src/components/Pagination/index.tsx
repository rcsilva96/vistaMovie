import React from "react";
import "./styles.css";
import {ReactComponent as Arrow} from "../../assets/img/arrow.svg";

function Pagination() {
  return (
    <div className="vistamovie-pagination-container">
      <div className="vistamovie-pagination-box">
        <button className="vistamovie-pagination-button" disabled={true}>
          <Arrow />
        </button>
        <p>{`${1} de ${3}`}</p>
        <button className="vistamovie-pagination-button" disabled={false}>
          <Arrow className="vistamovie-flip-horizontal" />
        </button>
      </div>
    </div>
  );
}

export default Pagination;

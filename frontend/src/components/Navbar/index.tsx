import React from "react";
import './styles.css';
import { ReactComponent as GitHubIcon } from "../../assets/img/github.svg";

function Navbar() {
  return (
    <header>
      <nav className="container">
        <div className="vistamovie-nav-content">
          <h1>vistaMovie</h1>
          <a href="https://github.com/rcsilva96">
            <div className="vistamovie-contact-container">
              <GitHubIcon></GitHubIcon>
              <p className="vistamovie-contact-link">/renatocs96</p>
            </div>
          </a>
        </div>
      </nav>
    </header>
  );
}

export default Navbar;

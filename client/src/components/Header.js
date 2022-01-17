import React from "react";
import { Link } from "react-router-dom";

const Header = () => {
    return (
        <header className="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
            <Link to="/" className="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <svg className="bi me-2" width="40" height="32"></svg>
                <span className="fs-4">Simple Blogger</span>
            </Link>
            <ul className="nav nav-pills">
                <li className="nav-item">
                    <Link to="/" className="nav-link" aria-current="page">
                        Home
                    </Link>
                </li>
                <li className="nav-item">
                    <a href="/blog/add" className="nav-link" aria-current="page">
                        Add Blog
                    </a>
                </li>
            </ul>
        </header>
    );
};

export default Header;
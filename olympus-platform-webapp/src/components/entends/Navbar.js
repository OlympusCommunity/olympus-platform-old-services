import React from 'react'
import { NavLink } from 'react-router-dom'
import './navbar.css'

export const Navbar = () => {
    return (
        <nav 
            className="navbar fixed-top navbar-expand-lg navbar-dark gris scrolling-navbar"
        >
            <div className="container-fluid">
                
                <NavLink
                    exact
                    to="/beginning"
                >
                    <a className="navbar-brand nav-link">
                        <img src="assets/img/logo.png" width="30" height="30" />
                        <strong>ＯＬＹＭＰＵＳ</strong>
                    </a>
                </NavLink>
                    
                <button 
                    className="navbar-toggler" 
                    type="button" 
                    data-toggle="collapse" 
                    data-target="#navbarSupportedContent" 
                    aria-controls="navbarSupportedContent" 
                    aria-expanded="false" 
                    aria-label="Toggle navigation">
                    <svg id="Layer_4" height="30" width="30" enable-background="new 0 0 24 24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path d="m5 0h-4c-.552 0-1 .448-1 1v4c0 .552.448 1 1 1h4c.552 0 1-.448 1-1v-4c0-.552-.448-1-1-1z" fill="#42a5f5"/><path d="m5 9h-4c-.552 0-1 .448-1 1v4c0 .552.448 1 1 1h4c.552 0 1-.448 1-1v-4c0-.552-.448-1-1-1z" fill="#90caf9"/><path d="m5 18h-4c-.552 0-1 .448-1 1v4c0 .552.448 1 1 1h4c.552 0 1-.448 1-1v-4c0-.552-.448-1-1-1z" fill="#90caf9"/><path d="m23 0h-4c-.552 0-1 .448-1 1v4c0 .552.448 1 1 1h4c.552 0 1-.448 1-1v-4c0-.552-.448-1-1-1z" fill="#42a5f5"/><path d="m23 9h-4c-.552 0-1 .448-1 1v4c0 .552.448 1 1 1h4c.552 0 1-.448 1-1v-4c0-.552-.448-1-1-1z" fill="#90caf9"/><path d="m23 18h-4c-.552 0-1 .448-1 1v4c0 .552.448 1 1 1h4c.552 0 1-.448 1-1v-4c0-.552-.448-1-1-1z" fill="#90caf9"/><path d="m14 0h-4c-.552 0-1 .447-1 1v4c0 .553.448 1 1 1h4c.552 0 1-.447 1-1v-4c0-.553-.448-1-1-1z" fill="#42a5f5"/><path d="m14 9h-4c-.552 0-1 .447-1 1v4c0 .553.448 1 1 1h4c.552 0 1-.447 1-1v-4c0-.553-.448-1-1-1z" fill="#90caf9"/><path d="m14 18h-4c-.552 0-1 .447-1 1v4c0 .553.448 1 1 1h4c.552 0 1-.447 1-1v-4c0-.553-.448-1-1-1z" fill="#90caf9"/><path d="m12 0h-2c-.552 0-1 .447-1 1v4c0 .553.448 1 1 1h2z" fill="#3990d5"/><path d="m12 9h-2c-.552 0-1 .447-1 1v4c0 .553.448 1 1 1h2z" fill="#7db0d9"/><path d="m12 18h-2c-.552 0-1 .447-1 1v4c0 .553.448 1 1 1h2z" fill="#7db0d9"/><path d="m21 0h-2c-.552 0-1 .447-1 1v4c0 .553.448 1 1 1h2z" fill="#3990d5"/><path d="m21 9h-2c-.552 0-1 .447-1 1v4c0 .553.448 1 1 1h2z" fill="#7db0d9"/><path d="m21 18h-2c-.552 0-1 .447-1 1v4c0 .553.448 1 1 1h2z" fill="#7db0d9"/><path d="m3 0h-2c-.552 0-1 .447-1 1v4c0 .553.448 1 1 1h2z" fill="#3990d5"/><g fill="#7db0d9"><path d="m3 9h-2c-.552 0-1 .447-1 1v4c0 .553.448 1 1 1h2z"/><path d="m3 18h-2c-.552 0-1 .447-1 1v4c0 .553.448 1 1 1h2z"/></g></svg>
                </button>

                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
  
                        <NavLink 
                            activeClassName="active"
                            className="nav-item nav-link" 
                            exact
                            to="/members"
                        >
                            Integrantes
                        </NavLink>

                        <NavLink 
                            activeClassName="active"
                            className="nav-item nav-link" 
                            exact
                            to="/about-us"
                        >
                            Conócenos
                        </NavLink>

                        <NavLink 
                            activeClassName="active"
                            className="nav-item nav-link" 
                            exact
                            to="/contact"
                        >
                            Conctácnos
                        </NavLink>

                        <NavLink 
                            activeClassName="active"
                            className="nav-item nav-link" 
                            exact
                            to="/galery"
                        >
                            Galería
                        </NavLink>

                        <NavLink 
                            activeClassName="active"
                            className="nav-item nav-link" 
                            exact
                            to="/community"
                        >
                            Comunidades
                        </NavLink>

                        <NavLink 
                            activeClassName="active"
                            className="nav-item nav-link" 
                            exact
                            to="/join-us"
                        >
                            Únete
                        </NavLink>

                        <li className="nav-item dropdown">
                            <a 
                                className="nav-link dropdown-toggle" 
                                href="#"
                                id="navbarDropdown" 
                                role="button" 
                                data-toggle="dropdown" 
                                aria-haspopup="true" 
                                aria-expanded="flase"
                            >
                                Opciones
                            </a>

                            <div className="dropdown-menu" aria-labelledby="navbarDropdown">
                                <NavLink
                                    className = "dropdown-item"
                                    exact
                                    to="/sign-up"
                                >
                                    Registrarse
                                </NavLink>
                                <NavLink
                                    className = "dropdown-item"
                                    exact
                                    to="/login"
                                >
                                    Iniciar Sesión
                                </NavLink>
                            <div className="dropdown-divider"></div>
                                <NavLink
                                    className = "dropdown-item"
                                    exact
                                    to="/info"
                                >
                                    Información
                                </NavLink>
                            </div>
                        </li>
                    </ul>

                    <ul className="navbar-nav d-flex flex-row">

                        <li className="nav-item me-3 me-lg-0">
                            <NavLink 
                                exact
                                to="#"
                            >
                                <a className="nav-link">
                                    <i className="fab fa-youtube"></i>
                                </a>
                            </NavLink>
                        </li>

                        <li className="nav-item me-3 me-lg-0">
                            <NavLink 
                                exact
                                to="#"
                            >
                                <a className="nav-link">
                                    <i className="fab fa-facebook-f"></i>
                                </a>
                            </NavLink>
                        </li>

                        <li className="nav-item me-3 me-lg-0">
                            <NavLink 
                                exact
                                to="#"
                            >
                                <a className="nav-link">
                                    <i className="fab fa-twitter"></i>
                                </a>
                            </NavLink>
                        </li>

                        <li className="nav-item me-3 me-lg-0">
                            <NavLink 
                                exact
                                to="#"
                            >
                                <a className="nav-link">
                                    <i className="fab fa-github"></i>
                                </a>
                            </NavLink>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    )
}
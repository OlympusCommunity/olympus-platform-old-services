import React, { Fragment } from 'react'
import { Link } from 'react-router-dom'
import { useEffect, useState } from 'react'
import './olympus.css'
import axios from 'axios'
import Representer from './Representer'

export const OlympusScreen = () => {
    const [messages, setMessage] = useState([]);
    const loadWelcomData = () => {
        axios.get('http://localhost:2856/olympus/welcome')
        .then(({data}) => setMessage(data));
    }
    useEffect(loadWelcomData, []);

    return (
        <Fragment>
            <div id="intro" className="bg-image vh-100 shadow-1-strong">
                
                <video classNameName='videoTag' playsinline autoPlay loop muted>
                    <source className="h-100" src="assets/video/olympus.mp4" type="video/mp4" />
                </video>

                <div className="mask" key = {messages.welcomeId}>
                    <div className="container d-flex align-items-center justify-content-center text-center h-100">
                        <div className="text-white">
                            <h1 className="mb-3 tittle">{messages.mainTittle}</h1>
                            <h5 className="mb-4 subtitle">{messages.mainSubTittle}</h5>
                            
                            <Link
                                exact
                                to="/community"
                            >
                                <a
                                    className="btn btn-outline-light btn-lg m-2"
                                    role="button"
                                    rel="nofollow"
                                    target="_blank"
                                    >¡Empecemos!</a
                                >
                            </Link>

                            <Link
                                exact
                                to="/login"
                            >
                                <a
                                    className="btn btn-outline-light btn-lg m-2"
                                    target="_blank"
                                    role="button"
                                    >Iniciar Sesion</a
                                >
                            </Link>
                        </div>
                    </div>
                </div>
            </div>

            <div className="bg-dark text-white py-5">
                <div className="container">
                    <div className="row">
                    <div className="col-md-3">
                        <div className="card text-white bg-dark">
                        <div className="card-body">
                            <h3>{messages.card1Tittle}</h3>
                            <p>
                            {messages.card1SubTittle}
                            </p>
                        </div>
                        </div>
                    </div>
                    <div className="col-md-3">
                        <div className="card text-white bg-dark">
                        <div className="card-body text-primary">
                            <h3>{messages.card2Tittle}</h3>
                            <p>
                            {messages.card2SubTittle}
                            </p>
                        </div>
                        </div>
                    </div>
                    <div className="col-md-3">
                        <div className="card text-white bg-dark">
                        <div className="card-body">
                            <h3>{messages.card3Tittle}</h3>
                            <p>
                            {messages.card3SubTittle}
                            </p>
                        </div>
                        </div>
                    </div>
                    <div className="col-md-3">
                        <div className="card text-white bg-dark">
                        <div className="card-body text-primary">
                            <h3>{messages.card4Tittle}</h3>
                            <p>
                            {messages.card4SubTittle}
                            </p>
                        </div>
                        </div>
                    </div>
                    </div>
                </div>
            </div>

            <div claasName="text-center communities">
                <div className="container p-5">
                    <h1 className="text-center text-white">{messages.communityTittle}</h1>
                    <p className="text-white text-center">
                    {messages.descComunity}
                    </p>
                </div>

                <div className="container">
                <div className="row">

                    <div className="col-sm-4 col-sm-12 col-lg-3" id="cm-cd">
                    <div className="card team text-white bg-dark cm-card">
                        <h4 name="typeUserName" className="card-title tittle text-center" >OLYMPUS</h4>
                        <img className="card-img-top img-fluid rounded" src="https://i.imgur.com/2P6CgK4.jpg" alt="Card image cap"></img>
                        <div className="card-body md-5">
                            <label name="subtittle" className="card-text subtitle md-1">Grupo de amistad y comunidad</label>
                            <h6 class="card-title"><b>Founder: Julius Sauco</b></h6>
                            <p name="description" className="card-text text-justify md-1">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
                            incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam <a href="#"> ver más</a></p>
                            <button type="button" id="social-btn" className="btn btn-outline-primary btn-lg btn-block">Grupo de Facebook</button>
                            <button type="button" id="social-btn" className="btn btn-outline-success btn-lg btn-block">Grupo de WhatsApp</button>
                            <button type="button" id="social-btn" className="btn btn-outline-warning btn-lg btn-block">Grupo de Instagram</button>
                        </div>
                    </div>
                    </div>

                    <div className="col-sm-4 col-sm-12 col-lg-3" id="cm-cd">
                    <div className="card team text-white bg-dark cm-card">
                        <h4 name="typeUserName" className="card-title tittle text-center" >OLYMPUS</h4>
                        <img className="card-img-top img-fluid rounded" src="https://i.imgur.com/2P6CgK4.jpg" alt="Card image cap"></img>
                        <div className="card-body md-5">
                            <label name="subtittle" className="card-text subtitle md-1">Grupo de amistad y comunidad</label>
                            <h6 class="card-title"><b>Founder: Julius Sauco</b></h6>
                            <p name="description" className="card-text text-justify md-1">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
                            incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam <a href="#"> ver más</a></p>
                            <button type="button" id="social-btn" className="btn btn-outline-primary btn-lg btn-block">Grupo de Facebook</button>
                            <button type="button" id="social-btn" className="btn btn-outline-success btn-lg btn-block">Grupo de WhatsApp</button>
                            <button type="button" id="social-btn" className="btn btn-outline-warning btn-lg btn-block">Grupo de Instagram</button>
                        </div>
                    </div>
                    </div>

                    <div className="col-sm-4 col-sm-12 col-lg-3" id="cm-cd">
                    <div className="card team text-white bg-dark cm-card">
                        <h4 name="typeUserName" className="card-title tittle text-center" >OLYMPUS</h4>
                        <img className="card-img-top img-fluid rounded" src="https://i.imgur.com/2P6CgK4.jpg" alt="Card image cap"></img>
                        <div className="card-body md-5">
                            <label name="subtittle" className="card-text subtitle md-1">Grupo de amistad y comunidad</label>
                            <h6 class="card-title"><b>Founder: Julius Sauco</b></h6>
                            <p name="description" className="card-text text-justify md-1">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
                            incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam <a href="#"> ver más</a></p>
                            <button type="button" id="social-btn" className="btn btn-outline-primary btn-lg btn-block">Grupo de Facebook</button>
                            <button type="button" id="social-btn" className="btn btn-outline-success btn-lg btn-block">Grupo de WhatsApp</button>
                            <button type="button" id="social-btn" className="btn btn-outline-warning btn-lg btn-block">Grupo de Instagram</button>
                        </div>
                    </div>
                    </div>

                    <div className="col-sm-4 col-sm-12 col-lg-3" id="cm-cd">
                    <div className="card team text-white bg-dark cm-card">
                        <h4 name="typeUserName" className="card-title tittle text-center" >OLYMPUS</h4>
                        <img className="card-img-top img-fluid rounded" src="https://i.imgur.com/2P6CgK4.jpg" alt="Card image cap"></img>
                        <div className="card-body md-5">
                            <label name="subtittle" className="card-text subtitle md-1">Grupo de amistad y comunidad</label>
                            <h6 class="card-title"><b>Founder: Julius Sauco</b></h6>
                            <p name="description" className="card-text text-justify md-1">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
                            incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam <a href="#"> ver más</a></p>
                            <button type="button" id="social-btn" className="btn btn-outline-primary btn-lg btn-block">Grupo de Facebook</button>
                            <button type="button" id="social-btn" className="btn btn-outline-success btn-lg btn-block">Grupo de WhatsApp</button>
                            <button type="button" id="social-btn" className="btn btn-outline-warning btn-lg btn-block">Grupo de Instagram</button>
                        </div>
                    </div>
                    </div>

                    <div className="col-sm-4 col-sm-12 col-lg-3" id="cm-cd">
                    <div className="card team text-white bg-dark cm-card">
                        <h4 name="typeUserName" className="card-title tittle text-center" >OLYMPUS</h4>
                        <img className="card-img-top img-fluid rounded" src="https://i.imgur.com/2P6CgK4.jpg" alt="Card image cap"></img>
                        <div className="card-body md-5">
                            <label name="subtittle" className="card-text subtitle md-1">Grupo de amistad y comunidad</label>
                            <h6 class="card-title"><b>Founder: Julius Sauco</b></h6>
                            <p name="description" className="card-text text-justify md-1">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
                            incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam <a href="#"> ver más</a></p>
                            <button type="button" id="social-btn" className="btn btn-outline-primary btn-lg btn-block">Grupo de Facebook</button>
                            <button type="button" id="social-btn" className="btn btn-outline-success btn-lg btn-block">Grupo de WhatsApp</button>
                            <button type="button" id="social-btn" className="btn btn-outline-warning btn-lg btn-block">Grupo de Instagram</button>
                        </div>
                    </div>
                    </div>

                    <div className="col-sm-4 col-sm-12 col-lg-3" id="cm-cd">
                    <div className="card team text-white bg-dark cm-card">
                        <h4 name="typeUserName" className="card-title tittle text-center" >OLYMPUS</h4>
                        <img className="card-img-top img-fluid rounded" src="https://i.imgur.com/2P6CgK4.jpg" alt="Card image cap"></img>
                        <div className="card-body md-5">
                            <label name="subtittle" className="card-text subtitle md-1">Grupo de amistad y comunidad</label>
                            <h6 class="card-title"><b>Founder: Julius Sauco</b></h6>
                            <p name="description" className="card-text text-justify md-1">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
                            incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam <a href="#"> ver más</a></p>
                            <button type="button" id="social-btn" className="btn btn-outline-primary btn-lg btn-block">Grupo de Facebook</button>
                            <button type="button" id="social-btn" className="btn btn-outline-success btn-lg btn-block">Grupo de WhatsApp</button>
                            <button type="button" id="social-btn" className="btn btn-outline-warning btn-lg btn-block">Grupo de Instagram</button>
                        </div>
                    </div>
                    </div>

                    <div className="col-sm-4 col-sm-12 col-lg-3" id="cm-cd">
                    <div className="card team text-white bg-dark cm-card">
                        <h4 name="typeUserName" className="card-title tittle text-center" >OLYMPUS</h4>
                        <img className="card-img-top img-fluid rounded" src="https://i.imgur.com/2P6CgK4.jpg" alt="Card image cap"></img>
                        <div className="card-body md-5">
                            <label name="subtittle" className="card-text subtitle md-1">Grupo de amistad y comunidad</label>
                            <h6 class="card-title"><b>Founder: Julius Sauco</b></h6>
                            <p name="description" className="card-text text-justify md-1">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
                            incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam <a href="#"> ver más</a></p>
                            <button type="button" id="social-btn" className="btn btn-outline-primary btn-lg btn-block">Grupo de Facebook</button>
                            <button type="button" id="social-btn" className="btn btn-outline-success btn-lg btn-block">Grupo de WhatsApp</button>
                            <button type="button" id="social-btn" className="btn btn-outline-warning btn-lg btn-block">Grupo de Instagram</button>
                        </div>
                    </div>
                    </div>

                    <div className="col-sm-4 col-sm-12 col-lg-3" id="cm-cd">
                    <div className="card team text-white bg-dark cm-card">
                        <h4 name="typeUserName" className="card-title tittle text-center" >OLYMPUS</h4>
                        <img className="card-img-top img-fluid rounded" src="https://i.imgur.com/2P6CgK4.jpg" alt="Card image cap"></img>
                        <div className="card-body md-5">
                            <label name="subtittle" className="card-text subtitle md-1">Grupo de amistad y comunidad</label>
                            <h6 class="card-title"><b>Founder: Julius Sauco</b></h6>
                            <p name="description" className="card-text text-justify md-1">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
                            incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam <a href="#"> ver más</a></p>
                            <button type="button" id="social-btn" className="btn btn-outline-primary btn-lg btn-block">Grupo de Facebook</button>
                            <button type="button" id="social-btn" className="btn btn-outline-success btn-lg btn-block">Grupo de WhatsApp</button>
                            <button type="button" id="social-btn" className="btn btn-outline-warning btn-lg btn-block">Grupo de Instagram</button>
                        </div>
                    </div>
                    </div>

                </div>
                </div>
            </div>

            <div className="text-center team">
                <div className="container p-5">
                    <h1 className="text-center text-white">{messages.themeTittle}</h1>
                    <p className="text-white text-center">
                    {messages.descTheme}
                    </p>
                </div>
            </div>

            <div claasName="text-center communities">
                <div className="container p-5">
                    <h1 className="text-center text-white">{messages.profileTittle}</h1>
                    <p className="text-white text-center">
                    {messages.descProfile}
                    </p>
                </div>
            </div>

            <div className="text-center team">
                <div className="container p-5">
                    <h1 className="text-center text-white">{messages.communityTittle}</h1>
                    <p className="text-white text-center">
                    {messages.descComunity}
                    </p>
                </div>
            </div>

            <div claasName="text-center communities">
                <div className="container p-5">
                    <h1 className="text-center text-white">{messages.subTittle}</h1>
                    <p className="text-white text-center">
                    {messages.descSub}
                    </p>
                </div>
            </div>

            <div className="text-center team">
                <div className="container p-5">
                    <h1 className="text-center text-white">{messages.teamTittle}</h1>
                    <p className="text-white text-center">
                    {messages.descTeam}
                    </p>

                    <div className="row">
                        <Representer messages={messages} />
                    </div>
                </div>
            </div>

        </Fragment>
    )
}

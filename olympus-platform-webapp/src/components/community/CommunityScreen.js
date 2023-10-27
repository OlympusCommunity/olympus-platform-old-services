import React, { Fragment } from 'react'
import "./community.css"

export const CommunityScreen = () => {
    return (
        <Fragment>
        <div claasName="text-center">
            <div className="container p-5 cm-ct">
                <h1 className="text-center text-white tittle">COMUNIDADES</h1>
                <p className="text-white text-justify">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
                incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud 
                exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute 
                irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla 
                pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia 
                deserunt mollit anim id est laborum.
                </p>

                <h3 className="text-center text-white tittle py-4">BÚSQUEDAD DE COMUNIDADES</h3>
               
                <div className="input-group mb-3">
                    <input type="text" className="form-control" placeholder="Ingrese el nombre, tema o representante de una comunidad." aria-label="Recipient's username" aria-describedby="basic-addon2" />
                    <div className="input-group-append">
                        <button className="btn btn-outline-warning" type="button">Buscar</button>
                    </div>
                </div>

                <div className="row">

                    <div class="col">
                        <h5 className="text-center text-white tittle py-4">TEMÁTICAS</h5>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input bg-dark" type="checkbox" id="inlineCheckbox1" value="option1" />
                            <label class="form-check-label text-white" for="inlineCheckbox1">Amistad</label>
                        </div>

                        <div class="form-check form-check-inline">
                            <input class="form-check-input bg-dark" type="checkbox" id="inlineCheckbox2" value="option1" />
                            <label class="form-check-label text-white" for="inlineCheckbox2">Amistad</label>
                        </div>

                        <div class="form-check form-check-inline">
                            <input class="form-check-input bg-dark" type="checkbox" id="inlineCheckbox3" value="option1" />
                            <label class="form-check-label text-white" for="inlineCheckbox3">Amistad</label>
                        </div>

                        <div class="form-check form-check-inline">
                            <input class="form-check-input bg-dark" type="checkbox" id="inlineCheckbox4" value="option1" />
                            <label class="form-check-label text-white" for="inlineCheckbox4">Amistad</label>
                        </div>

                        <div class="form-check form-check-inline">
                            <input class="form-check-input bg-dark" type="checkbox" id="inlineCheckbox5" value="option1" />
                            <label class="form-check-label text-white" for="inlineCheckbox5">Amistad</label>
                        </div>
                    </div>

                    <div class="col">
                    <h5 className="text-center text-white tittle py-4">SUB-TEMÁTICAS</h5>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input bg-dark" type="checkbox" id="inlineCheckbox6" value="option1" />
                            <label class="form-check-label text-white" for="inlineCheckbox6">Amistad</label>
                        </div>

                        <div class="form-check form-check-inline">
                            <input class="form-check-input bg-dark" type="checkbox" id="inlineCheckbox7" value="option1" />
                            <label class="form-check-label text-white" for="inlineCheckbox7">Amistad</label>
                        </div>

                        <div class="form-check form-check-inline">
                            <input class="form-check-input bg-dark" type="checkbox" id="inlineCheckbox8" value="option1" />
                            <label class="form-check-label text-white" for="inlineCheckbox8">Amistad</label>
                        </div>

                        <div class="form-check form-check-inline">
                            <input class="form-check-input bg-dark" type="checkbox" id="inlineCheckbox9" value="option1" />
                            <label class="form-check-label text-white" for="inlineCheckbox9">Amistad</label>
                        </div>

                        <div class="form-check form-check-inline">
                            <input class="form-check-input bg-dark" type="checkbox" id="inlineCheckbox10" value="option1" />
                            <label class="form-check-label text-white" for="inlineCheckbox10">Amistad</label>
                        </div>
                    </div>
                </div>

            </div>
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
        </Fragment>
    )
}

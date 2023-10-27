import React from 'react'
import { Link } from 'react-router-dom'
import "./login.css"

export const LoginScreen = () => {

    return (
        <div
             id = "login-container"
             className = "container h-80"
        >

            <h5 className="text-white text-center py-4 tittle">
                <strong>INICIAR SESIÓN</strong>
            </h5>

            <form>
    
            <div className="mb-4">
                <div className="col">
                    <label className="text-warning"><i class="fas fa-user" /> Ingrese su e-mail o nombre de usuario</label>
                    <input type="text" id="defaultRegisterFormFirstName" className="form-control bg-dark text-white" placeholder="E-mail o Nombre de usuario" />
                </div>
            </div>

            <div className="mb-4">
                <div className="col">
                    <label className="text-warning"><i class="fas fa-key" /> Ingrese su contraseña</label>
                    <input type="password" id="defaultRegisterFormFirstName" className="form-control bg-dark text-white" placeholder="Contraseña" />
                </div>
            </div>
            
            <div className="row mb-4 text-light">
                <div className="col d-flex justify-content-center">

                <div className="form-check">
                    <input
                    className="form-check-input bg-dark"
                    type="checkbox"
                    id="form2Example34"
                    />
                    <label className="form-check-label" for="form2Example34"> Recuérdame </label>
                </div>
                </div>

                <div className="col">

                <Link exact to="/reset-password" className = "text-warning">¿Olvidaste la contraseña?</Link>
                </div>
            </div>

            <button type="submit" className="btn btn-outline-warning btn-block mb-5">Iniciar Sesión</button>

            <div className="text-center text-light">
                <p>¿Aún no eres miembro? 
                    <Link exact to="/join-us" className = "text-warning"> Registrate</Link></p>
                <p>o inicia sesión con:</p>

                <button type="button" className="btn btn-primary btn-floating mx-1">
                <i className="fab fa-facebook-f"></i>
                </button>

                <button type="button" className="btn btn-danger btn-floating mx-1">
                <i className="fab fa-google"></i>
                </button>

            </div>
            </form>
        </div>
    )
}

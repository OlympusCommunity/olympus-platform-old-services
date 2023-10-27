import './join-us.css'
import UserTypes from './UserTypes'

export const JoinUsScreen = () => {
    return (
        <div
             id = "join-us-container"
             className = "container h-80"
        >

            <h5 className="text-white text-center py-4 tittle">
                <strong>REGISTRARSE</strong>
            </h5>

            <form method='POST'>
            <div className="mb-4">
                <div className="col">
                    <label className="text-warning"><i className="fas fa-user" /> Ingrese su nombre de usuario</label>
                    <input name="username" type="text" id="username" className="form-control bg-dark text-white" placeholder="Nombre de usuario" />
                </div>
            </div>
            
            <div className="mb-4">
                <div className="col">
                    <label className="text-warning"><i className="fa fa-envelope" /> Ingrese su e-mail</label>
                    <input name="email" type="email" id="email" className="form-control bg-dark text-white" placeholder="E-mail" />
                </div>
            </div>

            <div className="row mb-4">
                <div className="col">
                    <label className="text-warning"><i className="fas fa-key" /> Ingrese su contraseña</label>
                    <input name="password" type="password" id="password" className="form-control bg-dark text-white" placeholder="Contraseña" />
                </div>
                <div className="col">
                    <label className="text-warning"><i className="fas fa-key" /> Repita su contraseña</label>
                    <input name="repeatPassword" type="password" id="repeatPassword" className="form-control bg-dark text-white" placeholder="Repetir contraseña" />
                </div>
            </div>

            <UserTypes />

            <button type="submit" className="btn btn-outline-warning btn-block mb-5">Registrarse</button>

            <div className="text-center text-light">
                <p>o regístrate con:</p>

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

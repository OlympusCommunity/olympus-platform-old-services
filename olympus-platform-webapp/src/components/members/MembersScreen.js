import React, { Fragment } from 'react'

export const MembersScreen = () => {
    return (
        <Fragment>
        <div claasName="text-center">
            <div className="container p-5 cm-ct">
                <h1 className="text-center text-white tittle">MIEMBROS</h1>
                <p className="text-white text-justify">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
                incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud 
                exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute 
                irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla 
                pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia 
                deserunt mollit anim id est laborum.
                </p>

                <h3 className="text-center text-white tittle py-4">BÚSQUEDAD DE PERSONAS Y ENTIDADES</h3>
               
                <div className="input-group mb-3">
                    <input type="text" className="form-control" placeholder="Ingrese el nombre, nombre de usuario, nombre de comunidad o de empresa." aria-label="Recipient's username" aria-describedby="basic-addon2" />
                    <div className="input-group-append">
                        <button className="btn btn-outline-warning" type="button">Buscar</button>
                    </div>
                </div>

            </div>
        </div>
        </Fragment>
    )
}

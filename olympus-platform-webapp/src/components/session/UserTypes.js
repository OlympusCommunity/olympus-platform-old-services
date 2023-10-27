import React, { useEffect, useState } from 'react'
import axios from 'axios'

const UserTypes = () => {

    const [usertypes, setUsertypes] = useState([]);

    const loadUserTypes = () => {
        axios.get('http://localhost:2856/olympus/session/types-users')
        .then(({data}) => setUsertypes(data));
    }

    useEffect(loadUserTypes, []);

    return (
        <>
        <div className="bg-dark text-white py-1">
            <h5 className='tittle text-center'>ELIJA SU TIPO DE CUENTA</h5>
        <div className="container">
        <div className="row">
            {
                usertypes.map( (usertype) =>
                    <div className="col-sm-4" >
                        <div className="card text-white bg-dark">
                            <div className="card-body md-5">
                                <h5 name="typeUserName" className="card-title tittle text-center" >{usertype?.typeUserName}</h5>
                                <p name="typeUserDesc" className="md-1" className="card-text subtitle">{usertype?.typeUserDesc}</p>
                                <input name="typeUserId" type="checkbox" className="btn-check" id={'btn-check' + usertype?.typeUserId} value={usertype?.typeUserId} />
                                <label className="btn btn-outline-warning" for={'btn-check' + usertype?.typeUserId} >ELEGIR</label>
                            </div>
                        </div>
                    </div>         
                )
            }
        </div>
        </div>
        </div>
        </>
    );
}

export default UserTypes;
import React from "react";

const Representer = ({ messages }) => {
    return (
        <>
        {
            messages.representers?.map( (representer) =>
                <div className="col-lg-3">
                    <div className="card">
                        <div className="card-body">
                            <img src="" className="img-fluid rounded-circle w-50"></img>
                            <h3>{representer?.representerName}</h3>
                            <h4><b>{representer?.representerRole}</b></h4>
                            <p className="text-dark">{representer?.representerDesc}</p>
                            <div className="d-flex flex-row justify-content-center">
                                <div className="p-4">
                                    <a href="#"><i className="fab fa-facebook-f"></i></a>
                                </div>
                            <div className="p-4">
                                <a href="#"><i className="fab fa-whatsapp"></i></a>
                            </div>
                            <div className="p-4">
                                <a href="#"><i className="fab fa-instagram"></i></a>
                            </div>
                            </div>
                        </div>
                    </div>
                </div>
            )
        }
        </>
    );
}

export default Representer;
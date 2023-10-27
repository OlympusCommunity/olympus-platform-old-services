import React from 'react'
import { Link } from 'react-router-dom'
import './footer.css'

export const Footer = () => {
    return (

        // <footer>
        //     <div class="container p-3">
        //          <div class="row text-center text-white">
        //             <div class="col ml-auto">
        //                 <p>Todos los derechos reservados - Zycryx Creative - Copyright &copy; 2019</p>
        //             </div>
        //         </div>
        //     </div>
        // </footer>

        <footer class="text-center text-lg-start bg-black text-muted">

          <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
            <div class="me-5 d-none d-lg-block">
              <span>Conéctate con nosotros en las redes sociales</span>
            </div>

            <div>
              <a href="" class="me-4 text-reset">
                <i class="fab fa-facebook-f"></i>
              </a>
              <a href="" class="me-4 text-reset">
                <i class="fab fa-twitter"></i>
              </a>
              <a href="" class="me-4 text-reset">
                <i class="fab fa-google"></i>
              </a>
              <a href="" class="me-4 text-reset">
                <i class="fab fa-instagram"></i>
              </a>
              <a href="" class="me-4 text-reset">
                <i class="fab fa-linkedin"></i>
              </a>
              <a href="" class="me-4 text-reset">
                <i class="fab fa-github"></i>
              </a>
            </div>

          </section>
        
          <section>
            <div class="container text-center text-md-start mt-5">

              <div class="row mt-3">

                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">

                  <h6 class="text-uppercase fw-bold mb-4">
                    <i class="fas fa-gem me-3"></i>ZYCRYX BUSINESS
                  </h6>
                  <p>
                  Somos una empresa desarrolladora de software, fabricamos, mantenemos, desplegamos y
                  gestionamos páginas web, aplicaciones móviles y aplicaciones de escritorio.
                  </p>
                </div>

                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
 
                  <h6 class="text-uppercase fw-bold mb-4">
                    Products
                  </h6>
                  <p>
                    <a href="#!" class="text-reset">Angular</a>
                  </p>
                  <p>
                    <a href="#!" class="text-reset">React</a>
                  </p>
                  <p>
                    <a href="#!" class="text-reset">Vue</a>
                  </p>
                  <p>
                    <a href="#!" class="text-reset">Laravel</a>
                  </p>
                </div>

                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">

                  <h6 class="text-uppercase fw-bold mb-4">
                    Useful links
                  </h6>
                  <p>
                    <a href="#!" class="text-reset">Pricing</a>
                  </p>
                  <p>
                    <a href="#!" class="text-reset">Settings</a>
                  </p>
                  <p>
                    <a href="#!" class="text-reset">Orders</a>
                  </p>
                  <p>
                    <a href="#!" class="text-reset">Help</a>
                  </p>
                </div>

                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">

                  <h6 class="text-uppercase fw-bold mb-4">
                    Contacto
                  </h6>
                  <p><i class="fas fa-home me-3"></i> New York, NY 10012, US</p>
                  <p>
                    <i class="fas fa-envelope me-3"></i>
                    contact@olympus.com
                  </p>
                  <p><i class="fas fa-phone me-3"></i> + 1 (223) 216-2546</p>
                  <p><i class="fas fa-print me-3"></i> + 51 955 715 506</p>
                </div>

              </div>

            </div>
          </section>

          <div class="text-center p-4 zycryx">
            Todos los derechos reservados | Copyright &copy; 2021 | Desarrollado por
            <a class="text-reset fw-bold" href="https://zycryx.com/"> Zycryx Business</a>
          </div>

        </footer>
    )
}

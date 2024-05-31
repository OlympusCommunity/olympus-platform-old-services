<?php 
	include '../extend/navbar.php'; 	
?>

<head>
  <title>ＯＬＹＭＰＵＳ│ CONTACTO</title>
  <link rel="stylesheet" href="../css/inicio.css">
</head>

<br>
<br>
<br>

<!-- CONTACT -->
    <section class="bg-dark text-white py-5">
      <div class="container">
        <div class="row">
          <div class="col-lg-9">
            <h3>Contáctanos</h3>
            <p>
              ¿Tienes alguna consulta o quisieras trabajar con nostros?
            </p>
            <form action="">
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <i class="fas fa-user input-group-text"></i>
                </div>
                <input type="text" class="form-control" placeholder="Nombre" aria-label="Username" aria-describedby="basic-addon1">
              </div>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <i class="fas fa-envelope input-group-text"></i>
                </div>
                <input type="text" class="form-control" placeholder="E-mail" aria-label="Username" aria-describedby="basic-addon1">
              </div>
              <div class="input-group mb-3">
                <div class="input-group-prepend">
                  <i class="fas fa-pencil-alt input-group-text"></i>
                </div>
                <textarea name="" cols="30" rows="10" placeholder="Mensaje" class="form-control"></textarea>
              </div>
              <button type="submit" class="btn btn-primary btn-block">ENVIAR</button>
            </form>
          </div>
          <div class="col-lg-3 align-self-center">
            <img src="../img/product.png" alt="">
          </div>
        </div>
      </div>
    </section>

<?php include '../extend/footer.php'; ?>
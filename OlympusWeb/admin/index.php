<?php 
	include '../extend/navbar.php'; 	
?>

<head>
  <title>ＯＬＹＭＰＵＳ│ INICIO</title>
  <link rel="stylesheet" href="../css/inicio.css">
</head>

	<!-- HEADER -->
	<header class="main-header">
      <div class="background-overlay text-white py-5">
        <div class="container">
          <div class="row d-flex h-100">
            <div class="col-sm-6 text-center justify-content-center align-self-center">
              <h1>
              	<br>
                Conoce gente y grupos de tu mismo interés.
              </h1>
              <p>Plataforma Online que te permitirá contactar a personas con un interés común, aficionados y profesionales.</p>
              <a href="grupos.php" class="btn btn-outline-secondary btn-lg text-white">
                Ver Grupos
              </a>
            </div>
            <div class="col-sm-6">
              <img src="../img/product.png" class="img-fluid d-none d-sm-block">
            </div>
          </div>
        </div>
      </div>
  </header>

  <!-- NEWSLETTER  -->
<div class="container text-white" style="margin-top: 3%;">
    <h2>Grupos Populares</h2>

  <div class="row">
      <?php 
      $sel_group = $con->prepare("SELECT gr.id_grupo as codigo, gr.nombre AS name, u.nombre AS founder, gr.foto AS foto, gr.descripcion AS descri, gr.costo AS costo FROM grupos_red AS gr, usuarios AS u WHERE gr.id = u.id");
      $sel_group->execute();
      while ($f_group = $sel_group->fetch()) {
      ?>
    <div class="col-md-6 col-sm-12 col-lg-3">

        <div class="card team" style=" margin-top: 1%;">
          <img class="card-img-top img-fluid" src="../img/Groups/<?php echo $f_group['foto'] ?>" alt="Card image cap">
          
          <div class="card-body">
            <h5 class="card-title text-center"><?php echo $f_group['name'] ?></h5>
            <h6 class="card-title"><b>Founder: </b><?php echo $f_group['founder'] ?></h6>
            <p class="card-text"><?php echo substr($f_group['descri'] , 0, 100) ?>...</p>
            <a href="#">Ver más...</a>

            <?php  
              $nombre_grupo = $f_group['name'];
            ?>

            <?php 
            $sel_links = $con->prepare("SELECT rd.link, ps.plataforma AS plataforma, ps.button AS btn, ps.image AS img FROM red_social AS rd, grupos_red AS gr, plataforma_social AS ps WHERE rd.id_grupo = gr.id_grupo AND rd.id_plat = ps.id_plat AND gr.nombre = '$nombre_grupo' ");
            $sel_links->execute();
            while ($f_link = $sel_links->fetch()) {
            ?>

            <a href="<?php echo $f_link['link'] ?>" class="<?php echo $f_link['btn'] ?>">
              <i class="<?php echo $f_link['img'] ?>"></i>  <?php echo $f_link['plataforma'] ?>
            </a>

            <?php }
            $sel_links = null;
            ?>

          </div>
        </div>
      </div>


          <?php }
            $sel_group = null;
            ?>
  </div>
</div>

<br>

<?php include '../extend/footer.php'; ?>


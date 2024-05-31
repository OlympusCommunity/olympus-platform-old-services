<?php 
	include '../extend/navbar.php'; 	
?>

<head>
  <title>ＯＬＹＭＰＵＳ│ GRUPOS</title>
  <link rel="stylesheet" href="../css/inicio.css">
</head>

<div class="container text-light text-center bg-dark">
	<br>
	<br>
	<br>
	<br>
	<br>
      <h1>GRUPOS DEL OLYMPUS</h1>
</div>
 <hr>

 <!-- NEWSLETTER  -->
<div class="container text-white" style="margin-top: 3%;">

    <h3>Estos son tus grupos <?php echo $_SESSION['name'] ?></h3>

  <div class="row">

      <?php 
      $correo = $_SESSION['correo_user'];
      $sel_group = $con->prepare("SELECT gr.id_grupo as codigo, gr.nombre AS name, u.nombre AS founder, gr.foto AS foto, gr.descripcion AS descri, gr.costo AS costo FROM grupos_red AS gr, usuarios AS u WHERE gr.id = u.id AND u.correo = ? ");
      $sel_group->execute(array($correo));
      while ($f_group = $sel_group->fetch()) {
      ?>
    <div class="col-md-6 col-sm-12 col-lg-3">

        <div class="card team" style=" margin-top: 1%;">
          <img class="card-img-top img-fluid" src="../img/Groups/<?php echo $f_group['foto'] ?>" alt="Card image cap">
          
          <div class="card-body">
            <h5 class="card-title text-center"><?php echo $f_group['name'] ?></h5>
            <h6 class="card-title"><b>Founder: </b><?php echo $f_group['founder'] ?></h6>
            <p class="card-text"><?php echo substr($f_group['descri'] , 0, 100) ?>...</p>

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

  <a id="btnAdminGrupos" class="btn btn-outline-success btn-lg btn-block" href="gestion_grupos.php">ADMINISTRACIÓN DE GRUPOS</a>

</div>

<br>

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

    <a id="btnAdminGrupos" class="btn btn-outline-primary btn-lg btn-block" href="gestion_grupos.php">BUSCAR GRUPOS</a>

</div>

<br>
<?php include '../extend/footer.php'; ?>
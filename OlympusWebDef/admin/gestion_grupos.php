<?php 
	include '../extend/perfil_navbar.php'; 	
?>
<head>
  <title>ＯＬＹＭＰＵＳ│ GESTIÓN</title>
  <link rel="stylesheet" href="../css/inicio.css">
</head>

<div class="main-content">
		<div class="title">GESTION DE GRUPOS</div>

	<div class="container">
		<br>
		<a class="btn btn-outline-success btn-lg btn-block" href="nuevo_grupo.php">CREAR NUEVO GRUPO</a>
  <br>
			<div class="card text-white bg-dark" >
				<div class="card-header "><h4 class="card-title">GRUPOS REGISTRADOS</h4></div>
				<div class="card-body text-white">	
					<table class="table">
						<thead>
							<th class="card-header text-white">Foto</th>
							<th class="card-header text-white">Grupo</th>
							<th class="card-header text-white">Precio</th>
							<th class="card-header text-white">Descripción.</th>
						</thead>
						<tbody>
	<?php 
      $correo = $_SESSION['correo_user'];
      $sel_group = $con->prepare("SELECT gr.id_grupo as codigo, gr.nombre AS name, u.nombre AS founder, gr.foto AS foto, gr.descripcion AS descri, gr.costo AS costo FROM grupos_red AS gr, usuarios AS u WHERE gr.id = u.id AND u.correo = ? ");
      $sel_group->execute(array($correo));
      while ($f_group = $sel_group->fetch()) {
      ?>
							  	<tr>
							  		<td class="card-header text-white"><img src="../img/Groups/<?php echo $f_group['foto'] ?>" width="50" heigth="50" ></td>
							  		<td class="card-header text-white"><?php echo $f_group['name'] ?></td>
							  		<td class="card-header text-white"><?php echo "$". number_format($f_group['costo'], 2) ?></td>
							  		<td class="card-header text-white" colspan="2"><?php echo substr($f_group['descri'] , 0, 100) ?>...
							  			<hr>
							  		<a href="agregar_grupo.php?codigo=<?php echo $f_group['codigo'] ?>" class="btn btn-outline-success btn-sm"><span class="material-icons">Agregar</span></a>

							  		<a href="editar_grupo.php?codigo=<?php echo $f_group['codigo'] ?>" class="btn btn-outline-primary btn-sm"><span class="material-icons">Editar</span></a>

							  		<a href="#" class="btn btn-outline-danger btn-sm" onclick="bootbox.confirm('Seguro que desea realizar esta accion', function(result){ if (result == true){ location.href='eliminar_producto.php?codigo=<?php echo $f_group['codigo'] ?>&foto=<?php echo $f_group['foto'] ?>&pag=inventario.php';} })"><span class="material-icons" >Eliminar</span></a></td>
							  	</tr>
			<?php }
            $sel_group = null;
            ?>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</div>
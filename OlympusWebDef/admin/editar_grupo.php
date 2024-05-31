<?php 
	include '../extend/perfil_navbar.php'; 	
	$codigo = htmlentities($_GET['codigo']);
	$sel = $con->prepare("SELECT gr.id_grupo as codigo, gr.nombre AS name, u.nombre AS founder, gr.foto AS foto, gr.descripcion AS descri, gr.costo AS costo FROM grupos_red AS gr, usuarios AS u WHERE gr.id = u.id AND gr.id_grupo = ? ");
	$sel->execute(array($codigo));
  		if ($f = $sel->fetch()) { 
  		}
  		$sel = null;

  	$sel_cat = $con->prepare("SELECT id_tema, tematica FROM grupos_tema");
  	$sel_cat->execute();
?>

<head>
  <title>ＯＬＹＭＰＵＳ│ GESTIÓN</title>
  <link rel="stylesheet" href="../css/inicio.css">
</head>

<div class="main-content">
	<div class="title">GESTION DE GRUPOS</div>

<div class="container" style="margin-top: 1%;">
	<div class="card text-white bg-dark">
			<div class="card-header"><h4 class="card-title">EDITAR GRUPO</h4></div>
			<div class="card-body">
				<form action="up_grupo.php" method="post" autocomplete="off" enctype="multipart/form-data">
					<input type="hidden" name="codigo" value="<?php echo $codigo ?>">
					<div class="form-group">
						<p>Nombre del grupo:</p>
						<input type="text" name="name" required placeholder="NOMBRE DEL GRUPO" class="form-control" value="<?php echo $f['name'] ?>">
					</div>
					<div class="form-group">
						<p>Logo del grupo:</p>
						<img src="../img/Groups/<?php echo $f['foto'] ?>" width="200">
					</div>
					<div class="form-group">
						<input type="file" name="imagen" class="form-control">
					</div>
					<input type="hidden" name="anterior" value="<?php echo $f['foto'] ?>">
					<div class="form-group">
						<p>Costo del grupo:</p>
						<input type="number" step="0.01" required name="costo" placeholder="COSTO" class="form-control" value="<?php echo $f['costo'] ?>">

						<div class="form-check">
  							<input type="checkbox" class="form-check-input" id="materialChecked2" checked>
  							<label class="form-check-label" for="materialChecked2">Grupo Gratuito</label>
						</div>

					</div>

					<div class="form-group">
						<p>Descripción</p>
						<textarea name="DESCRIPCION" required cols="30" rows="10" class="form-control"><?php echo $f['descri'] ?></textarea>
					</div>

					<div class="form-group row">
    					<div class="col-sm-2">Temáticas</div>
    					<div class="col-sm-10">

							<div class="form-group">

								<select name="categoria" multiple required class="form-control">
								<?php
								while ($f_cat = $sel_cat->fetch()) {
								?>
									<option value="<?php echo $f_cat['id_tema'] ?>"><?php echo $f_cat['tematica'] ?></option>
								<?php }
								$sel_links = null;
								?>
								</select>

							</div>

						</div>
					</div>
      				
					<button type="submit" class="btn btn-info">EDITAR</button>

				</form>
			</div>
		</div>
	</div>
</div>
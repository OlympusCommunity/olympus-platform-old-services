<?php 
	include '../extend/perfil_navbar.php'; 	
	
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
			<div class="card-header"><h4 class="card-title">NUEVO GRUPO</h4></div>
			<div class="card-body">
				<form action="up_grupo.php" method="post" autocomplete="off" enctype="multipart/form-data">
					<input type="hidden" name="codigo" >
					<div class="form-group">
						<p>Nombre del grupo:</p>
						<input type="text" name="name" required placeholder="NOMBRE DEL GRUPO" class="form-control" >
					</div>
					<div class="form-group">
						<p>Logo del grupo:</p>
						<img src="../img/Groups/principal.png" width="200">
					</div>
					<div class="form-group">
						<input type="file" name="imagen" class="form-control">
					</div>
					<input type="hidden" name="anterior" src="../img/Groups/principal.png">
					<div class="form-group">
						<p>Costo del grupo:</p>
						<input type="number" step="0.01" required name="costo" placeholder="COSTO" class="form-control" >

						<div class="form-check">
  							<input type="checkbox" class="form-check-input" id="materialChecked2" checked>
  							<label class="form-check-label" for="materialChecked2">Grupo Gratuito</label>
						</div>

					</div>

					<div class="form-group">
                        <p>Descripción</p>
						<textarea name="DESCRIPCION" required cols="30" rows="10" class="form-control"></textarea>
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
      				
					<button type="submit" class="btn btn-success">AGREGAR</button>

				</form>
			</div>
		</div>
	</div>
</div>
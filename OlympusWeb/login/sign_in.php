<!DOCTYPE html>
<html>
<head>
	<title>OLYMPUS │ Sign In</title>
	<link rel="icon" type="image/png" href="../img/icono.ico" />
	<link rel="stylesheet" href="../css/sign_in.css">

	<!--JQUERY-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- FRAMEWORK BOOTSTRAP para el estilo de la pagina-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <!-- Los iconos tipo Solid de Fontawesome-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
    <script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
    <!-- Nuestro css-->
    <link rel="stylesheet" type="text/css" href="../css/sign_in.css" th:href="@{/css/sign_in.css}">
</head>
<body class="body-black text-white">

    <div class="modal-dialog text-center text-dark">
        <div class="col-sm-8 main-section">
            <div class="modal-content">
                <div class="col-12 user-img">
                    <img src="../img/user.png" th:src="@{/img/user.png}"/>
                </div>
                <p class="text-success text-center">
					Bienvenido a Olympus
				</p>
                <form class="col-12" th:action="@{/login}" method="POST">
                    <div class="form-group" id="user-group">
                        <input type="text" class="form-control" placeholder="E-mail o Username" name="username"/>
                    </div>
                    <div class="form-group" id="contrasena-group">
                        <input type="password" class="form-control" placeholder="Contraseña" name="password"/>
                    </div>
                    <button type="submit" class="btn btn-primary"><i class="fas fa-sign-in-alt"></i>  Ingresar </button>
                </form>
                <div class="col-12 forgot">
                    <a href="#">¿Ha olvidado la contraseña?</a>
                </div>
                
					<button id="btn-Google" href="" class="btn btn-block btn-outline-danger"><i class="fab fa-google"></i>   Login via Google</button>

					<button id="btn-Facebook" href="" class="btn btn-block btn-outline-primary"> <i class="fab fa-facebook-f"></i>   Login via facebook</button>		
				    
                    <br>
                    
                    <a href="sign_up.php">Regístrate</a>
            </div>
        </div>
    </div>
    
    <!-- Bootstrap JS CDN -->
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <!-- JQuerry -->
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Firebase -->
    <script src="https://www.gstatic.com/firebasejs/5.9.1/firebase.js"></script>
    <!-- App JS Integrity -->
    <script type="text/javascript" src="../js/app.js"></script>
</body>
</html>
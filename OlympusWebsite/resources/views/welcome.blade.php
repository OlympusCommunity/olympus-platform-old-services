<!doctype html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>ＯＬＹＭＰＵＳ</title>

        <link rel="icon" type="image/png" href="/img/icono.ico" />

        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,600" rel="stylesheet">

        <!-- Style -->
        <link rel="stylesheet" href="/css/index.css">

        <!-- Boostrap -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
    <body>

        <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="3000">
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>

            <div class="carousel-inner" role="listbox">
                <div class="carousel-item active">
                    <img src="/img/Silder/1.png" class="d-block w-100">
                    <div class="carousel-caption">
                        <h3>Bienvenido al Imperio Olympus</h3>
                       <p>Bienvenidos a la red de grupos de WhatsApp más grande del mundo.</p>
                        <button type="button" class="btn btn-success"><a href="#">ENTRAR</a></button>
                    </div>
                </div>

                <div class="carousel-item">
                    <img src="/img/Silder/2.png" class="d-block w-100">
                    <div class="carousel-caption">
                        <h3>Crea y personaliza tu grupo en alguna red social</h3>
                        <p>Bienvenidos a la red de grupos de WhatsApp más grande del mundo.</p>

                        @if (Route::has('login'))
                            <div class="top-right links">
                                @auth
                                    <a href="{{ url('/home') }}">Home</a>
                                @else
                                    <button type="button" class="btn btn-success"><a href="{{ route('login') }}">INICIAR SESIÓN</a></button>
                                    @if (Route::has('register'))
                                        <button type="button" class="btn btn-primary"><a href="{{ route('register') }}">REGÍSTRATE</a></button>
                                    @endif
                                @endauth
                            </div>
                        @endif
                    </div>
                </div>

                <div class="carousel-item">
                    <img src="/img/Silder/3.png" class="d-block w-100">
                    <div class="carousel-caption">
                        <h3>Publica tu publicidad en toda la red de grupos del Olympus</h3>
                        <p>Bienvenidos a la red de grupos de WhatsApp más grande del mundo.</p>
                        <button type="button" class="btn btn-success"><a href="#">INICIAR</a></button>
                    </div>
                </div>

                <a href="#myCarousel" class="carousel-control-prev" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previus</span>
                </a>

                <a href="#myCarousel" class="carousel-control-next" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>

            </div>
        </div>

        <!-- Scrips -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>

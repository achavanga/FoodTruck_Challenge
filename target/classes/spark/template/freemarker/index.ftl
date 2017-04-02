<!DOCTYPE html>
<html>
    <head>
  <#include "header.ftl">
        </head>

    <body>

        <header id="header">
            <nav class="navbar navbar-default navbar-fixed-top">
                <div class="jumbotron text-center">
                    <div class="container">
                        <a href="/" class="lang-logo">
                            <img src="/logo.jpg">
                            </a>
                        <h3>Find Food Trucks Near You</h3>
                        <!--<p>Find food trucks near you.</p>-->
                        <form id="search"  method="POST">
                            <input name="q" type="text" class="query form-control" placeholder="What kind of food do you like?" />
                            </form>
                        </div>
                    </div>
                </nav>
            </header>
    <!--        <div class="jumbotron text-center">
                <div class="container">
                    <a href="/" class="lang-logo">
                        <img src="/logo.jpg">
                        </a>
                    <h2>Food Trucks</h2>
                    <p>Find food trucks near you.</p>
                    <div id="floating-panel">
                        <form id="search" class="input-group" method="POST">
                            <input name="q" type="text" class="query form-control" placeholder="What kind of food do you like?" />
                            </form>
                        </div> 
                    </div>
                </div>-->
        <!--<div class="container">-->
        <ul id="map"></ul>
        <script src="/js/foodtruck.js" type="text/javascript" charset="utf-8"></script>
    <!--</div>-->
   
      <div class="alert alert-info text-center" role="alert">
      Chavanga Abel
     </div>
   <!--</div>-->


        </body>
    </html>

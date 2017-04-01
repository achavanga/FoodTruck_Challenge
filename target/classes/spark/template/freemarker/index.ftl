<!DOCTYPE html>
<html>
    <head>
  <#include "header.ftl">
        </head>

    <body>


        <div class="jumbotron text-center">
            <div class="container">
                <a href="/" class="lang-logo">
                    <img src="/logo.jpg">
                    </a>
                <h2>Food Trucks</h2>
                <p>Find food trucks near you.</p>
                <form id="search" class="input-group" method="POST">
                    <input name="q" type="text" class="query form-control" placeholder="What kind of food do you like?" />
                    </form>
<!--                <a type="button" class="btn btn-lg btn-default" href="https://devcenter.heroku.com/articles/getting-started-with-java"><span class="glyphicon glyphicon-flash"></span> Getting Started with Java</a>
                <a type="button" class="btn btn-lg btn-primary" href="https://github.com/heroku/java-getting-started"><span class="glyphicon glyphicon-download"></span> Source on GitHub</a>-->
                </div>
            </div>
            <!--<div class="container">-->
        <ul id="map"></ul>
        <script src="/js/foodtruck.js" type="text/javascript" charset="utf-8"></script>
   <!--
      <div class="alert alert-info text-center" role="alert">
      Chavanga Abel
     </div>-->
   <!--</div>-->


        </body>
    </html>

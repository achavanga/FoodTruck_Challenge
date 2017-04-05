<!DOCTYPE html>
<html>
    <head>
  <#include "header.ftl">
        </head>

    <body>
        <div id="navbar-wrapper">
            <header>
                <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                </button>
                            <a class="navbar-brand" href="#">Find Approved Food Trucks Near You :</a>
                            </div>
                        <div id="navbar-collapse" class="collapse navbar-collapse">

                            <form id="search"  method="POST" class="navbar-form navbar-left" role="search">
                                <div class="input-group">
                                    <input name="q" type="text" class="query form-control" placeholder="What kind of food do you like?">
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                                        </span>
                                    </div>
                                </form>
                            <ul class="nav navbar-nav navbar-right">                           
                                <li class="dropdown">
                                    <a id="user-profile" href="#" class="dropdown-toggle" data-toggle="dropdown">                                      
                                        <img src="/logo.jpg" class="img-responsive img-thumbnail img-circle">
                                        </a>

                                </ul>
                            </div>
                        </div>
                    </nav>
                </header>
            </div>
        <div id="wrapper">
            <div id="sidebar-wrapper">
                <div id="results">
                    <h2>
                        Food Trucks:
                        </h2>
                    <p id="result-list">No results yet</p>
                    </div>          
                </div>
            </div> 
        <ul id="map"></ul>
        <script src="/js/foodtruck.js" type="text/javascript" charset="utf-8"></script>
        </body>
    </html>

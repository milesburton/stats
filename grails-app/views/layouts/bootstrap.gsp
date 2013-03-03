<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta charset="utf-8">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">


    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <r:require module="bootstrap"/>

    <g:layoutHead/>
    <r:layoutResources/>
</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="#">Razer Folding@Home Statistics</a>

            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="/">Home</a></li>
                    <li><a href="http://www.milesburton.com">Contact</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span3">
            <div class="well sidebar-nav">
                <ul class="nav nav-list">
                    <li class="nav-header">REST API Documentation</li>
                    <li><a href="/docs/get-teams">teams/</a></li>
                    <li><a href="/docs/get-history-for-team">teams/:team-id/history</a></li>
                    <li><a href="/docs/get-users-for-team">teams/:team-id/users</a></li>
                    <li><a href="/docs/get-users">users/</a>
                    <li class="nav-header">Examples</li>
                </li>
                </ul>

            </div><!--/.well -->
        </div><!--/span-->
        <div class="span9">
            <g:layoutBody/>
        </div><!--/span-->
    </div><!--/row-->


    <hr>

    <footer>
        <p>&copy; <a href="http://www.agileview.co.uk">Agile View Limited 2013</a></p>
    </footer>

</div>

<g:javascript library="bootstrap"/>
<r:layoutResources/>
</body>
</html>

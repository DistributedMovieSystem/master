<%@ page import="myBean.Movie" %>
<%@ page import="java.util.*" %>
<%@ page import="sun.net.httpserver.HttpServerImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">

    <title>Movie Review</title>

    <!-- Loading third party fonts -->
    <link href="http://fonts.googleapis.com/css?family=Roboto:300,400,700|" rel="stylesheet" type="text/css">
    <link href="fonts/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- Loading main css file -->
    <link rel="stylesheet" href="style.css">

    <!--[if lt IE 9]>
    <script src="js/ie-support/html5.js"></script>
    <script src="js/ie-support/respond.js"></script>
    <![endif]-->

</head>


<body>


<div id="site-content">
    <header class="site-header">
        <div class="container">
            <a href="index.jsp" id="branding">
                <img src="images/logo.png" alt="" class="logo">
                <div class="logo-copy">
                    <h1 class="site-title">Movie Review</h1>
                    <small class="site-description">Find movies for you</small>
                </div>
            </a> <!-- #branding -->

            <div class="main-navigation">
                <button type="button" class="menu-toggle"><i class="fa fa-bars"></i></button>
                <ul class="menu">
                    <li class="menu-item current-menu-item"><a href="review.jsp">Movie reviews</a></li>
                </ul> <!-- .menu -->

                <form action="#" class="search-form">
                    <input type="text" placeholder="Search...">
                    <button><i class="fa fa-search"></i></button>
                </form>
            </div> <!-- .main-navigation -->

            <div class="mobile-navigation"></div>
        </div>
    </header>
    <main class="main-content">
        <div class="container">
            <div class="page">
                <div class="breadcrumbs">
                    <a href="review.jsp">Movie Review</a>
                    <span>Home</span>
                </div>

                <div class="filters">
                    <select name="type" id="type" placeholder="Choose Category">
                        <option value="#">剧情</option>
                        <option value="#">爱情</option>
                        <option value="#">科幻</option>
                        <option value="#">冒险</option>
                        <option value="#">动作</option>
                        <option value="#">喜剧</option>
                    </select>
                    <select name="year" id="year">
                        <option value="#">2017</option>
                        <option value="#">2016</option>
                        <option value="#">2015</option>
                    </select>
                </div>
                <div class="movie-list">
                    <%
                        List<Movie> movies = new ArrayList<Movie>();
                        movies =(List<Movie>)session.getAttribute("movie");
                        if (movies != null) {
                            Movie m = new Movie();
                            for (int i = 0; i < movies.size(); i++) {
                                m = movies.get(i);
                    %>
                    <div class="movie">
                        <figure class="movie-poster"><img src=<%=m.getPost_url()%> alt="#"></figure>
                        <div class="movie-title"><a href="single.jsp"><%=m.getM_name()%></a></div>
                        <p><%=m.getSummary()%></p>
                    </div>
                    <%}} %>
                </div> <!-- .movie-list -->

                <div class="pagination">
                    <a href="#" class="page-number prev"><i class="fa fa-angle-left"></i></a>
                    <span class="page-number current">1</span>
                    <a href="#" class="page-number">2</a>
                    <a href="#" class="page-number">3</a>
                    <a href="#" class="page-number">4</a>
                    <a href="#" class="page-number">5</a>
                    <a href="#" class="page-number next"><i class="fa fa-angle-right"></i></a>
                </div>
            </div>
        </div> <!-- .container -->
    </main>

</div>
<!-- Default snippet for navigation -->



<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/plugins.js"></script>
<script src="js/app.js"></script>

</body>

</html>

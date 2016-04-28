<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 4/28/2016
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>

    <!-- Bootstrap Setups -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Simple Sidebar - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/simple-sidebar.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

    <![endif]-->

</head>


<body>

<div id="wrapper">

    <!-- Sidebar -->
    <c:import url="jsp.sidebar.jsp"/>

    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1>Simple Sidebar</h1>
                    <p>This template has a responsive menu toggling system. The menu will appear collapsed on smaller
                        screens, and will appear non-collapsed on larger screens. When toggled using the button below,
                        the menu will appear/disappear. On small screens, the page content will be pushed off
                        canvas.</p>
                    <p>Make sure to keep all page content within the <code>#page-content-wrapper</code>.</p>
                    <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle Menu</a>

                    <a href="#add-collapsible" class="btn btn-default" id="add-collapsible">Add Collapsible</a>


                    <!-- Collapsible Content Dynamic Content Start-->
                    <div id="start" ></div>

                    <!-- Collapsible Content Static Content Start -->
                    <p>Here is an example of some content that I should be creating with Javascript</p>

                    <div class="panel-group">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" href="#game1_level1">Game 1</a>
                                </h4>
                            </div>
                            <div id="game1_level1" class="panel-collapse collapse">
                                <div class="panel-group">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                                <a data-toggle="collapse" href="#game1_level2_id1"> -- Factions</a>
                                            </h4>
                                        </div>
                                        <div id="game1_level2_id1" class="panel-collapse collapse">
                                            <!-- Collapsible Content -->
                                            <div class="panel-group">
                                                <div class="panel panel-default">
                                                    <div class="panel-heading">
                                                        <h4 class="panel-title">
                                                            <a data-toggle="collapse"
                                                               href="#game1_level2_id1_iteration1"> ---- Tremere </a>
                                                        </h4>
                                                    </div>
                                                    <div id="game1_level2_id1_iteration1"
                                                         class="panel-collapse collapse">
                                                        <div class="panel-body">Panel Body</div>
                                                        <div class="panel-footer">Panel Footer</div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Collapsible Content -->
                                            <div class="panel-group">
                                                <div class="panel panel-default">
                                                    <div class="panel-heading">
                                                        <h4 class="panel-title">
                                                            <a data-toggle="collapse"
                                                               href="#game1_level2_id1_iteration2"> ---- Giovanni</a>
                                                        </h4>
                                                    </div>
                                                    <div id="game1_level2_id1_iteration2"
                                                         class="panel-collapse collapse">
                                                        <div class="panel-body">Panel Body</div>
                                                        <div class="panel-footer">Panel Footer</div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Collapsible Content -->
                                            <div class="panel-group">
                                                <div class="panel panel-default">
                                                    <div class="panel-heading">
                                                        <h4 class="panel-title">
                                                            <a data-toggle="collapse"
                                                               href="#game1_level2_id1_iteration3"> ---- Followers of
                                                                Set</a>
                                                        </h4>
                                                    </div>
                                                    <div id="game1_level2_id1_iteration3"
                                                         class="panel-collapse collapse">
                                                        <div class="panel-body">Panel Body</div>
                                                        <div class="panel-footer">Panel Footer</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!-- Collapsible Content -->
                                <div class="panel-group">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                                <a data-toggle="collapse" href="#game1_level2_id2"> -- Disciplines</a>
                                            </h4>
                                        </div>
                                        <div id="game1_level2_id2" class="panel-collapse collapse">
                                            <div class="panel-body">Panel Body</div>
                                            <div class="panel-footer">Panel Footer</div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Collapsible Content -->
                                <div class="panel-group">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                                <a data-toggle="collapse" href="#game1_level2_id3"> -- Systems and
                                                    Drama</a>
                                            </h4>
                                        </div>
                                        <div id="game1_level2_id3" class="panel-collapse collapse">
                                            <div class="panel-body">Panel Body</div>
                                            <div class="panel-footer">Panel Footer</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Collapsible Content -->
                    <div class="panel-group">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" href="#game2_level1">Game 2</a>
                                </h4>
                            </div>
                            <div id="game2_level1" class="panel-collapse collapse">

                                <!-- Collapsible Content -->
                                <div class="panel-group">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title">
                                                <a data-toggle="collapse" href="#game2_level2">Collapsible panel 2</a>
                                            </h4>
                                        </div>
                                        <div id="game2_level2" class="panel-collapse collapse">
                                            <div class="panel-body">Panel Body</div>
                                            <div class="panel-footer">Panel Footer</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>
</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Menu Toggle Script -->
<script>
    var game_id = "0";
    var listing_id = "0";
    var sublisting_id = "0";
    var description_id = "0";
    $("#menu-toggle").click(function (e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });

    <!--    Using this function to simulate a "page-init" of the dynamically created level 1 table html elements -->
    <!--        So I can figure out how things are going to need to be created. -->

    $("#add-collapsible").click(function (e) {
        e.preventDefault();
        game_id = (parseInt(game_id) + 1).toString();
        var content = "<div class='panel-group' onclick=genLevelTwo(" + game_id.toString() + ")><div class='panel panel-default'><div class='panel-heading'><h4 class='panel-title'><a data-toggle='collapse' href='#game_level" + game_id.toString() + "'>Game " + game_id.toString() + "</a></h4></div><div id='game_level" + game_id.toString() + "' class='panel-collapse collapse'> <div class='panel-body'>Panel Body</div> <div class='panel-footer'><div id ='level_1_id_" + game_id.toString() + "' </div>Panel Footer</div></div>";
        $(content).appendTo("#start");
    });
    <!-- So when the collapsible is clicked, then it will build the sub colapsibles that exist one level underneath it. -->
    <!-- maybe will need three / four of these to work for the different levels. -->
    function genLevelTwo (game_id) {
        var numberPanels = $("start").toString();
        alert("Child element count :  " + numberPanels +
                "  Current game id" + game_id);
    };
</script>

</body>

</html>

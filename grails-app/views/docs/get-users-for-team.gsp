<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="bootstrap"/>
    <title>/v1/teams/:teamid/users</title>
</head>

<body>
<section>

    <header>
        <h1>GET /v1/teams/:teamid/users</h1>
    </header>

    <p>Retrieve the details of all users within a specified, and narrow down the results with specific arguments.</p>

    <h2>Parameters</h2>

    <p>All parameters are optional.</p>

    <table class="parameters">
        <thead>
        <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>order</td>
            <td>string</td>
            <td>The order to sort the results by. <span>Defaults to &#8220;ptsTotal&#8221;. Valid options are ${grailsApplication.config.stats.users.sort.options.collect { "&#8220;$it&#8221;" }.join(", ")}
            </td>
        </tr>
        <tr>
            <td>limit</td>
            <td>integer</td>
            <td>The number of results per page. <span>Defaults to &#8220;50&#8221;. Min: &#8220;1&#8221;, Max: &#8220;1000&#8221;</span>
            </td>
        </tr>
        </tbody>
    </table>

    <h2>Errors</h2>

    <table class="errors">
        <thead>
        <tr>
            <th>Status</th>
            <th>Reason</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>400</td>
            <td>Invalid query.</td>
        </tr>
        </tbody>
    </table>

    <h2>Example</h2>

    <div class="highlight"><pre><code>
        GET /v1/teams/62/users HTTP/1.1
        Host: api.razerstats.com
        Content-Type: application/json; charset=utf-8</code></pre>
    </div>

    <div class="highlight"><pre><code class="js">
        HTTP/1.1 200 OK
        Content-Type: application/json; charset=utf-8
        Content-Length: <span class="variable">length</span>


        {
        "total":1577774,
        "results":[
        {
        "teamId":0,
        "alias":"anonymous",
        "ptsTotal":30865642,
        "ptsDelta":30865642,
        "wuTotal":4394662783,
        "wuDelta":4394662783,
        "rank":1,
        "rankDelta":1,
        "rankTeam":0,
        "rankTeamDelta":0,
        "ptsDay":0,
        "ptsWeek":0
        },
        {
        "teamId":62,
        "alias":"PS3",
        "ptsTotal":11614888,
        "ptsDelta":11614888,
        "wuTotal":2812781923,
        "wuDelta":2812781923,
        "rank":2,
        "rankDelta":2,
        "rankTeam":0,
        "rankTeamDelta":0,
        "ptsDay":0,
        "ptsWeek":0
        },
        {
        "teamId":62,
        "alias":"its_me",
        "ptsTotal":1181026,
        "ptsDelta":1181026,
        "wuTotal":402595989,
        "wuDelta":402595989,
        "rank":3,
        "rankDelta":3,
        "rankTeam":0,
        "rankTeamDelta":0,
        "ptsDay":0,
        "ptsWeek":0
        },
        {
        "teamId":62,
        "alias":"eastms.edu",
        "ptsTotal":1150128,
        "ptsDelta":1150128,
        "wuTotal":137938712,
        "wuDelta":137938712,
        "rank":4,
        "rankDelta":4,
        "rankTeam":0,
        "rankTeamDelta":0,
        "ptsDay":0,
        "ptsWeek":0
        },
        {
        "teamId":62,
        "alias":"_",
        "ptsTotal":897086,
        "ptsDelta":897086,
        "wuTotal":199779355,
        "wuDelta":199779355,
        "rank":5,
        "rankDelta":5,
        "rankTeam":0,
        "rankTeamDelta":0,
        "ptsDay":0,
        "ptsWeek":0
        }
        }
    </code></pre>
    </div>
</section>
</body>
</html>
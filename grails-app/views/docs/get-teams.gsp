<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="bootstrap"/>
    <title>/v1/teams</title>
</head>

<body>
<section>

    <header>
        <h1>GET /v1/teams</h1>
    </header>

    <p>Retrieve the details of all teams, and narrow down the results with specific arguments.</p>

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
            <td>The order to sort the results by. <span>Defaults to &#8220;ptsTotal&#8221;. Valid options are ${grailsApplication.config.stats.teams.sort.options.collect { "&#8220;$it&#8221;" }.join(", ")}
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
    GET /v1/teams HTTP/1.1
    Host: api.razerstats.com
    Content-Type: application/json; charset=utf-8</code></pre>
    </div>

    <div class="highlight"><pre><code class="js">
    HTTP/1.1 200 OK
    Content-Type: application/json; charset=utf-8
    Content-Length: <span class="variable">length</span>

        {
            "total":63931,
            "results":
            [
                {
                "teamId":0,
                "alias":"Default (includes all those WU returned without valid team number)",
                "ptsTotal":26086434624,
                "ptsDelta":3191416,
                "wuTotal":103789980,
                "rank":1,
                "rankDelta":0,
                "ptsDay":0,
                "ptsWeek":0
                }
            ]
        }
    </code></pre>
    </div>
</section>
</body>
</html>
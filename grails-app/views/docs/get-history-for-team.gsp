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
            <td>The order to sort the results by. <span>Defaults to &#8220;ptsTotal&#8221;. Valid options are ${grailsApplication.config.stats.teams.sort.options.collect { "&#8220;$it&#8221;" }.join(", ")}</span>
            </td>
        </tr>
        <tr>
            <td>limit</td>
            <td>integer</td>
            <td>The number of results per page. <span>Defaults to &#8220;50&#8221;. Min: &#8220;1&#8221;, Max: &#8220;1000&#8221;</span>
            </td>
        </tr>
        <tr>
            <td>timestampBegin</td>
            <td>long</td>
            <td>Unix time in milliseconds
            </td>
        </tr>
        <tr>
            <td>timestampEnd</td>
            <td>long</td>
            <td>Unix time in milliseconds
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
        GET /v1/teams/62/history?timestampBegin=0&timestampEnd=99999999 HTTP/1.1
        Host: api.razerstats.com
        Content-Type: application/json; charset=utf-8</code></pre>
    </div>

    <div class="highlight"><pre><code class="js">
        HTTP/1.1 200 OK
        Content-Type: application/json; charset=utf-8
        Content-Length: <span class="variable">length</span>


        {
        "total": 13,
        "results": [
            {
            "teamId": 30,
            "alias": "www.kevin.org",
            "ptsTotal": 604348,
            "ptsDelta": 0,
            "wuTotal": 2990,
            "wuDelta": 0,
            "rank": 6228,
            "rankDelta": 1,
            "ptsDay": 0,
            "ptsWeek": 0,
            "timestamp": 1357748405000
            },
            {
            "teamId": 30,
            "alias": "www.kevin.org",
            "ptsTotal": 604348,
            "ptsDelta": 0,
            "wuTotal": 2990,
            "wuDelta": 0,
            "rank": 6227,
            "rankDelta": 1,
            "ptsDay": 0,
            "ptsWeek": 0,
            "timestamp": 1357726808000
            },
            {
            "teamId": 30,
            "alias": "www.kevin.org",
            "ptsTotal": 604348,
            "ptsDelta": 0,
            "wuTotal": 2990,
            "wuDelta": 0,
            "rank": 6226,
            "rankDelta": 1,
            "ptsDay": 0,
            "ptsWeek": 0,
            "timestamp": 1357672801000
            },
            {
            "teamId": 30,
            "alias": "www.kevin.org",
            "ptsTotal": 604348,
            "ptsDelta": 0,
            "wuTotal": 2990,
            "wuDelta": 0,
            "rank": 6225,
            "rankDelta": 1,
            "ptsDay": 0,
            "ptsWeek": 0,
            "timestamp": 1357662004000
            },
            {
            "teamId": 30,
            "alias": "www.kevin.org",
            "ptsTotal": 604348,
            "ptsDelta": 0,
            "wuTotal": 2990,
            "wuDelta": 0,
            "rank": 6224,
            "rankDelta": 1,
            "ptsDay": 0,
            "ptsWeek": 0,
            "timestamp": 1357651205000
            },
            {
            "teamId": 30,
            "alias": "www.kevin.org",
            "ptsTotal": 604348,
            "ptsDelta": 0,
            "wuTotal": 2990,
            "wuDelta": 0,
            "rank": 6223,
            "rankDelta": 1,
            "ptsDay": 0,
            "ptsWeek": 0,
            "timestamp": 1357618801000
            },
            {
            "teamId": 30,
            "alias": "www.kevin.org",
            "ptsTotal": 604348,
            "ptsDelta": 0,
            "wuTotal": 2990,
            "wuDelta": 0,
            "rank": 6222,
            "rankDelta": 1,
            "ptsDay": 0,
            "ptsWeek": 0,
            "timestamp": 1357608001000
            },
            {
            "teamId": 30,
            "alias": "www.kevin.org",
            "ptsTotal": 604348,
            "ptsDelta": 0,
            "wuTotal": 2990,
            "wuDelta": 0,
            "rank": 6221,
            "rankDelta": 2,
            "ptsDay": 0,
            "ptsWeek": 0,
            "timestamp": 1357586402000
            },
            {
            "teamId": 30,
            "alias": "www.kevin.org",
            "ptsTotal": 604348,
            "ptsDelta": 0,
            "wuTotal": 2990,
            "wuDelta": 0,
            "rank": 6219,
            "rankDelta": 1,
            "ptsDay": 0,
            "ptsWeek": 0,
            "timestamp": 1357554005000
            },
            {
            "teamId": 30,
            "alias": "www.kevin.org",
            "ptsTotal": 604348,
            "ptsDelta": 0,
            "wuTotal": 2990,
            "wuDelta": 0,
            "rank": 6218,
            "rankDelta": 1,
            "ptsDay": 0,
            "ptsWeek": 0,
            "timestamp": 1357532401000
            },
            {
            "teamId": 30,
            "alias": "www.kevin.org",
            "ptsTotal": 604348,
            "ptsDelta": 0,
            "wuTotal": 2990,
            "wuDelta": 0,
            "rank": 6217,
            "rankDelta": 1,
            "ptsDay": 0,
            "ptsWeek": 0,
            "timestamp": 1357478402000
            },
            {
            "teamId": 30,
            "alias": "www.kevin.org",
            "ptsTotal": 604348,
            "ptsDelta": 0,
            "wuTotal": 2990,
            "wuDelta": 0,
            "rank": 6216,
            "rankDelta": 18,
            "ptsDay": 0,
            "ptsWeek": 0,
            "timestamp": 1357431601000
            },
            {
            "teamId": 30,
            "alias": "www.kevin.org",
            "ptsTotal": 604348,
            "ptsDelta": 604348,
            "wuTotal": 2990,
            "wuDelta": 2990,
            "rank": 6198,
            "rankDelta": 6198,
            "ptsDay": 0,
            "ptsWeek": 0,
            "timestamp": 1356816001000
            }
        ]
        }
    </code></pre>
    </div>
</section>
</body>
</html>
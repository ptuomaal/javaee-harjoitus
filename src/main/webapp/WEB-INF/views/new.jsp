<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Pong!</title>
    <style>
        <%@ include file="../styles.css" %>
    </style>
</head>
<body>
<p>Lisää uusi pong!</p>

<p>
    <form>
        <input name="name-field" type="input" placeholder="NIMI"></input>
        <button type="button" onclick="addPong()">Lisää</button>
    </form>
</p>

</div>
<script type="application/javascript">
    function addPong() {
        console.log("Lisää painettu")
        let name = document.querySelector('[name="name-field"]').value
        console.log(name);
        create(name);
    }

    function create(data) {
        fetch("/post/data/here", {
            method: "POST",
            body: JSON.stringify(data)
        }).then(res => {
            console.log("Request complete! response:", res);
        });
    }
</script>
</body>
</html>

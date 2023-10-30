<!DOCTYPE html>
<html>
<head>
    <title>Zane Academy WebSocketPrj13</title>
    <script>
        var websocket = new WebSocket("ws://${pageContext.request.contextPath}/EndPointTest");

        websocket.onmessage = function processMessage(message) {
            var jsonData = JSON.parse(message.data);
            if (jsonData.message != null) document.getElementById("messages TextArea").value += jsonData.message + "\n";
        }

        websocket.onerror = function() {
            console.log('An error occured, closing application');
        };
        function sendMessage() {
            websocket.send(document.getElementById("messageText").value);
            document.getElementById("messageText").value = "";
        }
    </script>
</head>
<body>
<mark>username: ohm</mark><br>
<textarea id="messages TextArea" readonly="readonly" rows="10" cols="45"></textarea><br/>
<input type="text" id="messageText" size="50" /><input type="button" value="Send" onclick="sendMessage();" />
</body>
</html>

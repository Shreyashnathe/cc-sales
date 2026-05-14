function getBotResponse(message) {

    message = message.toLowerCase();

    if (message.includes("hello") || message.includes("hi")) {
        return "Hello! Welcome to Customer Support.";
    }

    else if (message.includes("product")) {
        return "We offer laptops, mobiles, and accessories.";
    }

    else if (message.includes("order")) {
        return "Please provide your Order ID.";
    }

    else if (message.includes("delivery")) {
        return "Delivery takes 3-5 business days.";
    }

    else if (message.includes("refund") || message.includes("return")) {
        return "Refunds are processed within 7 working days.";
    }

    else if (message.includes("payment")) {
        return "We accept UPI, Debit Card, and Credit Card.";
    }

    else if (message.includes("contact")) {
        return "You can contact us at support@gmail.com";
    }

    else if (message.includes("bye")) {
        return "Thank you for visiting!";
    }

    else {
        return "Sorry, I didn't understand.";
    }
}

function sendMessage() {

    let inputField = document.getElementById("userInput");
    let message = inputField.value;

    if (message.trim() === "") {
        return;
    }

    let chatBox = document.getElementById("chatBox");

    // User message
    chatBox.innerHTML += `<div class="user"><b>You:</b> ${message}</div>`;

    // Bot response
    let response = getBotResponse(message);

    chatBox.innerHTML += `<div class="bot"><b>Bot:</b> ${response}</div>`;

    inputField.value = "";

    chatBox.scrollTop = chatBox.scrollHeight;
}